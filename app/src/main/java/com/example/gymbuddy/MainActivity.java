package com.example.gymbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GYM_BUDDY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureToExerciseButton();
        configureToEquipmentButton();
        configureToWorkoutButton();
    }
    private void configureToExerciseButton(){
        ImageButton toExercise = (ImageButton) findViewById(R.id.button_exercise_main);
        toExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (MainActivity.this, ExerciseActivity.class));
                Log.d(TAG, "Exercise main button clicked!");
            }
        });
    }
    private void configureToEquipmentButton(){
        ImageButton toExercise = (ImageButton) findViewById(R.id.button_equipment_main);
        toExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (MainActivity.this, EquipmentActivity.class));
                Log.d(TAG, "Equipment main button clicked!");
            }
        });
    }
    private void configureToWorkoutButton(){
        ImageButton toExercise = (ImageButton) findViewById(R.id.button_workout_main);
        toExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (MainActivity.this, WorkoutActivity.class));
                Log.d(TAG, "Workout main button clicked!");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();

        if (menuId == R.id.info_menu) {
            Intent infoIntent = new Intent(this, InfoActivity.class);
            startActivity(infoIntent);
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