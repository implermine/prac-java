package org.example._anonymous;

public class Anonymous {

    // 방법 1: 필드에 익명자식 객체를 생성
    Insect spider1 = new Insect(){

        String name = "무당거미";

        //-> new Insect(){} 로 만든 익명 객체는 마치 extend를 한 것처럼 method의 추가가 가능하다.
        void cobweb(){
            System.out.println("사각형으로 거미줄을 친다.");
        }

        @Override
        void attack(){
            System.out.println(name + " 독을 발사한다.");
        }
    };

    // 방법2 : 로컬스택변수의 초기값으로 대입
    void method1(){
        Insect spider2 = new Insect(){

            String name = "늑대거미";

            // 거미줄을 치다.
            void cobweb(){
                System.out.println("육각형으로 거미줄을 친다.");
            }

            @Override
            void attack() {
                System.out.println(name + " 앞니로 문다.");
            }
        };


        // 로컬변수이기 때문에 메서드에서 바로 사용
        spider2.attack();
    }

    // 방법3 : 익명객체 매개변수로 대입
    void method2(Insect spider){
        spider.attack();
    }
}
