package com.example.gymbuddy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
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

final class EquipmentData {
    final private String equipmentName;
    final private String equipmentDescription;
    final private String equipmentMuscleGroup;
    final private int equipmentID;
    final private int imageID ;

    public EquipmentData(String equipmentName, String equipmentDescription, String equipmentMuscleGroup, int equipmentID, int imageID) {
        this.equipmentName = equipmentName;
        this.equipmentDescription = equipmentDescription;
        this.equipmentMuscleGroup = equipmentMuscleGroup;
        this.equipmentID = equipmentID;
        this.imageID = imageID;
}
    public int getEquipmentImage() {return imageID;}

    public int getEquipmentID() {return equipmentID;}

    public String getEquipmentName() {return equipmentName;}

    public String getEquipmentDescription() {return equipmentDescription;}

    public String getEquipmentMuscleGroup() {return equipmentMuscleGroup;}
}
public class EquipmentActivity extends AppCompatActivity {
        private final EquipmentData[] EQUIPMENT_DATA = {
                new EquipmentData("Dumbbell",
                        "Handled weight used for various exercises.",
                        "Arms, Legs, Chest, and Back", 1724, R.drawable.dumbell_tricep_extension),
                new EquipmentData("Box",
                        "Solid, elevated box used to jump up onto.",
                        "Legs", 1725, R.drawable.boxjump),
                new EquipmentData("Leg Curl Machine",
                        "Situate yourself in machine, put one leg at calf under pad, bend leg upward at knee.",
                        "Legs", 1726, R.drawable.kneeling_leg_curl),
                new EquipmentData("Barbell",
                        "Bar with weights on either side used for various exercises",
                        "Arms, Legs, Chest and Back", 1728, R.drawable.upright_row)
        };
        private static int index = 0;
        EditText userEquipmentSearch;

        private void updateEquipment(String equipmentName) {
            Boolean found = false;
            for(EquipmentData equipment: EQUIPMENT_DATA){
                if(equipment.getEquipmentName().equals(equipmentName)){
                    showEquipment(equipment);
                    Log.d(TAG, "Matching Worked");
                    found = true;
                    break;
                }
            }
            if(!found){
                TextView textView = (TextView) findViewById(R.id.equipmentName);
                textView.setText("Equipment not found, please try another search!");

                GifImageView equipmentGif = findViewById(R.id.equipmentPreview);
                equipmentGif.setImageResource(0);

                TextView viewID = findViewById(R.id.equipmentID);
                viewID.setText(null);

                TextView viewDescription = findViewById(R.id.equipmentDescription);
                viewDescription.setText(null);

                TextView viewMuscleGroup = findViewById(R.id.equipmentMuscleGroup);
                viewMuscleGroup.setText(null);
            }
        }

        private void showEquipment(EquipmentData equipmentData) {
            Log.d(TAG, "This should be displaying");
            Log.d(TAG, "Data to be displayed: " +equipmentData.toString());
            GifImageView equipmentGif = findViewById(R.id.equipmentPreview);
            equipmentGif.setImageResource(equipmentData.getEquipmentImage());

            TextView viewName = findViewById(R.id.equipmentName);
            viewName.setText(equipmentData.getEquipmentName());

            TextView viewID = findViewById(R.id.equipmentID);
            Object stringID = equipmentData.getEquipmentID();
            stringID = stringID.toString();
            viewID.setText((CharSequence) stringID);

            TextView viewDescription = findViewById(R.id.equipmentDescription);
            viewDescription.setText(equipmentData.getEquipmentDescription());

            TextView viewMuscleGroup = findViewById(R.id.equipmentMuscleGroup);
            viewMuscleGroup.setText(equipmentData.getEquipmentMuscleGroup());
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        userEquipmentSearch = (EditText) findViewById(R.id.equipment_search);
        View searchSubmitButton = findViewById(R.id.submit_search_button);
        searchSubmitButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String userSearch = userEquipmentSearch.getText().toString();
        Log.d(TAG, "Search Performed");
        Log.d(TAG, userSearch);
        updateEquipment(userSearch);
        closeKeyboard();
        userEquipmentSearch.setText("");
    }
    });
}
private void closeKeyboard(){
        //https://www.geeksforgeeks.org/how-to-programmatically-hide-android-soft-keyboard/
        View view = this.getCurrentFocus();
        if (view != null) {

        // now assign the system
        // service to InputMethodManager
        InputMethodManager manager
        = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        manager = (InputMethodManager)
        getSystemService(
        Context.INPUT_METHOD_SERVICE);
        }
        manager
        .hideSoftInputFromWindow(
        view.getWindowToken(), 0);
        }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int menuId=item.getItemId();

        if(menuId==R.id.home_menu){
        Intent mainIntent=new Intent(this,MainActivity.class);
        startActivity(mainIntent);
        return true;
        }else if(menuId==R.id.exercise_menu){
        Log.d(TAG,"Exercise menu clicked!");
        Intent exerciseIntent=new Intent(this,ExerciseActivity.class);
        startActivity(exerciseIntent);
        return true;
        }else if(menuId==R.id.equipment_menu){
        Log.d(TAG,"Equipment menu clicked!");
        Intent equipmentIntent=new Intent(this,EquipmentActivity.class);
        startActivity(equipmentIntent);
        return true;
        }else if(menuId==R.id.workouts_menu){
        Intent workoutIntent=new Intent(this,WorkoutActivity.class);
        startActivity(workoutIntent);
        return true;
        }
        return super.onOptionsItemSelected(item);
        }
        }