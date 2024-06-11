package org.example._inInstance;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class IsInstanceTest {

    @Test
    void test(){
        //boolean instance = Long.class.isInstance(3L);
        boolean instance = Long.class.isInstance(3);

        System.out.println(instance);
    }

    /**
     * null은 type이 없구나
     */
    @Test
    void nullintanceOfTest(){

        Optional<String> nullOptStr = null;
        Optional<String> notNullOptStr = Optional.of("str");

        if(nullOptStr instanceof Optional){
            System.out.println("1");
        }

        if(notNullOptStr instanceof  Optional){
            System.out.println("2");
        }
    }
}
