package bubblesortproject;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[smallest]) {
                    smallest = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[smallest];
            numbers[smallest] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        sort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));
    }
}