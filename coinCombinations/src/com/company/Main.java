package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Coins: $25, $10, $5, $1
        int money = 50;
        coinCombinations2(money);
        int[] coins = {25, 10, 5, 1};
//        coinCombinations1(money, coins);
    }


    //Method 2.
    private static void coinCombinations2(int total) {
        helper2(total, 0, 0,0,0);
    }

    private static void helper2(int total, int C25, int C10, int C5, int cur) {
        if (cur + 25 <= total) {
            cur += 25;
            C25 += 1;
            helper2(total, C25, C10, C5, cur);
            C25 -= 1;
            cur -= 25;
        }

        if (cur + 10 <= total) {
            cur += 10;
            C10 += 1;
            helper2(total, C25, C10, C5, cur);
            C10 -= 1;
            cur -= 10;
        }

        if (cur + 5 <= total) {
            cur += 5;
            C5 += 1;
            helper2(total, C25, C10, C5, cur);
            C5 -= 1;
            cur -= 5;
        }

        if (C25 * 25 + C10 * 10 + C5 * 5 <= total) {
            int C1 = total - (C25 * 25 + C10 * 10 + C5 * 5);
            System.out.println("C25: " + C25 + " + C10: " + C10 + " + C5: " + C5 + " + C1: " + C1);
        }
    }
}
