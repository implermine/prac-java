package org.example._inherit.model;

public class DrawableImage extends Image{
    private Pencil brush;

    public void draw(){
        System.out.println("drawing...");
    }

    public DrawableImage() {
        this.brush = new Pencil();
    }

    public static class Pencil{

    }
}
