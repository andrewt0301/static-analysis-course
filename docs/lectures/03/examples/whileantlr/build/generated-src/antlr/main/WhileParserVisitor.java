// Generated from WhileParser.g4 by ANTLR 4.9.2
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WhileParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(WhileParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(WhileParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(WhileParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(WhileParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(WhileParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(WhileParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(WhileParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#skipStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStmt(WhileParser.SkipStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(WhileParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(WhileParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(WhileParser.BoolContext ctx);
}