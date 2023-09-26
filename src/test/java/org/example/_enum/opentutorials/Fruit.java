package org.example._enum.opentutorials;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Fruit{
    APPLE("red"),
    PEACH("pink"),
    BANANA("yellow");

    public String color;

    /**
     * enum의 생성자는 접근제어자로 private만을 허용한다.
     */
    private Fruit(String color){
        System.out.println("Call Constructor "+this);
        this.color = color;
    }

    static Integer some;

    static{
        System.out.println("static context");

    }

    void custom(){
        System.out.println(Arrays.toString(values()));
//        same with
//        System.out.println(Arrays.toString(Fruit.values()));
        System.out.println(name());
    }

    private static final Map<String,Fruit> nameToFruit  = Arrays.stream(values()).collect(Collectors.toMap(fruit -> fruit.name(), Function.identity()));

    public static Optional<Fruit> findByName(String name){

        Fruit fruit = nameToFruit.get(name);

        return Optional.ofNullable(fruit);
    }

}