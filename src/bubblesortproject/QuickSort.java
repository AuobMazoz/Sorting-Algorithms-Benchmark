package bubblesortproject;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int low, int high) {
        int i = low;
        int j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }

            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(numbers, low, j);
        }

        if (i < high) {
            quickSort(numbers, i, high);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        sort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));
    }
}