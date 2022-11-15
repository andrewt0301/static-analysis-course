package org.example.lexer;

public class LexerException extends RuntimeException {
    private static final long serialVersionUID = 5118287558884097069L;

    public LexerException(String message) {
        super(message);
    }

    public LexerException(String message, Throwable cause) {
        super(message, cause);
    }
}
