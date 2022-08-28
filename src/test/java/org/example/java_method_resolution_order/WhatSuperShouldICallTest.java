package org.example.java_method_resolution_order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WhatSuperShouldICallTest {

    @Test
    @DisplayName("어떤 super가 콜") //-> super를 명시하나 명시하지않나 NoArg는 call한다.
    void test(){

        Son son = new Son(null);
        //Son son = new Son();

    }

    /**
     * So to say,
     *
     * 1. super()는 `바로 윗단계` Base class의 생성자를 호출 // python의 MRO는 애초에 JAVA에서 다중상속을 지원하지 않으니 차치할 문제이다. https://tibetsandfox.tistory.com/26
     * 2. super()를 명시하나 명시하지않나, 바로 윗단계의 super()를 호출
     * 3. super(arg)를 명시하면, 바로 윗단계의 super(par)를 호출 및 super() 비호출
     */
}
