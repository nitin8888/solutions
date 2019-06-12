package recursion;

public class PrintBack {

    public static void main(String[] args) {
        printBack(5, 0);
    }



    // Print back
    // return void
    // param max & init value
    // if max value reached end rec
    // forward start adding
    // backward start printing
    private static void printBack(int max, int i) {
        if (i >= max) {
            return;
        }
        i++;
        printBack(max, i);
        System.out.println(i);
    }
}
