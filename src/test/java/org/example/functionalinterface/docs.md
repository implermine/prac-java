# Ref

https://www.youtube.com/watch?v=VRpHdSFWGPs&t=870s

https://codechacha.com/ko/java8-functional-interface/ --> Functional Inteface의 의의

https://khj93.tistory.com/entry/JAVA-%EB%9E%8C%EB%8B%A4%EC%8B%9DRambda%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EA%B3%A0-%EC%82%AC%EC%9A%A9%EB%B2%95 --> Functional Inteface의 정의

---

# Summary

```java
FunctionalInterface func = new FunctionalInterface() {
    
    @Override
    public void doSomething(String text) {
        System.out.println(text);
    }
    
};

func.doSomething("do something");
```

정리하면, 함수형 인터페이스를 사용하는 것은 람다식으로 만든 객체에 접근하기 위해서 입니다. 

위의 예제처럼 람다식을 사용할 때마다 함수형 인터페이스를 매번 정의하기에는 불편하기 때문에 

자바에서 라이브러리로 제공하는 것들이 있습니다.

---> 2번째 ref에 있는 글인데, Functional Interface를 가장 잘 나타내는 표현이라 생각함.

추가적으론, 선언적 프로그래밍에서 서로가 합의하에 해당 선언을 trigger 해 줄 메서드 명이 apply 등으로

jdk에서 결정해놓는 것도 의미가 있다고 생각함.
