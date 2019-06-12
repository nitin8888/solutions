package multithreading.forkjoin;

import multithreading1.forkjoin.CustomRecursiveTask;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ForkJoinTaskTest {

    @Test
    public void forkJoinTaskTest() {
        String text = "abcdefghijk";
        CustomRecursiveTask forkJoinTask = new CustomRecursiveTask(text);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        assertThat(forkJoinPool.invoke(forkJoinTask).length(), is(text.length()));
    }
}
