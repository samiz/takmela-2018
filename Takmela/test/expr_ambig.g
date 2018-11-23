expr : expr '+' expr 
    | term ;
term : 
      ID 
    | NUM;
    
ID: [a-zA-Z] [a-zA-Z0-9]*;

NUM: [0-9]+;

WS skip: ' '*;
