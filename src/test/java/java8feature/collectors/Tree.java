package java8feature.collectors;

import lombok.Data;

import java.util.List;

@Data
public class Tree {
    public final String treeName;
    public final Integer treeId;

    public final List<GroupingByTest.Leaf> leafs;
}
