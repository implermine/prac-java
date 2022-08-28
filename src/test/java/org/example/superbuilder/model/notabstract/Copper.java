package org.example.superbuilder.model.notabstract;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class Copper extends Metal{
    private final String copperName;
}
