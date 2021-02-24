import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SumWithForkJoinTest {
    private static int expected;
    private static SumWithForkJoin sumWithForkJoin;

    @BeforeAll
    public static void beforeAll() {
        sumWithForkJoin = new SumWithForkJoin(ListSupplier.generateElements());
        expected = ListSupplier.generateElements().stream().reduce(Integer::sum).get();
    }

    @Test
    public void sum_Ok() {
        assertEquals(expected, sumWithForkJoin.compute());
    }
}
