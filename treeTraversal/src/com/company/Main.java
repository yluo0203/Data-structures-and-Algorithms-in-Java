package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode();
        root.createBalancedBST();
        root.InOrderDisplay(root);
        inOrderTraversal(root);
        System.out.println("");
        root.PreOrderDisplay(root);
        preOrderTraversal(root);
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) return ;
        inOrderTraversal(root.left);
        System.out.print(root.val + " --> ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return ;
        System.out.print(root.val + " --> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
