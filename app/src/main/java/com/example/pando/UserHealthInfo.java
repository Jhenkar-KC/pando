package com.example.pando;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

@IgnoreExtraProperties
public class UserHealthInfo {

    private String UserName;
    private String DateOfBirth;
    private String Height;
    private String Weight;
    private String LastPeriodDate;
    private String HeartRate;
    private String BloodPressure;

    public UserHealthInfo(String userName, String dateOfBirth, String height, String weight, String lastPeriodDate, String heartRate, String bloodPressure) {
        UserName = userName;
        DateOfBirth = dateOfBirth;
        Height = height;
        Weight = weight;
        LastPeriodDate = lastPeriodDate;
        HeartRate = heartRate;
        BloodPressure = bloodPressure;
    }

    public UserHealthInfo() {

    }
    public String getBlood_pressure() {
        return BloodPressure;
    }
    public String getDate_of_birth() {
        return DateOfBirth;
    }
    public String getHeart_rate() {
        return HeartRate;
    }
    public String getHeight() {
        return Height;
    }
    public String getLast_period_date() {
        return LastPeriodDate;
    }
    public String getUsername() {
        return UserName;
    }
    public String getWeight() {
        return Weight;
    }
}