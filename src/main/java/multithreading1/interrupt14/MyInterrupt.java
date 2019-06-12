package multithreading1.interrupt14;

import common.CommonUtil;

public class MyInterrupt {

    // Create thread with loop

    // From main thread interrupt

    // sout in created thread that interrrupted
    public static void main(String[] args) {
        MyInterrupt myInterrupt = new MyInterrupt();
        myInterrupt.createThread();
    }

    private void createThread() {
        Thread t1 = new Thread(() -> {
            System.out.println("started");
            while (true) {
                System.out.println("running");
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted");
                    break;
                }
            }
        });
        t1.start();
        CommonUtil.sleepSeconds(2);
        t1.interrupt();
        System.out.println("Finished");
    }
}
