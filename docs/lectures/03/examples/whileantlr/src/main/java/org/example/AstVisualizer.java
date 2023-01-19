package org.example;

import org.example.ast.Node;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Renders ASTs into DOT files.
 */
public class AstVisualizer {
    /**
     * Saves the AST to a file in the DOT format.
     *
     * @param root the AST root
     * @param dotFile the DOT file
     * @throws IOException if fails to write to the file
     */
    public void printDot(Node root, Path dotFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(dotFile))) {
            writer.println("digraph AST {");
            writer.println("  node [shape=box style=rounded];");
            writeTree(writer, root, 0, -1);
            writer.println("}");
        }
    }

    private int writeTree(
            PrintWriter writer,
            Node root,
            int currentIndex,
            int parentIndex) {
        writeNode(writer, root, currentIndex);
        if (parentIndex >= 0) {
            writeLink(writer, parentIndex, currentIndex);
        }
        int index = currentIndex;
        for (Node child : root.getChildren()) {
            index = writeTree(writer, child,index + 1, currentIndex);
        }
        return index;
    }

    private void writeNode(PrintWriter writer, Node node, int index) {
        String type = node.getClass().getSimpleName();
        String label = node.getLabel();
        writer.print("  node_");
        writer.print(index);
        writer.print(" [label=<");
        writer.print(Utils.encodeHtml(type));
        if (!label.isEmpty()) {
            writer.print("<br/><font color=\"blue\">");
            writer.print(Utils.encodeHtml(label));
            writer.print("</font>");
        }
        writer.println(">]; // NODE");
    }

    private void writeLink(PrintWriter writer, int fromIndex, int toIndex) {
        writer.print("  node_");
        writer.print(fromIndex);
        writer.print(" -> node_");
        writer.print(toIndex);
        writer.println("; // LINK");
    }
}
