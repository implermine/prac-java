package org.example._generics;

import java.util.ArrayList;

class Fruit{
    public String toString(){
        return "Fruit";
    }
}

class Apple extends Fruit{
    public String toString(){
        return "Apple";
    }
}

class Grape extends Fruit{
    public String toString(){
        return "Grape";
    }
}

class Juice{
    String name;

    Juice(String name) {
        this.name = name + "Juice";
    }

    public String toString(){
        return name;
    }
}

class Juicer{
    static Juice makeJuice(FruitBox<? extends Fruit> fruitBox){
        String tmp = "";

        for(Fruit eachFruit: fruitBox.getList()){
            tmp += eachFruit + " ";
        }

        return new Juice(tmp);
    }

    static <T extends Fruit> Juice makeJuice2(FruitBox<T> fruitBox){
        String tmp = "";

        for(Fruit eachFruit: fruitBox.getList()){
            tmp += eachFruit + " ";
        }

        return new Juice(tmp);
    }
}

class FruitBox<T extends Fruit> extends Box<T>{

}

class Box<T>{

    ArrayList<T> list = new ArrayList<>();
    void add(T item){
        list.add(item);
    }
    T get(int i){
        return list.get(i);
    }
    ArrayList<T> getList(){
        return this.list;
    }
    int size(){
        return this.list.size();
    }
    public String toString(){
        return this.list.toString();
    }

}


public class FruitBoxEx {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Juicer.makeJuice(fruitBox);
        Juicer.makeJuice(appleBox);

        Juicer.makeJuice2(fruitBox);
        Juicer.makeJuice2(appleBox);

        Juicer.<Fruit>makeJuice2(fruitBox);
        //Juicer.<Apple>makeJuice2(fruitBox); // wrong
    }

    // p.687 지네릭 타입의 형변환
    void test2(){

        //Box는 Box<Object> 이다.
        Box box = null;
        Box<Object> objBox = null;

        box = (Box)objBox;
        objBox = (Box<Object>)box;
    }

    void test2_2(){
    }



    void test3(){
        FruitBox<? extends Fruit> fruitBox = null;
        FruitBox<Apple> appleBox = (FruitBox<Apple>) fruitBox;
    }

    void test4(){
        //Box<Fruit> fruit₩Box = new Box<Apple>();
        // compile error for type-safety


        Box<Fruit> fruitBox = new FruitBox<Fruit>(); // 과일 (적어도 박스)
        // compile-time에 다음과 같이 변화한다.
        // 1. Box<Fruit> fruitBox = new FruitBox<Fruit>();
        // 2. Box fruitBox = new FruitBox(); // 그런데 type variable이 모두 Fruit인
        Box<? extends Fruit> fruitBox2 = new Box<Apple>(); // (적어도 과일) (적어도 박스)
        // yeah
        // compile-time에 다음과 같이 변화한다.
        // 1. Box<? extends Fruit> fruitBox2 = new Box<Apple>();
        // 2. Box<Apple> fruitBox2 = new Box<Apple>(); // Apple이 실제 paramerterized type이니까
        // 3. Box fruitBox2 = new Box(); // 그런데 type variable이 모두 Apple인

        // ?(wildcard)는 Object타입과 다를 게 없다. 라는말은 아닌듯하다.

        Box<?> box = new Box<Apple>();
        //Box<Object> box2 = new Box<Apple>();

        //왜냐하면 위 문구는 컴파일 에러가 발생하기 때문.
    }
}
