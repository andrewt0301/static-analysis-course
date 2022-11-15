package org.example.lexer;

public class LexerException extends RuntimeException {
    private static final long serialVersionUID = 5118287558884097069L;
    private final Position position;

    public LexerException(Position position, String message) {
        super(message);
        this.position = position;
    }

    public LexerException(Position position, String message, Throwable cause) {
        super(message, cause);
        this.position = position;
    }

    @Override
    public String getMessage() {
        return "Lexical error at " + position + ": " + super.getMessage();
    }
}
