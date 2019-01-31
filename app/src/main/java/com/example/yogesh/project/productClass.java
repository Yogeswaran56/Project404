package com.example.yogesh.project;

public class productClass {
    private String itemName;
    private String quantity;
    private String price;
    private String key;

    public productClass() {

    }

    public productClass(String itemName, String quantity, String price, String key) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.key = key;
    }


    public String getItemName() {
        return itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getKey() {
        return key;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
