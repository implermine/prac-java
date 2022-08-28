package org.example.stream;


import org.assertj.core.api.Assertions;
import org.example.stream.model.Leaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Stream에 대한 Collect 테스트
 */
public class CollectTest {

    // As we can see, treeId is not ordered.
    /**
     * Tree 1 - (1,8) <br>
     * Tree 2 - (2,4,6,7) <br>
     * Tree 3 - (3) <br>
     * Tree 4 - (5,9,10,11) <br>
     */
    Leaf leaf1 = new Leaf(1, "나뭇잎1", 1);
    Leaf leaf2 = new Leaf(2, "나뭇잎2", 2);
    Leaf leaf3 = new Leaf(3, "나뭇잎3", 3);
    Leaf leaf4 = new Leaf(4, "나뭇잎4", 2);
    Leaf leaf5 = new Leaf(5, "나뭇잎5", 4);
    Leaf leaf6 = new Leaf(6, "나뭇잎6", 2);
    Leaf leaf7 = new Leaf(7, "나뭇잎7", 2);
    Leaf leaf8 = new Leaf(8, "나뭇잎8", 1);
    Leaf leaf9 = new Leaf(9, "나뭇잎9", 4);
    Leaf leaf10 = new Leaf(10, "나뭇잎10", 4);
    Leaf leaf11 = new Leaf(11, "나뭇잎11", 4);

    private final List<Leaf> leaves = new ArrayList<>();

    @BeforeEach
    void scenario(){
        leaves.add(leaf1);
        leaves.add(leaf2);
        leaves.add(leaf3);
        leaves.add(leaf4);
        leaves.add(leaf5);
        leaves.add(leaf6);
        leaves.add(leaf7);
        leaves.add(leaf8);
        leaves.add(leaf9);
        leaves.add(leaf10);
        leaves.add(leaf11);
    }

    /**
     * leaf를 leafId에 따라 분류
     *
     * @의의 없음
     */
    @Test
    void test() {
        Map<Integer, Leaf> leafByLeafId = leaves.stream().collect(Collectors.toMap(Leaf::getLeafId, leaf -> leaf));

        for (Map.Entry<Integer, Leaf> eachEntry : leafByLeafId.entrySet()) {
            System.out.println("key = " + eachEntry.getKey() + " value = " + eachEntry.getValue());
        }
    }


    /**
     * leaf를 treeId 따라 분류
     * 그리고 그 구현은, ordered 되어있다.
     *
     * @의의 group by, grouping
     */
    @Test
    void groupLeavesByTreeId() {
        Map<Integer, List<Leaf>> collect = leaves.stream().collect(Collectors.groupingBy(leaf -> leaf.getTreeId()));

        for (Map.Entry<Integer, List<Leaf>> integerListEntry : collect.entrySet()) {

            System.out.println("integerListEntry = " + integerListEntry);

        }
    }


    /**
     * leaf를 treeId 따라 분류
     * 그리고 그 구현은, ordered 되어있다.
     * 그 구현된 객체를 각 value를 매핑( .map() )
     *
     * @의의 group by, grouping
     */
    @Test
    void test3(){

        Map<Integer, List<Integer>> leafIdListByTreeId = leaves
                .stream()
                .collect(
                        Collectors.groupingBy(leaf -> leaf.getTreeId(), Collectors.mapping(leaf -> leaf.getLeafId(), Collectors.toList()))
                );

        for(var each : leafIdListByTreeId.entrySet()){
            System.out.println(each);
        }
    }

    /**
     * leaf를 treeId 따라 분류
     * 그리고 그 구현은, ordered 되어있다.
     * 그 구현된 객체를 각 value를 매핑( .map() )
     *
     * Test3의 좀 더 직관적인 버전을 생각, -> 쉽지않음
     *
     * @의의 group by, grouping
     */
    @Test
    void test3Eh(){

        Map<Integer, List<Integer>> leafIdListByTreeId = leaves
                .stream()
                .collect(
                        Collectors.groupingBy(leaf -> leaf.getTreeId(), Collectors.mapping(leaf -> leaf.getLeafId(), Collectors.toList()))
                );


        for(var each : leafIdListByTreeId.entrySet()){
            System.out.println(each);
        }
    }

    @Nested
    @DisplayName("reduce")
    class ReduceTest {
        @Test
        @DisplayName("reduce with basic wrapper")
        void reduce_with_basic_wrapper() {

            List<Integer> list = new ArrayList<>();
            list.add(5);
            list.add(3);
            list.add(2);
            list.add(4);

            // identity is 초항
            Integer reduce = list.stream().reduce(0, (subTotal, element) -> subTotal + element);

            Assertions.assertThat(reduce).isEqualTo(14);
        }

        @Test
        @DisplayName("reduce with basic wrapper with custom BinaryOperator")
        void reduce_with_basic_wrapper_with_custom_binary_operator() {

            List<Integer> list = new ArrayList<>();
            list.add(5);
            list.add(3);
            list.add(2);
            list.add(4);

            BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer + integer2;
                }
            };


            Integer reduce = list.stream().reduce(0, binaryOperator);

            Assertions.assertThat(reduce).isEqualTo(14);
        }
    }
}
