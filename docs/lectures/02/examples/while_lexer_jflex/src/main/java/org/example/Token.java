package org.example;

public class Token {
    private final TokenType type;

    public Token(TokenType type) {
        this.type = type;
    }

    public TokenType getType() {
        return type;
    }

    public boolean isType(TokenType type) {
        return this.type.equals(type);
    }
}
