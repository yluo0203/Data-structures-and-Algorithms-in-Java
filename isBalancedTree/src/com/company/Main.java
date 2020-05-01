package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode();
        root.createBalancedBST();
        root.InOrderDisplay();
        System.out.println(isBalanced(root));
        System.out.println(isBalancedTree(root));

        root.createUnbalancedBST();
        root.InOrderDisplay();
        System.out.println(isBalanced(root));
        System.out.println(isBalancedTree(root));
    }

    //    Method 1.
    private static boolean isBalanced(TreeNode root){
        return Math.abs(getheight(root.left) - getheight(root.right)) <= 1;
    }

    private static int getheight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getheight(root.left), getheight(root.right)) + 1;
    }

    //    Method 2.
    private static boolean isBalancedTree(TreeNode root) {
        return helper(root) != -1;
    }

    private static int  helper(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        if (leftDepth == -1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}