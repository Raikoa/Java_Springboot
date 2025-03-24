package com.luv2code.springboot.thymleaf.demo.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;

    private String Country;

    private String Fav;
    private List<String> favSys;

    public Student(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getFav() {
        return Fav;
    }

    public void setFav(String fav) {
        Fav = fav;
    }

    public List<String> getFavSys() {
        return favSys;
    }

    public void setFavSys(List<String> favSys) {
        this.favSys = favSys;
    }
}
