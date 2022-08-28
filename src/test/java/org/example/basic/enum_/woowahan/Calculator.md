```java
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
```

```java
public enum ENUM이름 {

    (new)ENUM의 구현체1(3<- 진짜 생성자처럼 쓰기){
        
        @Override
        long calculate(long value) {
            return value;
        } // <- 함수를 구현
    },

    (new)ENUM의 구현체2(5){
        @Override
        long calculate(long value) {
            return value*10;
        }
    };

    
    abstract long calculate(long value); // <- ENUM이란 추상클래스의 추상메서드.

    private final Integer height; // <- ENUM이란 추상클래스의 필드

    Calculator(Integer height) { 
        this.height = height;
    }
}
```

다시말해, ENUM은 추상클래스이며, 각각의 attribute는 그 추상클래스의 구현이라 생각해도 좋다.