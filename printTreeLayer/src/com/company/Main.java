package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode();
        root.createBalancedBST();
        root.InOrderDisplay();
        printTree(root);
        printTree2(root);
    }

    // Method 1.
    private static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("root:");
        while (!queue.isEmpty()) {
            int sizeOfQ = queue.size();
            for (int i = 0; i < sizeOfQ; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " --> ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (queue.size() != 0) {
                System.out.println("next.");
            } else {
                System.out.println("Done.");
            }
        }
    }
    // Method 2.
    private static void printTree2(TreeNode root) {
        ArrayList<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        System.out.println("root:");
        while(curr.size() != 0) {
            ArrayList<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < curr.size(); i++) {
                TreeNode node = curr.get(i);
                System.out.print(node.val + " --> ");
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            if (next.size() != 0) {
                System.out.println( "Next.");
            } else {
                System.out.println( "Done.");
            }
            curr = next;
        }
    }
}
