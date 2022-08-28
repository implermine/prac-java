package org.example._constructor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * 기본생성자 call)
 * 1. 필드 생성자 call
 * 2. 기본 생성자 call
 *
 * 커스텀 생성자 call) -> 기본생성자를 call하지 않는다.
 * 1. 필드 생성자 call
 * 2. 커스텀 생성자 call
 */
public class ConstructorTest {

    @Test
    @DisplayName("기본 생성자가 존재할 때(묵시적 형성이 이루어지지 않았을 때) 이는 필드에 정의 해 놓은 값을 묵시적으로 호출하는가?") // yes
    void test(){
        Pojo pojo = new Pojo();

        Assertions.assertThat(pojo.getName()).isEqualTo("foo");
        Assertions.assertThat(pojo.isOriginal()).isEqualTo(true);
    }

    @Test
    @DisplayName("커스텀 생성자는 기본생성자를 묵시적으로 호출하는가?") // No but field constructing occurs....
    void test2(){
        Pojo pojo = new Pojo("bar");

        Assertions.assertThat(pojo.getName()).isEqualTo("bar");
        Assertions.assertThat(pojo.isOriginal()).isEqualTo(true); // false가 아니다.

        /**
         * 기본 생성자에 콘솔입력을 수행 해 놓았으나, 호출되지 않은것으로 미루어 볼 때,
         *
         * 커스텀 생성자의 수행 직전에 필드 생성을 수행하고, 커스텀 생성자를 호출하는것으로 보인다.
         *
         * 다시말해, test 와 test2의 내용을 종합해보면
         *
         * 기본생성자 call)
         * 1. 필드 생성자 call
         * 2. 기본 생성자 call
         *
         * 커스텀 생성자 call) -> 기본생성자를 call하지 않는다.
         * 1. 필드 생성자 call
         * 2. 커스텀 생성자 call
         */
    }

    @Test
    @DisplayName("field initialization -> constructor")
    void test3(){
        Pojo pojo = new Pojo(1L);
        //before Pojo Constructs, name is initialized with : foo
    }

    /*
    when it comes to context of `extends`...
     */
    @Test
    @DisplayName("base,derived field initialization -> base default constructor -> derived any constructor")
    void test4(){
        Derived derived = new Derived("hey");

        /*
        1. 부모 필드 생성자
        2. 부모 기본 생성자 (묵시적 super() 콜)
        3. 자식 필드 생성자 (1 타이밍에 같이 될 수도 있음)
        4. 자식 커스텀 생성자
        */
    }


}
