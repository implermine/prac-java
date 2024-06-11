package org.example._enum.java_standard_book;

public abstract class Direction extends MyEnum{

    static final Direction EAST = new Direction("EAST"){};
    static final Direction SOUTH = new Direction("SOUTH"){};

    private Direction(String name){
        super(name);
    }

    public String name(){
        return super.name;
    }

    public String toString(){
        return super.name;
    }

}
