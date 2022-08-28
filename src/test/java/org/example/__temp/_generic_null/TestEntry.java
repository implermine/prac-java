package org.example.__temp._generic_null;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestEntry {

    @Test
    void test(){

        Tuple<String, String> of = Tuple.of("abc", "cde");

        Tuple<Object, Object> of1 = Tuple.of(null, null);

        System.out.println("hey");
    }

    @Test
    void test1(){
        //Interval<LocalDateTime> as = new Interval<>(LocalDateTime.MIN, LocalDateTime.MAX);
        //
        //LocalDateTime start = as.getStart();

        Interval<LocalDate> localDateInterval = new Interval<LocalDate>(LocalDate.MIN, LocalDate.MAX);

    }
}
