package org.example.symbols;

import java.util.Optional;

/**
 * The {@link Scope} interface describes a symbol scope.
 *
 * @param <N> Type of AST node associated with a symbol. Not important for implementation.
 * @since 2021/10/08
 */
public interface Scope<N> {
    /**
     * Get scope depth.
     *
     * @return scope depth
     */
    int getDepth();

    /**
     * Returns true if the scope is static.
     *
     * @return {@code true} if the scope is static or {@code false} otherwise
     */
    boolean isStatic();

    /**
     * Defines the specified symbol in the current scope.
     *
     * @param symbol symbol to be defined
     * @return {@code true} if a new symbol is defined, {@code false}
     *         if a symbol with such name is already defined in the scope
     * @throws IllegalArgumentException if {@code symbol} is {@code null};
     *         if a symbol with such a name is already defined in the current scope
     */
    boolean define(Symbol<N> symbol);

    /**
     * Searches for a symbol by its name in the current scope.
     *
     * @param name symbol name
     * @return symbol or an empty Optional if symbol not found
     */
    Optional<Symbol<N>> resolve(String name);

    /**
     * Returns the outer scope for the current scope.
     *
     * @return outer scope or {@code null} if there is no outer scope
     */
    Scope<N> getOuterScope();

    /**
     * Returns symbol associated with the scope (or containing the scope)
     * or {@code null} it there is not such symbol.
     *
     * @return associated symbol or {@code null} it there is no such symbol
     */
    Symbol<N> getSymbol();

    /**
     * Returns all symbols declared in the scope.
     *
     * @return all symbols in the scope
     */
    Iterable<Symbol<N>> getMembers();
}
