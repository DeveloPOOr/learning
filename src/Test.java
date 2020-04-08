import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        IntStream mids = IntStream.iterate(13, n -> {
            n = n*n/10%1000;


            return n;
        }).limit(10);
        mids.forEach(System.out::println);

    }
    public static IntStream pseudoRandomStream(int seed) {
        return  IntStream.iterate(seed, n -> n*n/10%1000);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        stream = stream.sorted(order);
        List<T> list = stream.collect(Collectors.toList());
        T min = list.size() == 0 ?  null : list.get(0);
        T max = list.size() == 0 ? null : list.get(list.size()-1);
        minMaxConsumer.accept(min, max);


    }
}
