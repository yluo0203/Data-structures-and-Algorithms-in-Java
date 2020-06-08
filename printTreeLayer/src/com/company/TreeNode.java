package com.company;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int num) {
        this.val = num;
        this.left = null;
        this.right = null;
    }

    public TreeNode () {
        this.val = -1;
        this.left = null;
        this.right = null;
    }

    public void createSymmetricTree(){
        this.val = 1;
        this.left = new TreeNode(2);
        this.left.left = new TreeNode(3);
        this.left.left.left = new TreeNode(5);
        this.left.left.right = new TreeNode(6);

        this.left.right = new TreeNode(4);
        this.left.right.left = new TreeNode(7);
        this.left.right.right = new TreeNode(8);

        this.right = new TreeNode(2);
        this.right.left = new TreeNode(4);
        this.right.left.left = new TreeNode(8);
        this.right.left.right = new TreeNode(7);

        this.right.right = new TreeNode(3);
        this.right.right.left = new TreeNode(6);
        this.right.right.right = new TreeNode(5);
    }

    public void createBalancedBST(){
        this.val = 7;
        this.left = new TreeNode(3);
        this.left.left = new TreeNode(1);
        this.left.left.left = new TreeNode(0);
        this.left.left.right = new TreeNode(2);

        this.left.right = new TreeNode(5);
        this.left.right.left = new TreeNode(4);
        this.left.right.right = new TreeNode(6);

        this.right = new TreeNode(11);
        this.right.left = new TreeNode(9);
        this.right.left.left = new TreeNode(8);
        this.right.left.right = new TreeNode(10);

        this.right.right = new TreeNode(13);
        this.right.right.left = new TreeNode(12);
        this.right.right.right = new TreeNode(14);
    }

    public void createUnbalancedBST(){
        createBalancedBST();
        this.right.right.right.right = new TreeNode(20);
        this.right.right.right.right.right = new TreeNode(60);

    }

    public void InOrderDisplay() {
        System.out.print("In Order --> ");
        inOrderTraversal(left);
        System.out.print(this.val + " --> ");
        inOrderTraversal(right);
        System.out.println(" Done ");
    }

    public void PreOrderDisplay() {
        System.out.print("Pre Order --> ");
        System.out.print(this.val + " --> ");
        preOrderTraversal(left);
        preOrderTraversal(right);
        System.out.println(" Done ");
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return ;
        inOrderTraversal(root.left);
        System.out.print(root.val + " --> ");
        inOrderTraversal(root.right);
    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null) return ;
        System.out.print(root.val + " --> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
