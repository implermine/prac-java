package org.example._generics.model;

import java.util.ArrayList;

public class Box<T>{

    ArrayList<T> list = new ArrayList<T>();

    void add(T item){
        this.list.add(item);
    }

    T get(int index){
        return this.list.get(index);
    }

    ArrayList<T> getList(){
        return this.list;
    }

    int size(){
        return this.list.size();
    }

    public String toString(){
        return list.toString();
    }


}
