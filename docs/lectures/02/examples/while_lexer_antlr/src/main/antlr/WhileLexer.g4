lexer grammar WhileLexer;

COMMA     : ',';
SEMI      : ';';
ASSIGN    : ':=';
LPARENT   : '(';
RPARENT   : ')';

PLUS      : '+';
MINUS     : '-';
DIV       : '/';
MUL       : '*';
MOD       : '%';

NOT       : 'not';
AND       : 'and';
OR        : 'or';
XOR       : 'xor';

EQ        : '==';
NEQ       : '!=';
LESS      : '<';
GT        : '>';
LEQ       : '<=';
GTE       : '>=';

BSHL      : '<<';
BSHR      : '>>';
BAND      : '&';
BOR       : '|';
BXOR      : '^';

// Keywords
TRUE      : 'true';
FALSE     : 'false';
VAR       : 'var';
BEGIN     : 'begin';
END       : 'end';
IF        : 'if';
THEN      : 'then';
ELSE      : 'else';
WHILE     : 'while';
DO        : 'do';
WRITE     : 'write';
READ      : 'read';
SKIPP     : 'skip';

NUM       : [0-9]+;
ID        : [a-zA-Z][a-zA-Z0-9_]*;
WS        : [ \t\n\r] -> skip;
