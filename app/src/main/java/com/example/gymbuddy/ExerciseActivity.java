package com.example.gymbuddy;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {
    private final ExerciseData[] EXERCISE_DATA = {
            new ExerciseData("Dumbell Tricep Extension",
                    "Hold dumbell in one hand overhead, slowly lower dumbell behind head bending at the elbow, extend upward.",
                    "Arms", 1824, R.drawable.dumbell_tricep_extension),
            new ExerciseData("Box Jump",
                    "Stand square to box, bend at the knee, jump onto box landing on full foot.",
                    "Legs", 1825, R.drawable.boxjump),
            new ExerciseData("Kneeling Leg Curl",
                    "Situate yourself in machine, put one leg at calf under pad, bend leg upward at knee.",
                    "Legs", 1826, R.drawable.kneeling_leg_curl),
            new ExerciseData("Side Plank",
                    "Stack legs on top of one another and plant one forearm on the ground, dip at hip returning to side plank position.",
                    "Legs", 1827, R.drawable.side_plank),
            new ExerciseData("Upright Row",
                    "Using a barbell, place hand 6 inches apart using overhand grip, bring barbell from waist height to chest bending at elbows.",
                    "Legs", 1828, R.drawable.upright_row)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
