lexer grammar ParsetoolsLexer;

KW_WITHIN: 'within';
KW_PUSHES: 'pushes';
KW_POPS: 'pops';
KW_CLASS: 'class';
KW_SKIP: 'skip';

IDSmall: [a-z] [a-zA-Z0-9_]*;
IDCap: [A-Z_] [a-zA-Z0-9_]*;

LABEL: '#' IDCap;

INT: [0-9]+;

STRING:   '"' ('\\"' | . )*? '"' 
        | '\'' ('\\\'' | . )*? '\'' 
;

COMMA: ',';
OPAREN: '(';
CPAREN: ')';
DOLLAR: '$';
PLUS: '+';
STAR: '*';
QUESTION: '?';
BAR: '|';
COLON: ':';
SEMI: ';';

COMMENT2: '//' .*? ('\r')? ('\n' | EOF) -> skip;
COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;

START_CHARCLASS: '[' -> mode(IN_CHARCLASS);

mode IN_CHARCLASS;

END_CHARCLASS: ']' -> mode(DEFAULT_MODE);

CHAR: '\\' 
        ('n' 
        | 't' 
        | 'r' 
        | '\\' 
        | '\'' 
        | '-' 
        | '"'
        )
     | ~[\'\\\-\"]
    ;
    
DASH: '-';
