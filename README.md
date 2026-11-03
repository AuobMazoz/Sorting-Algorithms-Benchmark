# Sorting Algorithms Benchmark

This Java program compares five sorting algorithms using arrays of 100,000 integers.

## 1. Student information

- **Student:** AuobMazoz
- **University number:** 3167054
- **Section:** B

## 2. Project overview

The benchmark compares Selection Sort, Insertion Sort, Bubble Sort, Merge Sort, and Quick Sort. It runs each algorithm on four input cases and checks that every result is sorted correctly.

The benchmark uses a fresh copy of the input array for each algorithm, so one algorithm does not change the data used by another.

## 3. Algorithms and their time complexity

| Algorithm | Best case | Average case | Worst case |
|---|---:|---:|---:|
| Selection Sort | O(n²) | O(n²) | O(n²) |
| Insertion Sort | O(n) | O(n²) | O(n²) |
| Bubble Sort | O(n), with the early-stop check | O(n²) | O(n²) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) |

These are the usual time-complexity cases. Quick Sort's actual performance depends on how its pivots divide the data.

## 4. Test cases and measurement method

Each test case contains 100,000 integers:

- **Random:** Values are generated randomly.
- **Reverse:** Values are in descending order.
- **Partial:** The first 80% is ascending, and the remaining 20% is random.
- **Sorted:** Values are in ascending order.

For each algorithm and test case, the program copies the original input array, starts a timer with `System.nanoTime()`, calls the sorting method, and stops the timer. It converts the elapsed time to microseconds by dividing nanoseconds by 1,000. After timing, it checks that the array is sorted and reports an error if it is not.

## 5. Results

All values are in microseconds (µs). These are single-run results.

| Algorithm | Random | Reverse | Partial | Sorted |
|---|---:|---:|---:|---:|
| Selection Sort | 7002921 | 6845280 | 4113919 | 3450025 |
| Insertion Sort | 1521883 | 2624554 | 535818 | 243 |
| Bubble Sort | 25408541 | 16221371 | 11318671 | 129 |
| Merge Sort | 39707 | 7750 | 7652 | 6985 |
| Quick Sort | 58903 | 4319 | 10914 | 2920 |

## 6. Simple chart

The bars use a logarithmic visual scale so that both large and small timings can be seen. The numbers are the exact timings in microseconds; longer bars mean slower measured times.

| Algorithm | Random | Reverse | Partial | Sorted |
|---|---|---|---|---|
| Selection Sort | █████████████ 7002921 | █████████████ 6845280 | ████████████ 4113919 | ████████████ 3450025 |
| Insertion Sort | ███████████ 1521883 | ████████████ 2624554 | █████████ 535818 | ████ 243 |
| Bubble Sort | ███████████████ 25408541 | ██████████████ 16221371 | █████████████ 11318671 | ████ 129 |
| Merge Sort | ███████ 39707 | █████ 7750 | █████ 7652 | █████ 6985 |
| Quick Sort | ███████ 58903 | ████ 4319 | █████ 10914 | ████ 2920 |

## 7. Discussion

Selection Sort, Insertion Sort, and Bubble Sort have O(n²) average or worst-case time complexity. Merge Sort and average-case Quick Sort have O(n log n) time complexity. As the input gets larger, O(n log n) algorithms generally do much less work than O(n²) algorithms. This is reflected in the results: Merge Sort and Quick Sort have much lower timings than the three quadratic algorithms for the random, reverse, and partial cases.

Input order also affects performance. Insertion Sort works quickly on already sorted data because it has little or no movement to do. Bubble Sort has an early-stop check, so it finishes quickly when a pass makes no swaps; this explains its low timing on the sorted case. The partially sorted input can also help Insertion Sort because much of the array is already in order, although its random final section still needs work. Selection Sort still scans the remaining unsorted portion on each pass, even when the data is sorted.

Quick Sort's performance depends on pivot choice, because the pivot affects how evenly the array is divided at each step. This implementation chooses the middle element as the pivot. Choosing the middle position does not guarantee that the pivot is the median value, so the resulting partitions can still vary.

The timings are from one run and can vary by computer and between runs. They are measurements, not guaranteed performance results.

## 8. How to run in NetBeans 8.2

1. Open the project in NetBeans 8.2.
2. In the Projects panel, open **Source Packages**, then the `bubblesortproject` package.
3. Open `SortingAlgorithmsBenchmark.java`.
4. Right-click the file and choose **Run File** (or use the IDE's Run File command).
5. Read the progress messages and benchmark results in the Output window.
