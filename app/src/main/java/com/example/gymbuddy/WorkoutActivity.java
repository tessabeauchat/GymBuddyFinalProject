package com.example.gymbuddy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

final class ExerciseProfile {
    private final String exerciseName;
    private final int exerciseID;

    ExerciseProfile(String exerciseName, int exerciseID) {
        this.exerciseName = exerciseName;
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }
    public int getExerciseID() { return exerciseID; }
}
public class WorkoutActivity extends AppCompatActivity implements View.OnClickListener {

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

        int id = view.getId();
        if (id == R.id.next_exercise_button) {
        updateExerciseProfile(moveToNextProfile());
        } else if (id == R.id.last_exercise_button)
            updateExerciseProfile(moveToPreviousProfile());
    }

    private void updateExerciseProfile(ExerciseData data ) {showExercisePic(data);}

    private void showExercisePic(ExerciseData exerciseData) {
        ImageView exerciseImage = findViewById(R.id.workout_preview);
        exerciseImage.setImageResource(exerciseData.getExerciseID());

        TextView view;
        view = findViewById(R.id.current_exercise_text);
        view.setText(exerciseData.getExerciseName());

    }

    private ExerciseData moveToNextProfile() {
        index = (index + 1) % EXERCISE_DATA.length;
        return EXERCISE_DATA[index];
    }

    private ExerciseData moveToPreviousProfile() {
        index = index - 1;
        if (index < 0)
            index = EXERCISE_DATA.length - 1;
        return EXERCISE_DATA[index];
    }

    private ExerciseData getCurrentProfile() {
        return EXERCISE_DATA[index];
    }

}
