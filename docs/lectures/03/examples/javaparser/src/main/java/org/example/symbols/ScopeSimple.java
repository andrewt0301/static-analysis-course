package org.example.symbols;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The {@link ScopeSimple} class implements a symbol scope.
 *
 * @param <N> Type of AST node associated with a symbol. Not important for implementation.
 * @since 2021/10/08
 */
@SuppressWarnings("PMD.DataClass")
public class ScopeSimple<N> implements Scope<N> {
    /**
     * The outer scope.
     */
    private final Scope<N> outerScope;

    /**
     * Scope members.
     */
    private final Map<String, Symbol<N>> members;

    /**
     * Scope depth.
     */
    private final int depth;

    /**
     * Marker defining if symbol has static modifier.
     */
    private final boolean aStatic;

    /**
     * The scope symbol.
     */
    private final Symbol<N> symbol;

    /**
     * Main constructor for simple scope.
     *
     * @param outerScope outer scope
     * @param isStatic static marker
     * @param symbol symbol associated with scope or {@code null}
     */
    public ScopeSimple(
            final Scope<N> outerScope,
            final boolean isStatic,
            final Symbol<N> symbol) {
        this.outerScope = outerScope;
        this.members = new HashMap<>();
        this.depth = outerScope == null ? 0 : outerScope.getDepth() + 1;
        this.aStatic = isStatic;
        this.symbol = symbol;
    }

    /**
     * Instantiates a new Scope simple.
     *
     * @param outerScope outer scope
     * @param isStatic static marker
     */
    public ScopeSimple(final Scope<N> outerScope, final boolean isStatic) {
        this(outerScope, isStatic, null);
    }

    /**
     * Instantiates a new simple scope.
     */
    public ScopeSimple() {
        this(null, false, null);
    }

    /**
     * Get scope depth.
     *
     * @return scope depth
     */
    @Override
    public int getDepth() {
        return depth;
    }

    /**
     * Returns true if the scope is static.
     *
     * @return {@code true} if the scope is static or {@code false} otherwise
     */
    @Override
    public boolean isStatic() {
        return aStatic;
    }

    /**
     * Defines the specified symbol in the current scope.
     *
     * @param symbolToDef symbol to be defined
     * @return {@code true} if a new symbol is defined,
     *         {@code false} if a symbol with such name is already defined in the scope
     * @throws IllegalArgumentException if {@code symbol} is {@code null};
     *         if a symbol with such a name is already defined in the current scope
     */
    @Override
    public boolean define(final Symbol<N> symbolToDef) {
        return members.put(symbolToDef.getName(), symbolToDef) == null;
    }

    /**
     * Searches for a symbol by its name in the current scope.
     *
     * @param name symbol name
     * @return symbol or an empty Optional if symbol not found
     */
    @Override
    public Optional<Symbol<N>> resolve(final String name) {
        return Optional.ofNullable(members.get(name));
    }

    /**
     * Returns the outer scope for the current scope.
     *
     * @return outer scope or {@code null} if there is no outer scope
     */
    @Override
    public Scope<N> getOuterScope() {
        return outerScope;
    }

    /**
     * Returns symbol associated with the scope (or containing the scope)
     * or {@code null} it there is not such symbol.
     *
     * @return associated symbol or {@code null} it there is no such symbol
     */
    @Override
    public Symbol<N> getSymbol() {
        return symbol;
    }

    /**
     * Returns all symbols declared in the scope.
     *
     * @return all symbols in the scope
     */
    @Override
    public Iterable<Symbol<N>> getMembers() {
        return members.values();
    }
}
