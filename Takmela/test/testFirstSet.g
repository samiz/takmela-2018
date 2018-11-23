stmt:
      'if' expr 'then' stmt 'else' stmt
    | 'for' expr 'in' stmt
    | 'return' expr
    ;
    
expr:
        expr '+' term
    |   term
    ;
    
term:
    term '*' factor
    | factor
    ;
    
factor:
      '12'
    | 'x'
    | '(' expr ')'
    ;
