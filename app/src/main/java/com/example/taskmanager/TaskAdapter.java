package com.example.taskmanager;

import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter <TaskAdapter.ViewHolder> {

    private ArrayList<Task> tasks;
    private Activity activity;
    public TaskAdapter(ArrayList<Task> tasks, Activity activity){
        this.tasks = tasks;
        this.activity = activity;

    }


    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = tasks.get(position);

        holder.namaMatkul.setText(task.getNamaMatkul());
        holder.deadLine.setText(task.getDeadLine().toString());
        holder.deskripsiTugas.setText(task.getDeskripsiTugas());

    }

    @Override
    public int getItemCount() {
        if (tasks != null) {
            return tasks.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView namaMatkul;
        public final TextView deadLine;
        public final TextView deskripsiTugas;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            namaMatkul = view.findViewById(R.id.namaMatkul);
            deadLine = view.findViewById(R.id.deadLine);
            deskripsiTugas = view.findViewById(R.id.deskripsiTugas);
        }
    }


}
