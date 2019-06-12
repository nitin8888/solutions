import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSort {

    @Test
    public void testMergeSort() {
        List<Integer> nos = Arrays.asList(6, 4, 9, 5, 1, 8);
        List<Integer> expected = Arrays.asList(1, 4, 5, 6, 8, 9);
        List<Integer> ans = mergeSort(nos);

        assertThat(ans, is(expected));

    }

    private List<Integer> mergeSort(final List<Integer> nos) {
        int size = nos.size();
        if (size < 1) {
            return nos;
        }

        List<Integer> left = IntStream.range(0, size / 2)
                .map(nos::get)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> right = IntStream.range(size / 2, size)
                .map(nos::get)
                .boxed()
                .collect(Collectors.toList());

        mergeSort(left);
        mergeSort(right);

        return null;
//        return merge(left, right);
    }
/*

    private List<Integer> merge(List<Integer> left, List<Integer> right) {



        IntStream.range(0, left.size())
                .map(i -> {
                    if (left.get(0) <= right.get(0)) {
                        left.get(0);
                    } else {
                        right.get(0);
                    }
                });
        List<Integer> result = new ArrayList<>();
        result.addAll(getResult(left, right));

        result.add( ? )
        left.stream().flatMap(l -> right.stream().)
        return null;
    }
*/


    private Collection<? extends Integer> getResult(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        if (left.get(0) <= right.get(0)) {
            result.add(left.get(0));
        } else {
            result.add(right.get(0));
        }
        return result;
    }

    private Integer getNext(List<Integer> left, List<Integer> right) {
        
        return left.get(0) <= right.get(0) ? left.get(0) :right.get(0);
    }
}
