package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode node = new TreeNode();
        node.createSymmetricTree();
        node.InOrderDisplay();
        System.out.println(isSymmetric(node, node));

        node.createBalancedBST();
        node.InOrderDisplay();
        System.out.println(isSymmetric(node, node));

        node.createUnbalancedBST();
        node.InOrderDisplay();
        System.out.println(isSymmetric(node, node));
    }

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode){
        if (leftNode == null && rightNode == null) return true;
        if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null)) return false;
        if ((rightNode.val != leftNode.val)) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }
}
