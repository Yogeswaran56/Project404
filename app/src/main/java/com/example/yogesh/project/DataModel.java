package com.example.yogesh.project;

public class DataModel {

    String name;
    int rating;
    String price;
    // String feature;


    public DataModel(String name, int rating, String price ) {
        this.name=name;
        this.rating=rating;
        this.price=price;
        //     this.feature=feature;

    }


    public String getName() {
        return name;
    }


    public int getRating() {
        return rating;
    }


    public String getPrice() {
        return price;
    }

/*
    public String getFeature() {
        return feature;
    }
*/
}
