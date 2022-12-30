package org.example.lexer;

public interface Lexer {
    Token nextToken() throws java.io.IOException;
}
