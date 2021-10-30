package com.example.jazponlineshoping.modelclass;

public class MobileDetails_ModelClass {

    String name;
    int iamge;

    public MobileDetails_ModelClass(String name, int iamge) {
        this.name = name;
        this.iamge = iamge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIamge() {
        return iamge;
    }

    public void setIamge(int iamge) {
        this.iamge = iamge;
    }
}
