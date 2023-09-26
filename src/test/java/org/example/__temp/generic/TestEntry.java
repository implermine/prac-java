package org.example.__temp.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestEntry {

    @Test
    @DisplayName("Use case")
    void test(){
        GenericClass<String> stringGenericClass = new GenericClass<String>(new ArrayList<>(),"sneakers");

        stringGenericClass.say("some");

        GenericClass.<String>genericStaticMethod("Hey");

        stringGenericClass.<Object>genericMethod("Hey2");
    }
}
