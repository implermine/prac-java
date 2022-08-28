package org.example._mod;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ModTest {

    @Test
    @DisplayName("나머지 연산")
    void test() {

        int result = (3 % -1);
        int result2 = (3 & 0);

        Assertions.assertThat(result).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(0);
    }
}
