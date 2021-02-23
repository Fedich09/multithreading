import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    List<Integer> inputList;

    public MyCallable(List<Integer> inputList) {
        this.inputList = inputList;
    }

    @Override
    public Integer call() throws Exception {
        return inputList.stream().reduce(Integer::sum).get();
    }
}
