Here we will create a tiny grammar and use it to parse some input.

The grammar will be arithmatic expressions either in the form of an integer, or a binary addition of two integers.

```
expr:  INT
        | INT '+' INT
        ;
        
INT: [0-9]+;

WHITESPACE skip: (' ' | [\n] | [\r])+ ;
```

Note that the grammar supports both named tokens like `INT` and embedded tokens like `'+'`. Embedded tokens take the higher precedence when running lexical analysis.

## Parsing from the command line

The parsing engine is in the .jar file that you can obtain from the releases, and it depends on the ANTLR and nanojson jars. You can run it as follows:
```
java -cp takemlas_jar:lib/antlrs_jar:lib/nanojsons_jar takmela.tool.Parse <command args>
```

A small shell script `parse.sh` is included to take your command line arguments and run the Parser for you. We will use it here.

Let's also create a small input file input.txt:

```
1+2
```

To run the parsing engine save the grammar code in some grammar file and run the following:
```
./parse.sh --terse -s expr -g path_to_grammar input.txt
```

What the command line args mean:

`-s` is the start symbol (here it's `expr`). If the start symbol isn't provided it's assumed to be `main`

`-g` is the path to the grammar file

`--terse` means don't print full information in the parse tree

The last argument is the path to your input.

If all goes well, you'll get an output that looks like this:
```
{
    "trees":[["expr",{
        "token":"1"
    },{
        "token":"+"
    },{
        "token":"2"
    }]]
}
```

The terse version of the output is a JSON object with a single property, `trees`, that holds an array of tree objects. Each tree is a JSON array in the fashion of LISP s-expressions: the tree's label is the first element and its children are the rest of the elements. Terminals/Tokens are JSON objects with the `token` property set to the token's text content.

If you want a fuller tree you can omit the `--terse` option and get this:

```
{
    "trees":[{
        "children":[{
            "col":1,
            "line":0,
            "id":1,
            "type":"token",
            "lexeme":"1"
        },{
            "col":1,
            "line":0,
            "id":0,
            "type":"token",
            "lexeme":"+"
        },{
            "col":1,
            "line":0,
            "id":1,
            "type":"token",
            "lexeme":"2"
        }],
        "label":"expr",
        "type":"tree",
        "choice":0
    }]
}
```

Now the tree is an object in the form of `{type: "tree", label: "somestring", choice: someInteger, children: [...]}` for nonterminals, and `{type:"token", col:anInt, line: anInt, id:anInt, lexeme: "aString"}` for terminals.

The integer `choice` indicates which choice in the grammar was taken at this step (if the rule is in form `rule: choice0 | choice1 | ....`)

The integer `id` for tokens indicates which token type (e.g identifier, integer literal) is for this token. Later Takmela versions will generate a list of token id constants from a given grammar.

## Parsing from within your program

Next we'll try using Takmela as a library. Here's a full program to do the parsing:

```java
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
import java.io.IOException;

public class TestParse {
    public static void main(String[] args)  throws IOException, takmela.lexer.lexer.LexerError {
        String grammar = readFile("grammar.g");
        String input = "1+1";

        // Parse our grammar        
        List<String> outParseErrors = new ArrayList<>();
        
		takmela.ast.Module m = takmela.tool.Parse.parseGrammar(grammar, outParseErrors);

		if (outParseErrors.size() != 0)
		{
			System.out.println("Errors found in grammar:\n" + outParseErrors);
			System.exit(1);
		}
        
        // Use the grammar to parse an input
        takmela.tool.Parse.parse(m, input, "expr", (t) -> {
            System.out.println("Found a parse tree: " + t);
		});
    }
    
    public static String readFile(String filename) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(filename));
		StringBuilder sb = new StringBuilder();
		String line;
		String delim = "";
		while((line = r.readLine()) != null)
		{
			sb.append(delim + line);
			delim = "\n";
		}
		r.close();
		return sb.toString();
	}
}
```

The code is mostly self-explanatory. A callback is provided as the last argument to the `parse(...)` method which will be invoked each time a parse tree is found.

Save this program as `TestParser.java` and compile and run it using your favorite workflow, the output should be
```
Found a parse tree: expr(<1, 1>, <0, +>, <1, 1>)
```
It's not as fancy as the JSON output from the command line, but it'll do.

## The built-in parse tree type

So you've got a tree, what exactly is it made out of? 

- Nonterminals get mapped to `takmela.tree.Tree`
- Terminals get mapped to `takmela.tree.Leaf`
- Both inherit from `takmela.tree.Node`

Until more documentation is written, you can check these files in the project's source code (or use autocomplete!)
