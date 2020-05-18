package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "abc";
//        permutation2(str);
        permutation1(str);
    }

    //Method 1.
    private static void permutation1 (String str) {
        helper1(str, 0);
    }

    private static void helper1(String str, int index) {
        if (str.length() == index) {
            System.out.println(str);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            str = swap(str, i, index);
            index++;
            helper1(str, index);
            index--;
            str = swap(str, i, index);
        }
    }

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    // Method 2
    private static void permutation2(String str) {
        helper2(str, new HashSet<Character>(), new StringBuilder(""));
    }

    private static void helper2(String str, HashSet<Character> set, StringBuilder result) {
        if (str.length() == result.length()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                continue;
            }

            set.add(str.charAt(i));
            result.append(str.charAt(i));
            helper2(str, set, result);
            set.remove(str.charAt(i));
            result.deleteCharAt(result.length() - 1);
        }
    }
}
