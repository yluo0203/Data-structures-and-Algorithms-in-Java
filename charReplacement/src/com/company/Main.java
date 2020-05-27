package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder str = new StringBuilder("Apple_Banana_Cat_Dog_Elephant_Flower_");
        String s1 = "Elephant_";
        String s2 = "Elk_";
        charReplacement(str, s1, s2);
        System.out.println(str);

        s1 = "Flower_";
        s2 = "Fish_";
        charReplacement(str, s1, s2);
        System.out.println(str);

        s1 = "Cat_";
        s2 = "Cattle_";
        charReplacement(str, s1, s2);
        System.out.println(str);

        s1 = "Apple_";
        s2 = "Alligator_";
        charReplacement(str, s1, s2);
        System.out.println(str);
    }

    private static void charReplacement(StringBuilder str, String s1, String s2) {
        if (str == null || str.length() == 0 || s1 == null || s2 == null) return;
        if (s1.length() <= s2.length()) {
            replaceToLonger(str, s1, s2);
        }else{
            replaceToShorter(str, s1, s2);
        }
    }

    private static void replaceToLonger(StringBuilder str, String s1, String s2) {
        int fast = str.length() - 1;
        int diff = s2.length() - s1.length();
        int count = 0;
        for (int i = 0; i < str.length() - s1.length() + 1; i++) {
            if (str.charAt(i) == s2.charAt(0) && isSubString(str, i , s1)) {
                count++;
            }
        }
        appendChar(str, count * diff);
        int slow = str.length() - 1;
        while (fast >= 0) {
            if (fast >= s1.length() - 1 && isSubString(str, fast - s1.length() + 1, s1)) {
                int length = s2.length() - 1;
                while(length >= 0) {
                    str.setCharAt(slow--, s2.charAt(length--));
                }
                fast -= s1.length();
            } else {
                str.setCharAt(slow--, str.charAt(fast--));
            }
        }
    }

    private static void appendChar(StringBuilder str, int num) {
        for (int i = 0; i < num; i++) {
            str.append(' ');
        }
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
        str.replace(0, str.length(), str.substring(0, slow));
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
