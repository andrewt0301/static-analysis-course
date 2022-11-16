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
                    consume();
                    break;
                case ';' :
                    return consumeChar(WhileToken.SEMI);
                case ',' :
                    return consumeChar(WhileToken.COMMA);
                case '(' :
                    return consumeChar(WhileToken.LPARENT);
                case ')' :
                    return consumeChar(WhileToken.RPARENT);
                case '+':
                    return consumeChar(WhileToken.PLUS);
                case '-':
                    return consumeChar(WhileToken.MINUS);
                case '/':
                    return consumeChar(WhileToken.DIV);
                case '*':
                    return consumeChar(WhileToken.MUL);
                case '%':
                    return consumeChar(WhileToken.MOD);
                case '|':
                    return consumeChar(WhileToken.BOR);
                case '^':
                    return consumeChar(WhileToken.XOR);
                case ':':
                    return consumeTwoChars(WhileToken.ASSIGN);
                case '=':
                    return consumeTwoChars(WhileToken.EQ);
                case '!':
                    return consumeTwoChars(WhileToken.NEQ);
                default:
                    if (isLetter(ch)) {
                        return consumeIdOrKeyword();
                    }
                    if (isNumber(ch)) {
                        return consumeNumber();
                    }
                    throw new LexerException(
                            getPosition(), "Invalid character: " + ch
                       );
            }
        }
        Position pos = getPosition();
        return new Token(WhileToken.EOF, new Range(pos, pos));
    }

    private Token consumeIdOrKeyword() {
        Position start = getPosition();
        StringBuilder sb = new StringBuilder();
        char ch = getChar();
        do {
            sb.append(ch);
            consume();
            ch = getChar();
        } while (isLetter(ch) || isNumber(ch));
        Position end = getPosition();
        Range range = new Range(start, end);
        String text = sb.toString();
        TokenType type = WhileToken.fromText(text);
        return type == null
                ? new Token(WhileToken.ID, text, range)
                : new Token(type, range);
    }

    private Token consumeNumber() {
        Position start = getPosition();
        StringBuilder sb = new StringBuilder();
        char ch = getChar();
        do {
            sb.append(ch);
            consume();
            ch = getChar();
        } while (isNumber(ch));
        Position end = getPosition();
        Range range = new Range(start, end);
        String text = sb.toString();
        return new Token(WhileToken.NUM, text, range);
    }

    private Token consumeChar(TokenType type) {
        Position start = getPosition();
        consume();
        Position end = getPosition();
        return new Token(type, new Range(start, end));
    }

    private Token consumeTwoChars(TokenType type) {
        Position start = getPosition();
        consume();
        match(type.getText().charAt(1));
        Position end = getPosition();
        return new Token(type, new Range(start, end));
    }

    private static boolean isLetter(char ch) {
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z';
    }

    private static boolean isNumber(char ch) {
        return '0' <= ch && ch <='9';
    }

    private static boolean isSpace(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r';
    }
}
