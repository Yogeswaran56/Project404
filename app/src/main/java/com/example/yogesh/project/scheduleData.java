package com.example.yogesh.project;

public class scheduleData {

    public dateClass scheduledDay;
    public timeClass openTime, closeTime;
    public String placeOfLoc, town, key, vendorID;

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

    public void setScheduledDay(dateClass scheduledDay) {
        this.scheduledDay = scheduledDay;
    }

    public void setOpenTime(timeClass openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(timeClass closeTime) {
        this.closeTime = closeTime;
    }

    public void setPlaceOfLoc(String placeOfLoc) {
        this.placeOfLoc = placeOfLoc;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }
}
