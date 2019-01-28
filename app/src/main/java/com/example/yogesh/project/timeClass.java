package com.example.yogesh.project;

public class timeClass {
    private int hour, mins;
    private String ampm;

    public timeClass() {
    }

    public timeClass(int hour, int mins, String ampm) {
        this.hour = hour;
        this.mins = mins;
        this.ampm = ampm;
    }

    public int getHour() {
        return hour;
    }

    public int getMins() {
        return mins;
    }

    public String getAmpm() {
        return ampm;
    }
}
