package org.example;

import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Renders ANTLR parse trees into DOT files and images.
 */
public class TreeVisualizer {
    /** ANTLR rule names (from the parser). */
    private final List<String> ruleNames;

    public TreeVisualizer(String[] ruleNames) {
        this(Arrays.asList(ruleNames));
    }

    public TreeVisualizer(List<String> ruleNames) {
        this.ruleNames = Objects.requireNonNull(ruleNames);
    }

    /**
     * Saves the AST to a file in the DOT format.
     *
     * @param root the AST root
     * @param dotFile the DOT file
     * @throws IOException if fails to write to the file
     */
    public void printDot(Tree root, File dotFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dotFile))) {
            writer.println("digraph AST {");
            writer.println("  node [shape=box style=rounded];");
            writeTree(writer, root, 0, -1);
            writer.println("}");
        }
    }

    private int writeTree(
            PrintWriter writer,
            Tree root,
            int currentIndex,
            int parentIndex) {
        writeNode(writer, root, currentIndex);
        if (parentIndex >= 0) {
            writeLink(writer, parentIndex, currentIndex);
        }
        int index = currentIndex;
        for (int i = 0; i < root.getChildCount(); ++i) {
            index = writeTree(
                    writer,
                    root.getChild(i),
                    index + 1, currentIndex
                );
        }
        return index;
    }

    private void writeNode(PrintWriter writer, Tree node, int index) {
        writer.print("  node_");
        writer.print(index);
        writer.print(" [label=<");
        writer.print(getNodeText(node));
        writer.println(">]; // NODE");
    }

    private void writeLink(PrintWriter writer, int fromIndex, int toIndex) {
        writer.print("  node_");
        writer.print(fromIndex);
        writer.print(" -> node_");
        writer.print(toIndex);
        writer.println("; // LINK");
    }

    private String getNodeText(Tree tree) {
        return encodeHtml(Trees.getNodeText(tree, ruleNames));
    }

    private static String encodeHtml(final String str) {
        final StringBuilder result = new StringBuilder();
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            final char charVal = str.charAt(i);
            switch (charVal) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '\'':
                    result.append("&apos;");
                    break;
                case '\"':
                    result.append("&quot;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                default:
                    result.append(charVal);
                    break;
            }
        }
        return result.toString();
    }
}
