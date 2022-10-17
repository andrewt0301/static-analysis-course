package org.example.symbols;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The {@link ScopeExtended} class implements a symbol scope extended by other scopes.
 * <p>
 * Such implementation is used to implement lookup for classes that
 * extend other classes and implement interfaces.
 *
 * @param <N> Type of AST node associated with a symbol. Not important for implementation.
 * @since 2021/10/08
 */
public class ScopeExtended<N> implements Scope<N> {
    /**
     * Main scope.
     */
    private final Scope<N> mainScope;

    /**
     * Included scopes.
     */
    private final List<Scope<N>> includedScopes;

    /**
     * Constructs a scope extended by other scopes.
     *
     * @param mainScope main scope
     * @param includedScopes included scopes (e.g. scopes of inherited classes)
     */
    public ScopeExtended(final Scope<N> mainScope, final List<Scope<N>> includedScopes) {
        this.mainScope = Objects.requireNonNull(mainScope);
        this.includedScopes = Objects.requireNonNull(includedScopes);
    }

    /**
     * Get scope depth.
     *
     * @return scope depth
     */
    @Override
    public int getDepth() {
        return mainScope.getDepth();
    }

    /**
     * Returns true if the scope is static.
     *
     * @return {@code true} if the scope is static or {@code false} otherwise
     */
    @Override
    public boolean isStatic() {
        return mainScope.isStatic();
    }

    /**
     * Defines the specified symbol in the current scope.
     *
     * @param symbol symbol to be defined
     * @return {@code true} if a new symbol is defined, {@code false}
     *         if a symbol with such name is already defined in the scope
     * @throws IllegalArgumentException if {@code symbol} is {@code null};
     *         if a symbol with such a name is already defined in the current scope
     */
    @Override
    public boolean define(final Symbol<N> symbol) {
        return mainScope.define(symbol);
    }

    /**
     * Searches for a symbol by its name in the current scope.
     *
     * @param name symbol name
     * @return symbol or an empty Optional if symbol not found
     */
    @Override
    public Optional<Symbol<N>> resolve(final String name) {
        Optional<Symbol<N>> symbol = mainScope.resolve(name);
        if (symbol.isPresent()) {
            return symbol;
        }
        for (final Scope<N> includedScope : includedScopes) {
            symbol = includedScope.resolve(name);
            if (symbol.isPresent()) {
                return symbol;
            }
        }
        return Optional.empty();
    }

    /**
     * Returns the outer scope for the current scope.
     *
     * @return outer scope or {@code null} if there is no outer scope.
     */
    @Override
    public Scope<N> getOuterScope() {
        return mainScope.getOuterScope();
    }

    /**
     * Returns symbol associated with the scope (or containing the scope)
     * or {@code null} it there is not such symbol.
     *
     * @return associated symbol or {@code null} it there is no such symbol.
     */
    @Override
    public Symbol<N> getSymbol() {
        return mainScope.getSymbol();
    }

    /**
     * Returns all symbols declared in the scope.
     *
     * @return all symbols in the scope
     */
    @Override
    public Iterable<Symbol<N>> getMembers() {
        return mainScope.getMembers();
    }
}
