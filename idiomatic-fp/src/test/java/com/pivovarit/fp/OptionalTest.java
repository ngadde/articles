package com.pivovarit.fp;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalTest {

    @Test
    void example_1_imperative() throws Exception {
        String name = getName();
        if (name != null) {
            String anotherString = name.toUpperCase();
            if (anotherString != null) {
                // ...
            }
        }
    }

    @Test
    void example_1_declarative() throws Exception {
        // 1. Put value inside Optional
        // 2. Interact with it
        // 3. Unpack it

        /*
        Optional<String> name = Optional.ofNullable(getName());
        Optional<String> upperCase = name.map(s -> s.toUpperCase());
        */

        Optional.ofNullable(getName()) // 1
          .map(s -> s.toUpperCase())   // 2
          .map(s -> s.trim())          // 3
          .orElse("default");     // 4

    }

    @Test
    void example_2_flatmap() throws Exception {

       /*
       Optional<Optional<String>> s1 = Optional.ofNullable(getName())
          .map(s -> getOptionalName(s));
       */

        Optional.ofNullable(getName())
          .flatMap(s -> getOptionalName(s));
    }

    @Test
    void example_3() throws Exception {
        var list = List.of(1);
        // list != null
        Optional.of(list)
          .isPresent();

        Stream.of(1, null)
          .filter(Objects::nonNull)
          .forEach(s -> {});
    }


    private String getName() {
        return "42";
    }

    private Optional<String> getOptionalName(String name) {
        return Optional.of(name + "42");
    }
}
