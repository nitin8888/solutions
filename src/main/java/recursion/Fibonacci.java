package recursion;

import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.printNos(1);
        System.out.println();
        fibonacci.printNos(2);
        System.out.println();
        fibonacci.printNos(10);
    }

//    1, 1, 2, 3, 5, 8
    private void printNos(int nos) {
        IntStream.rangeClosed(1, nos).forEach(i -> System.out.print(fib(i) + " "));
    }

    private int fib(int i) {
        // For element 1 & 2 return 1
        if (i==1 || i==2) {
            return 1;
        } else {
            return fib(i-1) + fib(i-2);
        }
    }
}
