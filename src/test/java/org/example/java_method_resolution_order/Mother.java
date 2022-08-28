package org.example.java_method_resolution_order;

public class Mother extends GrandMother{

    public Mother() {
        super();
        System.out.println("im mother");
    }

    public Mother(String nulls){
        System.out.println("im mother with parameter");
    }
}
