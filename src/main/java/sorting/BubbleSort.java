package sorting;

import java.util.stream.IntStream;

// https://en.wikipedia.org/wiki/Bubble_sort
// https://www.baeldung.com/java-bubble-sort

public class BubbleSort {


    public static void sort(int... nos) {
        // do while no swaps required
        // for 1 to l-1 swap
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < nos.length-1; i++) {
                if (swap(nos, i)) {
                    swapped = true;
                }
            }
        } while (swapped);

    }


    // 2 Loops sort
    public static void sort1(int... nos) {
        // Traverse the whole array
        // swap values if different
        // traverse internal j[] until nothing is swapped

        for (int i = 0; i < nos.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < nos.length-1; j++) {
                if(swap(nos, j)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    void sort3(int[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if (arr[j - 1] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                });
    }

    private static boolean swap(int[] nos, int j) {
        if (nos[j] > nos[j+1]) {
            // store in tmp
            int tmp = nos[j + 1];
            nos[j + 1] = nos[j];
            nos[j] = tmp;
            return true;
        } else {
            return false;
        }
    }
}
