import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SumListWithExecutorServiceTest {
    private static int expected;
    private static SumListWithExecutorService service;

    @BeforeAll
    public static void beforeAll() {
        service = new SumListWithExecutorService();
        expected = ListSupplier.generateElements().stream().reduce(Integer::sum).get();
    }

    @Test
    public void sum_Ok() throws ExecutionException, InterruptedException {
        assertEquals(expected, service.execute());
    }
}
