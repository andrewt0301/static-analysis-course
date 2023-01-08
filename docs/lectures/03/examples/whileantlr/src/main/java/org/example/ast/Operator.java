package org.example.ast;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    PLUS    ("+"),
    MINUS   ("-"),
    DIV     ("/"),
    MUL     ("*"),
    MOD     ("%"),

    NOT     ("not"),
    AND     ("and"),
    OR      ("or"),
    XOR     ("xor"),

    EQ      ("=="),
    NEQ     ("!="),
    LESS    ("<"),
    GT      (">"),
    LEQ     ("<="),
    GTE     (">="),

    BSHL    ("<<"),
    BSHR    (">>"),
    BAND    ("&"),
    BOR     ("|"),
    BXOR    ("^"),
    BNOT    ("~");

    private static final Map<String, Operator> OP_BY_TEXT = new HashMap<>();
    static {
        for (Operator operator : values()) {
            OP_BY_TEXT.put(operator.text, operator);
        }
    }

    private final String text;

    Operator(String text) {
        this.text = text;
    }

    public static Operator fromText(String text) {
        return OP_BY_TEXT.get(text);
    }

    public String getText() {
        return text;
    }
}
