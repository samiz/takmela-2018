How Takmela's parser works

## Overview

This documentation assumes the reader has some familiarity with parsing algorithms. If you've implemented your own recursive-descent parser by hand and know why left-recursion in grammars is often troublesome, you should be able to follow this document.

The actual parser implementation is in [ParseEngine.java](../Takmela/src/takmela/engine/ParseEngine.java).

The main goal in creating Takmela was to parse left-recursive grammar rules without problem, and the main technique we use for that is to keep a table of *continuations*. This main idea is explained below:

Consider the classical example of left recursion:

```
expr ->  expr + term
        | term
```
        
If we write a naive recursive-descent parser and then invoke `expr` at some input position, the generated/written `expr()` function would call itself without consuming any input, leading to an infinite loop.

To fix this we will note that a function call (or analogously, 'calling' a grammer rule) actually involves multiple things:

1. Keeping a record of what should happen after the callee successfully returns.
2. The callee doing its processing
3. After the callee is finished, the "what to do next" record is examined and control flow goes there.

The record being kept in this case is called a continuation, and the separation of continuation bookkeeping from the rest of the rule processing is the key to avoiding those pesky infinite loops. Here's how calls work in Takmela:

We have two tables, one for continuations (call it K) and one for remembering successfull rule invocations (call it S). Each of them is a map like this:

K maps from {called rule name, input pos} to a {set of continuation records}

S maps from {called rule name, input pos} to {set of new input positions after the rule succeeded}

Notice that S[SomeRule, SomeInput] can contain multiple new positions to move to after SomeRule succeeds, success takes many forms as they say.

If we are interested in parse trees and not just language recognition, S[R,I] will be a set of (InputPos, Set(Tree)) pairs. For simplicity we will not talk much about parse tree generation in this document, however, and leave it to the parser's source code.

