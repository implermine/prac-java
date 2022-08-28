package org.example.stream.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {


    @Test
    @DisplayName("partitioningBy 기본1")
    void test(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> collect = list.stream()
                .collect(Collectors.partitioningBy(this::foo));

        List<Integer> trued = collect.get(true);
        List<Integer> falsed = collect.get(false);

        System.out.println(trued);
        System.out.println(falsed);
    }

    @Test
    @DisplayName("partitioningBy 기본2 - key/value에서 value를 원하는것으로 mapping")
    void test2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> collect = list.stream()
                .collect(Collectors.partitioningBy(this::foo,Collectors.mapping(integer -> integer+100, Collectors.toList())));

        List<Integer> trued = collect.get(true);
        List<Integer> falsed = collect.get(false);

        System.out.println(trued);
        System.out.println(falsed);
    }


    boolean foo(Integer integer){
        if(List.of(1,5,6).contains(integer)){
            return true;
        }
        return false;
    }

    boolean bar(Book book){
        if(book.getId()==3){
            return true;
        }

        if(book.getId()==1){
            return true;
        }

        return false;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Book{

        private Long id;
        private String name;
        private Integer height;
    }

    public static class Tuple<A, B> {
        private final A first;
        private final B second;

        public Tuple(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        public static <A,B> Tuple<A,B> of(A first, B second){
            return new Tuple<>(first, second);
        }
    }

}
