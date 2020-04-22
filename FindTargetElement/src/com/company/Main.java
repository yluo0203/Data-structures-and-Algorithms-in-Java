package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Create test case.
        int size = 20;
        int[] myArray = new int[20];
        for (int i = 0; i < size; i++) {
            myArray[i] = i;
        }
        int target = 13;
        int result = FindTargetIndex(myArray, target);
        System.out.println("Target value " + target + " at index: " + result);
    }

    private static int FindTargetIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
