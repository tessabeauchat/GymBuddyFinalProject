package com.example.gymbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class ExerciseListAdapter extends
        RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder> {
    private final ExerciseData[] mExerciseList;
    private final LayoutInflater mInflater;

    public ExerciseListAdapter(Context context, ExerciseData[] mExerciseList) {
        this.mExerciseList = mExerciseList;
        mInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public ExerciseListAdapter.ExerciseViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.exercise_list_item, parent, false);
        return new ExerciseViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListAdapter.ExerciseViewHolder holder, int position) {
        ExerciseData exercise = mExerciseList[position];
        holder.exerciseNameView.setText(exercise.getExerciseName());
        holder.exerciseImageView.setImageResource(exercise.getExerciseImage());
        holder.exerciseDescView.setText(exercise.getExerciseName());
        holder.exerciseMuscleView.setText(exercise.getExerciseMuscleGroup());
        holder.exerciseIDView.setText(exercise.getExerciseID());
    }
    @Override
    public int getItemCount() {
        return mExerciseList.length;
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView exerciseNameView;
        public final ImageView exerciseImageView;
        public final TextView exerciseDescView;
        public final TextView exerciseMuscleView;
        public final TextView exerciseIDView;
        final ExerciseListAdapter mAdapter;

        public ExerciseViewHolder(@NonNull View itemView, ExerciseListAdapter adapter) {
            super(itemView);
            exerciseNameView = itemView.findViewById(R.id.exercise_list_name_id);
            exerciseImageView = itemView.findViewById(R.id.exercise_list_image_id);
           exerciseDescView = itemView.findViewById(R.id.exercise_list_desc_id);
           exerciseMuscleView = itemView.findViewById(R.id.exercise_list_muscle_id);
           exerciseIDView = itemView.findViewById(R.id.exercise_list_id_id);
            this.mAdapter = adapter;

            exerciseNameView.setOnClickListener(this);
           exerciseImageView.setOnClickListener(this);
            exerciseDescView.setOnClickListener(this);
            exerciseMuscleView.setOnClickListener(this);
            exerciseIDView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String campus = mExerciseList[mPosition].getExerciseName();
            Snackbar.make(exerciseNameView,
                    campus + " clicked!",
                    Snackbar.LENGTH_SHORT).show();

        }
    }
}
