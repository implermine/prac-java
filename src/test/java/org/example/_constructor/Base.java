package org.example._constructor;

public class Base {

    protected String baseName = "baseName";

    public Base() {
        System.out.println("base: basic constructor called...");
        System.out.println("in this context, baseName is... : " + this.baseName);
        System.out.println("base: basic constructor call finished...");
    }

    //custom constructor
    public Base(String custom) {
        System.out.println("base: custom constructor called...");
        System.out.println(this.baseName);
    }
}
