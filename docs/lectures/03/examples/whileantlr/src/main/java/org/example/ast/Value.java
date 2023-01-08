package org.example.ast;

import java.util.Objects;

public class Value extends NodeImpl implements Expr {
    private final String value;

    public Value(String value, Range range) {
        super(range);
        this.value = Objects.requireNonNull(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return getValue();
    }
}
