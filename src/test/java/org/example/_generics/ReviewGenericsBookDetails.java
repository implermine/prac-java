package org.example._generics;

import org.example._generics.model.Box;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReviewGenericsBookDetails {

    @Test
    void test(){
        //fair
        Box<String> stringBox = new Box<String>();

        //참조변수와 생성자에 대입된 타입(매개변수화된 타입)이 일치해야함
        //Box<Integer> integerBox = new Box<String>();

    }

    /*
    지네릭스는 `타입 안정성`을 제공한다.

    타입 안정성은 컴파일러가 컴파일하는 동안 타입을 검증하고, 변수에 잘못된 타입을 할당하려고 할 때 오류를 발생시킨다는 것을 의미.
    https://stackoverflow.com/questions/260626/what-is-type-safe
     */
    @Test
    void genericsSupportsTypeSafety(){

        List rawList = new ArrayList<>();
        // 위 List는 List<Object> rawList = new ArrayList<Object>(); 이다. 지네릭스가 나오기 이전 (JDK 5 이전)과의 하위
        // 호환성을 유지하기위해 남았다.

        rawList.add(new Dotori());
        // does not throw any compile-error. 즉 타입안정성을 제공하지 못한다./


        List<NotDotori> notDotoris = new ArrayList<>();
        //notDotoris.add(new Dotori());
        // does occur compile error
        // java: incompatible types: Dotori cannot be converted to NotDotori
        // 즉, 지네릭스는 타입안정성을 제공한다.

    }
}

class NotDotori{

}

class Dotori{

}
