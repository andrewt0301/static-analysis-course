package org.example.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.example.WhileParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AstBuilder extends org.example.WhileParserBaseVisitor<Node> {
    @Override
    public Node visitCompilationUnit(org.example.WhileParser.CompilationUnitContext ctx) {
        return new CompilationUnit(
                newRange(ctx),
                ctx.fun()
                    .stream()
                    .map(f -> (Fun) Objects.requireNonNull(visitFun(f)))
                    .collect(Collectors.toList())
            );
    }

    @Override
    public Node visitFun(WhileParser.FunContext ctx) {
        return new Fun(
            newRange(ctx),
            ctx.ID().getText(),
            (Args) visitArgs(ctx.args()),
            (StmtBlock) visitBlockStmt(ctx.blockStmt())
        );
    }

    @Override
    public Node visitArgs(WhileParser.ArgsContext ctx) {
        return new Args(
            newRange(ctx),
            ctx.argDecl().stream().map(a -> new ArgDecl(newRange(a), a.ID().getText())).collect(Collectors.toList())
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
        Expr cond = (Expr) visitBool(ctx.bool());
        Stmt ifBlock = (Stmt) visitStmt(ctx.stmt(0));
        return ctx.ELSE() == null
            ? new StmtIf(range, cond, ifBlock)
            : new StmtIf(range, cond, ifBlock, (Stmt) visitStmt(ctx.stmt(1)));
    }

    @Override
    public Node visitWhileStmt(org.example.WhileParser.WhileStmtContext ctx) {
        Range range = newRange(ctx);
        return new StmtWhile(range, (Expr) visitBool(ctx.bool()), (Stmt) visitStmt(ctx.stmt()));
    }

    @Override
    public Node visitRetStmt(org.example.WhileParser.RetStmtContext ctx) {
        Range range = newRange(ctx);
        return ctx.expr() == null
            ? new StmtReturn(range)
            : new StmtReturn(range, (Expr) visitExpr(ctx.expr()));
    }

    @Override
    public Node visitVarRef(org.example.WhileParser.VarRefContext ctx) {
        return new VarRef(newRange(ctx), ctx.ID().getText());
    }

    @Override
    public Node visitExpr(org.example.WhileParser.ExprContext ctx) {
        if (ctx.bop != null) {
            return new ExprOp(
                    newRange(ctx),
                    Operator.fromText(ctx.bop.getText()),
                    (Expr) visitExpr(ctx.expr(0)),
                    (Expr) visitExpr(ctx.expr(1))
                );
        }
        if (ctx.uop != null) {
            return new ExprOp(
                    newRange(ctx),
                    Operator.fromText(ctx.uop.getText()),
                    (Expr) visitExpr(ctx.expr(0))
                );
        }
        return super.visitExpr(ctx);
    }

    @Override
    public Node visitAtom(org.example.WhileParser.AtomContext ctx) {
        if (ctx.NUM() != null) {
            return new Value(newRange(ctx), ctx.NUM().getText());
        }
        if (ctx.READ() != null) {
            return new ExprRead(newRange(ctx));
        }
        if (ctx.expr() != null) {
            return visitExpr(ctx.expr());
        }
        return super.visitAtom(ctx);
    }

    @Override
    public Node visitBool(org.example.WhileParser.BoolContext ctx) {
        if (ctx.NOT() != null) {
            return new ExprOp(
                    newRange(ctx),
                    Operator.NOT,
                    (Expr) visitBool(ctx.bool(0))
                );
        }
        if (ctx.bop != null) {
            return new ExprOp(
                    newRange(ctx),
                    Operator.fromText(ctx.bop.getText()),
                    (Expr) visitExpr(ctx.expr(0)),
                    (Expr) visitExpr(ctx.expr(1))
                );
        }
        return super.visitBool(ctx);
    }

    @Override
    public Node visitBoolAtom(org.example.WhileParser.BoolAtomContext ctx) {
        if (ctx.val != null) {
            return new BoolValue(newRange(ctx), Boolean.parseBoolean(ctx.val.getText()));
        }
        return super.visitBool(ctx.bool());
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
                token.getCharPositionInLine() + 1
            );
    }

    private static Position newEndPosition(Token token) {
        int length = token.getStopIndex() - token.getStartIndex();
        return new Position(
                token.getStartIndex(),
                token.getLine(),
                token.getCharPositionInLine() + length + 2
            );
    }
}
