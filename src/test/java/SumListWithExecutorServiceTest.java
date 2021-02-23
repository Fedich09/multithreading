import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumListWithExecutorServiceTest {
    public static int expected;
    private static SumListWithExecutorService service;

    @BeforeAll
    static void beforeAll() {
        service = new SumListWithExecutorService();
        expected = Util.generateElements().stream().reduce(Integer::sum).get();
    }

    @Test
    void sum_Ok() throws ExecutionException, InterruptedException {
        assertEquals(expected, service.execute());
    }
}