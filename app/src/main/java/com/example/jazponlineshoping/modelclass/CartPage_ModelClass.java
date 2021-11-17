package com.example.jazponlineshoping.modelclass;

public class CartPage_ModelClass {

    String productName,productColor,internalStorage,externalStorage,deliveryDate,productPrice;
    int productImage;

    public CartPage_ModelClass(int productImage,String productName, String productColor, String internalStorage,
                               String externalStorage, String deliveryDate, String productPrice) {

        this.productImage = productImage;
        this.productName = productName;
        this.productColor = productColor;
        this.internalStorage = internalStorage;
        this.externalStorage = externalStorage;
        this.deliveryDate = deliveryDate;
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
    }

    public String getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(String externalStorage) {
        externalStorage = externalStorage;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
