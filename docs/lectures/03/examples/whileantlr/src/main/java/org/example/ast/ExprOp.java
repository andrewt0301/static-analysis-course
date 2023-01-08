package org.example.ast;

public class ExprOp extends AbstractOp<Expr> implements Expr {
    public ExprOp(Range range, Operator operator, Expr left, Expr right) {
        super(range, operator, left, right);
    }

    public ExprOp(Range range, Operator operator, Expr left) {
        super(range, operator, left);
    }
}
