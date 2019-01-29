package com.example.yogesh.project;

public class scheduleData {

    private dateClass scheduledDay;
    private timeClass openTime, closeTime;
    private String placeOfLoc, town, key, vendorID;

    public scheduleData() {
    }

    public scheduleData(dateClass scheduledDay, timeClass openTime, timeClass closeTime, String placeOfLoc, String town, String key, String vendorID) {
        this.scheduledDay = scheduledDay;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.placeOfLoc = placeOfLoc;
        this.town = town;
        this.key = key;
        this.vendorID = vendorID;
    }

    public dateClass getScheduledDay() {
        return scheduledDay;
    }

    public timeClass getOpenTime() {
        return openTime;
    }

    public timeClass getCloseTime() {
        return closeTime;
    }

    public String getPlaceOfLoc() {
        return placeOfLoc;
    }

    public String getTown() {
        return town;
    }

    public String getKey() {
        return key;
    }

    public String getVendorID() {
        return vendorID;
    }
}
