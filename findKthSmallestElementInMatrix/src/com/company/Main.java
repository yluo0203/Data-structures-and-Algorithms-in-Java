package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix;

        for (int k = 0; k < 30; k++) {
            matrix = createMatrix();
            System.out.println(k + "-th smallest element: " + findKth(matrix, k));
        }
    }

    private static int[][] createMatrix(){
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}};
        return matrix;
    }

//    Ref: https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
    private static class HeapNode implements Comparable<HeapNode>{
        int val;
        int r, c;
        HeapNode(int num, int r, int c) {
            this.val = num;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(HeapNode that) {
            return this.val - that.val;
        }
    }

    //    Ref: https://stackoverflow.com/questions/15179536/kth-smallest-element-in-sorted-matrix
    private static int findKth(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int min = matrix[0][0];
        PriorityQueue<HeapNode> heap = new PriorityQueue<>();
        heap.add(new HeapNode(min, 0, 0));
        while (!heap.isEmpty()) {
            HeapNode node = heap.poll();
            int row = node.r;
            int col = node.c;

            if (row + 1 < matrix.length && matrix[row + 1][col] != -1) {
                heap.add(new HeapNode(matrix[row + 1][col], row + 1, col));
                matrix[row + 1][col] = -1;
            }

            if (col + 1 < matrix[0].length && matrix[row][col + 1] != -1) {
                heap.add(new HeapNode(matrix[row][col + 1], row, col + 1));
                matrix[row][col + 1] = -1;
            }

            if (node.val >= min) {
                min = node.val;
                k--;
            }

            if (k == 0) return min;
        }
        return -1;
    }
}
