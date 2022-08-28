package org.example.functionalinterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;

/**
 * `Function` takes 1 argument and produces 1 result
 *
 * Function은 1개의 인자를 받아 1개의 결과를 냅니다.
 */
public class FunctionTest {

    @Test
    @DisplayName("Use case")
    void use_function(){
        // `Function` takes 1 argument and produces 1 result
        int result = incrementByOne(1);
        assertThat(result).isEqualTo(2);

        int result2 = incrementByOne2.apply(1);
        assertThat(result2).isEqualTo(2);

        int result3 = incrementByOne3.apply(1);
        assertThat(result3).isEqualTo(2);
    }

    @Test
    @DisplayName("and then (combine)")
    void and_then(){

        Function<Integer,Integer> multiplyBy10 = (someInteger) -> someInteger*10;

        Function<Integer, Integer> combinedFunction = incrementByOne2.andThen(multiplyBy10);

        Integer result = combinedFunction.apply(1);

        assertThat(result).isEqualTo(20);
    }

    /**
     * `normal` java function
     */
    public int incrementByOne(int number){
        return number+1;
    }

    /**
     * functional interface implemented by `lambda`
     */
    public Function<Integer,Integer> incrementByOne2 = (someInt) -> someInt+1;

    /**
     * functional interface implemented by Anonymous class
     */
    public Function<Integer,Integer> incrementByOne3 = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer + 1;
        }
    };
}
