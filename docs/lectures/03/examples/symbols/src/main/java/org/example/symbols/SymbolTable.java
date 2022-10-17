package org.example.symbols;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * This class implements a symbol table.
 *
 * @param <N> node type parameter
 * @since 2021/10/08
 */
public class SymbolTable<N> {
    /**
     * Global scope for reserved names.
     */
    private final Scope<N> globalScope;

    /**
     * Current scope.
     */
    private Scope<N> scope;

    /**
     * Constructs a symbol table with a global scope.
     *
     * @param globalScope global scope
     */
    public SymbolTable(final Scope<N> globalScope) {
        this.globalScope = Objects.requireNonNull(globalScope);
        this.scope = globalScope;
    }

    /**
     * Returns the current scope.
     *
     * @return current scope
     */
    public Scope<N> peek() {
        return scope;
    }

    /**
     * Creates a new scope and puts it as the current scope.
     *
     * @param scopeFactory creates a nested scope for the current scope
     */
    public void push(final Function<Scope<N>, Scope<N>> scopeFactory) {
        final Scope<N> newScope = scopeFactory.apply(scope);
        this.scope = Objects.requireNonNull(newScope);
    }

    /**
     * Discards the current scope and replaces it with its outer scope.
     *
     * @throws IllegalStateException if the current scope is the global scope (must not be popped)
     */
    public void pop() {
        if (globalScope == scope) {
            throw new IllegalStateException("Cannot pop the global scope.");
        }
        scope = scope.getOuterScope();
    }

    /**
     * Defines the specified symbol in the current scope.
     *
     * @param symbolFactory creates the symbol to be defined
     * @return {@code true} if a new symbol is defined,
     *         {@code false} if a symbol with such name is already defined in the scope
     */
    public boolean define(final Function<Scope<N>, Symbol<N>> symbolFactory) {
        final Symbol<N> newSymbol = symbolFactory.apply(peek());
        return peek().define(Objects.requireNonNull(newSymbol));
    }

    /**
     * Searches for a symbol by its name in the current scope and its outer scopes.
     *
     * @param name symbol name
     * @return symbol or an empty Optional if it is not found
     */
    public Optional<Symbol<N>> resolve(final String name) {
        Scope<N> currentScope = peek();
        Optional<Symbol<N>> symbol = Optional.empty();
        boolean needStatic = false;
        while (!symbol.isPresent() && currentScope != null) {
            symbol = currentScope.resolve(name);
            if (!symbol.isPresent()) {
                needStatic = currentScope.isStatic(); // method static
                currentScope = currentScope.getOuterScope();
            }
        }
        if (symbol.isPresent() && needStatic) {
            return symbol.get().isStatic() ? symbol : Optional.empty();
        }
        return symbol;
    }

    /**
     * Searches for a symbol by its name in the current scope only.
     * Outer scopes are not searched.
     *
     * @param name symbol name
     * @return symbol or an empty Optional if it is not found
     */
    public Optional<Symbol<N>> resolveMember(final String name) {
        return peek().resolve(name);
    }

    /**
     * Searches for a symbol described by an array containing its name
     * preceded with names of the scopes it is nested into.
     * <p>
     * Search starts in the current scope and goes to outer scopes until
     * the first nesting scope is found. Then the search is continued in that scope.
     *
     * @param names array of names
     * @return symbol or an empty Optional if it is not found
     */
    public Optional<Symbol<N>> resolveNested(final String... names) {
        Optional<Symbol<N>> symbol = resolve(names[0]);
        for (int index = 1; index < names.length; ++index) {
            if (!symbol.isPresent()) {
                return Optional.empty();
            }
            final Scope<N> innerScope = symbol.get().getInnerScope();
            if (innerScope == null) {
                return Optional.empty();
            }
            symbol = innerScope.resolve(names[index]);
        }
        return symbol;
    }

    /**
     * Searches for a symbol by its name in the global scope only.
     *
     * @param name symbol name
     * @return symbol or an empty Optional if it is not found
     */
    public Optional<Symbol<N>> resolveGlobal(final String name) {
        return globalScope.resolve(name);
    }
}
