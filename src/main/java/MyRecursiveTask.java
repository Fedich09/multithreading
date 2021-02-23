import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    List<Integer> inputList;

    public MyRecursiveTask(List<Integer> inputList) {
        this.inputList = inputList;
    }

    @Override
    protected Integer compute() {
        return inputList.stream().reduce(Integer::sum).get();
    }
}
