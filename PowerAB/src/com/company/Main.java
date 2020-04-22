package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    // Calculate power(a, b)
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(powerAB(i, j) + " --> ");
            }
            System.out.println("...");
        }
    }

    private static int powerAB(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;

        if (b % 2 == 1) {
            return powerAB(a, b/2) * powerAB(a, b / 2 + 1);
        }else{
            return powerAB(a, b/2) * powerAB(a, b / 2);
        }
    }
}
