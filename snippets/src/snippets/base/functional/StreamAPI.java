package snippets.base.functional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.*;

public class StreamAPI {
    public static void run() {
//        createStream();
//        fibonacci();
//        map();
//        filter();
//        findWeekend();
//        reduce();
//        toList();
//        toMap();
//        group();
//        sort();
        distinct();
    }

    private static void createStream() {
        // 1. Stream.of()
        Stream<String> stream1 = Stream.of("A", "B", "C", "D");

        // 2. 基于数组或Collection
        Stream<String> stream2 = Arrays.stream(new String[]{"A", "B", "C", "D"});

        // 3. 基于Supplier
        Stream<Integer> natural = Stream.generate(new NaturalSupplier());

        print(stream2);
        natural.limit(10).forEach(System.out::println);
    }

    private static void fibonacci() {
        LongStream stream = LongStream.generate(new fibonacciSupplier());
        stream.limit(10).forEach(System.out::println);
    }

    private static void map() {

        List<String> list = Arrays.asList(new String[]{"  Apple ", " pear ", " ORANGE", " BaNaNa "});
        list.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void filter() {
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }

    private static void findWeekend() {
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }

    private static void reduce() {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum);
    }

    private static void toList() {

        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream.filter(s -> s != null && !s.trim().isEmpty()).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void toArray() {
        List<String> list = Arrays.asList(new String[]{"  Apple ", " pear ", " ORANGE", " BaNaNa "});
        String[] arrays = list.stream().toArray(String[]::new);
    }

    private static void toMap() {
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(
                        // 把元素s映射为key:
                        s -> s.substring(0, s.indexOf(':')),
                        // 把元素s映射为value:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);
    }

    private static void group() {
        List<String> list = Arrays.asList(new String[]{"Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots"});

        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }

    private static void sort() {
        List<String> list = Arrays.asList(new String[]{"Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots"})
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void distinct() {
        List<String> list = Arrays.asList(new String[]{"A", "B", "A", "C", "B", "D"})
                .stream()
                .distinct()
                .collect(Collectors.toList()); // [A, B, C, D]
        System.out.println(list);
    }

    private static void print(Stream<String> stream) {
        // forEach()方法相当于内部循环调用
        // 传入符合Consumer接口的void accept(T t)的方法引用：
        stream.forEach(System.out::println);
    }
}

class NaturalSupplier implements Supplier<Integer> {
    int n = 0;

    @Override
    public Integer get() {
        return ++n;
    }
}

class fibonacciSupplier implements LongSupplier {
    private int n1 = 0;
    private int n2 = 1;
    private int next;

    @Override
    public long getAsLong() {
        next = n1 + n2;
        n1 = n2;
        n2 = next;
        return n1;
    }
}

class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2020, 1, 1);
    int n = -1;

    @Override
    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
