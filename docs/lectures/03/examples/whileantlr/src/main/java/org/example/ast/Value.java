package org.example.ast;

import java.util.Objects;

public class Value extends AbstractNode implements Expr {
    private final String value;

    public Value(Range range, String value) {
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
