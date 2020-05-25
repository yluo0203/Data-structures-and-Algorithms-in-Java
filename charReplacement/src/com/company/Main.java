package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder str = new StringBuilder("Apple_Banana_Cat_Dog_Elephant_Flower_");
        String s1 = "Elephant_";
        String s2 = "Elk_";
//        charReplacement(str);
        charReplacement(str, s1, s2);
        System.out.println(str);
    }

    private static void charReplacement(StringBuilder str, String s1, String s2) {
        if (str == null || str.length() == 0 || s1 == null || s2 == null) return;
        if (s1.length() < s2.length()) {
            replaceToLonger(str, s1, s2);
        }else{
            replaceToShorter(str, s1, s2);
        }
    }

    private static void replaceToLonger(StringBuilder str, String s1, String s2) {

    }

    private static void replaceToShorter(StringBuilder str, String s1, String s2) {
        int slow = 0;
        int fast = 0;
        while (fast < str.length()) {
            if (str.charAt(fast) == s1.charAt(0) && isSubString(str, fast, s1)) {
                for(int i = 0; i < s2.length(); i++) {
                    str.setCharAt(slow++, s2.charAt(i));
                }
                fast += s1.length();
            } else {
                str.setCharAt(slow++, str.charAt(fast++));
            }
        }
        String result = str.substring(0, slow);
        str.replace(0, str.length(), result);
    }

    private static boolean isSubString(StringBuilder str, int index, String s1) {
        for (int i = 0; i < s1.length(); i++) {
            if (index + i == str.length() || str.charAt(index + i) != s1.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
