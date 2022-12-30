package org.example;

public interface Lexer {
    Token nextToken() throws java.io.IOException;
}
