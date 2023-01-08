package org.example.ast;

import java.util.Objects;
import java.util.Optional;

public class AbstractOp<T extends Node> extends AbstractNode {
    private final Operator operator;
    private final T left;
    private final T right;

    public AbstractOp(Range range, Operator operator, T left, T right) {
        super(range, left, right);
        this.operator = Objects.requireNonNull(operator);
        this.left = Objects.requireNonNull(left);
        this.right = Objects.requireNonNull(right);
    }

    public AbstractOp(Range range, Operator operator, T left) {
        super(range, left);
        this.operator = Objects.requireNonNull(operator);
        this.left = Objects.requireNonNull(left);
        this.right = null;
    }

    public boolean isBinary() {
        return right != null;
    }

    public Operator getOperator() {
        return operator;
    }

    public T getLeft() {
        return left;
    }

    public Optional<T> getRight() {
        return Optional.ofNullable(right);
    }

    @Override
    public String getLabel() {
        return operator.getText();
    }
}
