package org.example.ast;

import java.util.Collections;
import java.util.Objects;

public class Value extends NodeImpl implements Expr {
    private final String value;

    public Value(String value, Range range) {
        super(range, Collections.emptyList());
        this.value = Objects.requireNonNull(value);
    }

    public String getValue() {
        return value;
    }
}
