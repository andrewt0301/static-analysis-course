package org.example;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws CannotCompileException {
        System.out.println("Hello world!");
        generateClass();
    }

    public static void generateClass() throws CannotCompileException {
        ClassFile cf = new ClassFile(false, "org.example.MyClass", null);
        cf.setInterfaces(new String[] {"java.lang.Cloneable"});

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);

        ClassPool classPool = ClassPool.getDefault();
        Class<?> clazz = classPool.makeClass(cf).toClass();
        System.out.println(clazz.getName());
        Field[] fields = clazz.getFields();
    }
}