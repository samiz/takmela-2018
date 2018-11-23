A grammar is composed of two parts:

```
<grammar rules>
<lexer rules>
```

Grammar rules take this form:
`name: choice0 | choice1 | .... ;`

The name must start with a small letter. A choice can be empty (indicating a null production).

Choices can also have labels (which would then be used to label parse trees instead of the rule name). A rule must have either all choices labelled or none labelled. Labels must start with a capital letter.

```
name:
      choice0     #Label0
    | choice1     #Label1
    ;
```
    
Terminals in rules can be either embedded strings `'like this'` or tokens defined in the lexer rules section, which must start with a capital letter (and by convention are usually ALL CAPS).

Future versions will support EBNF operators `*`, `?`, `+` and `(` `)` in grammar rules.

A lexer rule takes this form:

`Name <optional modifiers> : <regexp> ;`

For example:

```
ID: [a-zA-Z] [a-zA-Z0-9]*;
SPACING skip: ' ';
```

Currently the only supported modifier is `skip` but more are planned.

Tokenizing chooses the successfully accepted rule by longest match. In case of multiple longest match ties are broken by order in the grammar listing (earlier = higher priority). All embedded terminals take higher priority than named tokens, and the order among embedded terminals is currently undefined.

A RegExp in Takmela supports the following operations:
Sequencing: `partA partB`
Repetition: `part+` or `part*`
Optional parts: `part?`
String literals: `'hello'`
Character classes: `[a-h] [abcdx-z] [a-z2-5] [\n] [\n\r\t\'\"\\\-]`

Sub-expressions can be grouped using parentheses.

A character class can contain a mix of char ranges (i.e `from-to`) and single characters. Char ranges are inclusive from both sides.

These character escapes are supported in both single characters and character ranges (but not yet string literals):
`\n`        New line
`\r`        Carriage return
`\t`        Tab
`\\`        Literal backslash
`\"`        Double quote
`\'`        Single quote
`\-`        Dash

Notably lacking right now is Unicode code points (Unicode support in general is lacking right now).

Putting it all together, here's the classical example of a grammar for simple arithmetic expressions:

```
expr : expr '+' term 
    | expr '-' term 
    | term 
    ;
    
term :  term '*' factor
      | term '/' factor
      | factor
      ;

factor:
    | INT
    | '(' expr ')'
    ;

INT: [0-9]+;

WS skip: (' ' | [\n\r\t])+;
```
