package multithreading1.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinRecursive {

    // Call method to print text in upper case

    public static void main(String[] args) {
        String text = "abcdefghijk";
        ForkJoinRecursive forkJoinRecursive = new ForkJoinRecursive();
//        forkJoinRecursive.printUpperCase(text);
        forkJoinRecursive.printUpperCaseFJ(text);
    }

    private void printUpperCaseFJ(String text) {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction(text);
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        commonPool.invoke(customRecursiveAction);
//        customRecursiveAction.invoke();

    }

    private void printUpperCase(String text) {
        System.out.println(text.toUpperCase());
    }
}
