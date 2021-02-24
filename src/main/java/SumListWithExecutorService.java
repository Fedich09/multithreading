import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class SumListWithExecutorService {
    private static final int THREADS = 10;

    public int execute() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Integer> integers = ListSupplier.generateElements();
        List<List<Integer>> lists = ListUtils.partition(integers, integers.size() / THREADS);
        List<Callable<Integer>> callables = lists.stream()
                .map(ListSumCalculator::new)
                .collect(Collectors.toList());
        List<Future<Integer>> futures = executorService.invokeAll(callables);
        executorService.shutdown();
        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        return sum;
    }
}
