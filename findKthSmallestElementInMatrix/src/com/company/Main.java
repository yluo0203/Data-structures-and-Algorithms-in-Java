package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix = {  {1, 2, 3, 4, 5},
                            {2, 3, 4, 5, 6},
                            {3, 4, 5, 6, 7},
                            {4, 5, 6, 7, 8},
                            {5, 6, 7, 8, 9}};
        int k = 6;
    }

    private static int[] findKth(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int x = 0;
        int y = 0;
        int[][] steps = {{1, 0}, {0, 1}};
//        ArrayList<>
        return new int[0];
    }
}
