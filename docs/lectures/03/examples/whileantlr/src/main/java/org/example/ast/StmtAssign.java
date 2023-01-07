package org.example.ast;

import java.util.Objects;

public class StmtAssign extends NodeImpl implements Stmt {
    private final VarRef left;
    private final Expr right;

    public StmtAssign(Range range, VarRef left, Expr right) {
        super(range, left, right);
        this.left = Objects.requireNonNull(left);
        this.right = Objects.requireNonNull(right);
    }

    public VarRef getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }
}
