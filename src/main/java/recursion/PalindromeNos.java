package recursion;

public class PalindromeNos {
    public static void main(String[] args) {
        PalindromeNos palindromeNos = new PalindromeNos();
        int[] nos = {1,2,0,0,2,1};
        int[] nos2 = {1,2,3};
        System.out.println(palindromeNos.pal(nos, 0));
        System.out.println(palindromeNos.pal(nos2, 0));

    }

    // Recu
    // terminator cond
    // Forward rec store char going forward
    // Call rec
    // Back check value is same
    private boolean pal(int[] nos, int i) {
        if (i>= nos.length/2) {
            return true;
        }
        int fValue = nos[i];
        boolean flag = pal(nos, (i+1));
        return flag && fValue == nos[nos.length-i-1];
    }
}
