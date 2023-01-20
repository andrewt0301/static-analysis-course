package org.example.ast;

import java.util.Objects;
import java.util.Optional;

public class VarDecl extends AbstractNode implements Stmt {
    private final String name;
    private final Expr expr;

    public VarDecl(String name, Range range) {
        super(range);
        this.name = Objects.requireNonNull(name);
        this.expr = null;
    }

    public VarDecl(String name, Expr expr, Range range) {
        super(range, expr);
        this.name = Objects.requireNonNull(name);
        this.expr = Objects.requireNonNull(expr);
    }

    public String getName() {
        return name;
    }

    public Optional<Expr> getExpr() {
        return Optional.ofNullable(expr);
    }

    @Override
    public String getLabel() {
        return getName();
    }
}
