public class Counter {
    private int value = 0;

    public int get() {
        return value;
    }

    public int increment() {
        return ++value;
    }
}
