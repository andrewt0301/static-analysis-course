package org.example.ast;

import java.util.Objects;
import java.util.Optional;

public class StmtIf extends NodeImpl implements Stmt {
    private final Bool condition;
    private final Stmt ifStatement;
    private final Stmt elseStatement;

    public StmtIf(
            Range range,
            Bool condition,
            Stmt ifStatement,
            Stmt elseStatement) {
        super(range, condition, ifStatement, elseStatement);
        this.condition = Objects.requireNonNull(condition);
        this.ifStatement = Objects.requireNonNull(ifStatement);
        this.elseStatement = Objects.requireNonNull(elseStatement);
    }

    public StmtIf(
            Range range,
            Bool condition,
            Stmt ifStatement) {
        super(range, condition, ifStatement);
        this.condition = Objects.requireNonNull(condition);
        this.ifStatement = Objects.requireNonNull(ifStatement);
        this.elseStatement = null;
    }

    public Bool getCondition() {
        return condition;
    }

    public Stmt getIfStatement() {
        return ifStatement;
    }

    public Optional<Stmt> getElseStatement() {
        return Optional.ofNullable(elseStatement);
    }
}
