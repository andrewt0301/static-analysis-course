package org.example;

import com.github.javaparser.Range;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.DotPrinter;
import com.github.javaparser.printer.YamlPrinter;
import com.google.common.base.Charsets;
import org.example.symbols.Access;
import org.example.symbols.ScopeSimple;
import org.example.symbols.Symbol;
import org.example.symbols.SymbolTable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * This class parses Java sources to build
 * an AST, draws the AST, and finds trivial bugs in it.
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
        Node root = StaticJavaParser.parse(new File(fileName));


        detectUnusedImport(root);
     //   detectVisibilityIssue(root);
        transform(root);
        printYaml(root);
        File dotFile = new File("ast.dot");
        printDot(root, dotFile);
        createSvg(dotFile);
    }


    /**
     * Prints the AST in the YAML format.
     *
     * @param astRoot the AST root
     */
    private void printYaml(Node astRoot) {
        YamlPrinter printer = new YamlPrinter(true);
        System.out.println(printer.output(astRoot));
    }

    /**
     * Saves the AST to a file in the DOT format.
     *
     * @param rootRoot the AST root
     * @param dotFile the DOT file
     * @throws IOException if fails to write to the file
     */
    private void printDot(Node rootRoot, File dotFile) throws IOException {
        DotPrinter printer = new DotPrinter(true);
        try (FileWriter fileWriter = new FileWriter(dotFile);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(rootRoot));
        }
    }

    /**
     * Creates an SVG file for the given DOT file using the "dot" tool.
     *
     * @param dotFile the DOT file
     */
    private void createSvg(File dotFile) throws IOException {
        String path = dotFile.getPath();
        ProcessBuilder svgBuilder = new ProcessBuilder("dot", "-Tsvg", path);
        Process process = svgBuilder.start();
        try (OutputStream output = Files.newOutputStream(Paths.get(path + ".svg"))) {
            copy(process.getInputStream(), output);
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                copy(process.getErrorStream(), buffer);
                String errMsg = buffer.toString(Charsets.UTF_8.name());
                throw new IOException(errMsg);
            }
        } catch (InterruptedException ex) {
            throw new IOException(
                    "The current thread failed to finish image rendering"
                            + " as it was interrupted.", ex
            );
        }
    }

    private static void copy(InputStream source, OutputStream target) throws IOException {
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) != -1) {
            target.write(buf, 0, length);
        }
    }

    /**
     * Detects unused imports in a Java AST.
     *
     * @param astRoot the AST root
     */
    private void detectUnusedImport(Node astRoot) {
        Map<String, Integer> usages = new HashMap<>();
        Map<String, ImportDeclaration> imports = new HashMap<>();
        astRoot.accept(new VoidVisitorAdapter<Object>() {
            @Override
            public void visit(ImportDeclaration n, Object arg) {
                if (!n.isAsterisk()) {
                    String id = n.getName().getId();
                    usages.putIfAbsent(id, 0);
                    imports.putIfAbsent(id, n);
                }
                super.visit(n, arg);
            }

            @Override
            public void visit(ClassOrInterfaceType n, Object arg) {
                String id = n.getName().getId();
                usages.computeIfPresent(id, (k, v) -> v + 1);
                super.visit(n, arg);
            }
        }, new Object());
        for (Map.Entry<String, Integer> usage : usages.entrySet()) {
            if (usage.getValue() == 0) {
                ImportDeclaration imp = imports.get(usage.getKey());
                Range range = imp.getRange().get();
                System.out.println("UNUSED IMPORT: " + imp + " at " + range);
            }
        }
    }

    /**
     * Detects unused imports in a Java AST.
     *
     * @param astRoot the AST root
     */
    private void detectVisibilityIssue(Node astRoot) {
        SymbolTable<Node> symbols = new SymbolTable<>(new ScopeSimple<>());

        astRoot.accept(new VoidVisitorAdapter<Object>() {
            Access access;

            @Override
            public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                symbols.push(scope -> new ScopeSimple<>(scope, false));
                super.visit(n, arg);
                symbols.pop();
            }

            @Override
            public void visit(ConstructorDeclaration n, Object arg) {
                symbols.push(scope -> new ScopeSimple<>(scope, false));
                super.visit(n, arg);
                symbols.pop();
            }

            @Override
            public void visit(MethodDeclaration n, Object arg) {
                String id = n.getName().getId();
                boolean result = symbols.define(nodeScope -> new Symbol<>(
                        id,
                        false,
                        Access.LOCAL,
                        n,
                        nodeScope,
                        null,
                        null
                ));
                if (!result) {
                    System.out.println("ALREADY DEFINED");
                }
                symbols.push(scope -> new ScopeSimple<>(scope, false));
                super.visit(n, arg);
                symbols.pop();
            }

            @Override
            public void visit(VariableDeclarator n, Object arg) {
                String id = n.getName().getId();
                Optional<Symbol<Node>> symbol = symbols.resolve(id);
                if (symbol.isPresent()) {

                    System.out.print(n.getRange().get() + ": ");
                    System.out.println(id + " is already declared at " +
                            symbol.get().getNode().getRange().get());
                }
                symbols.define(nodeScope -> new Symbol<>(
                        id,
                        false,
                        access,
                        n,
                        nodeScope,
                        null,
                        null
                ));
                super.visit(n, arg);
            }

            @Override
            public void visit(Parameter n, Object arg) {
                String id = n.getName().getId();
                Optional<Symbol<Node>> symbol = symbols.resolve(id);
                if (symbol.isPresent()) {

                    System.out.print(n.getRange().get() + ": ");
                    System.out.println(id + " is already declared at " +
                            symbol.get().getNode().getRange().get());
                }
                symbols.define(nodeScope -> new Symbol<>(
                        id,
                        false,
                        Access.LOCAL,
                        n,
                        nodeScope,
                        null,
                        null
                ));
                super.visit(n, arg);
            }

        }, new Object());

    }

    private void transform(Node astRoot) {

        astRoot.accept(new ModifierVisitor<Object>() {



        }, new Object());
    }
}

