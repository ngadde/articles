package com.pivovarit.fp;

import org.junit.jupiter.api.Test;

class MainTest {

    // Stringly-typed
    /*
    private final String name = ".,a.,da.s,ddam162t 2t 8";
    private final String surname = "Adam";
    private final String address = "Foobar 5";
    */

    private final Name name = new Name("Adam");
    private final Surname surname = new Surname("Nowak");
    private final Address address = new Address("Foobar 5");

    class Name {
        private final String name = "default";

        public Name(String name) {
        }
    }

    class Surname {
        private final String name = "default";

        public Surname(String name) {
        }
    }

    class Address {
        private final String name = "default";

        public Address(String name) {
        }
    }

    @Test
    void example_1() throws Exception {
    }
}