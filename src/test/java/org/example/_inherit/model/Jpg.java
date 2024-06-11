package org.example._inherit.model;

public class Jpg extends FileImage{

    @Override
    public void save() {
        System.out.println("save jpg");
    }

    @Override
    public void load() {
        System.out.println("load jpg");
    }
}
