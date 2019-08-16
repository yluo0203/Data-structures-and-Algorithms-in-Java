public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
//        int temp1 = iterativeFactorial(2);
//        System.out.println(temp1);
//
//        int temp2 = recursiveFactorial(2);
//        System.out.println(temp2);

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print("" + intArray[i] + " ");
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end-start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    public static int iterativeFactorial (int num) {
        if (num <= 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i < num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static int recursiveFactorial (int num) {
        if (num <= 0) {
            return 1;
        }

        int temp = num * recursiveFactorial(num - 1);
        System.out.println(temp);
        return temp;
    }
}
