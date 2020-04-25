package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] myMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int target = 12;
        Node myResult = findTarget(myMatrix, target);
        System.out.println(myResult.row + " " + myResult.col);
    }

    private static class Node{
        int row;
        int col;

        private Node(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    private static Node findTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new Node(0, 0);

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int start = 0;
        int end = rowLength * colLength - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midRow = mid / colLength;
            int midCol = mid % colLength;
            if (matrix[midRow][midCol] == target) {
                return new Node(midRow, midCol);
            }else if(matrix[midRow][midCol] > target) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return new Node(-1, -1);
    }
}