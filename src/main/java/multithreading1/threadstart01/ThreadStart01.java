package multithreading1.threadstart01;

public class ThreadStart01 {
    public static void main(String[] args) {
        ThreadStart01 threadStart01 = new ThreadStart01();
        threadStart01.newThread();
    }

    private void newThread() {
        Thread thread = new Thread(() -> {
            System.out.println("Started");
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
