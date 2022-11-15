package org.example;

import org.example.lexer.Lexer;
import org.example.lexer.Token;
import org.example.lexer.WhileLexer;
import org.example.lexer.WhileTokens;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "a \n + b;";
        try (InputStream input = new ByteArrayInputStream(text.getBytes())) {
            Lexer lexer = new WhileLexer(input);
            for (
                Token token = lexer.nextToken();
                !token.isType(WhileTokens.EOF);
                token = lexer.nextToken()
            ) {
                System.out.println(token);
            }
        }
    }
}