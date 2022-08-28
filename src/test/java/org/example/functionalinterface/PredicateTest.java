package org.example.functionalinterface;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

/**
 * `Predicate` takes 1 argument and produces 1 Boolean result
 *
 * Function은 1개의 인자를 받아 1개(Boolean)의 결과를 냅니다.
 */
public class PredicateTest {

    @Test
    @DisplayName("Use case")
    void test() {

        assertThat(this.isEven(2)).isTrue();

        assertThat(isEven2.test(2)).isTrue();

        assertThat(isEven3.test(2)).isTrue();
    }

    /**
     * `NORMAL` JAVA Function
     */
    Boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    /**
     * Predicate implemented by `lambda`
     */
    Predicate<Integer> isEven2 = (integer) -> integer % 2 == 0;

    /**
     * Predicate implemented by `Anonymous class`
     */
    Predicate<Integer> isEven3 = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 == 0;
        }
    };

}
