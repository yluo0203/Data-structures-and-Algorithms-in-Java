package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode();
        root.createUnbalancedBST();
        root.InOrderDisplay();

        System.out.println("Tree Height: " + getHeight(root));
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
