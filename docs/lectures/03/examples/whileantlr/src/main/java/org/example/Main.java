package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.example.WhileLexer;
import org.example.WhileParser;
import org.example.WhileBaseVisitor;

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
        final ParseTree root;
        try (InputStream input = Files.newInputStream(filePath)) {
            CharStream stream = CharStreams.fromStream(input);
            WhileLexer lexer = new WhileLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            WhileParser parser = new WhileParser(tokens);
            root = parser.program();
        }
        root.accept(new WhileBaseVisitor<Object>() {

        });
    }
}
