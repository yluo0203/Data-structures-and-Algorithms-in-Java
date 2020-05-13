package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int money = 50;

        //        Coins: $25, $10, $5, $1
        int[] coins = {25, 10, 5, 1};
        coinCombinations1(money, coins);
//        coinCombinations2(money);

    }
    // Method 1.
    private static void coinCombinations1(int total, int[] coins) {
        int[] sol = new int[coins.length];
        helper1(total, coins, sol, 0);
    }

    private static void helper1(int total, int[] coins, int[] sol, int level) {
        if (level == coins.length - 1) {
            int current = 0;
            for (int i = 0; i < coins.length - 1; i++) {
                current += coins[i] * sol[i];
            }
            System.out.print("C25: " + sol[0] + " + C10: " + sol[1] + " + C5: " + sol[2] + " + C1: " + total);
            System.out.println(" --> Total: $" + (current + total));
            return;
        }

        for (int i = 0; i <= total / coins[level]; i++) {
            sol[level] = i;
            total -= coins[level] * i;
            helper1(total, coins, sol, level + 1);
            total += coins[level] * i;
            sol[level] = 0;
        }
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
