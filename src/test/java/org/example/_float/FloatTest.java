package org.example._float;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FloatTest {

    @Test
    void test(){

        /**
         * https://woo-dev.tistory.com/93 -> 소숫점 이진수 변환
         * 0.625의 경우...
         * 0.625*2 = [1].250 (정수부는 버림)
         * 0.250*2 = [0].500
         * 0.500*2 = [1].000
         *
         * -> 101
         *
         * 0.1의 경우...
         * 0.1 * 2 = [0].2
         * 0.2 * 2 = [0].4
         * 0.4 * 2 = [0].8
         * 0.8 * 2 = [1].6
         * 0.6 * 2 = [1].2
         * 0.2 * 2 = [0].4 (순환)
         *
         * 0.15의 경우...
         * 0.15 * 2 = [0].3
         * 0.3 * 2 = [0].6
         * 0.6 * 2 = [1].2 (순환)
         *
         */

        // 0.1과 0.2가 특정 rounding strategy에 의해 반올림되지 않음. (machine epsilon as 2^-23)
        boolean b = (0.1f + 0.2f == 0.3f); // TRUE --> 얘는 rounding strategy에 따라 다름, (어느 레벨에서 이 strategy가 구현되는지는 모름, JVM? OS?)

        // 소숫점이지만 순환되지않아 정확히 표현할 수 있는 소숫점 숫자
        boolean bb = (0.625f + 0.25f == 0.875f); // TRUE ---> 얘는 때려죽여도 TRUE

        // b와 마찬가지로 반올림이 발생하지 않음.
        boolean bbb = (0.1f + 0.1f == 0.2f); // TRUE
        boolean bbbb = (0.1d + 0.1d == 0.2d); // TRUE

        // 0.1 과 0.2가 특정 rounding strategy에 의해 반올림되어 bias가 발생
        boolean bbbbb = (0.1d + 0.2d == 0.3d); // FALSE

        assertThat(b).isTrue();
        assertThat(bb).isTrue();
        assertThat(bbb).isTrue();
        assertThat(bbbb).isTrue();
        assertThat(bbbbb).isFalse();

    }
}
