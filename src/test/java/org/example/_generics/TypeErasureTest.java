package org.example._generics;

import org.example._generics.model.Foo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureTest {

    @Test
    void testTypeErasure(){

        List<Foo> fooList = new ArrayList<>();
        fooList.add(new Foo());

        Foo foo = fooList.get(0);

    }
}
