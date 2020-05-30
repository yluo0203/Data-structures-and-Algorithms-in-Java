package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder str = new StringBuilder("xaaaabccaaaaax");
        encodeString(str);
        System.out.println("Encode: " + str); // --> "xa4bc2a5x   " --> "x1a4b1c2a5x1"
    }

    private static void encodeString(StringBuilder str){
        System.out.println("Raw code: " + str);
        if (str == null || str.length() == 0) return;
        int slow = 0;
        int fast = 0;
        int reserveSpace = 0;
        Integer charCount = 1;
        slow = 0;
        fast = 0;
        while (fast < str.length()) {
            if (isUnique(str, fast)) {
                reserveSpace++;
                str.setCharAt(slow++, str.charAt(fast));
                fast++;
            } else {
                str.setCharAt(slow++, str.charAt(fast));
                fast++;
                // Count same char.
                while (fast < str.length() && (fast == 0 || (fast != 0 && str.charAt(fast) == str.charAt(fast - 1)))) {
                    charCount++;
                    fast++;
                }
                // Find the 1st char.
                if ((fast < str.length() && (fast != 0 && str.charAt(fast) != str.charAt(fast - 1))) || (fast >= str.length() - 1)) {
//                    str.setCharAt(slow++, str.charAt(fast));
                    if (charCount != 1) {
                        str.setCharAt(slow++, (char) (charCount + '0'));
                    }
                    charCount = 1;
                }
            }
        }

//        while (fast < str.length()) {
//            if (isUnique(str, fast)) {
//                reserveSpace++;
//            }
//            if (fast != 0 && str.charAt(fast) != str.charAt(fast - 1) || fast == str.length() - 1) {
//                if (fast == str.length() - 1 && !isUnique(str, fast)) charCount++;
//                if (charCount != 1) {
//                    str.setCharAt(++slow, (char)(charCount + '0'));
//                }
//                slow++;
//                str.setCharAt(slow, str.charAt(fast));
//                charCount = 1;
//            } else if (fast != 0 && str.charAt(fast) == str.charAt(fast - 1)) {
//                charCount++;
//            }
//            fast++;
//        }

        for(int i = 0; i < reserveSpace; i++) {
            str.setCharAt(slow++, ' ');
        }
        str.replace(0, str.length(), str.substring(0, slow));
        System.out.println("1st round: " + str);

        slow = str.length() - 1;
        fast = str.length() - 1;
        while (fast >= 0) {
            while (fast >= 0 && str.charAt(fast) == ' ') {
                fast--;
            }
            if (fast >= 0 && Character.isLetter(str.charAt(fast)) && !Character.isDigit(str.charAt(fast + 1))) {
                str.setCharAt(slow, '1');
                slow--;
            }
            str.setCharAt(slow--, str.charAt(fast--));
        }
        System.out.println("2nd round: " + str);
    }

    private static boolean isUnique(StringBuilder str, int index) {
        if (str.length() == 1) return true;
        if ((index != 0 && str.charAt(index) == str.charAt(index - 1)) ||
            (index != str.length() - 1 && str.charAt(index) == str.charAt(index + 1))) {
                return false;
        }
        return true;
    }
}
