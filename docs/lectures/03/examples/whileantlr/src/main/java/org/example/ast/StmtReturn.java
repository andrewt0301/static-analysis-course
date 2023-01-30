package org.example.ast;

import java.util.Objects;
import java.util.Optional;

public class StmtReturn extends AbstractNode implements Stmt {
    private final Expr expr;

    public StmtReturn(Range range, Expr expr) {
        super(range, expr);
        this.expr = Objects.requireNonNull(expr);
    }

    public StmtReturn(Range range) {
        super(range);
        this.expr = null;
    }

    public Optional<Expr> getExpr() {
        return Optional.ofNullable(expr);
    }

    @Override
    public String getLabel() {
        return "";
    }
}
