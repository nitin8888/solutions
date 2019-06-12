//import org.junit.Test;

import java.util.stream.IntStream;

//import static org.junit.Assert.assertArrayEquals;

// https://en.wikipedia.org/wiki/Bubble_sort
// https://www.baeldung.com/java-bubble-sort
public class BubbleSort {

    public void bubbleSort1(int[] numbers) {
        boolean numbersSwitched;
        do {
            numbersSwitched = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] < numbers[i]) {
                    int tmp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = tmp;
                    numbersSwitched = true;
                }
            }
        } while (numbersSwitched);
    }

    void bubbleSort(int[] arr) {
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
/*
    @Test
    public void testBubble() {
        final int[] numbers = {6, 4, 9, 5, 1, 8};
        final int[] expected = {1, 4, 5, 6, 8, 9};

        bubbleSort(numbers);
        assertArrayEquals(expected, numbers);
    }
    */
}

