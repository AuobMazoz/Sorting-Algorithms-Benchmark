package bubblesortproject;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] numbers) {
        int[] temp = new int[numbers.length];
        mergeSort(numbers, temp, 0, numbers.length - 1);
    }

    private static void mergeSort(int[] numbers, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(numbers, temp, left, middle);
        mergeSort(numbers, temp, middle + 1, right);
        merge(numbers, temp, left, middle, right);
    }

    private static void merge(int[] numbers, int[] temp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (numbers[i] <= numbers[j]) {
                temp[k] = numbers[i];
                i++;
            } else {
                temp[k] = numbers[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            temp[k] = numbers[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = numbers[j];
            j++;
            k++;
        }

        for (int index = left; index <= right; index++) {
            numbers[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        sort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));
    }
}