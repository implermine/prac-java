package org.example.__temp._generic;

import org.example.__temp._generic.variant.GrandParent;
import org.example.__temp._generic.variant.Parent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;


public class TestEntry {

    @Test
    @DisplayName("상한 경계 wildcard(extends)에서 Produce 해보기")
    void using_extend_wildcard_produce(){
        Collection<? extends Parent> c = new ArrayList<>();

        // 컴파일 에러
//        for (Child parent : c) {
//
//        }
        /**
         * extends는 자식 클래스를 만들 때 사용되므로, ? capture of Parent는 Parent와 미지(Unknown)의 모든 Parent 자식 클래스이다.
         * 이 자식클래스는 Parent의 자식 클래스이지만 Child는 아니고 OtherChild 일 수도 있다.
         * 따라서, 이 경우에 `그냥 다른 객체이므로 다형성을 추구할 수 없는` 경우로써 컴파일 에러가 발생한다.
         */

        for (Parent parent : c) {

        }

        for (GrandParent parent : c) {

        }

        for (Object parent : c) {

        }
    }

    @Test
    @DisplayName("상한 경계 wildcard(extends)에서 Consume 해보기")
    void using_extend_wildcard_consume(){
        Collection<? extends Parent> c = new ArrayList<>();

        // 전부 컴파일 에러
//        c.add(new Child());
//        c.add(new Parent());
//        c.add(new GrandParent());
//        c.add(new AnotherChild());
//        c.add(new Object());

        /**
         * c.add에는 capture ? extends Parent가 필요하다
         *
         * ? extends Parent로 가능한 타입은 Parent와 미지(unknown)의 모든 Parent 자식 클래스들이므로,
         * 우리는 c가 Parent의 하위 타입 중에서 어떤 타입인지 모르기때문에,
         * add 할 수 없다.
         *
         * 이는 produce된건 업캐스팅이 가능하지만,
         * Collection은 Parent로 업캐스팅된 다형적인 객체가 아닌 extends Parent된 그 `특정` 무언가가 필요해서 그렇다
         */

    }


}
