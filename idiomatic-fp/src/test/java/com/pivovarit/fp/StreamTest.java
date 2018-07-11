package com.pivovarit.fp;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    /**
     * very important!
     */
    @Test
    void example_1() throws Exception {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        integerStream.forEach(System.out::println);
        // integerStream.forEach(System.out::println); exception!
    }

    @Test
    void example_2() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 33);

        list.stream()
          .map(s -> s.toString())
          .forEach(System.out::println);
    }

    @Test
    void example_3() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 33);

        list.stream()
          .map(s -> {
              System.out.println(s); // bad place for putting side effects!
              return null;
          }).forEach(s -> {});
    }

    @Test
    void example_4() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 33);

        List<String> collect = list.stream()
          .map(s -> s.toString() + "-string")
          .collect(Collectors.toList());

        LinkedList<String> collect2 = list.stream()
          .map(s -> s.toString() + "-string")
          .collect(Collectors.toCollection(() -> new LinkedList<>()));

        Map<String, Integer> collect3 = list.stream()
          .map(s -> s.toString() + "-string")
          .collect(Collectors.toMap(e -> e, e -> e.length()));

        System.out.println(collect3);
    }

    @Test
    void example_5() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 33);

        list.stream()
          .map(s -> s)
          .findAny()
          .map(s -> s.toString())
          .orElse("42");
    }

    @Test
    void example_6() throws Exception {
        List<Integer> list = IntStream.range(0, 100).boxed().collect(Collectors.toList());

        LocalTime before = LocalTime.now();
        list.parallelStream()
          .forEach(s -> {
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
          });

        LocalTime after = LocalTime.now();

        System.out.println(Duration.between(before, after).toMillis());
    }
}
