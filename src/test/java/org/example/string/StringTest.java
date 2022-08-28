package org.example.string;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("null + \"\" ?")
    void test0(){

        Object o = null + "";

        System.out.println(o.getClass());
        System.out.println(o);

        Assertions.assertThat(o).isEqualTo("null");
        Assertions.assertThat(o).isNotNull();
    }

    @Test
    @DisplayName("String + null")
    void test(){
        String actual = "1234" + null;
        Assertions.assertThat(actual).isEqualTo("1234null");
    }

    @Test
    @DisplayName("StringBuffer + null")
    void test2(){

        String some = null;

        System.out.println(new StringBuffer("1234").append(some));
        //1234
    }

    @Test
    @DisplayName("첫번째 char 변경")
    void test3(){

        String some = "ab12";

        char[] chars = some.toCharArray();

        chars[0] = Character.toUpperCase(chars[0]);

        System.out.println(chars);
    }

}
