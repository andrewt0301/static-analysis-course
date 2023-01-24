package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.example.ast.AstBuilder;
import org.example.ast.Node;

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
            root = parser.compilationUnit();

            TreeDumper dumper = new TreeDumper(parser.getRuleNames());
            String treeText = dumper.printTree(root);
            System.out.print(treeText);

            TreeVisualizer visualizer = new TreeVisualizer(parser.getRuleNames());
            Path dotFile = Paths.get("tree.dot");
            visualizer.printDot(root, dotFile);
            Dot.renderSvg(dotFile);
        }

        Node astRoot = root.accept(new AstBuilder());
        System.out.println("------------------------");
        System.out.println(new AstDumper().printTree(astRoot));

        AstVisualizer visualizer = new AstVisualizer();
        Path dotFile = Paths.get("ast.dot");
        visualizer.printDot(astRoot, dotFile);
        Dot.renderSvg(dotFile);
    }
}
