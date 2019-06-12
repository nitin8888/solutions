package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sortIntegerArrayTest() {
        final int[] numbers = {6, 4, 9, 5, 1, 8};
        final int[] expected = {1, 4, 5, 6, 8, 9};

        BubbleSort.sort(numbers);
        assertArrayEquals(expected, numbers);

    }

}