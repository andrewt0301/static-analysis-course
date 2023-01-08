package org.example.ast;

import java.util.Objects;

public class StmtWhile extends NodeImpl implements Stmt {
    private final Bool condition;
    private final Stmt statement;

    public StmtWhile(Range range, Bool condition, Stmt statement) {
        super(range, condition, statement);
        this.condition = Objects.requireNonNull(condition);
        this.statement = Objects.requireNonNull(statement);
    }

    public Bool getCondition() {
        return condition;
    }

    public Stmt getStatement() {
        return statement;
    }
}
