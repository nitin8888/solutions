package multithreading1.future13;

import common.CommonUtil;

import java.util.Random;
import java.util.concurrent.*;

public class MyFuture {

    // Create a callable
    // submit to executor

    // display returned value from future

    public static void main(String[] args) {
        MyFuture myFuture = new MyFuture();
        myFuture.createThread();
    }

    private void createThread() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> {
            Random random = new Random();
            int duration = random.nextInt(10);
            CommonUtil.sleepSeconds(duration);
            return duration;
        };

        Future<Integer> future = executorService.submit(callable);
        executorService.shutdown();

        try {
            System.out.println("Future value" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
