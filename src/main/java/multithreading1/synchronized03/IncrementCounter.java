package multithreading1.synchronized03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class IncrementCounter {

    // instance variable count
    private int count;

    public static void main(String[] args) {
        IncrementCounter incrementCounter = new IncrementCounter();
        incrementCounter.startThreads();
    }

    private void startThreads() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> {
            IntStream.range(0, 10000).forEach(i -> {
                incrementCount();
            });
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count:" + count);
    }

    private synchronized void incrementCount() {
        count++;

    }


    // method to increment count


    // 2 threads to increment count


}
