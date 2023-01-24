package org.example.ast;

import java.util.Objects;
import java.util.Optional;

public class ExprOp extends AbstractNode implements Expr {
    private final Operator operator;
    private final Expr left;
    private final Expr right;

    public ExprOp(Range range, Operator operator, Expr left, Expr right) {
        super(range, left, right);
        this.operator = Objects.requireNonNull(operator);
        this.left = Objects.requireNonNull(left);
        this.right = Objects.requireNonNull(right);
    }

    public ExprOp(Range range, Operator operator, Expr left) {
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

    public Expr getLeft() {
        return left;
    }

    public Optional<Expr> getRight() {
        return Optional.ofNullable(right);
    }

    @Override
    public String getLabel() {
        return operator.getText();
    }
}
