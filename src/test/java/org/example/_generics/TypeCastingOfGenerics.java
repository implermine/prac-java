package org.example._generics;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TypeCastingOfGenerics {

    @Test
    void test(){
        Optional<Fruit> empty = Optional.<Fruit>empty();
        Optional<Object> empty1 = Optional.empty();

        Optional<?> wopt = Optional.of(new Object());
        Optional<Object> oopt = Optional.of(new Object());

        Optional<String> sopt = (Optional<String>)wopt;
        //Optional<String> ssopt = (Optional<String>)oopt;

        //---

        Box<?> a1 = new Box<String>();
        Box<Object> a2 = new Box<Object>();

        @SuppressWarnings("unchecked")
        Box<Object> a3 = (Box<Object>)a1;






    }

    Optional<Fruit> getOptFruit(){
        return Optional.empty(); // 리턴값 추론해서 return Optional.<Fruit>empty();임
    }
}
