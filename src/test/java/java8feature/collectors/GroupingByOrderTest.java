package java8feature.collectors;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByOrderTest {

    public static void main(String[] args) {

        // As we can see, treeId is not ordered.
        GroupingByTest.Leaf leaf1 = new GroupingByTest.Leaf(1, "나뭇잎1", 1);
        GroupingByTest.Leaf leaf2 = new GroupingByTest.Leaf(2, "나뭇잎2", 2);
        GroupingByTest.Leaf leaf3 = new GroupingByTest.Leaf(3, "나뭇잎3", 3);
        GroupingByTest.Leaf leaf4 = new GroupingByTest.Leaf(4, "나뭇잎4", 2);
        GroupingByTest.Leaf leaf5 = new GroupingByTest.Leaf(5, "나뭇잎5", 4);
        GroupingByTest.Leaf leaf6 = new GroupingByTest.Leaf(6, "나뭇잎6", 2);
        GroupingByTest.Leaf leaf7 = new GroupingByTest.Leaf(7, "나뭇잎7", 2);
        GroupingByTest.Leaf leaf8 = new GroupingByTest.Leaf(8, "나뭇잎8", 1);
        GroupingByTest.Leaf leaf9 = new GroupingByTest.Leaf(9, "나뭇잎9", 4);
        GroupingByTest.Leaf leaf10 = new GroupingByTest.Leaf(10, "나뭇잎10", 4);
        GroupingByTest.Leaf leaf11 = new GroupingByTest.Leaf(11, "나뭇잎11", 4);



        List<GroupingByTest.Leaf> leafs = new ArrayList<>();

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

        Map<Integer, List<GroupingByTest.Leaf>> collect = leafs.stream()
                .collect(Collectors.groupingBy(leaf -> leaf.getTreeId()));


        for (Integer integer : collect.keySet()) {

            System.out.println(" key = "+ integer +" value = " + collect.get(integer));
        }

        /**
         *  key = 1 value = [GroupingByTest.Leaf(leafId=1, leafName=나뭇잎1, treeId=1), GroupingByTest.Leaf(leafId=8, leafName=나뭇잎8, treeId=1)]
         *  key = 2 value = [GroupingByTest.Leaf(leafId=2, leafName=나뭇잎2, treeId=2), GroupingByTest.Leaf(leafId=4, leafName=나뭇잎4, treeId=2), GroupingByTest.Leaf(leafId=6, leafName=나뭇잎6, treeId=2), GroupingByTest.Leaf(leafId=7, leafName=나뭇잎7, treeId=2)]
         *  key = 3 value = [GroupingByTest.Leaf(leafId=3, leafName=나뭇잎3, treeId=3)]
         *  key = 4 value = [GroupingByTest.Leaf(leafId=5, leafName=나뭇잎5, treeId=4), GroupingByTest.Leaf(leafId=9, leafName=나뭇잎9, treeId=4), GroupingByTest.Leaf(leafId=10, leafName=나뭇잎10, treeId=4), GroupingByTest.Leaf(leafId=11, leafName=나뭇잎11, treeId=4)]
         */


        /**
         * As we can see, the embedded List is ordered as existing order
         */

    }


    @Data
    public static class Tree {

        public final String treeName;
        public final Integer treeId;

        public final List<GroupingByTest.Leaf> leafs;
    }

    @Data
    public static class Leaf {

        public final Integer leafId;
        public final String leafName;

        // 1:N = Tree:Leaf
        public final Integer treeId;
    }
}
