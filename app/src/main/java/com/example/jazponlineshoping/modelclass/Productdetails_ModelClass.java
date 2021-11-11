package com.example.jazponlineshoping.modelclass;

public class Productdetails_ModelClass {

    String name,price;
    int image;

    public Productdetails_ModelClass(String name, String price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
