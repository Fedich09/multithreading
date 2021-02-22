public class Counter {
    private int value = 0;

    public int get() {
        return value;
    }

    public int incAndGet() {
        this.value++;
        return this.value;
    }
}
