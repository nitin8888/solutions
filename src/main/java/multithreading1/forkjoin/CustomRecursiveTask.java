package multithreading1.forkjoin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<String> {

    // Get threshold
    private static int THRESHOLD = 2;
    // Store workload

    private final String workload;

    public CustomRecursiveTask(String workload) {
        this.workload = workload;
    }

    // if below threshold store return upper case else recursively break up

    @Override
    protected String compute() {
        if (workload.length() <= THRESHOLD) {
            return process(workload);
        } else {
            return ForkJoinTask.invokeAll(getBreakdownTasks()).stream().map(ForkJoinTask::join).reduce("", (a, b) -> a + b);
        }
    }

    private String process(String workload) {
        return workload.toUpperCase();
    }

    private Collection<CustomRecursiveTask> getBreakdownTasks() {
        List<CustomRecursiveTask> customRecursiveTasks = new ArrayList<>(2);
        customRecursiveTasks.add(new CustomRecursiveTask(workload.substring(0, workload.length()/2)));
        customRecursiveTasks.add(new CustomRecursiveTask(workload.substring((workload.length()/2),workload.length())));
        return customRecursiveTasks;
    }

    // Task return the
}
