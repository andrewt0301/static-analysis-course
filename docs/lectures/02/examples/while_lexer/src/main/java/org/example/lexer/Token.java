package org.example.lexer;

import java.util.Objects;

public class Token {
    private final Enum<?> type;
    private final String text;
    private final Position position;

    public Token(Enum<?> type, String text, Position position) {
        this.type = type;
        this.text = Objects.requireNonNull(text);
        this.position = Objects.requireNonNull(position);
    }

    public Token(Enum<?> type, Position position) {
        this(type, '<' + type.name() + '>', position);
    }

    public Enum<?> getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("<'%s', %s, %s>", text, type.name(), position);
    }
}
