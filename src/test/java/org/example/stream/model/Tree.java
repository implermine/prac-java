package org.example.stream.model;

import lombok.Data;

import java.util.List;

@Data
public class Tree {
    public final String treeName;
    public final Integer treeId;

    public final List<Leaf> leafs;
}
