package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode();
        root.createBalancedBST();
        root.InOrderDisplay();
        printKeysInRange(root, 10, 4);
    }

    private static void printKeysInRange(TreeNode root, int max, int min) {
        if (root == null) return;
//        if (root.val > max || root.val < min) return;
        if (root.val > min) {
            printKeysInRange(root.left, max, min);
        }
        if (root.val < max && root.val > min) {
            System.out.print(root.val + " --> ");
        }
        if (root.val < max) {
            printKeysInRange(root.right, max, min);
        }
    }
}
