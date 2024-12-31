package com.example.fitnessapp;

import java.io.Serializable;

public class Goal implements Serializable {
    private String name;
    private int target; // e.g., target calories to burn

    public Goal(String name, int target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public int getTarget() {
        return target;
    }
}
