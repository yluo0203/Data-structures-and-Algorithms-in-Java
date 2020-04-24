package com.company;
import java.lang.Math;


public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {1, 4, 7, 9, 12, 15, 18, 21, 24, 27, 29, 30, 31};
        int target = 19;
        System.out.println(findClostest(myArray, target));

    }

    private static int findClostest(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            }else if (arr[mid] > target) {
                right = mid;
            }else{
                left = mid;
            }
        }
        if (Math.abs(arr[left] - target) < Math.abs(arr[right] - target)) {
            return arr[left];
        }
        return arr[right];
    }
}
