/*---------
parserName('ParsetoolsParser')
noParserInCtxType()
with_pos_info()
---------*/

parser grammar ParsetoolsParser;

options { tokenVocab = ParsetoolsLexer; }

/*---------   
astType('Module', [('Rules', lstOf('Rule')), ('LexerRules', lstOf('LexerRule'))])

astType('Rule', [('Name', 'String'),
                 ('Options', lstOf('utils.LLst<Expr>')),
                 ('Labels', lstOf('String'))])

listField('rules', 'Rule')
pubField('rules')

astType('LexerRule', [('Name', 'String'),
                       ('Within', lstOf('String')),
                       ('Pushes', lstOf('String')),
                       ('Pops', lstOf('String')),
                       ('Class', 'String'),
                       ('Skip', 'boolean'),                       
                       ('Expr', 'RExpr')])
                       
listField('lexer_rules', 'LexerRule')
pubField('lexer_rules')

---------*/

program:
    grammar_rule*
    lexer_rule*
    ;

/*---------   
astOring('Expr',
    [('Seq', [('Items', lstOf('Expr'))]),
     ('Star', [('Expr', 'Expr')]),
     ('Plus', [('Expr', 'Expr')]),
     ('Question', [('Expr', 'Expr')]),
     ('Terminal', [('Value', 'String')]),
     ('Tokenz', [('Value', 'String')]),
     ('Call', [('Callee', 'String')])])
     
prop('expr', 'Expr')

addList('grammar_rule', 'rules', make('Rule', 
                                [only('IDSmall'),
                                 call('makeLst', [all_get('expr', 'seq')]),
                                 call('stripHashes', [all_get_tokens('LABEL')])]))
---------*/   
grammar_rule:
    IDSmall
    COLON
    seq (LABEL)? (BAR seq (LABEL)?)*
    SEMI
;


/*---------   
prop_set('seq', 'expr', call('flattenSeq', [all_get('expr', 'piece')]))
---------*/   
seq:
      piece*
    ;
    
/*---------   
prop_set('PieceTerminal', 'expr', make('Terminal', [call('stripQuotes', [only('STRING')])]))
prop_set('PieceToken', 'expr', make('Tokenz', [only('IDCap')]))
prop_set('PieceCall', 'expr', make('Call', [only('IDSmall')]))
---------*/       
piece:
      STRING                #PieceTerminal
    | IDSmall               #PieceCall
    | IDCap                 #PieceToken
    | piece '+'             #PiecePlus
    | piece '*'             #PieceStar
    | piece '?'             #PieceQuestion
    | '(' piece ')'         #PieceParened
;

/*---------   

prop('within_part', lstOf('String'))
prop('pushes_part', lstOf('String'))
prop('pops_part', lstOf('String'))
addList('lexer_rule', 'lexer_rules', make('LexerRule', 
                                        [nth('IDCap', 0),
                                         prop_get('within_part', 'within_part'),
                                         prop_get('pushes_part', 'pushes_part'),
                                         prop_get('pops_part', 'pops_part'),
                                         asIs('null'),
                                         existence_token('KW_SKIP'),
                                         prop_get('rexpr', 'rx')]))
---------*/   
lexer_rule:
    IDCap
    within_part
    pushes_part
    pops_part
    (KW_CLASS IDCap)?
    KW_SKIP?
    COLON
    rx
    SEMI
    ;

/*---------   
prop_set('within_part', 'within_part', all_get_tokens('IDCap'))
---------*/   
within_part:
    (KW_WITHIN OPAREN IDCap (COMMA IDCap)* CPAREN )?
;

/*---------   
prop_set('pushes_part', 'pushes_part', all_get_tokens('IDCap'))
---------*/   
pushes_part:
    (KW_PUSHES OPAREN IDCap (COMMA IDCap)* CPAREN )?
;

