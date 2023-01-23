parser grammar WhileParser;

options { tokenVocab=WhileLexer; }

compilationUnit : blockStmt
         ;

stmt     : blockStmt
         | assignStmt
         | skipStmt
         | writeStmt
         | ifStmt
         | whileStmt
         ;

varDecl  : VAR ID (ASSIGN expr)?
         ;

varOrStmt: varDecl | stmt
         ;

blockStmt: BEGIN (varOrStmt SEMI)* END
         ;

assignStmt: varRef ASSIGN expr
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
         | varRef
         | READ
         | uop=MINUS expr
         | uop=BNOT expr
         | expr bop=(DIV|MUL|MOD) expr
         | expr bop=(BSHL|BSHR|BAND|BOR|BXOR) expr
         | expr bop=(PLUS|MINUS) expr
         | LPARENT expr RPARENT
         ;

varRef   : ID
         ;

bool     : val=(TRUE|FALSE)
         | NOT bool
         | expr bop=(EQ|NEQ|LESS|GT|LEQ|GTE) expr
         | bool bop=(AND|OR|XOR) bool
         | LPARENT bool RPARENT
         ;
