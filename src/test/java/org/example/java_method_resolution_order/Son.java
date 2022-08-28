package org.example.java_method_resolution_order;

public class Son extends Mother{

    public Son() {
        super();
        System.out.println("im son");
    }

    public Son(String nulls){
        super(null);
        System.out.println("im son with parameter");
    }
}
