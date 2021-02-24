import java.util.List;
import java.util.concurrent.Callable;

public class ListSumCalculator implements Callable<Integer> {
    private final List<Integer> inputList;

    public ListSumCalculator(List<Integer> inputList) {
        this.inputList = inputList;
    }

    @Override
    public Integer call() {
        return inputList.stream().reduce(Integer::sum).get();
    }
}
