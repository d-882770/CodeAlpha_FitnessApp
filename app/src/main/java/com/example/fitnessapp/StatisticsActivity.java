package com.example.fitnessapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    private TextView statsTextView;
    private ArrayList<Workout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        workouts = (ArrayList<Workout>) getIntent().getSerializableExtra("workouts");

        statsTextView = findViewById(R.id.statsTextView);

        int totalWorkouts = workouts.size();
        int totalMinutes = 0;
        int totalCalories = 0;
        for (Workout workout : workouts) {
            totalMinutes += workout.getDuration();
            totalCalories += workout.getCalories();
        }

        String statsText = "Total Workouts: " + totalWorkouts +
                "\nTotal Minutes: " + totalMinutes +
                "\nTotal Calories: " + totalCalories;

        statsTextView.setText(statsText);
    }
}
