import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    public static final int LIMIT = 100;
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private final Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < LIMIT; i++) {
            counter.incAndGet();
            logger.info(Thread.currentThread().getName() + " value = " + counter.get());
        }
    }
}
