// Generated from WhileParser.g4 by ANTLR 4.9.2
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileParser}.
 */
public interface WhileParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(WhileParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(WhileParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(WhileParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(WhileParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(WhileParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(WhileParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(WhileParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(WhileParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(WhileParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(WhileParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(WhileParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(WhileParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(WhileParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(WhileParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(WhileParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(WhileParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#skipStmt}.
	 * @param ctx the parse tree
	 */
	void enterSkipStmt(WhileParser.SkipStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#skipStmt}.
	 * @param ctx the parse tree
	 */
	void exitSkipStmt(WhileParser.SkipStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(WhileParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(WhileParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(WhileParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(WhileParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(WhileParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(WhileParser.BoolContext ctx);
}