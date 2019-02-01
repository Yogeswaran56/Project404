package com.example.yogesh.project;

public class MergedData {
    public scheduleData sData;
    public personalInformation pData;

    public MergedData() {

    }

    public MergedData(scheduleData sData, personalInformation pData) {
        this.sData = sData;
        this.pData = pData;
    }

    public void setScheduledDay(dateClass scheduledDay) { this.sData.scheduledDay = scheduledDay; }

    public void setOpenTime(timeClass openTime) {
        this.sData.openTime = openTime;
    }

    public void setCloseTime(timeClass closeTime) {
        this.sData.closeTime = closeTime;
    }

    public void setPlaceOfLoc(String placeOfLoc) {
        this.sData.placeOfLoc = placeOfLoc;
    }

    public void setTown(String town) {
        this.sData.town = town;
    }

    public void setKey(String key) {
        this.sData.key = key;
    }

    public void setVendorID(String vendorID) {
        this.sData.vendorID = vendorID;
    }

    public scheduleData getsData() {
        return sData;
    }

    public personalInformation getpData() {
        return pData;
    }

    public void setsData(scheduleData sData) { this.sData = sData; }

    public void setpData(personalInformation pData) {
        this.pData = pData;
    }
}
