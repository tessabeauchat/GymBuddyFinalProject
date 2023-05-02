package com.example.gymbuddy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Button lastExerciseButton = findViewById(R.id.last_exercise_button);
        lastExerciseButton.setOnClickListener(this);

        Button nextExerciseButton = findViewById(R.id.next_exercise_button);
        nextExerciseButton.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {

    }
}
