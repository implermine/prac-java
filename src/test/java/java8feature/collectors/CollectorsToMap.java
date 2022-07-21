package java8feature.collectors;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class CollectorsToMap {

    public static void main(String[] args) {


        // As we can see, treeId is not ordered.
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



        List<Leaf> leafs = new ArrayList<>();

        leafs.add(leaf1);
        leafs.add(leaf2);
        leafs.add(leaf3);
        leafs.add(leaf4);
        leafs.add(leaf5);
        leafs.add(leaf6);
        leafs.add(leaf7);
        leafs.add(leaf8);
        leafs.add(leaf9);
        leafs.add(leaf10);
        leafs.add(leaf11);


        ConcurrentMap<Integer, Leaf> collect = leafs.stream().collect(Collectors.toConcurrentMap(leaf -> leaf.getTreeId(), leaf -> leaf));

        for (Integer integer : collect.keySet()) {


            System.out.println("key : " +integer.toString() + " value :" + collect.get(integer));
        }


    }
}
