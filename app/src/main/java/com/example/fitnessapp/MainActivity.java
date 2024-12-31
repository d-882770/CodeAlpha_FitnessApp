package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Workout> workouts;
    private ArrayList<Goal> goals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        workouts = new ArrayList<>();
        goals = new ArrayList<>();

        // UI components
        EditText typeEditText = findViewById(R.id.typeEditText);
        EditText dateEditText = findViewById(R.id.dateEditText);
        EditText durationEditText = findViewById(R.id.durationEditText);
        EditText caloriesEditText = findViewById(R.id.caloriesEditText);

        Button addWorkoutButton = findViewById(R.id.addWorkoutButton);
        Button viewProgressButton = findViewById(R.id.viewProgressButton);
        Button setGoalsButton = findViewById(R.id.setGoalsButton);
        Button exerciseLibraryButton = findViewById(R.id.exerciseLibraryButton);
        Button viewStatsButton = findViewById(R.id.viewStatsButton);

        // Set up button listeners
        addWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = typeEditText.getText().toString();
                String date = dateEditText.getText().toString();
                int duration = Integer.parseInt(durationEditText.getText().toString());
                int calories = Integer.parseInt(caloriesEditText.getText().toString());

                if (!type.isEmpty() && !date.isEmpty() && duration > 0 && calories > 0) {
                    workouts.add(new Workout(type, date, duration, calories));
                    Toast.makeText(MainActivity.this, "Workout Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                intent.putExtra("workouts", workouts);
                startActivity(intent);
            }
        });

        setGoalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText goalNameEditText = findViewById(R.id.goalNameEditText);
                EditText goalTargetEditText = findViewById(R.id.goalTargetEditText);

                String goalName = goalNameEditText.getText().toString();
                int goalTarget = Integer.parseInt(goalTargetEditText.getText().toString());

                if (!goalName.isEmpty() && goalTarget > 0) {
                    goals.add(new Goal(goalName, goalTarget));
                    Toast.makeText(MainActivity.this, "Goal Set", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exerciseLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExerciseLibraryActivity.class);
                startActivity(intent);
            }
        });

        viewStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                intent.putExtra("workouts", workouts);
                startActivity(intent);
            }
        });
    }
}
