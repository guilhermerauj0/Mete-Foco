package com.coldrosemob.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.Task;
import com.coldrosemob.myapplication.viewholder.TaskViewHolder;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private List<Task> listaTask;
    public TaskAdapter(List<Task> lista){listaTask = lista; }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View taskView = inflater.inflate(R.layout.row_task_list, parent, false);

        return new TaskViewHolder(taskView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = listaTask.get(position);
        holder.bindData(task);

    }

    @Override
    public int getItemCount() {
        return listaTask.size();
    }
}