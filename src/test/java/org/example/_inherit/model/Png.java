package org.example._inherit.model;

public class Png extends FileImage{

    @Override
    public void save() {
        System.out.println("save png");
    }

    @Override
    public void load() {
        System.out.println("load png");
    }
}
