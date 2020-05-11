package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        char[] set = new char{'a', 'b', 'c', 'd'};
        char set[] = {'a', 'b', 'c', 'd'};
//        printSubsets1(set);

        String str = "abcd";
        printSubsets(str, "", -1);
    }

        private static void printSubsets(String set, String subset, int index) {
        ;
        if (set.length() == subset.length() - 1) return;

        System.out.println(subset);
        int n = set.length();
        for (int i = index + 1 ; i < set.length() ; i++) {
//            System.out.println(subset);
//            if (i != 0 && subset.charAt(i) == subset.charAt(i - 1)){
//                continue;
//            }
            subset += set.charAt(i);
            printSubsets(set, subset, i);
            subset = subset.substring(0, subset.length() - 1);
        }
    }

//    Method1. https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
    static void printSubsets1(char set[])
    {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }


}
