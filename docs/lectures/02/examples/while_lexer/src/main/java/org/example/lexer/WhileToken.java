package org.example.lexer;

import java.util.HashMap;
import java.util.Map;

public enum WhileToken implements TokenType {
    EOF       (""),

    NUM       (""),
    ID        (""),

    COMMA     (","),
    SEMI      (";"),
    ASSIGN    (":="),
    LPARENT   ("("),
    RPARENT   (")"),

    PLUS      ("+"),
    MINUS     ("-"),
    DIV       ("/"),
    MUL       ("*"),
    MOD       ("%"),

    NOT       ("not"),
    AND       ("and"),
    OR        ("or"),
    XOR       ("xor"),

    EQ        ("=="),
    NEQ       ("!="),
    LESS      ("<"),
    GT        (">"),
    LEQ       ("<="),
    GTE       (">="),

    BSHL      ("<<"),
    BSHR      (">>"),
    BAND      ("&"),
    BOR       ("|"),
    BXOR      ("^"),

    TRUE      ("true"),
    FALSE     ("false"),
    VAR       ("var"),
    BEGIN     ("begin"),
    END       ("end"),
    IF        ("if"),
    THEN      ("then"),
    ELSE      ("else"),
    WHILE     ("while"),
    DO        ("do"),
    WRITE     ("write"),
    READ      ("read"),
    SKIP      ("skip");

    private static final Map<String, WhileToken> TYPES = new HashMap<>();
    static {
        for (WhileToken type : values()) {
            if (!type.text.isEmpty()) {
                TYPES.put(type.text, type);
            }
        }
    }

    private final String text;

    WhileToken(String text) {
        this.text = text.isEmpty() ? '<' + name() + '>' : text;
    }

    public static WhileToken fromText(String text) {
        return TYPES.get(text);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getId() {
        return ordinal();
    }

    @Override
    public String getName() {
        return name();
    }
}
