import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class SumWithForkJoin extends RecursiveTask<Integer> {
    private static final int THREADS = 10;

    @Override
    public Integer compute() {
        List<Integer> integers = Util.generateElements();
        List<List<Integer>> lists = ListUtils.partition(integers, integers.size() / THREADS);
        List<MyRecursiveTask> collect = lists.stream()
                .map(MyRecursiveTask::new)
                .collect(Collectors.toList());
        Collection<MyRecursiveTask> myRecursiveTasks = ForkJoinTask.invokeAll(collect);
        return myRecursiveTasks.stream().map(MyRecursiveTask::compute).reduce(Integer::sum).get();
    }
}
