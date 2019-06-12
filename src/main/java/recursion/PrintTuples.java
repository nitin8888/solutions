package recursion;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PrintTuples {
    public static void main(String... args) {
//        processTuples();
        processTuplesRecurse();
    }

    private static void processTuplesRecurse() {
        // return void
        // forward rec only
        // param: max, init, nosOfLoops
        // term: init reached max
        tuplesRec(5,0, 2);
    }

    private static void tuplesRec(int max, int i, int loops) {
        if (i >= max) {
            return;
        }
        i++;
        System.out.println(i);
//        System.out.println();
        tuplesRec(max, i, loops);
    }

    private static void processTuples() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            IntStream.rangeClosed(1, 5).forEach(j -> {
                printValues(i, j);
            });
        });
    }

    private static void printValues(int... i) {
        String collect = Arrays.stream(i).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
