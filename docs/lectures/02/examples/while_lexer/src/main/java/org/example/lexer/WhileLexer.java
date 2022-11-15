package org.example.lexer;

import java.io.InputStream;

public class WhileLexer extends Lexer {
    public WhileLexer(InputStream input) {
        super(input);
    }

    @Override
    public Token nextToken() {
        for (char ch = getChar(); ch != EOF; ch = getChar()) {
            switch (ch) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    consumeWhiteSpace();
                    break;
                case ';' :
                    consume();
                    return new Token(WhileTokens.SEMI, ";", getPosition());
                case ',' :
                    consume();
                    return new Token(WhileTokens.COMMA, ",", getPosition());
                case '(' :
                    consume();
                    return new Token(WhileTokens.LPARENT, "(", getPosition());
                case ')' :
                    consume();
                    return new Token(WhileTokens.RPARENT, ")", getPosition());
                case '+':
                    consume();
                    return new Token(WhileTokens.PLUS, "+", getPosition());
                case '-':
                    consume();
                    return new Token(WhileTokens.MINUS, "-", getPosition());
                case '/':
                    consume();
                    return new Token(WhileTokens.DIV, "/", getPosition());
                case '*':
                    consume();
                    return new Token(WhileTokens.MUL, "*", getPosition());
                case '%':
                    consume();
                    return new Token(WhileTokens.REM, "%", getPosition());
                default:
                    if (isLetter(ch)) {
                        return consumeId();
                    }
                    throw new LexerException("Invalid character: " + ch);
            }
        }
        return new Token(WhileTokens.EOF, getPosition());
    }

    private void consumeWhiteSpace() {
        for (char ch = getChar(); isSpace(ch) ; ch = getChar()) {
            consume();
        }
    }

    Token consumeId() {
        StringBuilder sb = new StringBuilder();
        for (char ch = getChar(); isLetter(ch) ; ch = getChar()) {
            sb.append(ch);
            consume();
        }
        return new Token(WhileTokens.ID, sb.toString(), getPosition());
    }

    private static boolean isLetter(char ch) {
        return 'a' <= ch && ch <='z' || 'A' <= ch && ch <= 'Z';
    }

    private static boolean isNumber(char ch) {
        return '0' <= ch && ch <='9';
    }

    private static boolean isSpace(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r';
    }
}
