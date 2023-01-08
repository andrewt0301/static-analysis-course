package org.example.ast;

import java.util.Objects;

public class VarRef extends NodeImpl implements Expr {
    private final String name;

    public VarRef(String value, Range range) {
        super(range);
        this.name = Objects.requireNonNull(value);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getLabel() {
        return getName();
    }
}
