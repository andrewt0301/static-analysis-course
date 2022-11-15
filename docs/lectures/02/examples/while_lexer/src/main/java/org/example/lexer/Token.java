package org.example.lexer;

import java.util.Objects;

public class Token {
    private final TokenType type;
    private final String text;
    private final Range range;

    public Token(TokenType type, String text, Range range) {
        this.type = Objects.requireNonNull(type);
        this.text = Objects.requireNonNull(text);
        this.range = Objects.requireNonNull(range);
    }

    public Token(TokenType type, Range range) {
        this(type, type.getText(), range);
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

    public Range getRange() {
        return range;
    }

    @Override
    public String toString() {
        return String.format("<'%s', %s, %s>", text, type.getName(), range);
    }
}
