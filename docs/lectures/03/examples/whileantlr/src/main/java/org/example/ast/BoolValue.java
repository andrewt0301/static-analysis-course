package org.example.ast;

public class BoolValue extends NodeImpl implements Bool {
    private final boolean value;

    public BoolValue(Range range, boolean value) {
        super(range);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return Boolean.toString(value);
    }
}
