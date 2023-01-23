package org.example.ast;

import java.util.Objects;

public class VarRef extends AbstractNode implements Expr {
    private final String name;

    public VarRef(Range range, String name) {
        super(range);
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getLabel() {
        return getName();
    }
}
