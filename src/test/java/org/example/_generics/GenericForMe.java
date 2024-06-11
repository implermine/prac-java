package org.example._generics;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class GenericForMe {


    @Test
    void test(){
        Optional<String> empty = Optional.<String>empty();
        Optional<Object> empty1 = Optional.empty();


        Box<?> anonymousBox = new Box<>();
    }

    @Test
    void test2(){
        //new Box<?>();

    }
}
