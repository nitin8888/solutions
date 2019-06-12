package multithreading1.addlists04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AddLists {

    // Create 2 lists
    private List<Integer> list1 = new ArrayList<>(10000);
    private List<Integer> list2 = new ArrayList<>(10000);

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    // add values to both lists
    public void add() {

        Runnable runnable = (() -> {
            addValues(list1);
            addValues(list2);
        });
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addValues(List<Integer> list) {
        Random random = new Random();
        IntStream.range(0, 10000).forEach(i -> {
            synchronized (list) {
                list.add(random.nextInt(100));
            }
        });
    }

    public int getTotalListSize() {
        // Get total of both loops
        return list1.size() + list2.size();
    }
}
