package org.example.ast;

public class BoolOp extends NodeOpImpl<Bool> implements Bool {
    public BoolOp(Range range, Operator operator, Bool left, Bool right) {
        super(range, operator, left, right);
    }

    public BoolOp(Range range, Operator operator, Bool left) {
        super(range, operator, left);
    }
}
