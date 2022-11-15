package org.example.lexer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public abstract class Lexer {
    public static final char EOF = (char) -1;

    private final InputStream input;
    private char curChar;
    private int index;
    private int line;
    private int column;

    public Lexer(InputStream input) {
        this.input = Objects.requireNonNull(input);
        this.index = 0;
        this.line = 1;
        this.column = 0;
        consume();
    }

    public char getChar() {
        return curChar;
    }

    public void consume() {
        try {
            curChar = (char) input.read();
        } catch (IOException ex) {
            throw new LexerException(getPosition(), "Failed to read from stream", ex);
        }
        index++;
        if (curChar == '\n') {
            line++;
            column = 0;
        } else {
            column++;
        }
    }

    public Position getPosition() {
        return new Position(index, line, column);
    }

    public abstract Token nextToken();
}
