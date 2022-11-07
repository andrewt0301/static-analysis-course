package org.example;

import fr.inria.controlflow.ControlFlowBuilder;
import fr.inria.controlflow.ControlFlowGraph;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Entry point for CFG analysis.
 */
public class Main {
    /**
     * Runs CFG analysis for the given file.
     *
     * @param args the file to analyze (e.g. {@code ./src/test/Test.java})
     */
    public static void main(String[] args) {
        String filePath = args[0];
        CtModel model = parse(filePath);
        for (CtType<?> type : model.getAllTypes()) {
            String className = type.getSimpleName();
            System.out.println("Type: " + className);
            for (CtMethod<?> method : type.getAllMethods()) {
                String methodName = method.getSimpleName();
                System.out.println("    Method: " + methodName);
                if (method.getPosition().isValidPosition()) {
                    ControlFlowBuilder builder = new ControlFlowBuilder();
                    ControlFlowGraph graph = builder.build(method);
                    visualizeCfg(graph, filePath, className, methodName);
                    processCfg(graph);
                }
            }
        }
    }

    /**
     * Processes the CFG to find violations.
     *
     * @param graph the CFG
     */
    private static void processCfg(ControlFlowGraph graph) {
        // Implement analysis here!
    }

    /**
     * Parses the specified file with Spoon parser.
     *
     * @param fileName the name of the Java file
     * @return the model of the program
     */
    private static CtModel parse(String fileName) {
        Launcher launcher = new Launcher();
        launcher.addInputResource(fileName);
        return launcher.buildModel();
    }

    /**
     * Visualized CFG.
     *
     * @param graph the CFG
     * @param fileName the file name
     * @param className the class name
     * @param methodName the method name
     */
    private static void visualizeCfg(
            ControlFlowGraph graph,
            String fileName,
            String className,
            String methodName) {
        File dotFile = new File(
                String.format("%s_%s_%s.dot", fileName, className, methodName));
        int index = 0;
        while (dotFile.exists()) {
            dotFile = new File(
                    String.format("%s_%s_%s_%d.dot", fileName, className, methodName, index));
            index++;
        }
        try {
            try (Writer writer = Files.newBufferedWriter(dotFile.toPath(), StandardCharsets.UTF_8)) {
                writer.write(graph.toGraphVisText());
            }
            DotUtils.createSvg(dotFile);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to render DOT text!");
        }
    }
}
