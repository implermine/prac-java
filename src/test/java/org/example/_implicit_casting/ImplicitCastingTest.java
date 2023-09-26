package org.example._implicit_casting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImplicitCastingTest {

    /**
     * http://www.tcpschool.com/java/java_datatype_typeConversion
     *
     *
     * 자바에서는 데이터의 손실이 발생하지 않거나, 데이터의 손실이 최소화되는 방향으로 묵시적 타입 변환을 진행합니다.
     * 또한, 자바에서는 데이터의 손실이 발생하는 대입 연산은 허용하지 않습니다.
     */
    @Test
    void test(){

        Integer a = 100; // 4byte
        Double b = 50.0; // 8byte

        Object result = a * b;

        System.out.println(result.getClass());
        Assertions.assertThat(result).isInstanceOf(Double.class);

        //Integer is implicitly cast to Double
        //Integer -> Double

    }
}
