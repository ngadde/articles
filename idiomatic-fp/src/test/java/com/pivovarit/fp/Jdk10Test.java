package com.pivovarit.fp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk10Test {

    @Test
    void example_1() throws Exception {
        Optional<String> any = Stream.of(1)
          .flatMap(i -> Stream.generate(() -> UUID.randomUUID().toString()))
          .findAny();
    }

    @Test
    void example_2() throws Exception {
        Stream.iterate(LocalDate.now(), date -> date.plusMonths(1))
          .filter(date -> date.getMonth() != Month.JANUARY)
          .forEach(date -> System.out.println(date));

        Stream.iterate(LocalDate.now(), date -> date.plusMonths(1))
          .takeWhile(date -> date.getMonth() != Month.JANUARY)
          .forEach(date -> System.out.println(date));
    }

    @Test
    void example_3() throws Exception {
        List<Optional<Integer>> optionals = Arrays.asList(Optional.of(1), Optional.<Integer>empty(), Optional.of(3));

        optionals.stream()
          .filter(Optional::isPresent)
          .map(Optional::get)
          .forEach(System.out::println);

        optionals.stream()
          .flatMap(Optional::stream)
          .forEach(System.out::println);
    }

    @Test
    void example_4() throws Exception {
        //Stream.of(null).forEach(System.out::println);

        Stream.ofNullable(null).forEach(System.out::println);
    }

    @Test
    void example_5() throws Exception {
        List.of(1, 2 ,3);
    }

    /**
     * libraries/languages to remember about
     */
    @Test
    void example_6() throws Exception {
        // vavr.io
        // scala
        // kotlin
        // cyclops-react
        // RxJava/Project Reactor(Spring Webflux)
    }




}
