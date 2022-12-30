package org.example;

%%

%public
%class WhileLexer
%implements Lexer
%unicode
%function nextToken
%type Token
%line
%column

%eofval{
return new Token(WhileToken.EOF);
%eofval}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return new Token(null); }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return new Token(null); }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return new Token(null); }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return new Token(null); }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return new Token(null); }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return new Token(null); }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return new Token(null); }

[^]                                                         { throw new IllegalStateException("Invalid character!"); }
