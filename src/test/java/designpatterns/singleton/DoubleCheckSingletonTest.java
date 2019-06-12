package designpatterns.singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class DoubleCheckSingletonTest {

    @Test
    void duplicateCheckTest() {
        assertNotNull(DoubleCheckSingleton.getInstance());
        assertTrue(DoubleCheckSingleton.getInstance() == DoubleCheckSingleton.getInstance());
    }

    @Test
    void duplicateCheckMultiThreadTest() throws ExecutionException, InterruptedException {
        // Create 2 threads
        // Create 2 instance using future & check equality
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<DoubleCheckSingleton> instance1 = executorService.submit(DoubleCheckSingleton::getInstance);
        Future<DoubleCheckSingleton> instance2 = executorService.submit(DoubleCheckSingleton::getInstance);

        assertTrue(instance1.get() == instance2.get());
        executorService.shutdown();
    }
}