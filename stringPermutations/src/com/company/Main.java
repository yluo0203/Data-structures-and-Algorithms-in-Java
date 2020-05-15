package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "abcdefg";
        permutation(str);
    }

    private static void permutation(String str) {
        helper(str, new HashSet<Character>(), new StringBuilder(""));
    }

    private static void helper(String str, HashSet<Character> set, StringBuilder result) {
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
            helper(str, set, result);
            set.remove(str.charAt(i));
            result.deleteCharAt(result.length() - 1);
        }
    }
}
