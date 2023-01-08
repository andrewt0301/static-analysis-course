package org.example.ast;

import java.util.Objects;

public class StmtWrite extends NodeImpl implements Stmt {
    private final Expr argument;

    public StmtWrite(Range range, Expr argument) {
        super(range, argument);
        this.argument = Objects.requireNonNull(argument);
    }

    public Expr getArgument() {
        return argument;
    }

    @Override
    public String getLabel() {
        return "write";
    }
}
