import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter();
        MyRunnable myRunnable = new MyRunnable(counter);
        MyThread myThread = new MyThread(counter);
        myThread.start();
        new Thread(myRunnable).start();

        SumListWithExecutorService service = new SumListWithExecutorService();
        System.out.println(service.execute());
        SumWithForkJoin sumWithForkJoin = new SumWithForkJoin(ListSupplier.generateElements());
        System.out.println(sumWithForkJoin.compute());
    }
}
