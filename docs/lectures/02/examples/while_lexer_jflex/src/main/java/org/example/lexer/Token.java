package org.example.lexer;

public class Token {
    private final TokenType type;
    private final String text;

    public Token(TokenType type) {
        this(type, "");
    }

    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
    }

    public TokenType getType() {
        return type;
    }

    public boolean isType(TokenType type) {
        return this.type.equals(type);
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("<'%s', %s>", text, type.getName());
    }
}
