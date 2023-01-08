package org.example.ast;

public class ExprRead extends AbstractNode implements Expr {
    public ExprRead(Range range) {
        super(range);
    }

    @Override
    public String getLabel() {
        return "read";
    }
}
