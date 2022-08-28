package org.example.__temp._generic.model;

public class Printer <T>{

    private T material;
    public Printer() {
    }

    //Consumer
    public void print(T val){
        System.out.println(val);
    }

    //Producer
    public T get(){
        return material;
    }

    // 제네릭 메서드 , if U defined 'T', it hides T value declared top of the class <T>
    public <U> void printGenerically(T val, U val2){
        System.out.println(val2);
        System.out.println(val);
    }
}
