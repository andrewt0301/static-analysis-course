package org.example.symbols;

import java.util.Objects;

/**
 * The {@link Symbol} class describes a record in a symbol table.
 *
 * @param <N> Type of AST node associated with a symbol. Not important for implementation.
 * @since 2021/10/08
 */
@SuppressWarnings("PMD.DataClass")
public class Symbol<N> {
    /**
     * Symbol name.
     */
    private final String name;

    /**
     * Marker defining if symbol has static modifier.
     */
    private final boolean aStatic;

    /**
     * Symbol's access modifier.
     */
    private final Access access;

    /**
     * Symbol node.
     */
    private final N node;

    /**
     * The outer scope.
     */
    private final Scope<N> outerScope;

    /**
     * The inner scope.
     */
    private final Scope<N> innerScope;

    /**
     * The tag.
     */
    private final Object tag;

    /**
     * Constructs a symbol.
     *
     * @param name symbol name used for lookups
     * @param isStatic flags that specifies whether the symbol is static
     * @param access access type
     * @param node AST node associated with the symbol
     * @param outerScope scope where the symbol is defined
     * @param innerScope scope nested into the symbol
     * @param tag tag object, additional information on the symbol specific to symbol type
     */
    public Symbol(
            final String name,
            final boolean isStatic,
            final Access access,
            final N node,
            final Scope<N> outerScope,
            final Scope<N> innerScope,
            final Object tag) {
        this.name = Objects.requireNonNull(name);
        this.aStatic = isStatic;
        this.access = Objects.requireNonNull(access);
        this.node = Objects.requireNonNull(node);
        this.outerScope = Objects.requireNonNull(outerScope);
        this.innerScope = innerScope;
        this.tag = tag;
    }

    /**
     * Returns the symbol name.
     *
     * @return Symbol name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns true if the symbol is static.
     *
     * @return {@code true} if the symbol is static or {@code false} otherwise
     */
    public boolean isStatic() {
        return aStatic;
    }

    /**
     * Returns information on access type.
     *
     * @return access type
     */
    public Access getAccess() {
        return access;
    }

    /**
     * Returns an AST node associated with the symbol.
     *
     * @return node
     */
    public N getNode() {
        return node;
    }

    /**
     * Returns the scope where the symbol is defined.
     *
     * @return scope where the symbol is defined
     */
    public Scope<N> getOuterScope() {
        return outerScope;
    }

    /**
     * Returns the scope nested into the symbol.
     *
     * @return nested scope or {@code null} if the symbol has no nested scope
     */
    public Scope<N> getInnerScope() {
        return innerScope;
    }

    /**
     * Returns the tag object (some additional information) associated with the symbol.
     *
     * @return tag object or {@code null} if it is not assigned
     */
    public Object getTag() {
        return tag;
    }
}

