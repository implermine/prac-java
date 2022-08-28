package org.example.functionalinterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.*;

/**
 * BiFunction은 2개의 인자를 받아 1개의 결과를 냅니다.
 */
public class BiFunctionTest {

    @Test
    @DisplayName("Use case")
    void use_case() {

        assertThat(biFunctionImplementedByLambda.apply(1, "helloWorld")).isEqualTo(2);

        assertThat(biFunctionImplementedByAnonymousClass.apply(1, "hiWorld")).isEqualTo(2);

    }

    BiFunction<Integer, String, Integer> biFunctionImplementedByLambda = (T, U) -> {
        System.out.println(U);
        return T + 1;
    };

    BiFunction<Integer, String, Integer> biFunctionImplementedByAnonymousClass = new BiFunction<Integer, String, Integer>() {
        @Override
        public Integer apply(Integer integer, String s) {
            System.out.println(s);
            return integer + 1;
        }
    };
}
