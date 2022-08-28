package org.example.functionalinterface;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * `Supplier` takes 0 argument and produces 1 result
 *
 * Supplier는 0개의 인자를 받아 1개의 결과를 냅니다. (Consumer의 반대)
 */
public class SupplierTest {

    @Test
    @DisplayName("Use Case")
    void test(){

        Assertions.assertThat(this.numberProvider()).isEqualTo(1);
        Assertions.assertThat(numberProvider2.get()).isEqualTo(1);
        Assertions.assertThat(numberProvider3.get()).isEqualTo(1);

    }

    /**
     * `NORMAL` Java Function
     */
    public Integer numberProvider(){
        return 1;
    }

    /**
     * Supplier implemented by Lambda
     */
    Supplier<Integer> numberProvider2 = () -> 1;


    /**
     * Supplier implemented by Anonymous class
     */
    Supplier<Integer> numberProvider3 = new Supplier<Integer>() {
        @Override
        public Integer get() {
            return 1;
        }
    };


}
