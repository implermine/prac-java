package bigdecimal;

import java.math.BigDecimal;

public class BigDecimalSelfModifyingTest {

    public static void main(String[] args) {

        BigDecimal bigDecimalZero = BigDecimal.ZERO;

        BigDecimal add = bigDecimalZero.add(BigDecimal.ONE);

        System.out.println(bigDecimalZero);

        /**
         * 혹시 .add 같은 method를 호출했을 때, bigDecimalZero 그 자체가 변화하는지 보려고 함.
         */

    }
}
