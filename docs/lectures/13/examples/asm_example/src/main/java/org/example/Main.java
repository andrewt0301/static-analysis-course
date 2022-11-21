package org.example;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.util.TraceClassVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println("Hello!");
        } else if (args.length == 3) {
            System.out.println("NO");
        }
        try {
            measureComplexity("org.example.Main");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AnalyzerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printClass(String className) throws IOException {
        ClassPrinter printer = new ClassPrinter();
        ClassReader reader = new ClassReader(className);
        reader.accept(printer, 0);
    }

    public static void traceClass(String className) throws IOException {
        ClassReader reader = new ClassReader(className);
        PrintWriter writer = new PrintWriter(System.out);
        TraceClassVisitor tcv = new TraceClassVisitor(writer);
        reader.accept(tcv, 0);
    }

    public static void measureComplexity(String className) throws IOException, AnalyzerException {
        ClassNode cn = new ClassNode(Opcodes.ASM9);
        ClassReader cr = new ClassReader(className);
        cr.accept(cn, 0);
        CyclomaticComplexity complexity = new CyclomaticComplexity();
        for (MethodNode method : cn.methods) {
            int c = complexity.getCyclomaticComplexity(className, method);
            System.out.println(method.name + " : " + c);
        }
    }
}
