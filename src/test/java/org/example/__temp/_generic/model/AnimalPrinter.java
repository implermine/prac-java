package org.example.__temp._generic.model;

public class AnimalPrinter <T extends Animal>{

    public void print(T val){
        System.out.println(val);
    }
}
