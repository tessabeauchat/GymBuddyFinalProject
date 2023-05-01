package com.example.gymbuddy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import pl.droidsonroids.gif.GifImageView;

final class ExerciseData {
    final private String exerciseName;
    final private String exerciseDescription;
    final private String exerciseMuscleGroup;
    final private int exerciseID;
    final private int imageID;


    public ExerciseData(String exerciseName, String exerciseDescription, String exerciseMuscleGroup, int exerciseID, int imageID) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseMuscleGroup = exerciseMuscleGroup;
        this.exerciseID = exerciseID;
        this.imageID = imageID;
    }
    public int getExerciseImage() {return imageID;}

    public int getExerciseID() {return exerciseID;}

    public String getExerciseName() {return exerciseName;}

    public String getExerciseDescription() {return exerciseDescription;}

    public String getExerciseMuscleGroup() {return exerciseMuscleGroup;}
}

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
    private static int index = 0;

    private void updateExercise(ExerciseData exerciseData){
        showExercise(exerciseData);
    }

    private void showExercise(ExerciseData exerciseData) {
        GifImageView exerciseGif = findViewById(R.id.exercisePreview);
        exerciseGif.setImageResource(exerciseData.getExerciseImage());

        TextView view;
        view = findViewById(R.id.exerciseName);
        view.setText(exerciseData.getExerciseName());

        view = findViewById(R.id.exerciseID);
        view.setText(exerciseData.getExerciseID());

        view = findViewById(R.id.exerciseDescription);
        view.setText(exerciseData.getExerciseDescription());

        view = findViewById(R.id.exercicseMuscleGroup);
        view.setText(exerciseData.getExerciseMuscleGroup());
    }

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();

        if (menuId == R.id.home_menu) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
            return true;
        } else if (menuId == R.id.exercise_menu) {
            Log.d(TAG, "Exercise menu clicked!");
            Intent exerciseIntent = new Intent(this, ExerciseActivity.class);
            startActivity(exerciseIntent);
            return true;
        } else if (menuId == R.id.equipment_menu) {
            Log.d(TAG, "Equipment menu clicked!");
            Intent equipmentIntent = new Intent(this, EquipmentActivity.class);
            startActivity(equipmentIntent);
            return true;
        } else if (menuId == R.id.workouts_menu) {
            Intent workoutIntent = new Intent(this, WorkoutActivity.class);
            startActivity(workoutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
