package org.example.ast;

import java.util.ArrayList;
import java.util.List;

public class StmtCall extends NodeImpl implements Stmt {
    private final String name;
    private final List<Expr> arguments;

    public StmtCall(Range range, String name, List<Expr> arguments) {
        super(range, new ArrayList<>(arguments));
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public List<Expr> getArguments() {
        return arguments;
    }

    @Override
    public String getLabel() {
        return getName();
    }
}
