package recursion;

public class PrintNosBackwards {
    public static void main(String[] args) {
        PrintNosBackwards printNosBackwards = new PrintNosBackwards();
        printNosBackwards.printBack(0);
    }

    // Recursion
    // Forward recu add values
    // Call Recur
    // Backward recur print values
    private void printBack(int i) {
        if (i >= 5) {
            return;
        }
        i++;
        printBack(i);
        System.out.print(i + " ");
    }
}
