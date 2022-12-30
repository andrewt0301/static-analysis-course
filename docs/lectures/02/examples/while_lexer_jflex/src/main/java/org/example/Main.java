package org.example;

import org.example.lexer.Lexer;
import org.example.lexer.Token;
import org.example.lexer.WhileLexer;
import org.example.lexer.WhileToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("The While file to be parsed is not specified!");
            return;
        }
        Path filePath = Paths.get(args[0]);
        try (Reader reader = Files.newBufferedReader(filePath)) {
            Lexer lexer = new WhileLexer(reader);
            for (
                    Token token = lexer.nextToken();
                    !token.isType(WhileToken.EOF);
                    token = lexer.nextToken()
            ) {
                System.out.println(token);
            }
        }
    }
}
