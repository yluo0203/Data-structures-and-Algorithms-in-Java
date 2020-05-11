package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Method1. DFS.
        String str = "abcdd";
        StringBuilder subString = new StringBuilder("");
        printSubsets(str, subString, -1);

        //Method2. Ref: https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
        //char set[] = {'a', 'b', 'c', 'd'};
        //printSubsets2(set);
    }

    private static void printSubsets(String str, StringBuilder subStr, int index) {
        System.out.println("{ " + subStr + " }");
        if (str.length() == subStr.length()) return;

        for (int i = index + 1; i < str.length(); i++) {
            subStr.append(str.charAt(i));
            printSubsets(str, subStr, i);
            subStr.deleteCharAt(subStr.length() - 1);
        }
    }

    // Method2. https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
    static void printSubsets2(char set[])
    {
        int n = set.length;

        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }


}
