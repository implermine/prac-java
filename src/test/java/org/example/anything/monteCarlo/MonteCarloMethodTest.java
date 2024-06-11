package org.example.anything.monteCarlo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MonteCarloMethodTest {


    @DisplayName("area of circle")
    @Test
    void should_return_pi() {
        int countOfPoint = 10000;

        int inCirclePoint = 0;
        for (int i = 0; i < countOfPoint; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;

            if (x * x + y * y <= 1) {
                inCirclePoint++;
            }
        }

        System.out.println(4* (double)inCirclePoint/countOfPoint);

    }

    @DisplayName("length of line")
    @Test
    void should_return_length() {
        int countOfPoint = 10000;

        int inLinePoint = 0;
        for (int i = 0; i < countOfPoint; i++) {
            double x = Math.random() * 2;

            if (x  <= 1) {
                inLinePoint++;
            }
        }

        System.out.println( (double)inLinePoint/countOfPoint);

    }


}

