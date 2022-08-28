package org.example.basic.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericClass <weirdo>{

    List<weirdo> weirdoList = new ArrayList<>();
    weirdo sneakers;

    public GenericClass(List<weirdo> weirdoList, weirdo sneakers) {
        this.weirdoList = weirdoList;
        this.sneakers = sneakers;
    }

    void say(weirdo parWeirdo){
        System.out.println(sneakers.getClass());
        System.out.println(parWeirdo);
    }

    public static <V> void genericStaticMethod(V some){
        System.out.println(some.getClass());
    }

    public <K> void genericMethod(K some){
        System.out.println(some.getClass());
    }
}
