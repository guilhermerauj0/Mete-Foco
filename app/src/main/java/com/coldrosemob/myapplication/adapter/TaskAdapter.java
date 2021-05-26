package com.coldrosemob.myapplication.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.DBHelper;
import com.coldrosemob.myapplication.viewholder.TaskViewHolder;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList taskId, taskTitle, taskDescription, taskType, taskDate;
    private DBHelper db;

    public TaskAdapter(Activity activity, Context context, ArrayList taskId, ArrayList taskTitle, ArrayList taskDescription,
                       ArrayList taskType, ArrayList taskDate) {
        this.activity = activity;
        this.context = context;
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskType = taskType;
        this.taskDate = taskDate;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View taskView = inflater.inflate(R.layout.row_task_list, parent, false);
        db = new DBHelper(context);

        return new TaskViewHolder(taskView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.textRow_TaskName.setText(String.valueOf(taskTitle.get(position)));
        holder.textRow_TaskDate.setText(String.valueOf(taskDate.get(position)));

        holder.rlRow_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // detalhes da tarefa
                AlertDialog.Builder builderDialog = new AlertDialog.Builder(v.getRootView().getContext());
                View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.custom_dialog, null);
                TextView editDialog_Title, editDialog_Descricao, editDialog_Tipo, textDialog_Date;
                Button deleteTaskDialog;
                builderDialog.setView(dialogView);
                AlertDialog dialog = builderDialog.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                editDialog_Descricao = dialogView.findViewById(R.id.editDialog_Descricao);
                editDialog_Title = dialogView.findViewById(R.id.editDialog_Title);
                editDialog_Tipo = dialogView.findViewById(R.id.editDialog_Tipo);
                textDialog_Date = dialogView.findViewById(R.id.textDialog_date);
                deleteTaskDialog = dialogView.findViewById(R.id.btnDialog_DeleteTask);

                editDialog_Descricao.setText(String.valueOf(taskDescription.get(position)));
                editDialog_Title.setText(String.valueOf(taskTitle.get(position)));
                editDialog_Tipo.setText(String.valueOf(taskType.get(position)));
                textDialog_Date.setText(String.valueOf(taskDate.get(position)));

                deleteTaskDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        long result = db.delete_Tarefa(Integer.parseInt(String.valueOf(taskId.get(position))));
                        if (result == -1) {
                            Toast.makeText(context, "Não foi possível remover a tarefa.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Tarefa removida.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builderDialog.setCancelable(true);
                dialog.show();
            }
        });

        // click do checkBox
        holder.cbRow_ConfirmTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.cbRow_ConfirmTask.isChecked()) {
                    holder.rlRow_.setActivated(true);
                } else {
                    holder.rlRow_.setActivated(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskId.size();
    }
}


