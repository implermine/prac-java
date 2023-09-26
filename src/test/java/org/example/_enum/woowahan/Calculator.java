package org.example._enum.woowahan;

public enum Calculator {

    CALC_A(3){
        @Override
        long calculate(long value) {
            return value;
        }
    },

    CALC_B(5){
        @Override
        long calculate(long value) {
            return value*10;
        }
    };



    abstract long calculate(long value);

    private final Integer height;

    Calculator(Integer height) {
        this.height = height;
    }
}
