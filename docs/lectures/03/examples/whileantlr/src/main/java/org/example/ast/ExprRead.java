package org.example.ast;

public class ExprRead extends NodeImpl implements Expr {
    public ExprRead(Range range) {
        super(range);
    }

    @Override
    public String getLabel() {
        return "read";
    }
}
