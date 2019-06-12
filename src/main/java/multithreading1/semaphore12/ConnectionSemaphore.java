package multithreading1.semaphore12;

public class ConnectionSemaphore {

    Connection connection = Connection.getInstance();

    public ConnectionSemaphore() {
    }

    public void connect() {
        /*
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 20).forEach(i -> {
            executorService.execute(() ->connection.connect());
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    public int getConnection() {
        return connection.getConnection();
    }
}
