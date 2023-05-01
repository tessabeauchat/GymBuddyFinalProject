package com.example.gymbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public ExerciseListAdapter.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.exercise_list_item, parent, false);
        return new ExerciseViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListAdapter.ExerciseViewHolder holder, int position) {
        ExerciseData exercise = mExerciseList[position];
        holder.campusImageView.setImageResource(campus.getProfileImage());
        holder.campusTitleView.setText(campus.getCampusName());
        holder.campusPhoneView.setText(campus.getPhone());
        holder.campusEmailView.setText(campus.getEmail());
    }
}
