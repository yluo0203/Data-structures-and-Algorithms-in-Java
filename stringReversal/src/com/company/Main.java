package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder str = new StringBuilder("Hello");
        System.out.println(reverseString(str));

        String str2 = "Kitty";
        System.out.println(reverseStringRecursion(str2));
    }

    private static String reverseString(StringBuilder str) {
        if (str == null || str.length() == 0) return "";
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char ch = str.charAt(left);
            str.setCharAt(left, str.charAt(right));
            str.setCharAt(right, ch);
            left++;
            right--;
        }
        return str.toString();
    }

    private static String reverseStringRecursion(String str) {
        if (str.length() <= 1) return str;
        return str.charAt(str.length() - 1) + reverseStringRecursion(str.substring(1, str.length() - 1)) + str.charAt(0);
    }
}
