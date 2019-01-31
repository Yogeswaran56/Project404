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
}
