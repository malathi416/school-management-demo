package com.launchcode.schoolmanagementdemo.models;

public enum Gender {
    MALE("male"),
    FEMALE("female");
    private final String displayName;
    Gender(String displayName){
        this.displayName=displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
