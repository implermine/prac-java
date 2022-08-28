package org.example.superbuilder.model.notabstract;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Metal {
    private final String metalName;
}
