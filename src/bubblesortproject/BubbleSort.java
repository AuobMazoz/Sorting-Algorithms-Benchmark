package bubblesortproject;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        sort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));
    }
}