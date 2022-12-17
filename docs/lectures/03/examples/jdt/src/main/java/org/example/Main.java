package org.example;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * This class parses Java sources to build an AST,
 * draws the AST, and finds trivial bugs in it.
 */
public class Main {
    /** The full name of the parsed Java file. */
    private final String fileName;

    /**
     * Constructor.
     *
     * @param fileName the file name
     */
    public Main(final String fileName) {
        this.fileName = Objects.requireNonNull(fileName);
    }

    /**
     * The entry point method.
     *
     * @param args command-line arguments, must contain file name
     * @throws IOException if fails to parse the file or to generate output files
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("The Java file to be parsed is not specified!");
            return;
        }
        Main main = new Main(args[0]);
        main.process();
    }

    /**
     * Parses the JavaFile and processes the AST.
     *
     * @throws IOException if fails to parse the file or to generate output files
     */
    private void process() throws IOException {
        CompilationUnit cu = parse();
        cu.accept(new ASTVisitor() {
            @Override
            public boolean visit(ImportDeclaration node) {
                System.out.println(node.getName());
                return super.visit(node);
            }
        });
    }

    private CompilationUnit parse() throws IOException {
        ASTParser parser = ASTParser.newParser(AST.JLS16);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        char[] source = readAllChars(fileName);
        parser.setSource(source);
        return (CompilationUnit) parser.createAST(null);
    }

    private static char[] readAllChars(String fileName) throws IOException {
        StringBuilder result = new StringBuilder();
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buffer)) != -1) {
                String readData = String.valueOf(buffer, 0, numRead);
                result.append(readData);
            }
        }
        return result.toString().toCharArray();
    }
}
