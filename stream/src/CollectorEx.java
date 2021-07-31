import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorEx {
    public static void main(String[] args) {

        Map<Boolean, Long> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(
                        Collectors.partitioningBy(
                                i -> i % 2 == 0, Collectors.counting()
                        ));
        System.out.println(collect);

        Map<Boolean, Long> odc = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(
                        Collectors.partitioningBy(i -> i % 2 == 0, Collectors.counting())
                );
        System.out.println(odc);

        Map<Integer, List<Integer>> iden = Stream.of(2, 2, 3, 3, 5, 6, 8, 8, 9)
                .collect(
                        Collectors.groupingBy(Function.identity())
                );
        System.out.println(iden);


        Map<String, Optional<Country>> mp = Country.countryStream.stream().collect(
                Collectors.groupingBy(c -> c.name,
                        Collectors.maxBy(Comparator.comparingInt(Country::getPositiveCases)))


        );
        System.out.println(mp);

        Map<String, Country> hrp = Country.countryStream.stream().collect(
                Collectors.groupingBy(c -> c.name,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Country::getPositiveCases))
                                , Optional::get
                        )
                )

        );
        System.out.println(hrp);


        Map<String, Integer> mpp = Country.countryStream.stream().collect(
                Collectors.groupingBy(c -> c.name,
                        Collectors.summingInt(Country::getPositiveCases)

                )

        );

        System.out.println(mpp);
    }



}
