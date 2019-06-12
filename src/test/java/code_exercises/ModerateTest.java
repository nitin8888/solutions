package code_exercises;

import java8.code_exercises.Moderate;
import org.junit.jupiter.api.Test;

import static java8.code_exercises.Moderate.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ModerateTest {

    @Test
    public void fizzBizzTest() {
        assertThat(fizzBizz(3), is("FIZZ"));
        assertThat(fizzBizz(9), is("FIZZ"));
        assertThat(fizzBizz(5), is("BUZZ"));
        assertThat(fizzBizz(10), is("BUZZ"));
        assertThat(fizzBizz(15), is("FIZZBUZZ"));
        assertThat(fizzBizz(30), is("FIZZBUZZ"));
        assertThat(fizzBizz(7), is("7"));
    }

    @Test
    public void primeTest() {
        assertThat(isPrime(2), is(true));
        assertThat(isPrime(3), is(true));
        assertThat(isPrime(5), is(true));
        assertThat(isPrime(9), is(false));
    }

    @Test
    public void palindromeTest() {
        assertThat(isPalindrome("abcba"), is(true));
        assertThat(isPalindrome("abba"), is(true));
        assertThat(isPalindrome("1234321"), is(true));
        assertThat(isPalindrome("12a4a21"), is(true));
        assertThat(isPalindrome("abcd"), is(false));
        assertThat(isPalindrome("abcba "), is(false));  // Char + Space
        assertThat(isPalindrome(null), is(false));      // null
        assertThat(isPalindrome(""), is(true));         // empty
        assertThat(isPalindrome(" "), is(true));        // space
        assertThat(isPalindrome("£$%$£"), is(true));    // Special char
    }

    @Test
    public void palindromeNosTest() {
        assertThat(Moderate.isPalindromeNos(0), is(true));
        assertThat(Moderate.isPalindromeNos(-1), is(true));
        assertThat(Moderate.isPalindromeNos(1234321), is(true));
        assertThat(Moderate.isPalindromeNos(1234), is(false));
        assertThat(Moderate.isPalindromeNos(-1234321), is(true));               // Negative
        assertThat(Moderate.isPalindromeNos(Integer.MAX_VALUE), is(false));     // Max value
        assertThat(Moderate.isPalindromeNos(Integer.MIN_VALUE), is(false));     // Min value
    }

    @Test
    public void fibonacciNthTest() {
        assertThat(Moderate.fibonacciNth(3), is(2));
        assertThat(Moderate.fibonacciNth(5), is(5));
        assertThat(Moderate.fibonacciNth(8), is(21));
    }

    @Test
    public void fibonacciSumTest() {
        assertThat(Moderate.fibonacciSum(3), is(2));
        assertThat(Moderate.fibonacciSum(7), is(10));
        assertThat(Moderate.fibonacciSum(10), is(44));
    }

}
