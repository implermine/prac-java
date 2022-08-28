package org.example.functionalinterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * Consumer는 1개의 인자를 받고 0개의 결과를 냅니다.
 */
public class ConsumerTest {

    @Test
    @DisplayName("Use case")
    void test(){
        this.greet("implermine");

        greet2.accept("implermine");

        greet3.accept("implermine");
    }

    /**
     * `NORMAL` JAVA Function
     */
    void greet(String who){
        System.out.println(" Hello " + who);
    }

    /**
     * Functional Interface implemented by `lambda`
     */
    Consumer<String> greet2 = (someObject) -> System.out.println(" Hello " + someObject);

    /**
     * Functional Interface implemented by `Anonymous Class`
     */
    Consumer<String> greet3 = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(" Hello " + s);
        }
    };
}
