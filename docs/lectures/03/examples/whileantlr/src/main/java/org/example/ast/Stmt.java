package org.example.ast;

public interface Stmt extends Node {
    @Override
    default String getLabel() {
        return "";
    }
}
