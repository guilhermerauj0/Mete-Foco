package com.coldrosemob.myapplication.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.adapter.TaskAdapter;
import com.coldrosemob.myapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private CheckBox cbRow_ConfirmTask;
    private TextView textRow_TaskName;
    private TextView textRow_TaskDate;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);

        cbRow_ConfirmTask = itemView.findViewById(R.id.cbRow_ConfirmTask);
        textRow_TaskName = itemView.findViewById(R.id.textRow_TaskName);
        textRow_TaskDate = itemView.findViewById(R.id.textRow_TaskDate);

    }

    public void bindData(Task task) {
        // Lugar onde trata os itens do row
        textRow_TaskName.setText(task.getTaskTitle());
        textRow_TaskDate.setText(task.getTaskDate());

    }

}
