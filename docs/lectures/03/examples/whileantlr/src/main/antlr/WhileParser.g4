parser grammar WhileParser;

options { tokenVocab=WhileLexer; }

compilationUnit : stmts
         ;

stmts    : stmt (SEMI stmt)*
         ;

stmt     : blockStmt
         | assignStmt
         | skipStmt
         | writeStmt
         | ifStmt
         | whileStmt
         ;

var      : VAR ID SEMI
         ;

blockStmt: BEGIN var* stmts END
         ;

assignStmt: ID ASSIGN expr
         ;

whileStmt: WHILE bool DO stmt
         ;

ifStmt   : IF bool THEN stmt (ELSE stmt)?
         ;

skipStmt : SKIPP
         ;

writeStmt: WRITE expr
         ;

expr     : NUM
         | ID
         | READ
         | MINUS expr
         | BNOT expr
         | expr (PLUS|MINUS) expr
         | expr (BSHL|BSHR|BAND|BOR|BXOR) expr
         | expr (DIV|MUL|MOD) expr
         | LPARENT expr RPARENT
         ;

bool     : (TRUE|FALSE)
         | NOT bool
         | bool (AND|OR|XOR) bool
         | expr (EQ|NEQ|LESS|GT|LEQ|GTE) expr
         | LPARENT bool RPARENT
         ;
