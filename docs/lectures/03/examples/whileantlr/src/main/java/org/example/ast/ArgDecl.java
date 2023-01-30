package org.example.ast;

import java.util.Objects;

public class ArgDecl extends AbstractNode {
    private final String name;

    public ArgDecl(Range range, String name) {
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
