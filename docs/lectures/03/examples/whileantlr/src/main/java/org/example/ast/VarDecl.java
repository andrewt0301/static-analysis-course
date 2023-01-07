package org.example.ast;

import java.util.Collections;
import java.util.Objects;

public class VarDecl extends NodeImpl {
    private final String name;

    public VarDecl(String value, Range range) {
        super(range, Collections.emptyList());
        this.name = Objects.requireNonNull(value);
    }

    public String getName() {
        return name;
    }
}
