package multithreading1.countdownlatch05;

import common.CommonUtil;

import java.util.concurrent.CountDownLatch;

public class CountDownApp {

    // var count downlatch of 3
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    // create 5 threads
    public static void main(String[] args) {
        CountDownApp countDownApp = new CountDownApp();
        countDownApp.createThreads();
    }

    private void createThreads() {
        Runnable runnable = () -> {
            System.out.println("Started..." + Thread.currentThread().getName());
            CommonUtil.sleepSeconds(1);
            countDownLatch.countDown();
            System.out.println("Finished..."+ Thread.currentThread().getName());
        };
        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "3");
        Thread t4 = new Thread(runnable, "4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All completed:" + countDownLatch.getCount());
    }

    // print when the latch done on main thread


}
