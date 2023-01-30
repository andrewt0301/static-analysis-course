package org.example.ast;

import java.util.List;
import java.util.Objects;

public class Args extends AbstractNode {
    private final List<ArgDecl> args;

    public Args(Range range, List<ArgDecl> args) {
        super(range, args);
        this.args = Objects.requireNonNull(args);
    }

    public List<ArgDecl> getArgs() {
        return args;
    }

    @Override
    public String getLabel() {
        return "";
    }
}
