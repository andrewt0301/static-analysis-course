package org.example.lexer;

import java.util.Objects;

public class Position {
    private final int index;
    private final int line;
    private final int column;

    public Position(int index, int line, int column) {
        this.index = index;
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return index + ":" + line + ":" + column;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        final Position other = (Position) obj;
        return this.index == other.index
                && this.line == other.line
                && this.column == other.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, line, column);
    }
}
