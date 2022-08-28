package org.example.basic.enum_.woowahan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestEntry {

    @Test
    @DisplayName("JAVA7 버전의 선언적 Enum 설계")
    void test1(){
        Calculator calcA = Calculator.CALC_A;


        System.out.println(calcA.getClass());
        /**
         * class Calculator$1
         */

        /**
         * 보다싶이 Calculator '$1' 이란 시그니쳐가 남는다.
         *
         * 익명클래스의 구현체가 존재한다는것을 시사한다.
         * */

    }
}
