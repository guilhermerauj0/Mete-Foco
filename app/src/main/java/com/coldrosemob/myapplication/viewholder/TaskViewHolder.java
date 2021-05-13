package com.coldrosemob.myapplication.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.Task;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private ImageButton btnAddTask;
    private CheckBox cbConfirmTask;
    private TextView textTaskName;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);

        btnAddTask = itemView.findViewById(R.id.btnAddTask);
        cbConfirmTask = itemView.findViewById(R.id.cbConfirmTask);
        textTaskName = itemView.findViewById(R.id.textTaskName);

    }

    public void bindData(Task task) {
        textTaskName.setText(task.getTaskNome());
    }
}
