https://youtu.be/K1iu1kXkVoA
https://www.baeldung.com/java-generics-vs-extends-object
https://www.baeldung.com/java-super-type-tokens#1reification // - erasure
http://happinessoncode.com/2017/05/21/java-generic-and-variance-1/
https://mangkyu.tistory.com/241 // BEST


## 왜 제네릭이 필요한가?

Printer라는 클래스를 정의하고 싶을 때, 이를 IntegerPrinter, DoublePrinter와 같이 여러 Type별로 나누는것을 지양하기 위해.

## 왜 와일드카드가 필요한가?

제네릭 클래스를 주고받기 위해서 (함수 파라미터) 필요하다. 즉 SomeClass<Object> 는 SomeClass<Integer>와 부모-자식 관계가 아니다.
이는 invariant , 불공변이라 합니다.

제네릭 클래스의 상속관계를 위함