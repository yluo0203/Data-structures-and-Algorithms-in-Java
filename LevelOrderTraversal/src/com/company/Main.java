package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode();
        root.createBalancedBST();
        root.InOrderDisplay();
        BFS(root);
    }

    private static void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("Root --> ");
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            System.out.print(node.val + " --> ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println(" Done. ");
    }
}
