package EnumPrac;

public class CalculatorEntry {

    public static void main(String[] args) {

        var calcA = CalculatorTypeJava7.CALC_A;

        System.out.println(calcA.getClass());
        /**
         * class EnumPrac.CalculatorTypeJava7$1
         */

        /**
         * 보다싶이 CalculatorTypeJava7 '$1' 이란 시그니쳐가 남는다.
         *
         * 익명클래스의 구현체가 존재한다는것을 시사한다.
         * */

        var apple = Company.APPLE;

        System.out.println(apple.getClass());
        /**
         * class EnumPrac.Company
         */


        /**
         * 여기서 시사하는 바는, Enum들은 서로 같은 타입이며, 다른 값을 가진다. 너는나고 나는 너인 느낌이다.
         */
    }
}
