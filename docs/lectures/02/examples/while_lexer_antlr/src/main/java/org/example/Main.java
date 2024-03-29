package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.InputStream;
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
        try (InputStream input = Files.newInputStream(filePath)) {
            CharStream stream = CharStreams.fromStream(input);
            Lexer lexer = new org.example.WhileLexer(stream);
            for (
                Token token = lexer.nextToken();
                token.getType() != Token.EOF;
                token = lexer.nextToken()
            ) {
                printToken(lexer, token);
            }
        }
    }

    private static void printToken(Lexer lexer, Token token) {
        String type = lexer.getRuleNames()[token.getType() - 1];
        System.out.printf(
            "<'%s', %s, %d:%d:%d-%d:%d:%d>%n",
            token.getText(),
            type,
            token.getStartIndex() + 1,
            token.getLine(),
            token.getCharPositionInLine() + 1,
            token.getStopIndex() + 2,
            token.getLine(),
            token.getCharPositionInLine() + (token.getStopIndex() - token.getStartIndex()) + 2
        );
        //<'begin', BEGIN, 1:1:1-6:1:6>
    }
}