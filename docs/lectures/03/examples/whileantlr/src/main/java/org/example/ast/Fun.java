package org.example.ast;

import java.util.Objects;

public class Fun extends AbstractNode {
    private final String name;
    private final Args args;
    private final StmtBlock stmts;

    public Fun(Range range, String name, Args args, StmtBlock stmts) {
        super(range, args, stmts);
        this.name = Objects.requireNonNull(name);
        this.args = Objects.requireNonNull(args);
        this.stmts = Objects.requireNonNull(stmts);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getLabel() {
        return getName();
    }

    public Args getArgs() {
        return args;
    }

    public StmtBlock getStmts() {
        return stmts;
    }
}
