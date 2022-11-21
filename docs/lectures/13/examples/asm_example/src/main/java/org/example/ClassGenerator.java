package org.example;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V1_8;

/**
 * {@code
 *   package pkg;
 *   public interface Comparable extends Mesurable {
 *   int LESS = -1;
 *   int EQUAL = 0;
 *   int GREATER = 1;
 *   int compareTo(Object o);
 * }
 */
public class ClassGenerator {
    private static class MyClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }

    private static class StubClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name.endsWith("_Stub")) {
                byte[] b = generateClass();
                return defineClass(name.substring(0, name.length() - 5), b, 0, b.length);
            }
            return super.findClass(name);
        }
    }

    public static byte[] generateClass() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(
                V1_8,
                ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable",
                null,
                "java/lang/Object",
                new String[] {  });
        cw.visitField(
                ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "LESS",
                "I",
                null,
                -1).visitEnd();
        cw.visitField(
                ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "EQUAL",
                "I",
                null,
                0).visitEnd();
        cw.visitField(
                ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "GREATER",
                "I",
                null,
                1).visitEnd();
        cw.visitMethod(
                ACC_PUBLIC + ACC_ABSTRACT,
                "compareTo",
                "(Ljava/lang/Object;)I",
                null,
                null).visitEnd();
        cw.visitEnd();
        return cw.toByteArray();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = new StubClassLoader();
        Class<?> clazz = loader.loadClass("pkg.Comparable_Stub");
        System.out.println(clazz.getName());
    }
}
