package com.example.jazponlineshoping.modelclass;

public class TelevisionDetails_ModelClass {

    String name;
    int image;

    public TelevisionDetails_ModelClass(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
