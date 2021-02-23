import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumWithForkJoinTest {
    private static int expected;
    private static SumWithForkJoin sumWithForkJoin;

    @BeforeAll
    static void beforeAll() {
        sumWithForkJoin = new SumWithForkJoin(Util.generateElements());
        expected = Util.generateElements().stream().reduce(Integer::sum).get();
    }

    @Test
    void sum_Ok() {
        assertEquals(expected, sumWithForkJoin.compute());
    }
}
