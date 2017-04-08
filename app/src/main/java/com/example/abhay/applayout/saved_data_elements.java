package com.example.abhay.applayout;

/**
 * Created by abhay on 07/04/17.
 */

public class saved_data_elements {
    private String dest;
    private Integer contact;
    private Integer lattitude;
    private Integer longitude;

    public saved_data_elements(){}

    public saved_data_elements(String dest, Integer lattitude, Integer longitude, Integer contact)
    {
        this.dest=dest;
        this.contact=contact;
        this.lattitude=lattitude;
        this.longitude=longitude;

    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getDest() {

        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Integer getLattitude() {
        return lattitude;
    }

    public void setLattitude(Integer lattitude) {
        this.lattitude = lattitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }
}
