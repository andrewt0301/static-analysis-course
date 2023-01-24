package org.example.ast;

import java.util.Objects;

public class StmtWhile extends AbstractNode implements Stmt {
    private final Expr condition;
    private final Stmt statement;

    public StmtWhile(Range range, Expr condition, Stmt statement) {
        super(range, condition, statement);
        this.condition = Objects.requireNonNull(condition);
        this.statement = Objects.requireNonNull(statement);
    }

    public Expr getCondition() {
        return condition;
    }

    public Stmt getStatement() {
        return statement;
    }
}
