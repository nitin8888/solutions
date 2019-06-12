package java8.code_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class Moderate {

    public static String fizzBizz(int i) {
        if (i%15 == 0) {
            return "FIZZBUZZ";
        } else if (i%3 ==0) {
            return "FIZZ";
        } else if (i%5 ==0) {
            return "BUZZ";
        }
        return String.valueOf(i);
    }

    public static boolean isPrime(int nos) {
        // loop from 2 to i-1,
        // if divisible retunn false
        // IntStream, match any, return false
        // We only have to loop through 2 to half of num, because no number is divisible by more than its half.
        // extreme 0 & 1 are false
        if (nos <= 1) {
            return false;
        } else {
            return IntStream.range(2, nos/2).parallel().noneMatch(i -> nos % i == 0);
        }
    }

    public static boolean isPalindrome(String text) {
        // Get char array
        // using IntStream len/2 check reverse
        // match all same
        // Validations
        if (text == null) {
            return false;
        }
        char[] chars = text.toCharArray();
        return IntStream.range(0, chars.length / 2).parallel().allMatch(i -> chars[i] == chars[chars.length - i - 1]);
    }

    public static boolean isPalindromeNos(int nos) {
        // Get char array
        // IntStream 0 to len/2
        // all match reverse
        char[] chars = String.valueOf(abs(nos)).toCharArray();
        return IntStream.range(0, chars.length/2).parallel().allMatch(i -> chars[i] == chars[chars.length -i -1]);
    }

    public static int fibonacciNth(int nth) {
        // term 1 or 2 == 1
        // forward rec n-1 + n-2
        // ret element
        return fib(nth);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fibonacciSum(int nth) {
        // get fib nos till nth in list
        // filter by even
        // sum stream
        return IntStream.rangeClosed(1, nth).parallel().map(Moderate::fib).filter(i -> i % 2 == 0).sum();
    }
}
