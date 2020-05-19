package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "TonyLu";
        System.out.println(swapString(str, 0, str.length() - 1));
        System.out.println(swapString2(str, 0, str.length() - 1));
    }

    //Ref: https://www.geeksforgeeks.org/swapping-characters-string-java/
    private static String swapString(String str, int i, int j) {
        return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1, str.length());
    }

    private static String swapString2(String str, int i, int j) {
        StringBuilder result = new StringBuilder(str);
        result.setCharAt(i, str.charAt(j));
        result.setCharAt(j, str.charAt(i));
        return result.toString();
    }
}
