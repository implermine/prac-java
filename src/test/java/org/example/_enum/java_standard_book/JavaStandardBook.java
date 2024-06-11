package org.example._enum.java_standard_book;

import org.example._enum.model.Direction;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class JavaStandardBook {

    /*
    열거형 상수간의 비교에는 `==`를 사용할 수 있다.
     */
    @Test
    void test(){
        Direction dir = Direction.EAST;

        if(dir==Direction.EAST){
            System.out.println(true);
        }
    }

    /*
    열거형에 추상 메서드 추가하기 p.697
     */
    @Test
    void test2(){
        System.out.println("TransportationV2.BUS.getFare(100) : " + TransportationV2.BUS.getFare(100));
        System.out.println("TransportationV2.TRAIN.getBasicFare() : " + TransportationV2.TRAIN.getBasicFare());
        System.out.println("TransportationV3.BUS.getFare(100) : " + TransportationV3.BUS.getFare(100));
        System.out.println("TransportationV3.TRAIN.getFare(100) : " + TransportationV3.TRAIN.getFare(100));


        System.out.println("TransportationV4.BUS.getFare(100) : " + TransportationV4.BUS.getFare(100));

    }


}

enum Transportation{
    BUS(100),
    TRAIN(150),
    SHIP(100),
    AIRPLANE(300);

    private final int BASIC_FARE;

    private Transportation(int basicFare){
        this.BASIC_FARE = basicFare;
    }

    public int getBasicFare() {
        return BASIC_FARE;
    }
}

/*
거리에 따라 요금을 계산하는 방식이 각 운송수단마다 다르다면?
즉 명령을 저장해야한다.
 */
enum TransportationV2{

    BUS(100){
        int getFare(int distance){
            return distance * BASIC_FARE;
        }
    },
    TRAIN(150){
        @Override
        int getFare(int distance) {
            return distance * BASIC_FARE;
        }

        // super는 TransportationV2이므로 override 가능하다.
        @Override
        public int getBasicFare() {
            return 123;
        }
    };


    /**
     * 어차피, BUS.getFare() 이런식으로 찍을거라 상관없다. 그렇지만 compile 단계에서 모든 enum이 getFare를 구현하도록 유도한다.
     */
    abstract int getFare(int distance);

    /*
    protected 로 작업하지 않으면 각 enum객체에서 BASIC_FARE에 접근할 수 없다.
     */
    protected final int BASIC_FARE;

    private TransportationV2(int basicFare){
        this.BASIC_FARE = basicFare;
    }

    public int getBasicFare(){
        return BASIC_FARE;
    }
}

/*
Function을 사용한다면...

그런데 abstract enum이 아무래도 self 참조와, overriding이 가능하기에 좀 더 유연하지 않을까...
 */
enum TransportationV3{

    BUS(100, integer -> integer * 100), // self-referencing 불가
    TRAIN(150, new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            //anonymous 객체 사용하면 self-referencing 가능
            return integer * TRAIN.BASIC_FARE;
        }
    });

    /*
    protected 로 작업하지 않으면 각 enum객체에서 BASIC_FARE에 접근할 수 없다.
     */
    private final int BASIC_FARE;
    private final Function<Integer,Integer> getFareExpression;

    private TransportationV3(int basicFare, Function<Integer,Integer> getFareExpression){
        this.BASIC_FARE = basicFare;
        this.getFareExpression = getFareExpression;
    }

    public int getBasicFare(){
        return BASIC_FARE;
    }

    public int getFare(int distance){
        return getFareExpression.apply(distance);
    }
}

/**
 * ENUM을 CLASS로 구현해보면?
 */
class TransportationV4{
    static final TransportationV4 BUS = new TransportationV4(100){
        int getFare(int distance){
            return distance* BASIC_FARE;
        }
    };

    protected final int BASIC_FARE;

    private TransportationV4(int basicFare){
        this.BASIC_FARE = basicFare;
    }

    int getFare(int distance){
        return 1;
    }
}
