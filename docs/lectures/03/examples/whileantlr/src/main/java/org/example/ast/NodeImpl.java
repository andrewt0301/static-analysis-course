package org.example.ast;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NodeImpl implements Node {
    private final Range range;
    private final List<Node> children;

    public NodeImpl(Range range, List<Node> children) {
        this.range = Objects.requireNonNull(range);
        this.children = Objects.requireNonNull(children);
    }

    public NodeImpl(Range range, Node... children) {
        this(range, Arrays.asList(children));
    }

    public Range getRange() {
        return range;
    }

    public List<Node> getChildren() {
        return children;
    }
}
