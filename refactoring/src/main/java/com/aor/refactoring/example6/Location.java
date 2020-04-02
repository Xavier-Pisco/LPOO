package com.aor.refactoring.example6;

public class Location {
    private String latitude;
    private String longitude;
    private String name;

    public Location(String latitude, String longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String toString(){
        StringBuffer location = new StringBuffer();
        location.append(latitude + "," + longitude + " (" + name + ")");
        return location.toString();
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
