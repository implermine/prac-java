package EnumPrac;

/**
 * https://techblog.woowahan.com/2527/
 */
public enum CalculatorTypeJava7 {

    CALC_A(3){

        @Override
        long calculate(long value) {
            return value;
        }
    },
    CAL_B(5){
        @Override
        long calculate(long value) {
            return value*10;
        }
    };

    abstract long calculate(long value);

    private final Integer height;

    CalculatorTypeJava7(Integer _height) {
        this.height = _height;
    }
}
