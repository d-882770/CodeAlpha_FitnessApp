package com.example.fitnessapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ExerciseLibraryActivity extends AppCompatActivity {

    private ListView exercisesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_library);

        exercisesListView = findViewById(R.id.exercisesListView);

        ArrayList<String> exercises = new ArrayList<>();
        exercises.add("Push-Up");
        exercises.add("Squat");
        exercises.add("Lunge");
        exercises.add("Plank");
        exercises.add("Sit-Up");
        // Add more exercises here

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
        exercisesListView.setAdapter(adapter);
    }
}
