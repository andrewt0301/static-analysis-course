package org.example.ast;

import java.util.List;
import java.util.Objects;

public class CompilationUnit extends AbstractNode {
    private final List<Stmt> statements;

    public CompilationUnit(Range range, List<Stmt> statements) {
        super(range, statements);
        this.statements = Objects.requireNonNull(statements);
    }

    public List<Stmt> getStatements() {
        return statements;
    }

    @Override
    public String getLabel() {
        return "";
    }
}
