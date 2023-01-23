package org.example.ast;

import java.util.Objects;
import java.util.Optional;

public class VarDecl extends AbstractNode implements Stmt {
    private final String name;
    private final Expr expr;

    public VarDecl(Range range, String name) {
        super(range);
        this.name = Objects.requireNonNull(name);
        this.expr = null;
    }

    public VarDecl(Range range, String name, Expr expr) {
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
