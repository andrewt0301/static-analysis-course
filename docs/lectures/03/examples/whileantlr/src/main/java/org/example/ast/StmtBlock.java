package org.example.ast;

import java.util.List;
import java.util.Objects;

public class StmtBlock extends AbstractNode implements Stmt {
    private final List<Stmt> statements;

    public StmtBlock(Range range, List<Stmt> statements) {
        super(range,statements);
        this.statements = Objects.requireNonNull(statements);
    }

    public List<Stmt> getStatements() {
        return statements;
    }
}
