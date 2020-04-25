package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {1, 4, 6, 14, 14, 24, 25, 26, 26, 88, 88, 88, 99, 99, 100, 100};
        int target = 14;
        System.out.println(findFirstElement(myArray, target));
        System.out.println(findLastElement(myArray, target));
    }

    private static int findFirstElement(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if (arr[left] == target) return left;
        return right;
    }

    private static int findLastElement(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        if (arr[right] == target) return right;
        return left;
    }
}
