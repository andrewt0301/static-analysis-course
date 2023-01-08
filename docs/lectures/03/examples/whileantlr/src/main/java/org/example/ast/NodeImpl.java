package org.example.ast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class NodeImpl implements Node {
    private final Range range;
    private final List<Node> children;

    @SuppressWarnings("unchecked")
    public NodeImpl(Range range, List<? extends Node> children) {
        this.range = Objects.requireNonNull(range);
        this.children = (List<Node>) Objects.requireNonNull(children);
    }

    public NodeImpl(Range range) {
        this(range, Collections.emptyList());
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
