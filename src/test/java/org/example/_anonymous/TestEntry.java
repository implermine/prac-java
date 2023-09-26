package org.example._anonymous;

import org.junit.jupiter.api.Test;

public class TestEntry {

    @Test
    void test(){
        Anonymous a= new Anonymous();

        // 방법 1 : 익명객체 필드 사용
        a.spider1.attack();

        // 방법 2 : 익명객체 로컬 변수 사용
        a.method1();


        String outerName = "타란튤라2";

        // 방법 3 : 매개변수로 익명객체 사용
        a.method2(new Insect(){
//            String name = "타란튤라";
            String name = outerName;

            //거미줄을 치다.
            void cobweb(){
                System.out.println("그냥 마구잡이로 친다.");
            }

            @Override
            void attack(){
                System.out.println(name + " 공격 안하고 후퇴한다.");
            }
        });

        // 익명 객체 내부에서 새롭게 정의된 필드, 메서드는 `부모객체`로 생성된 spider1에서 접근할 수 없음!!
//        a.spider1.name = "왕거미";  // 익명객체에서 새롭게 정의된 필드 (접근불가)
//        a.spider1.cobweb(); // 익명객체에서 새롭게 정의된 메서드 (접근불가)
//        a.spider1.attack(); // 부모클래스 Insect에서 오버라이딩해서 재정의 한 메서드 (접근가능)

        /**
         * 무당거미 독을 발사한다.
         * 늑대거미 앞니로 문다.
         * 타란튤라 공격 안하고 후퇴한다.
         */
    }
}
