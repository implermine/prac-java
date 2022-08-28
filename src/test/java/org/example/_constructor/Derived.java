package org.example._constructor;

public class Derived extends Base {

    private String derivedName = "derivedName";

    public Derived() {
        System.out.println("derived: basic constructor called...");
    }

    public Derived(String custom){
        System.out.println("derived: custom constructor called...");
        System.out.println("in this context, derivedName is... : " + derivedName);
        System.out.println("in this context, baseName is... : " + baseName);
        System.out.println("derived: custom constructor call finished...");
    }

    public String getDerivedName() {
        return derivedName;
    }

    public String getBaseName(){
        return super.baseName;
    }
}
