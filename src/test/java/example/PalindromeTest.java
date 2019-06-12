package example;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void palindromTest() {
        assertThat(Palindrome.isPalindrome("madam"), is(true));
    }

    @Test
    public void palindromLongTest() {
        assertThat(Palindrome.isPalindrome("Mr Owl Ate My Metal Worm"), is(true));
    }

}