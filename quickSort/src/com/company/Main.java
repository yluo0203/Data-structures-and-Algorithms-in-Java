package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {13, 88, 8, 21, 83, 93, 36, 65, 75, 9, 38, 81,46, 48, 22, 33, 4, 25, 7, 97, 61, 58, 24, 76, 53, 89, 86, 40, 2, 31, 45, 23, 98, 99, 6, 54};
//        int[] myArray = {93, 88}; // Edge Case
        quickSort(myArray);
        System.out.print("Sort: ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " --> ");
        }
        System.out.println("Done.");
    }

    private static void quickSort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    private static void qs(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int pivot = left + (right - left) / 2;
        while (left <= right) {
            while (left <= right && arr[left] < arr[pivot]) {
                left++;
            }
            while (left <= right && arr[right] > arr[pivot]) {
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
        qs(arr, start, right);
        qs(arr, left, end);
    }
}
