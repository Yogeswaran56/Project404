package com.example.yogesh.project;

public class personalInformation {
    private String vendorName;
    private long phonenumber;

    public personalInformation(String vendorName, long phonenumber) {
        this.vendorName = vendorName;
        this.phonenumber = phonenumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }
}
