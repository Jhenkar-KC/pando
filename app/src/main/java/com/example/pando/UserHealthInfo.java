package com.example.pando;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserHealthInfo {

    private String username;
    private String date_of_birth;
    private String height;
    private String weight;
    private String last_period_date;
    private String heart_rate;
    private String blood_pressure;


    public UserHealthInfo() {
    }

    public String getUsername() {
        return username;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getLast_period_date() {
        return last_period_date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setLast_period_date(String last_period_date) {
        this.last_period_date = last_period_date;
    }

    public void setHeart_rate(String heart_rate) {
        this.heart_rate = heart_rate;
    }

    public void setBlood_pressure(String blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public String getHeart_rate() {
        return heart_rate;
    }

    public String getBlood_pressure() {
        return blood_pressure;
    }
}