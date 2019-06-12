package multithreading1.volatile02;

import common.CommonUtil;

public class VolatileVariable {

    // new volatile var
    private volatile boolean isShutDown;

    public static void main(String[] args) {
        VolatileVariable volatileVariable = new VolatileVariable();
        volatileVariable.startThread();

        // From main thread do shutdown
        CommonUtil.sleepSeconds(3);
        volatileVariable.shutdown();

    }

    private void shutdown() {
        isShutDown = true;
    }

    private void startThread() {
        Thread thread = new Thread(() -> {
            System.out.printf("Started");

            while (!isShutDown) {
                System.out.println("Is running");
                CommonUtil.sleepSeconds(1);
            }
        });
        thread.start();
    }


    // Start thread

}
