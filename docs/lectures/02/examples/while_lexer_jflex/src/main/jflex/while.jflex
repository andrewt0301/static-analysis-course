package org.example.lexer;

%%

%public
%class WhileLexer
%implements Lexer
%unicode
%function nextToken
%type Token

%char
%line
%column

%{
  private Position pos() {
    return new Position((int) yychar, (int) yyline, (int) yycolumn);
  }

  private Token token(TokenType type) {
    Wreturn new Token(type, yytext());
  }
%}

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

<YYINITIAL> ","      { return token(WhileToken.COMMA); }
<YYINITIAL> ";"      { return token(WhileToken.SEMI); }
<YYINITIAL> ":="     { return token(WhileToken.ASSIGN); }
<YYINITIAL> "("      { return token(WhileToken.LPARENT); }
<YYINITIAL> ")"      { return token(WhileToken.RPARENT); }

<YYINITIAL> "+"      { return token(WhileToken.PLUS); }
<YYINITIAL> "-"      { return token(WhileToken.MINUS); }
<YYINITIAL> "/"      { return token(WhileToken.DIV); }
<YYINITIAL> "*"      { return token(WhileToken.MUL); }
<YYINITIAL> "%"      { return token(WhileToken.MOD); }

<YYINITIAL> "not"    { return token(WhileToken.NOT); }
<YYINITIAL> "and"    { return token(WhileToken.AND); }
<YYINITIAL> "or"     { return token(WhileToken.OR); }
<YYINITIAL> "xor"    { return token(WhileToken.XOR); }

/* keywords */
<YYINITIAL> "true"   { return token(WhileToken.TRUE); }
<YYINITIAL> "false"  { return token(WhileToken.FALSE); }
<YYINITIAL> "var"    { return token(WhileToken.VAR); }
<YYINITIAL> "begin"  { return token(WhileToken.BEGIN); }
<YYINITIAL> "end"    { return token(WhileToken.END); }
<YYINITIAL> "if"     { return token(WhileToken.IF); }
<YYINITIAL> "then"   { return token(WhileToken.THEN); }
<YYINITIAL> "else"   { return token(WhileToken.ELSE); }
<YYINITIAL> "while"  { return token(WhileToken.WHILE); }
<YYINITIAL> "do"     { return token(WhileToken.DO); }
<YYINITIAL> "write"  { return token(WhileToken.WRITE); }
<YYINITIAL> "read"   { return token(WhileToken.READ); }
<YYINITIAL> "skip"   { return token(WhileToken.SKIP); }


<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL);  }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE);  }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL);  }

[^]  { throw new LexerException(pos(), "Invalid character: " + yytext()); }
