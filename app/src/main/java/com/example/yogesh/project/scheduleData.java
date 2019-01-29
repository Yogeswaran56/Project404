package com.example.yogesh.project;

public class scheduleData {

    private dateClass scheduledDay;
    private timeClass openTime, closeTime;
    private String placeOfLoc, town;

    public scheduleData() {

    }

    public scheduleData(dateClass scheduledDay, timeClass openTime, timeClass closeTime, String placeOfLoc, String town) {
        this.scheduledDay = scheduledDay;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.placeOfLoc = placeOfLoc;
        this.town = town;
    }
}
