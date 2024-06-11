package org.example._enum.java_standard_book;

public abstract class MyEnum implements Comparable<MyEnum>{

    static int id = 0;

    int ordinal;
    String name = "";

    public int ordinal(){
        return this.ordinal;
    }

    MyEnum(String name){
        this.name = name;
        ordinal = id++;
    }

    @Override
    public int compareTo(MyEnum other) {
        return this.ordinal - other.ordinal;
    }
}
