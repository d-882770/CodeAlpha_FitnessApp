package com.example.fitnessapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {

    private ListView workoutsListView;
    private ArrayList<Workout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        workouts = (ArrayList<Workout>) getIntent().getSerializableExtra("workouts");

        workoutsListView = findViewById(R.id.workoutsListView);

        ArrayList<String> workoutStrings = new ArrayList<>();
        for (Workout workout : workouts) {
            workoutStrings.add(workout.getType() + " - " + workout.getDate() + " - " +
                    workout.getDuration() + " min - " + workout.getCalories() + " cal");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, workoutStrings);
        workoutsListView.setAdapter(adapter);
    }
}
