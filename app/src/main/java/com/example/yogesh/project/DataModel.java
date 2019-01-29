package com.example.yogesh.project;

public class DataModel {

    String name;
    String location;
    String price;
    // String feature;


    public DataModel(String name, String location, String price ) {
        this.name=name;
        this.location=location;
        this.price=price;
        //     this.feature=feature;

    }


    public String getName() {
        return name;
    }


    public String getLocation() {
        return location;
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
