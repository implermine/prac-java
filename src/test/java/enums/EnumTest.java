package enums;

import java.util.Optional;

public class EnumTest {

    public static void main(String[] args) {

        /*
        if(Fruit.APPLE == Company.APPLE){
            System.out.println("과일 애플과 회사 애플이 같다.");
        }
        */
        Fruit type = Fruit.APPLE; // 하나만 생성해도 모든 enum Type 생성자를 콜한다.
//        switch(type){
//            case APPLE:
//                System.out.println(57+" kcal");
//                break;
//            case PEACH:
//                System.out.println(34+" kcal");
//                break;
//            case BANANA:
//                System.out.println(93+" kcal");
//                break;
//        }

        Optional<Fruit> apple = Fruit.getFruitByName("APPLE");

        apple.ifPresent(System.out::println);
    }
}