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
    return new Position((int) yychar + 1, (int) yyline + 1, (int) yycolumn + 1);
  }

  private Range range() {
    Position pos = pos();
    return new Range(pos, pos.withOffset((int) yylength()));
  }

  private Token token(TokenType type) {
    return new Token(type, range());
  }
%}

%eofval{
return token(WhileToken.EOF);
%eofval}

WS=[\ \n\r\t\f]
NUM=[0-9]+
ID=[a-zA-Z]+

%%

{WS}+    { }

","      { return token(WhileToken.COMMA); }
";"      { return token(WhileToken.SEMI); }
":="     { return token(WhileToken.ASSIGN); }
"("      { return token(WhileToken.LPARENT); }
")"      { return token(WhileToken.RPARENT); }

"+"      { return token(WhileToken.PLUS); }
"-"      { return token(WhileToken.MINUS); }
"/"      { return token(WhileToken.DIV); }
"*"      { return token(WhileToken.MUL); }
"%"      { return token(WhileToken.MOD); }

"not"    { return token(WhileToken.NOT); }
"and"    { return token(WhileToken.AND); }
"or"     { return token(WhileToken.OR); }
"xor"    { return token(WhileToken.XOR); }

"=="     { return token(WhileToken.EQ); }
"!="     { return token(WhileToken.NEQ); }
"<"      { return token(WhileToken.LESS); }
">"      { return token(WhileToken.GT); }
"<="     { return token(WhileToken.LEQ); }
">="     { return token(WhileToken.GTE); }

"<<"     { return token(WhileToken.BSHL); }
">>"     { return token(WhileToken.BSHR); }
"&"      { return token(WhileToken.BAND); }
"|"      { return token(WhileToken.BOR); }
"^"      { return token(WhileToken.BXOR); }

"true"   { return token(WhileToken.TRUE); }
"false"  { return token(WhileToken.FALSE); }
"var"    { return token(WhileToken.VAR); }
"begin"  { return token(WhileToken.BEGIN); }
"end"    { return token(WhileToken.END); }
"if"     { return token(WhileToken.IF); }
"then"   { return token(WhileToken.THEN); }
"else"   { return token(WhileToken.ELSE); }
"while"  { return token(WhileToken.WHILE); }
"do"     { return token(WhileToken.DO); }
"write"  { return token(WhileToken.WRITE); }
"read"   { return token(WhileToken.READ); }
"skip"   { return token(WhileToken.SKIP); }

{ID}     { return new Token(WhileToken.ID, yytext(), range()); }
{NUM}    { return new Token(WhileToken.NUM, yytext(), range()); }

[^]      { throw new LexerException(pos(), "Invalid character: " + yytext()); }
