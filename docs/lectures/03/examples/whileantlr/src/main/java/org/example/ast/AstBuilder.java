package org.example.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AstBuilder extends org.example.WhileParserBaseVisitor<Node> {
    @Override
    public Node visitCompilationUnit(org.example.WhileParser.CompilationUnitContext ctx) {
        return new CompilationUnit(
                newRange(ctx),
                Collections.singletonList((Stmt) visitBlockStmt(ctx.blockStmt()))
            );
    }

    @Override
    public Node visitVarDecl(org.example.WhileParser.VarDeclContext ctx) {
        Range range = newRange(ctx);
        String id = ctx.ID().getText();
        return (ctx.expr() == null)
                ? new VarDecl(range, id)
                : new VarDecl(range, id, (Expr) visitExpr(ctx.expr()));
    }

    @Override
    public Node visitBlockStmt(org.example.WhileParser.BlockStmtContext ctx) {
        List<Stmt> stmts = new ArrayList<>(ctx.children.size());
        ctx.varOrStmt().forEach(
            child -> stmts.add((Stmt) Objects.requireNonNull(visitVarOrStmt(child)))
        );
        return new StmtBlock(newRange(ctx), stmts);
    }

    @Override
    public Node visitAssignStmt(org.example.WhileParser.AssignStmtContext ctx) {
        return new StmtAssign(
                newRange(ctx),
                (VarRef) visitVarRef(ctx.varRef()),
                (Expr) visitExpr(ctx.expr())
        );
    }

    @Override
    public Node visitSkipStmt(org.example.WhileParser.SkipStmtContext ctx) {
        return new StmtSkip(newRange(ctx));
    }

    @Override
    public Node visitWriteStmt(org.example.WhileParser.WriteStmtContext ctx) {
        return new StmtWrite(newRange(ctx), (Expr) visitExpr(ctx.expr()));
    }

    @Override
    public Node visitIfStmt(org.example.WhileParser.IfStmtContext ctx) {
        Range range = newRange(ctx);
        Bool cond = (Bool) visitBool(ctx.bool());
        Stmt ifBlock = (Stmt) visitStmt(ctx.stmt(0));
        return ctx.ELSE() == null
            ? new StmtIf(range, cond, ifBlock)
            : new StmtIf(range, cond, ifBlock, (Stmt) visitStmt(ctx.stmt(1)));
    }

    @Override
    public Node visitWhileStmt(org.example.WhileParser.WhileStmtContext ctx) {
        Range range = newRange(ctx);
        return new StmtWhile(range, (Bool) visitBool(ctx.bool()), (Stmt) visitStmt(ctx.stmt()));
    }

    @Override
    public Node visitVarRef(org.example.WhileParser.VarRefContext ctx) {
        return new VarRef(newRange(ctx), ctx.ID().getText());
    }

    @Override
    public Node visitExpr(org.example.WhileParser.ExprContext ctx) {
        if (ctx.varRef() != null) {
            return visitVarRef(ctx.varRef());
        }
        Range range = newRange(ctx);
        if (ctx.bop != null) {
            return new ExprOp(
                    range,
                    Operator.fromText(ctx.bop.getText()),
                    (Expr) visitExpr(ctx.expr(0)),
                    (Expr) visitExpr(ctx.expr(1))
                );
        }
        if (ctx.uop != null) {
            return new ExprOp(
                    range,
                    Operator.fromText(ctx.uop.getText()),
                    (Expr) visitExpr(ctx.expr(0))
                );
        }
        return new Value(range, "0");
    }

    @Override
    public Node visitBool(org.example.WhileParser.BoolContext ctx) {
        return new BoolValue(newRange(ctx), false);
    }

    private static Range newRange(ParserRuleContext ctx) {
        return new Range(
                newStartPosition(ctx.start),
                newEndPosition(ctx.stop)
        );
    }

    private static Position newStartPosition(Token token) {
        return new Position(
                token.getStartIndex(),
                token.getLine(),
                token.getCharPositionInLine()
        );
    }

    private static Position newEndPosition(Token token) {
        int length = token.getStopIndex() - token.getStartIndex();
        return new Position(
                token.getStartIndex(), token.getLine(),
                token.getCharPositionInLine() + length
        );
    }
}