/*---------   
prop_set('pops_part', 'pops_part', all_get_tokens('IDCap'))
---------*/   
pops_part:
    (KW_POPS OPAREN IDCap (COMMA IDCap)* CPAREN )?
;

/*---------   
astOring('CharClassPart',[('CharRange', [('From', 'char'), ('To','char')]),
                            ('CharSingle', [('Ch','char')])])

astOring('RExpr',[
                  ('Oring', [('Exprs', lstOf('RExpr'))]),
                  ('RXSeq', [('Exprs', lstOf('RExpr'))]),
                  ('Star',[('Expr', 'RExpr')]),
                  ('Plus', [('Expr', 'RExpr')]),
                  ('Question', [('Expr', 'RExpr')]),
                  ('ByName', [('Name', 'String')]),
                  ('Str', [('Value', 'String')]),
                  ('CharClass', [('Parts', lstOf('CharClassPart'))])
                 ])
                 
prop('rexpr', 'RExpr')                
prop_set('Oring', 'rexpr', call('flattenOring', [prop_get('rexpr', 'rx'), prop_get('rexpr', 'rx_seq')]))
prop_set('JustSeq', 'rexpr', prop_get('rexpr', 'rx_seq'))
---------*/   
rx:
        rx BAR rx_seq          #Oring
    |   rx_seq                 #JustSeq
    ;

/*---------   
prop_set('Seqq', 'rexpr', call('flattenSeq', [prop_get('rexpr', 'rx_seq'), prop_get('rexpr', 'rxpiece')]))
prop_set('JustPiece', 'rexpr', prop_get('rexpr', 'rxpiece'))
---------*/   
rx_seq:
      rx_seq rxpiece        #Seqq
    | rxpiece               #JustPiece
    ;
    
/*---------   
prop_set('PieceString', 'rexpr', make('Str', [call('stripQuotes', [only('STRING')])]))
prop_set('PieceChar', 'rexpr', prop_get('rexpr', 'charClass'))
prop_set('PiecePredefined', 'rexpr', make('ByName', [only('IDCap')]))
prop_set('PieceAsterisk', 'rexpr', make('Star', [prop_get('rexpr', 'rxpiece')]))
prop_set('PiecePlus', 'rexpr', make('Plus', [prop_get('rexpr', 'rxpiece')]))
prop_set('PieceQuestion', 'rexpr', make('Question', [prop_get('rexpr', 'rxpiece')]))
prop_set('PieceParened', 'rexpr', prop_get('rexpr', 'rx'))
---------*/       
rxpiece:
      STRING                #PieceString
    | charClass             #PieceChar
    | DOLLAR IDCap          #PiecePredefined
    | rxpiece STAR          #PieceAsterisk
    | rxpiece PLUS          #PiecePlus
    | rxpiece QUESTION      #PieceQuestion
    | OPAREN rx CPAREN      #PieceParened
;

/*---------   
prop('charClassPart', 'CharClassPart')   
prop_set('charClass', 'rexpr', make('CharClass', [all_get('charClassPart')]))
---------*/       
charClass:
    START_CHARCLASS
    charClassPart+
    END_CHARCLASS
;

/*---------   
prop('charClassPart', 'CharClassPart')   
prop_set('RangeCharClassPart', 'charClassPart', prop_get('charClassPart', 'rangeCh'))
prop_set('SingleCharClassPart', 'charClassPart', prop_get('charClassPart', 'singleCh'))
---------*/       
charClassPart:
      rangeCh                   #RangeCharClassPart
    | singleCh                  #SingleCharClassPart
    ;

/*---------   
prop_set('rangeCh', 'charClassPart', make('CharRange', [call('singleChar', [nth_token(0)]), call('singleChar', [nth_token(2)])]))
---------*/       
rangeCh: CHAR '-' CHAR;

/*---------   
prop_set('singleCh', 'charClassPart', make('CharSingle', [call('singleChar', [nth_token(0)])]))
---------*/       
singleCh: CHAR;


