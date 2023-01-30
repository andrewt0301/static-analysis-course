package org.example.ast;

import java.util.List;
import java.util.Objects;

public class CompilationUnit extends AbstractNode {
    private final List<Fun> functions;

    public CompilationUnit(Range range, List<Fun> functions) {
        super(range, functions);
        this.functions = Objects.requireNonNull(functions);
    }

    public List<Fun> getFunctions() {
        return functions;
    }

    @Override
    public String getLabel() {
        return "";
    }
}
