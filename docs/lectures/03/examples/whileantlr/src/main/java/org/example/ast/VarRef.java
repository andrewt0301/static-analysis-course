package org.example.ast;

import java.util.Collections;
import java.util.Objects;

public class VarRef extends NodeImpl implements Expr {
    private final String name;

    public VarRef(String value, Range range) {
        super(range, Collections.emptyList());
        this.name = Objects.requireNonNull(value);
    }

    public String getName() {
        return name;
    }
}
