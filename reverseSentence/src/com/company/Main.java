package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder sb = new StringBuilder("Impossible is Nothing");
        System.out.println(reverseSentence(sb));  // --> "Nothing is Impossible"

        reverseSentence2(sb);
        System.out.println(sb.toString());
    }

    // Method 2, In-place.
    private static void reverseSentence2(StringBuilder str) {
        if (str == null || str.length() == 0) return;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            swap(str, left++, right--);
        }
        left = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && str.charAt(i) != ' ' && str.charAt(i - 1) == ' ') {
                left = i;
            }

            if (i == str.length() - 1) {
                right = i;
                while (left < right) {
                    swap(str, left++, right--);
                }
                break;
            } else if (str.charAt(i) != ' ') {
                continue;
            }
            right = i - 1;
            while (left < right) {
                swap(str, left++, right--);
            }
        }
    }

    // Method 1.
    private static String reverseSentence(StringBuilder str) {
        if (str == null || str.length() == 0) return "";
        StringBuilder result = new StringBuilder(str);
        swapCharactors(result);

        String[] list = result.toString().split(" ");
        for (int i = 0; i < list.length; i++) {
            StringBuilder subSB = new StringBuilder(list[i]);
            swapCharactors(subSB);
            list[i] = subSB.toString();
        }

        result = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            result.append(list[i] + " ");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    private static void swapCharactors(StringBuilder str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            swap(str, left++, right--);
        }
    }

    private static void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }
}
