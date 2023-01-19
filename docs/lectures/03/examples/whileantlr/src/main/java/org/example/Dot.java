package org.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Dot {
    /**
     * Creates an SVG file for the given DOT file using the "dot" tool.
     *
     * @param dotFile the DOT file
     */
    public static void renderSvg(Path dotFile) throws IOException {
        ProcessBuilder svgBuilder = new ProcessBuilder("dot", "-Tsvg", dotFile.toString());
        Process process = svgBuilder.start();
        Path svgFile = dotFile.resolveSibling(dotFile.getFileName() + ".svg");
        try (OutputStream output = Files.newOutputStream(svgFile)) {
            copy(process.getInputStream(), output);
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                copy(process.getErrorStream(), buffer);
                String errMsg = buffer.toString(StandardCharsets.UTF_8.name());
                throw new IOException(errMsg);
            }
        } catch (InterruptedException ex) {
            throw new IOException(
                    "The current thread failed to finish image rendering"
                            + " as it was interrupted.", ex
            );
        }
    }

    private static void copy(
            InputStream source,
            OutputStream target) throws IOException {
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) != -1) {
            target.write(buf, 0, length);
        }
    }
}
