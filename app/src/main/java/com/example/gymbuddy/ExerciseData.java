package com.example.gymbuddy;

public class ExerciseData {
    final private String exerciseName;
    final private String exerciseDescription;
    final private String exerciseMuscleGroup;
    final private int exerciseID;
    final private int previewID;


    public ExerciseData(String exerciseName, String exerciseDescription, String exerciseMuscleGroup, int exerciseID, int previewID) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseMuscleGroup = exerciseMuscleGroup;
        this.exerciseID = exerciseID;
        this.previewID = previewID;
    }
    public int getExercisePreview() {return previewID;}

    public int getExerciseID() {return exerciseID;}

    public String getExerciseName() {return exerciseName;}

    public String getExerciseDescription() {return exerciseDescription;}

    public String getExerciseMuscleGroup() {return exerciseMuscleGroup;}
}

