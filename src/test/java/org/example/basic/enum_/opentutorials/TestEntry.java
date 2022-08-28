package org.example.basic.enum_.opentutorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TestEntry {

    @Test
    @DisplayName("Enum은 null이 될 수 있는가?")
    void test_null(){
        Fruit apple = null;
    }

    @Test
    void contextLoads(){
        Fruit apple = Fruit.APPLE;

        /**
         * Lazily Load `ALL` Enum Context
         * and
         * Lazily Load static Context
         */

        Fruit fruit = Enum.valueOf(Fruit.class, "PEACH");

        System.out.println("=============");
        System.out.println(fruit);
    }

    @Test
    @DisplayName("enum의 public field에 접근해보기")
    void test1(){
        String color = Fruit.APPLE.color;
        System.out.println(color);
    }

    @Test
    @DisplayName("enum 내에서 static context method inner call")
    void test2(){
        Fruit.APPLE.custom();
    }

    @Test
    @DisplayName("Enum의 특정 인스턴스를 O(1)으로 찾기")
    void test3(){
        Optional<Fruit> apple = Fruit.findByName("APPLE");
        apple.ifPresent(System.out::println);

        Optional<Fruit> notapple = Fruit.findByName("NOT_APPLE");
        notapple.ifPresent(System.out::println);
    }

}
