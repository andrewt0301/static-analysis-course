package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;

/**
 * Dumps ANTLR parse tree into text.
 */
public class TreeDumper {
    /** New line separator. */
    private static final String NL = System.lineSeparator();

    /** ANTLR rule names (from the parser). */
    private final List<String> ruleNames;

    public TreeDumper(String[] ruleNames) {
        this(Arrays.asList(ruleNames));
    }

    public TreeDumper(List<String> ruleNames) {
        this.ruleNames = Objects.requireNonNull(ruleNames);
    }

    public String printTree(Tree root) {
        StringBuilder buffer = new StringBuilder();
        printTree(buffer, root);
        return buffer.toString();
    }

    public void printTree(StringBuilder buffer, Tree root) {
        recursive(root, buffer, 0);
    }

    private void recursive(Tree root, StringBuilder buffer, int offset) {
        printOffset(buffer, offset);
        buffer.append(getNodeText(root)).append(NL);
        for (int i = 0; i < root.getChildCount(); ++i) {
            recursive(root.getChild(i), buffer, offset + 1);
        }
    }

    private static void printOffset(StringBuilder buffer, int offset) {
        for (int i = 0; i < offset; ++i) {
            buffer.append("  ");
        }
    }

    private String getNodeText(Tree tree) {
        return Trees.getNodeText(tree, ruleNames);
    }
}
