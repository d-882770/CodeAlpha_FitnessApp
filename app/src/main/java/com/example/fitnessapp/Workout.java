package com.example.fitnessapp;

import java.io.Serializable;

public class Workout implements Serializable {
    private String type;
    private String date;
    private int duration; // in minutes
    private int calories;

    public Workout(String type, String date, int duration, int calories) {
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public int getCalories() {
        return calories;
    }
}
