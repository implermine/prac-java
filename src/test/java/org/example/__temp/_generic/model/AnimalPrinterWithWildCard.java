package org.example.__temp._generic.model;

public class AnimalPrinterWithWildCard {

    //서브타입 와일드카드를 파라미터로 받은 경우엔, 그 와일드 카드로 표현된
    // 변수에서 get은 가능하나, put은 불가하다. PECS 룰 Produce-Extend, Consumer-Super
    public void dogPrint(AnimalPrinter<? super Dog> printer, Dog dog){

        printer.print(dog);
    }

    /**
     * ? extends Dog 의 경우를 막는 이유는
     * AnimalPrinter는 ? capture of Dog로 initiate 되었다.
     *
     * 이때, AnimalPrinter는 늘 (Dog) 캐스팅을 시도한다.
     *
     * 이때, print()의 아규먼트로는 어떤 값이든지 허용되지만,
     *
     * 이때, Dog보다 상위값이 추가되는 경우엔 다운캐스팅 불가 이슈가 발생하기 때문입니다.
     *
     * 이와 달리 ? super Dog의 경우는
     *
     * 이때, AnimalPrinter는 늘 (Dog) 캐스팅을 시도한다.
     *
     * 이때, print()의 아규먼트로는 어떤 값이든지 허용되지만,
     *
     * 이때,
     */
}
