expr : expr PLUS term 
    | term ;
term : 
      ID 
    | NUM
    | expr OPENP expr CLOSEP;
    
ID: [a-zA-Z] [a-zA-Z0-9]*;

NUM: [0-9]+;

PLUS: '+';
OPENP: '(';
CLOSEP: ')';
WS skip: ' '*;
