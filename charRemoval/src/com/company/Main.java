package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "mommy";
        System.out.println(charRemoval(str, 'm'));

        StringBuilder sb = new StringBuilder("mommy");
        System.out.println(charRemovalOptimal(sb, 'm'));
    }

    private static String charRemovalOptimal(StringBuilder str, char ch) {
        int slow = 0;
        int fast = 0;
        while (fast != str.length()) {
            if (str.charAt(fast) != ch) {
                str.setCharAt(slow, str.charAt(fast));
                slow++;
            }
            fast++;
        }
        return str.substring(0, slow);
    }

    private static String charRemoval(String str, char ch) {
        int ptr = 0;
        String result = "";
        while (ptr != str.length()) {
            if (str.charAt(ptr) != ch) {
                result += str.charAt(ptr);
            }
            ptr++;
        }
        return result;
    }

    // Incorrect Method.
//    private static String charRemoval(String str, char ch) {
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ch) {
//                str = str.substring(0, i) + str.substring(i + 1, str.length());
//            }
//        }
//        return str;
//    }
}
