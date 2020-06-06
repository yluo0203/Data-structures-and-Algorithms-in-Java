// Leetcode: 953. Verifying an Alien Dictionary
package com.company;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String order = "hlabcdefgijkmnopqrstuvwxyz";
//        String[] words = {"hello","leetcode"};
        String[] words = {"apple","app"};
        System.out.print(helper(words, order));
    }

    private static boolean helper(String[] words, String order) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        for (int i = 0; i < order.length(); i++) {
            table.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {

            String prev = words[i - 1];
            String current = words[i];
            if (inOrder(table, prev,current) == false) {
                return false;
            }
        }
        return true;
    }

    private static boolean inOrder(Hashtable<Character, Integer> table, String prev, String current) {
        if (prev.length() == 0) {
            return true;
        } else if (current.length() == 0) {
            return false;
        }
        int prevIndex = table.get(prev.charAt(0));
        int currentIndex = table.get(current.charAt(0));
        if (prevIndex < currentIndex) {
            return true;
        } else if (prevIndex > currentIndex) {
            return false;
        } else {
            return inOrder(table, prev.substring(1, prev.length()), current.substring(1, current.length()));
        }
    }
}
