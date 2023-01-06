package org.example;

public class Test {
    private int a;

    public Test(int a) {
        assert a != 10;
        this.a = a;
    }
}
