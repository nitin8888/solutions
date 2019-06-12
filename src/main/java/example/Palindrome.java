package example;

import java.util.stream.IntStream;

public class Palindrome {


    public static boolean isPalindrome3(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            while (isBlank(s.charAt(i))) {
                i++;
                if (i >= j) {
                    return true;
                }
            }
            while (isBlank(s.charAt(j))) {
                j--;
                if (i >= j) {
                    return true;
                }
            }
            if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) return false;
        }

        return true;
    }

    private static void printEnd(long start) {
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start));

    }

    public static boolean isPalindrome(String text) {


        long start = System.currentTimeMillis();

        String s = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = new StringBuilder(s)
                .reverse().toString().equals(s);


        System.out.println("Total time: " + (System.currentTimeMillis() - start));

        return isPalindrome;
    }

    public static boolean isPalindrome2(String text) {

        long start = System.currentTimeMillis();
        char[] chars = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

        boolean isPalindrome = IntStream.range(0, chars.length / 2).allMatch(i -> chars[i] == chars[chars.length - i - 1]);

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start));

        return isPalindrome;
    }

    static boolean isBlank(char c) {
        return c == ' ' || c == ',';
    }

    static char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }
}
