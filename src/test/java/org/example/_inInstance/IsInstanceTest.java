package org.example._inInstance;

import org.junit.jupiter.api.Test;

public class IsInstanceTest {

    @Test
    void test(){
        //boolean instance = Long.class.isInstance(3L);
        boolean instance = Long.class.isInstance(3);

        System.out.println(instance);
    }
}
