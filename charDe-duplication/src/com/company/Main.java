package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StringBuilder sbSpace = new StringBuilder("   ccccraaaaacking the     codingggg  iiiinterviewwww   ");
        System.out.println(charSpaceRemoval(sbSpace));

        System.out.println("Result: " + deDuplicationAdjacentLetters(new StringBuilder("abbbbaz")));
    }

    private static String charSpaceRemoval(StringBuilder str) {
        boolean firstSpace = true;
        int slow = 0;
        int fast = 0;
        boolean space = true;
        while (fast != str.length()) {
            if (firstSpace && str.charAt(fast) == ' ') {
                ;
            } else if (str.charAt(fast) != ' ' && fast != 0 && str.charAt(fast) != str.charAt(fast - 1)) {
                firstSpace = false;
                str.setCharAt(slow, str.charAt(fast));
                space = true;
                slow++;
            } else if (space == true && str.charAt(fast) == ' '){
                str.setCharAt(slow, str.charAt(fast));
                space = false;
                slow++;
            }
            fast++;
        }
        return str.substring(0, slow);
    }

    private static String deDuplicationAdjacentLetters(StringBuilder str) {
        if (str.length() <= 1) return str.toString();
        int slow = -1;
        int fast = 0;
        StringBuilder result = new StringBuilder("");
        while (fast != str.length()) {
            if (slow == -1) {
                slow = fast;
                result.append(str.charAt(fast));
            } else if (slow != -1 && str.charAt(slow) != str.charAt(fast)) {
                slow++;
                result.append(str.charAt(fast));
            } else if (slow != -1 && str.charAt(slow) == str.charAt(fast)) {
                slow--;
                result.deleteCharAt(result.length() - 1);
            }
            fast++;
        }
        return result.toString();
    }
}
