package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "TonyLu";
        System.out.println(swapString(str, 0, str.length() - 1));
    }

    private static String swapString(String str, int i, int j) {
        return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1, str.length());
    }
}
