package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str1 = "cracking the coding interview";
        String str2 = "view";
        System.out.println(isSubString(str1, str2));
    }

    private static int isSubString(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null) return -1;
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                if (match(str1, str2, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean match(String str1, String str2, int n) {
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt((i + n)) != str2.charAt(i)) return false;
        }
        return true;
    }
}
