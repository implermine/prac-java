package org.example._constructor;


import lombok.Getter;

@Getter
public class Pojo {

    private String name = "foo";

    private boolean original = true;

    public Pojo(){
        System.out.println("No-Arg Constructor called...");
    }

    public Pojo(String name){
        this.name = name;
    }

    public Pojo(Long a){
        System.out.println("before Pojo Constructs, name is initialized with : " + name);
    }
}
