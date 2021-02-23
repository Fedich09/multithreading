import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    public static List<Integer> generateElements() {
        return IntStream
                .rangeClosed(1, 1_000_000)
                .boxed()
                .collect(Collectors.toList());
    }
}
