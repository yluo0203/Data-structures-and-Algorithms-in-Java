package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = {2, 3, 8, 16, 26, 28, 33, 36, 41, 66, 67, 68, 70, 71, 82, 86, 88, 90, 96, 97};
        int target = 53;
        int k = 10;
        int closestIndex = findClosest(myArray, target);
        System.out.println(closestIndex);
        int[] result = findKElement(myArray, k, closestIndex, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " --> ");
        }
    }

    private static int findClosest(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
//        while (left <= right - 1) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if(arr[mid] > target) {
                right = mid;
            }else{
                left = mid;
            }
        }
        if (Math.abs(target - arr[left]) < Math.abs(target - arr[right])) return left;
        return right;
    }

    private static int[] findKElement(int[] arr, int k, int index, int target) {
        int resultIndex = 0;
        int[] result = new int[k];
        int ptrLeft = index;
        int ptrRight = index;
        if (index == 0) {
            ptrRight += 1;
        }else{
            ptrLeft -= 1;
        }

        while (resultIndex < k && ptrLeft >= 0 && ptrRight <= arr.length - 1) {
            int leftDiff = Math.abs(arr[ptrLeft] -  target);
            int rightDiff = Math.abs(arr[ptrRight] - target);

            if (leftDiff <= rightDiff) {
                result[resultIndex] = arr[ptrLeft];
                ptrLeft -= 1;
            }else {
                result[resultIndex] = arr[ptrRight];
                ptrRight += 1;
            }
            resultIndex += 1;
        }

        while (resultIndex < k) {
            if (ptrLeft < 0 && ptrRight > arr.length - 1) {
                result[resultIndex] = -1;
            }else if (ptrLeft < 0){
                result[resultIndex] = arr[ptrRight];
                ptrRight += 1;
            }else{
                result[resultIndex] = arr[ptrLeft];
                ptrLeft -= 1;
            }
            resultIndex += 1;
        }
        return result;
    }
}
