package org.example.lexer;

import java.util.Objects;

public class Range {
    private final Position start;
    private final Position end;

    public Range(Position start, Position end) {
        this.start = Objects.requireNonNull(start);
        this.end = Objects.requireNonNull(end);
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Range other = (Range) o;
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
