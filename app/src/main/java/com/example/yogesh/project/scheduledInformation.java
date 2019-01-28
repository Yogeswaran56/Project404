package com.example.yogesh.project;

public class scheduledInformation {
    public String townName, place;
    public timeClass openingTime, closingTime;
    public dateClass dayOfSchedule;

    public scheduledInformation(String townName, String place, timeClass openingTime, timeClass closingTime, dateClass dayOfSchedule) {
        this.townName = townName;
        this.place = place;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.dayOfSchedule = dayOfSchedule;
    }
}
