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
         | expr bop=(DIV|MUL|MOD) expr
         | expr bop=(BSHL|BSHR|BAND|BOR|BXOR) expr
         | expr bop=(PLUS|MINUS) expr
         | LPARENT expr RPARENT
         ;

bool     : val=(TRUE|FALSE)
         | NOT bool
         | expr bop=(EQ|NEQ|LESS|GT|LEQ|GTE) expr
         | bool bop=(AND|OR|XOR) bool
         | LPARENT bool RPARENT
         ;
