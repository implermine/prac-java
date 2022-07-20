package EnumPrac;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

enum Fruit{
    APPLE("red"), PEACH("pink"), BANANA("yellow");
    public String color;
    Fruit(String color){
        System.out.println("Call Constructor "+this);
        this.color = color;
    }

    String getColor(){
        return this.color;
    }

    /**
     * Enum의 몇몇 default static method는 static method이므로 열거체 내부에서 inner call 할 수 있다.
     */
    void custom(){
        System.out.println(Arrays.toString(values()));
    }
    /**
     * 이 특성을 통해, String으로 enum을 iterate하지 않으면서 O(1) 시간안에 찾을 수 있다.
     */

    private static final Map<String,Fruit> fruitMap = Arrays.stream(values()).collect(Collectors.toConcurrentMap(fruit -> fruit.name(),fruit -> fruit));
    private static final Map<String,Fruit> fruitMap2 = Arrays.stream(values()).collect(Collectors.toConcurrentMap(Enum::name, Function.identity()));

    public static Optional<Fruit> getFruitByName(String name){
        return Optional.ofNullable(fruitMap.get(name));
    }
}