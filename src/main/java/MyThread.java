import org.apache.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class);
    private final Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.incAndGet();
            logger.info(Thread.currentThread().getName() + " value = " + counter.get());
        }
    }
}
