package org.example;

public class Test {
    public static void main(String[] args) {
        int x = 10;
        {
            System.out.println("INSIDE!W");
        }
        while (x != 0) {
            System.out.println("AAA");

            if (x == 1)
                break;

            System.out.println("Forever!");
            x--;
        }
    }
}
