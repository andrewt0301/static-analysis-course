package org.example;

import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.BasicInterpreter;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;
import org.objectweb.asm.tree.analysis.Value;

import java.util.HashSet;
import java.util.Set;

class Node<V extends Value> extends Frame<V> {
    public final Set<Node<V>> successors = new HashSet<>();

    public Node(int nLocals, int nStack) {
        super(nLocals, nStack);
    }

    public Node(Frame<? extends V> src) {
        super(src);
    }
}

public class CyclomaticComplexity {
    public int getCyclomaticComplexity(
            String owner,
            MethodNode mn
    ) throws AnalyzerException {
        Analyzer<BasicValue> analyzer = new Analyzer<BasicValue>(new BasicInterpreter()) {
            @Override
            protected Frame<BasicValue> newFrame(int nLocals, int nStack) {
                return new Node<>(nLocals, nStack);
            }

            @Override
            protected Frame<BasicValue> newFrame(Frame<? extends BasicValue> src) {
                return new Node<>(src);
            }

            @Override
            protected void newControlFlowEdge(int src, int dst) {
                Node<BasicValue> s = (Node<BasicValue>) getFrames()[src];
                s.successors.add((Node<BasicValue>) getFrames()[dst]);
            }
        };
        analyzer.analyze(owner, mn);
        Frame<BasicValue>[] frames = analyzer.getFrames();
        int edges = 0;
        int nodes = 0;
        for (Frame<BasicValue> frame : frames) {
            if (frame != null) {
                edges += ((Node<BasicValue>) frame).successors.size();
                nodes += 1;
            }
        }
        return edges - nodes + 2;
    }
}
