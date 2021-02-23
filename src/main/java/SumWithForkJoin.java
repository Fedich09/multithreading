import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumWithForkJoin extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 50_000;
    private List<Integer> list;

    public SumWithForkJoin(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if (list.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            return processing(list);
        }
    }

    private Collection<SumWithForkJoin> createSubtasks() {
        List<SumWithForkJoin> dividedTasks = new ArrayList<>();
        dividedTasks.add(new SumWithForkJoin(list.subList(0, list.size() / 2)));
        dividedTasks.add(new SumWithForkJoin(list.subList(list.size() / 2, list.size())));
        return dividedTasks;
    }

    private Integer processing(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
