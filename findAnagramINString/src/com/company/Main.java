package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "MyNameIsTony.";
        String s1 = "Tony";
        System.out.println(findAnagram(str, s1));
    }
    private static int findAnagram(String str, String s1) {
        String target = sortString(s1);
        for (int i = 0; i < str.length() - s1.length() + 1; i++) {
            String temp = sortString(str.substring(i, i + s1.length()));
//            System.out.println(temp);
            if (target.equals(temp)) return i;
        }
        return -1;
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
