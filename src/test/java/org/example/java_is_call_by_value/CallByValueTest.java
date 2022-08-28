package org.example.java_is_call_by_value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

public class CallByValueTest {

    @Test
    void someTest() {

        IntBox a = new IntBox(3);
        IntBox b = new IntBox(5);
        int c = 3;

        func1(a);
        func2(b);
        func3(c);

        System.out.println(a); // 문제1
        System.out.println(b); // 문제2
        System.out.println(c); // 문제3
    }

    void func1(IntBox par) {
        par = new IntBox(7);
    }

    void func2(IntBox par) {
        par.setIntValue(11);
    }

    void func3(int par) {
        par = 15;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    private static class IntBox {
        private int intValue;
    }
}
