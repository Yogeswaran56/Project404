package com.example.yogesh.project;

public class transportData {

    public dateClass scheduledDay;
    public timeClass startTime, reachTime;
    public String srcLoc, destLoc, key, vendorID;

    public transportData() {

    }

    public transportData(dateClass scheduledDay, timeClass startTime, timeClass reachTime, String srcLoc, String destLoc, String key, String vendorID) {
        this.scheduledDay = scheduledDay;
        this.startTime = startTime;
        this.reachTime = reachTime;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.key = key;
        this.vendorID = vendorID;
    }

    public void setScheduledDay(dateClass scheduledDay) {
        this.scheduledDay = scheduledDay;
    }

    public void setStartTime(timeClass startTime) {
        this.startTime = startTime;
    }

    public void setReachTime(timeClass reachTime) {
        this.reachTime = reachTime;
    }

    public void setSrcLoc(String srcLoc) {
        this.srcLoc = srcLoc;
    }

    public void setDestLoc(String destLoc) {
        this.destLoc = destLoc;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public dateClass getScheduledDay() {
        return scheduledDay;
    }

    public timeClass getStartTime() {
        return startTime;
    }

    public timeClass getReachTime() {
        return reachTime;
    }

    public String getSrcLoc() {
        return srcLoc;
    }

    public String getDestLoc() {
        return destLoc;
    }

    public String getKey() {
        return key;
    }

    public String getVendorID() {
        return vendorID;
    }
}
