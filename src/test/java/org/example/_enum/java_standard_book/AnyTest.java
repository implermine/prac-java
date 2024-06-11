package org.example._enum.java_standard_book;

import org.junit.jupiter.api.Test;

public class AnyTest {

    @Test
    void test(){
        Direction east = Direction.EAST;
        Direction south = Direction.SOUTH;

        int i = east.compareTo(south);

        System.out.println(i);


    }
}
