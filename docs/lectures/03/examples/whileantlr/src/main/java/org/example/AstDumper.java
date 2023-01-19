package org.example;

import org.example.ast.Node;

/**
 * Dumps AST into text.
 */
public class AstDumper {
    /** New line separator. */
    private static final String NL = System.lineSeparator();

    public String printTree(Node root) {
        StringBuilder buffer = new StringBuilder();
        printTree(buffer, root);
        return buffer.toString();
    }

    public void printTree(StringBuilder buffer, Node root) {
        recursive(root, buffer, 0);
    }

    private void recursive(Node root, StringBuilder buffer, int offset) {
        printOffset(buffer, offset);
        buffer.append(getNodeText(root)).append(NL);
        for (Node child : root.getChildren()) {
            recursive(child, buffer, offset + 1);
        }
    }

    private static void printOffset(StringBuilder buffer, int offset) {
        for (int i = 0; i < offset; ++i) {
            buffer.append("  ");
        }
    }

    private String getNodeText(Node node) {
        String type = node.getClass().getSimpleName();
        String label = node.getLabel();
        return label.isEmpty() ? type : type + " : " + label;
    }
}
