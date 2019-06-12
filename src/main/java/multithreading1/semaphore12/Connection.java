package multithreading1.semaphore12;

import common.CommonUtil;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public final class Connection {

    private static final Connection INSTANCE = new Connection();
    private static final Semaphore SEMAPHORE = new Semaphore(10, true);

    // connection counter
    private static AtomicInteger connections = new AtomicInteger();
    // Increment on getInstnace

    // Connection die after 3 sec

    // get connection

    public static Connection getInstance() {
        return INSTANCE;
    }

    private Connection() {
    }

    public int getConnection() {
        return connections.get();
    }

    public void connect() {
        try {
            SEMAPHORE.acquire();
            connections.incrementAndGet();

            System.out.printf("%s:: Connection. Permits Left = %d\n",
                    Thread.currentThread().getName(),
                    SEMAPHORE.availablePermits());

            CommonUtil.sleepSeconds(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            connections.decrementAndGet();
            SEMAPHORE.release();
        }

    }
}
