package bubblesortproject;

import java.util.Random;
import java.util.Arrays;

public class SortingAlgorithmsBenchmark {

    private static final int SIZE = 100000;

    public static void main(String[] args) {
        String[] caseNames = {
            "Random", "Reverse", "Partial", "Sorted"
        };

        String[] algorithmNames = {
            "Selection Sort",
            "Insertion Sort",
            "Bubble Sort",
            "Merge Sort",
            "Quick Sort"
        };

        int[][] testCases = createTestCases(SIZE);
        long[][] times = new long[algorithmNames.length][caseNames.length];

        for (int caseIndex = 0; caseIndex < caseNames.length; caseIndex++) {
            for (int algorithmIndex = 0;
                    algorithmIndex < algorithmNames.length;
                    algorithmIndex++) {

                System.out.println("Running "
                        + algorithmNames[algorithmIndex]
                        + " on " + caseNames[caseIndex] + "...");

                int[] numbers = Arrays.copyOf(
                        testCases[caseIndex], testCases[caseIndex].length);

                long startTime = System.nanoTime();
                runAlgorithm(algorithmIndex, numbers);
                long endTime = System.nanoTime();

                if (!isSorted(numbers)) {
                    throw new IllegalStateException(
                            algorithmNames[algorithmIndex]
                            + " did not sort the data correctly.");
                }

                times[algorithmIndex][caseIndex] =
                        (endTime - startTime) / 1000;
            }
        }

        System.out.printf("%-18s %15s %15s %15s %15s%n",
                "Algorithm", "Random (us)", "Reverse (us)",
                "Partial (us)", "Sorted (us)");

        for (int i = 0; i < algorithmNames.length; i++) {
            System.out.printf("%-18s %15d %15d %15d %15d%n",
                    algorithmNames[i],
                    times[i][0],
                    times[i][1],
                    times[i][2],
                    times[i][3]);
        }
    }

    private static int[][] createTestCases(int size) {
        Random random = new Random();

        int[] randomNumbers = new int[size];
        int[] reverseNumbers = new int[size];
        int[] partialNumbers = new int[size];
        int[] sortedNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            randomNumbers[i] = random.nextInt(size);
            reverseNumbers[i] = size - i;
            sortedNumbers[i] = i;
        }

        int sortedPart = (int) (size * 0.8);

        for (int i = 0; i < sortedPart; i++) {
            partialNumbers[i] = i;
        }

        for (int i = sortedPart; i < size; i++) {
            partialNumbers[i] = random.nextInt(size);
        }

        return new int[][] {
            randomNumbers, reverseNumbers, partialNumbers, sortedNumbers
        };
    }

    private static void runAlgorithm(int algorithmIndex, int[] numbers) {
        switch (algorithmIndex) {
            case 0:
                SelectionSort.sort(numbers);
                break;
            case 1:
                InsertionSort.sort(numbers);
                break;
            case 2:
                BubbleSort.sort(numbers);
                break;
            case 3:
                MergeSort.sort(numbers);
                break;
            case 4:
                QuickSort.sort(numbers);
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm.");
        }
    }

    private static boolean isSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return false;
            }
        }

        return true;
    }
}