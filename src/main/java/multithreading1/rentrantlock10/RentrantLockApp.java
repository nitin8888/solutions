package multithreading1.rentrantlock10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class RentrantLockApp {
    // variable int count
    private int count;

    // Create Rentrant lock
    private Lock lock = new ReentrantLock();
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void startThread() {
        Runnable runnable = () -> {
            IntStream.range(0, 10000).forEach(this::incrementCounter);
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.shutdown();
    }

    private void incrementCounter(int i) {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public void waitToFinish() {
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // create 2 threads which increment count, 10000
    // handle multthreading via rentrant lock

    // later finish

}
