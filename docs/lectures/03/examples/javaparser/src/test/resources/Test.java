package org.example;

import java.io.File;
import java.util.Objects;

/**
 * This is test Java file with one unused import.
 */
public class Test {
    private final File file;

    public Test(File file) {
        this.file = file;
    }

    public void test() {
        System.out.println(file);
    }

    public static void main(String[] args) {
        new Test(args[0]).test();
    }
}
