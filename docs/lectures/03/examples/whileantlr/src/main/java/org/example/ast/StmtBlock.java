package org.example.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StmtBlock extends NodeImpl implements Stmt {
    private final List<VarDecl> variables;
    private final List<Stmt> statements;

    public StmtBlock(Range range, List<VarDecl> variables, List<Stmt> statements) {
        super(range, concat(variables, statements));
        this.variables = Objects.requireNonNull(variables);
        this.statements = Objects.requireNonNull(statements);
    }

    private static List<Node> concat(List<VarDecl> variables, List<Stmt> statements) {
        List<Node> result = new ArrayList<>(variables.size() + statements.size());
        result.addAll(variables);
        result.addAll(statements);
        return result;
    }

    public List<VarDecl> getVariables() {
        return variables;
    }

    public List<Stmt> getStatements() {
        return statements;
    }
}
