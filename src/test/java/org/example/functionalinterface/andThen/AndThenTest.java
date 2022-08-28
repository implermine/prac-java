package org.example.functionalinterface.andThen;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AndThenTest {

    @Test
    @DisplayName("CustomInterface 사용")
    void test(){

        var before = new CustomFunctionalInterface<Integer,String>(){
            @Override
            public String trigger(Integer integer) {
                return " Hello " + integer;
            }
        };

        var after = new CustomFunctionalInterface<String,String>(){
            @Override
            public String trigger(String s) {
                return " Second " + s;
            }
        };

        CustomFunctionalInterface<Integer, String> combined = before.andThen(after);

        String combinedString = combined.trigger(3);

        Assertions.assertThat(combinedString).isEqualTo(" Second " + " Hello " + 3);
        System.out.println(combinedString);

    }

}
