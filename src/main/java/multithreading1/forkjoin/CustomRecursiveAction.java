package multithreading1.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction {

    // threshold variable
    private static int THRESHOLD = 2;

    private String workload;

    // Recursively breakdown the tasks to make string to upper case and log it
    // Import


    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length()<=2) {
            process(workload);
        } else {
            // create subtasks i.e. break down
            ForkJoinTask.invokeAll(createTasks());
        }
    }

    private List<CustomRecursiveAction> createTasks() {
        // divide it
        List<CustomRecursiveAction> part = new ArrayList<>();
        part.add(new CustomRecursiveAction(workload.substring(0, workload.length()/2)));
        part.add(new CustomRecursiveAction(workload.substring(workload.length()/2, workload.length())));
        return part;
    }

    private void process(String workload) {
        System.out.print(workload.toUpperCase());
    }
}
