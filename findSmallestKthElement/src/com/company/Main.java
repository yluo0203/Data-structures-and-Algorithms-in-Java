package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {13, 88, 8, 21, 83, 93, 36, 65, 75, 9, 38, 81,46, 48, 22, 33, 4, 25, 7, 97, 61, 58, 24, 76, 53, 89, 86, 40, 2, 31, 45, 23, 98, 99, 6, 54};
        int k = 6;
        System.out.print("Method 1, k = 6: ");
        int[] result = findSmallestK1(myArray, k);
        for (int i = 0; i < k; i++) {
            System.out.print(result[i] + " --> ");
        }
        System.out.println("Done.");

        System.out.print("Method 2, k = 6: ");
        int[] result2 = findSmallestK2(myArray, k);
        for (int i = 0; i < k; i++) {
            System.out.print(result2[i] + " --> ");
        }
        System.out.println("Done.");

        System.out.print("Method 3, k = 6: ");
        int[] result3 = findSmallestK3(myArray, k);
        for (int i = 0; i < k; i++) {
            System.out.print(result3[i] + " --> ");
        }
        System.out.println("Done.");
    }

    private static int[] findSmallestK1(int[] arr, int k) {
        int[] result = new int[k];
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
        TonyQueue queue = new TonyQueue(k);
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (size < k) {
                queue.add(-1 * arr[i]);
                size++;
            } else {
                int top = -1 * queue.peek();
                if (arr[i] < top) {
                    queue.poll();
                    queue.add(-1 * arr[i]);
                }
            }
        }
//        System.out.println("size of queue: " + queue.size());
        for (int i = k - 1 ; i >= 0; i--) {
            result[i] = -1 * queue.poll();
        }
        return result;
    }

    private static int[] findSmallestK2(int[] arr, int k) {
        TonyQueue queue = new TonyQueue(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private static int[] findSmallestK3(int[] arr, int k) {
        quickSelect(arr, k, 0, arr.length - 1);
        int[] result = new int[k];

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " --> ");
//        }
//        System.out.println("Done. ");

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static void quickSelect(int[] arr, int k, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int mid = start + (end - start) / 2;
        while (left <= right) {
            while (left <= right && arr[left] < arr[mid]) {
                left++;
            }
            while (left <= right && arr[right] > arr[mid]) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        quickSelect(arr, k, start, right);
        if (left <= k) {
            quickSelect(arr, k, left, end);
        }
    }
}
