package com.example.proklimjobenlestari.Domain;

import java.io.Serializable;

public class MapsDomain implements Serializable{
    private String title;
    private String pic;
    private String description;

    private double latitude;

    private double longitude;


    public MapsDomain(String title, String pic, String description, double latitude, double longitude ) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    // Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Pic
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Latitude
    public double getLatitude() {return latitude;}

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Longitude
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
