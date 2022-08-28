package org.example.stream.model;

import lombok.Data;

@Data
public class Leaf {
    public final Integer leafId;
    public final String leafName;

    // 1:N = Tree:Leaf
    public final Integer treeId;
}
