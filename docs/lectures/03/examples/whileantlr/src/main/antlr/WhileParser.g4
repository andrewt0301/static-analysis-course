parser grammar WhileParser;

options { tokenVocab=WhileLexer; }

compilationUnit : fun*
         ;

fun      : FUN ID args blockStmt
         ;

args     : (LPARENT (argDecl (COMMA argDecl)*)? RPARENT)?
         ;

argDecl  : ID
         ;

stmt     : blockStmt
         | assignStmt
         | skipStmt
         | writeStmt
         | ifStmt
         | whileStmt
         | retStmt
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

retStmt  : RETURN expr?
         ;

expr     : atom
         | uop=MINUS expr
         | uop=BNOT expr
         | expr bop=(DIV|MUL|MOD) expr
         | expr bop=(BSHL|BSHR|BAND|BOR|BXOR) expr
         | expr bop=(PLUS|MINUS) expr
         ;

atom     : NUM
         | READ
         | LPARENT expr RPARENT
         | varRef
         ;

varRef   : ID
         ;

bool     : boolAtom
         | NOT bool
         | expr bop=(EQ|NEQ|LESS|GT|LEQ|GTE) expr
         | bool bop=(AND|OR|XOR) bool
         ;

boolAtom : val=(TRUE|FALSE)
         | LPARENT bool RPARENT
         ;
