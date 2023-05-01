package com.example.gymbuddy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import pl.droidsonroids.gif.GifImageView;

final class ExerciseData {
    final private String exerciseName;
    final private String exerciseDescription;
    final private String exerciseMuscleGroup;
    final private int exerciseID;
    final private int imageID ;


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
    EditText userExerciseSearch;

    private void updateExercise(String exerciseName) {
        Boolean isDone = false;
        while(isDone != true){
            for(ExerciseData exercise: EXERCISE_DATA){
                if(exercise.getExerciseName().equals(exerciseName)){
                    showExercise(exercise);
                    Log.d(TAG, "Matching Worked");
                    isDone = true;
                }
                else{
                    isDone = false;
                }
            }
        }
        if(isDone = false){
            TextView textView = (TextView) findViewById(R.id.exerciseName);
            textView.setText("Exercise not found, please try another search!");
        }
    }

    private void showExercise(ExerciseData exerciseData) {
            Log.d(TAG, "This should be displaying");
            Log.d(TAG, "Data to be displayed: " +exerciseData.toString());
            GifImageView exerciseGif = findViewById(R.id.exercisePreview);
            exerciseGif.setImageResource(exerciseData.getExerciseImage());

            TextView viewName = findViewById(R.id.exerciseName);
            viewName.setText(exerciseData.getExerciseName());

            TextView viewID = findViewById(R.id.exerciseID);
            viewID.setText(exerciseData.getExerciseID());

            TextView viewDescription = findViewById(R.id.exerciseDescription);
            viewDescription.setText(exerciseData.getExerciseDescription());

            TextView viewMuscleGroup = findViewById(R.id.exercicseMuscleGroup);
            viewMuscleGroup.setText(exerciseData.getExerciseMuscleGroup());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        userExerciseSearch = (EditText) findViewById(R.id.exercise_search);
        View searchSubmitButton = findViewById(R.id.submit_search_button);

        searchSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userSearch = userExerciseSearch.getText().toString();
                Log.d(TAG, "Search Performed");
                Log.d(TAG, userSearch);
                updateExercise(userSearch);
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
