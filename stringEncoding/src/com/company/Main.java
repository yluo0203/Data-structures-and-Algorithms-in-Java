package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder str = new StringBuilder("aaaabccaaaaa");
        encodeString(str);
        System.out.println(str); // --> "a4bc2a5 " --> "a4b1c2a5"
    }

    private static void encodeString(StringBuilder str){
        if (str == null || str.length() == 0) return;
        int slow = 0;
        int fast = 0;
        int reserveSpace = 0;
        Integer charCount = 1;
        while (fast < str.length()) {
            if (isUnique(str, fast)) {
                reserveSpace++;
            }
            if (fast != 0 && str.charAt(fast) != str.charAt(fast - 1) || fast == str.length() - 1) {
                if (fast == str.length() - 1 && !isUnique(str, fast)) charCount++;
                if (charCount != 1) {
                    str.setCharAt(++slow, (char)(charCount + '0'));
                }
                slow++;
                str.setCharAt(slow, str.charAt(fast));
                charCount = 1;
            } else if (fast != 0 && str.charAt(fast) == str.charAt(fast - 1)) {
                charCount++;
            }
            fast++;
        }

        for(int i = 0; i < reserveSpace; i++) {
            str.setCharAt(slow++, ' ');
        }
        str.replace(0, str.length(), str.substring(0, slow)); //--> a4bc2a5
        System.out.println(str);

        slow = str.length() - 1;
        fast = str.length() - 1;
        while (fast >= 0) {
//            System.out.println(slow + " <--> " + str.charAt(slow));
            while (fast >= 0 && str.charAt(fast) == ' ') {
                fast--;
            }
            if (fast >= 0 && Character.isLetter(str.charAt(fast)) && !Character.isDigit(str.charAt(fast + 1))) {
                str.setCharAt(slow, '1');
                slow--;
            }
//            if (fast >= 0) {
                str.setCharAt(slow--, str.charAt(fast--));
//            }
        }
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
