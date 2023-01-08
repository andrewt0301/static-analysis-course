package org.example.ast;

public class StmtSkip extends AbstractNode implements Stmt {
    public StmtSkip(Range range) {
        super(range);
    }

    @Override
    public String getLabel() {
        return "skip";
    }
}
