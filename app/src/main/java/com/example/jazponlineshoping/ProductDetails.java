package com.example.jazponlineshoping;

public class ProductDetails {

   int image;
   String name;

    public ProductDetails(int image, String name) {
        this.image = image;
        this.name = name;
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

    @Override
    public String toString() {
        return "ProductDetails{" +
                "image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