A continuation record contains the following fields: 
- The caller rule name
- The start input position when the caller was invoked
- The 'code position' in the caller rule where parsing should resume (represented e.g by a choice # and an index within a choice)

To call some rule A from rule B at input positin IPos:

1. Find out if this is the first time we call this rule *at this particular input position*
    ```
    firstCall = isEmpty(K[A, IPos])
    ```
2. Record a new continuation:
    ```
    c = new Cont(B, B's start pos, code location in B)
    K[A, IPos].add(c)
    ```
3. Process the newly called rule only if this is its first invocation in this particular input position
    ```
    if(firstCall)
    {
        process(A, IPos, IPos, c)
    }
    ```
    
If you have programmed with Node.js this technique of "return from call by keeping a record of continuations" should be very familiar to you. An important difference here is that Node stores continuations as function objects or closures, while we represent our continuations explicitly via a custom data structure.

When calling a top-level rule to start parsing our input, we will give it a special *root* continuation, and when we find that root being resumed and we have reached the end of input then we know a successful parse has been performed.

So how does `process` work? Processing a rule means processing each of its choices:

```
// Processing a whole rule
function process(rule, ruleStartInputPos, inputPos)
{
    for(Seq choice : rule.choices)
    {
        // An overloaded version, process a 'code position' in one of the rule's choices
        process(rule, choice/0, ruleStartInputPos, inputPos) 
    }
}
```

The `process` function called inside the loop is supposed to process a sequence like `expr + term` in a rule. It takes as arguments the rule whose choice is being processed, the "code position" in the choice sequence, the input position where parsing this rule started (to know which continuation to invoke if the rule succeeds) and of course, the current input position.

`process` can do multiple things depending on the 'code' it needs to run:
- If it finds a terminal at the given code pos, it tries to match it, advance the input, and move to the next 'code pos'.
- If it find a call to a nonterminal rule, it executes the call mechanism described above (saving the continuation...etc)
- If the code position reaches the end of the sequence, we know the rule has successfully matched its components with the input.

How is success handled? The result from one or more successful rule parses is combined with the continuations at the input position of those successful parsers, it's clearer to say this in symbols:

To handle success for rule R which started parsing at input position I and ended at newI:

```
function returnFromSuccess(R, I, newI)
{
    for(cont in K[R, I])
    {
        process(cont.callerRule, cont.codePos, I, newI)
    }
}
```

So far it seems we have fully described the parsing algorithm, however this algorithm in its current state is....wrong. It seems to work but it has some complications that need to be addressed:

*First:* Sometimes we make a new call to (R, IPos) which already has some past successes, in this case we must resume not only when something is added to S, but also when something is added to K. i.e we have two types of resuming from continuations: (a) on new calls, join with existing successes (b) on new successes, join with existing continuations.

So we need to modify `returnFromSuccess` to something like the following, and add a mirror function for calls:
```
function returnFromSuccess(R, I)
{
    for(successInputPos in S[R, I])
    {
        for(cont in K[R, I])
        {
            process(cont.callerRule, cont.codePos, I, successInputPos)
        }
    }
}
```

This operation looks similar to database joins, in fact it *is* a join.

*But:* Another problem arises when we do this, however: we get the problem of redundant parsing, for example whenever we call some rule (R,Pos) we will have to join it with all previous successes even if we did so before.

Even worse, we directly call `process` from `returnFromSuccess` as in the join code above, and the call to `process` can lead to further calls and successes, and we come back to our old enemy: infinite loops. This is what we have been trying to avoid in the first place!

Luckily there's a solution that fixes these problems: we will not directly call `process` from the joining between successes and continuation, instead we will work in batches or iterations, as our `process`-ing generates new continuations or successes, we shall delay their joining until the next iteration. Furthermore we will take advantage of iterations to process only newly discovered K & S items. Iteration will stop when no new K/S items have been generated.

Our final algorithm looks like this:

```
    continuations = new Map(); newContinuations = new Map()
    successfulCalls = new Map() ; newSuccessfulCalls = new Map()
                
    call(startRule, 0);

    while (true)
    {
        merge(successfulCalls, newSuccessfulCalls)
        merge(continuations, newContinuations)

        sWorklist = newSuccessfulCalls; newSuccessfulCalls = new Map();
        kWorkList = newContinuations; newContinuations = new Map();

        boolean noChange = true;
        
        if (sWorklist.size() != 0)  // join from new successes
        {
	        noChange = false;
	        for (Rule,Pos) in sWorklist.keys()
	        {
		        for newPos in sWorklist[Rule,Pos]
		        {
			        joinWithContinuations(Rule, Pos, newPos)
		        }
	        }
        }

        if (kWorkList.size() != 0) // join from new continuations
        {
	        noChange = false;
	        for [Rule, Pos] in kWorkList.keys()
	        {
		        Set<Cont> cs = kWorkList[Rule, Pos]
		        for c in cs
		        {
			        joinWithSuccesses(c)
		        }
	        }
        }

        if (noChange) { break }
    }
```    
    
If you have worked with the Semi-naive algorithm in Datalog this code would be familiar to you!
    
## Walkthrough

Let's test our parser with the following input:

#### Grammar

```
expr ->  expr + term
       | term
       ;
       
term ->  NUM
       | ID
       | expr '(' expr ')'
       ;
```
       
#### Input Text

```
12 + f ( 13 )
```
       
This grammar is a nice challenge for our parser as it is left-recursive (both directly and indirectly) and ambigous, since both `(12) + (f(13))` and `(12+f)(13)` are valid parse trees for it.

Remember, our two main data structures are `K[Rule, Pos]->Set(Continuaton)` and `S[Rule, Pos]->Set(Pos)`, and we start by calling a start rule (here it will be `expr`)

```
Starting the Parser

Iteration #1 ------------------------------------------

    Call Expr@0, callerK = root
        Add Cont.
        ....K[Expr, 0].add({root@0, ×})                                // Cont #0
        Process expr
        ....Choice #1, Call expr@0
            Add Cont.
            ....K[Expr, 0].add({Expr@0, `+ term ×`})                   // Cont #1
            No processing
        ....Choice #2, Call Term@0
            Add Cont.
            ....K[Term, 0].add({Expr@0, ×})                            // Cont #2
            Process term@0
            ....match NUM, succeed, S[term, 0].add(1)
            ....match ID, fail
            ....call expr@0
                Add Cont.
                ....K[Expr, 0].add({Term@0, [(, expr, ), ×]})          // Cont #3
                No processing
                
End of iteration #1
K[Expr, 0] =   {Root, ×}                                   // Cont0
            &  {Expr@0, [...+ term ×]}                     // Cont1
            &  {Term@0, [...'(' expr ')' ×]}               // Cont3
            
K[Term, 0] =   {Expr@0, ×}                                 // Cont2

S[Term 0]  = { 1 }

Joins: Cont2 with Success(Term, 0, 1) -> process(Expr, ×, 0, 1, K={Root, ×})

Iteration #2 ------------------------------------------
    process(rule=Expr, ruleCodePos=×, inputPosAtRuleStart=0, inputPosNow=1)
    ....end of rule, success. S[Expr,0].add(1)
    
End of iteration #2

K[Expr, 0] =   {Root, ×}                                    // Cont0
            &  {Expr@0, [+, term, ×]}                       // Cont1
            &  {Term@0, [(, expr, ), ×]}                    // Cont3
            
K[Term, 0] =   {Expr@0, ×}                                  // Cont2

S[Term, 0]  = { 1 }
S[Expr, 0]  = { 1 }

Joins: Cont0, Cont1, Cont3 with success(Expr, 0, 1)
    -> process(Root, [×]            , 0, 1)
    -> process(Expr, [+, term, ×]   , 0, 1)
    -> process(Term, [(, expr, ), ×], 0, 1)
    
Iteration #3 ------------------------------------------
    process(Root, ×, 0, 1)
        inputPos !=EOF, don't record successful full parse
    process(Expr, [+, term, ×], 0, 1)
        match +, ok, input now = 2
        call term@2
            Add Cont.
            ....K[term,2].add({expr@0, ×})                                   // Cont4
            Process term@2
            ...Choice #1
                match NUM, fail
            ...Choice #2
                match ID, success, S[term, 2].add(3)
            ...Choice #3
                call expr@2
                    Add Cont.
                    ....K[expr, 2].add({term@2, [(, expr, ), ×]}             // Cont5
                    Process Expr@2
                    ....Choice #1
                        Call expr@2
                            Add Cont.
                            ....K[expr, 2].add({expr@2, [+, term, ×]})       // Cont6
                            No processing
                    ....Choice #2
                        Call term@2
                            Add Cont.
                            ....K[term, 2].add({expr@2, [×]})                // Cont7
                            No processing
    process(term, [(, expr, ), ×], 0, 1)
        match (, fail
        
End of iteration #3
K[Expr, 0] =   {Root, ×}                                                   // Cont0
            &  {Expr@0, [+, term, ×]}                                      // Cont1
            &  {Term@0, ['(', expr, ')', ×]}                               // Cont3
            
K[Term, 0] =   {Expr@0, ×}                                                 // Cont2

K[Expr, 2] =   {Term@2, [(, expr, ), ×]}                                   // Cont5
            &  {expr@2, [+, term, ×]}                                      // Cont6
            

K[Term, 2] =   {expr@0, [×]}                                               // Cont4
            &  {expr@2, [×]}                                               // Cont7
            

S[Term, 0]  = { 1 }
S[Expr, 0]  = { 1 }
S[Term, 2]  = { 3 }

Joins:
K[Term, 2] -- two continuations Cont4 & Cont7, with S[Term, 2]
    process(expr, [×], 0, 3)
    process(expr, [×], 2, 3)
    
Iteration #4 ------------------------------------------
    process(expr, [×], 0, 3) // expr, choice #1, last term was finished in 'expr -> expr + term'
        no more to match, expr@0 succeeds, input now=3, S[expr, 0].add(3)
    process(expr, [×], 2, 3) // expr, choice #2, term was finished in 'expr -> term'
        no more to match, expr@2 succeeds, S[expr, 2].add(3)

Iteration #4 done
K = as before
S[Term, 0]  = { 1 }
S[Expr, 0]  = { 1, 3 }
S[Term, 2]  = { 3 }
S[Expr, 2]  = { 3 }

Joins:
    S[Expr, 0] with K[Expr, 0] i.e Cont0, Cont1, Cont3
    S[Expr, 2] with Cont5, Cont6
    process(root, [×], 0, 3)
    process(expr, [+, term, ×], 0, 3)
    process(term, [(, expr, ), ×], 0, 3)
    process(term, [(, expr, ), ×], 2, 3)
    process(expr, [+, term, ×], 2, 3)

Iteration #5 ------------------------------------------
    process(root, [×], 0, 3)
        inputPos !=EOF, don't record successful full parse
    process(expr, [+, term, ×], 0, 3)
        match +, fail
    process(term, [(, expr, ), ×], 0, 3)
        match (, success, input=4
        call expr@4
            Add Cont.
            ....K[expr, 4].add({term@0, [...), ×]})                                       // Cont8
            Process expr@4
                Choice #1, call expr
                    Add Cont.
                    ....K[expr, 4].add({expr@4, [+, term, ×]})                            // Cont9
                    No processing
                Choice #2, call term
                    Add Cont
                    ....K[term, 4].add({expr@4, [×]})                                     // Cont10
                    Process term@4
                        Choice #1, match NUM, success, input now=5, S[term, 4].add(5)
                        Choice #2, match ID, fail
                        Choice #3, call expr@4
                            Add cont
                            ....K[expr,4].add({term@4, [...(, expr, ), ×]})               // Cont11
                            No processing
    process(term, [(, expr, ), ×], 2, 3)
        match (, success, input=4
        call expr@4
            Add Cont
            ....K[expr, 4].add({term@2, [), ×]})                                          // Cont12
            No processing
    process(expr, [+, term, ×], 2, 3)
        match +, fail
    
End of iteration 5

K[Expr, 0] =   {Root, ×}                                                   // Cont0
            &  {Expr@0, [+, term, ×]}                                      // Cont1
            &  {Term@0, ['(', expr, ')', ×]}                               // Cont3
            
K[Term, 0] =   {Expr@0, ×}                                                 // Cont2

K[Expr, 2] =   {Term@2, [(, expr, ), ×]}                                   // Cont5
            &  {expr@2, [+, term, ×]}                                      // Cont6
            

K[Term, 2] =   {expr@0, [×]}                                               // Cont4
            &  {expr@2, [×]}                                               // Cont7
            
K[Expr, 4] =   {term@0, [), ×]}                                            // Cont8
            &  {expr@4, [+, term, ×]}                                      // Cont9
            &  {term@4, [(, expr, ), ×]}                                   // Cont11
            &  {term@2, [), ×]}                                            // Cont12
            
K[Term, 4] =   {expr@4, [×]}                                               // Cont10

S[Term, 0]  = { 1 }
S[Expr, 0]  = { 1, 3 }
S[Term, 2]  = { 3 }
S[Expr, 2]  = { 3 }
S[Term, 4]  = { 5 }

Joins:
    S[Term, 4] with Cont10
    process(expr, [×], 4, 5)

Iteration #6 ------------------------------------------
process(expr, [×], 4, 5)
    no more to match, expr@4 succeeds, input now=5, S[expr, 4].add(5)

End of iteration 6
K = as before

S[Term, 0]  = { 1 }
S[Expr, 0]  = { 1, 3 }
S[Term, 2]  = { 3 }
S[Expr, 2]  = { 3 }
S[Term, 4]  = { 5 }
S[Expr, 4]  = { 5 }

Joins:
    S[Expr, 4] with Cont8, Cont9, Cont11, Cont12
    process(term, [), ×], 0, 5)
    process(expr, [+, term, ×], 4, 5)
    process(term, [(, expr, ), ×], 4, 5)
    process(term, [), ×], 2, 5)

Iteration #7 ------------------------------------------
    process(term, [), ×], 0, 5)
        match ), success, input now=6
        no more to match, term@0 succeeds, input now=6, S[term, 0].add(6)
        
    process(expr, [+, term, ×], 4, 5)
        match +, fail
        
    process(term, [(, expr, ), ×], 4, 5)
        match ), fail
        
    process(term, [), ×], 2, 5)
        match ), success, input now=6
        no more to match, term@2 succeeds, input now=6, S[term, 2].add(6)

Iteration #7 done
K = as before
S[Term, 0]  = { 1, 6 }
S[Expr, 0]  = { 1, 3 }
S[Term, 2]  = { 3, 6 }
S[Expr, 2]  = { 3 }
S[Term, 4]  = { 5 }
S[Expr, 4]  = { 5 }

Joins
    success(term, 0, 6) with Cont2
    success(term, 2, 6) with Cont4 & Cont7
    process(Expr, [×], 0, 6)
    process(Expr, [×], 0, 6) // notice that this is redundant, but leads to a different parse tree is successfull!
    process(Expr, [×], 2, 6) 

Iteration #8 ------------------------------------------
    process(Expr, [×], 0, 6)
        no more to match, expr@0 succeeds, input now=6, S[expr, 0].add(6) // note parse tree = expr(term(expr(expr(term(12)),+, term(f)),
                                                                                                         '(',
                                                                                                          expr(term(13)),
                                                                                                          ')'
                                                                                                          )
                                                                                                    )
    process(Expr, [×], 0, 6)
        no more to match, expr@0 succeeds, input now=6, S[expr, 0].add(6) // note parse tree = expr(expr(term(12)), 
                                                                                                    +,
                                                                                                    term(expr(term(f)), 
                                                                                                        '(', 
                                                                                                         expr(term(13)),
                                                                                                         ')'
                                                                                                     )
                                                                                                    )
    process(Expr, [×], 2, 6) 
        no more to match, expr@0 succeeds, input now=6, S[expr, 2].add(6)
    
End of iteration 8
K = as before
S[Term, 0]  = { 1, 6 }
S[Expr, 0]  = { 1, 3, 6 }
S[Term, 2]  = { 3, 6 }
S[Expr, 2]  = { 3, 6 }
S[Term, 4]  = { 5 }
S[Expr, 4]  = { 5 }


Joins:
    success(expr, 0, 6) with root 
    success(expr, 0, 6) with root 
    success(expr, 2, 6) with Cont5, Cont6

    process(root, [×], 0, 6)
    process(root, [×], 0, 6)
    process(term, [(, expr, ), ×], 2, 6)
    process(expr, [+, term, ×], 2, 6}

Iteration #9 ------------------------------------------
    process(root, [×], 0, 6)
        inputPos = EOF, SUCCESSFUL PARSE!!
    process(root, [×], 0, 6)
            inputPos = EOF, SUCCESSFUL PARSE!!
    process(term, [(, expr, ), ×], 2, 6)
        match (, fail due to eof
    process(expr, [+, term, ×], 2, 6}
        match +, fail due to eof
        
End of iteration #9, no more new S or K, algorithm finished
```
