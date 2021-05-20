package com.coldrosemob.myapplication.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TaskViewHolder extends RecyclerView.ViewHolder {

    public CheckBox cbRow_ConfirmTask;
    public TextView textRow_TaskName;
    public TextView textRow_TaskDate;
    public RelativeLayout rlRow_;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);

        cbRow_ConfirmTask = itemView.findViewById(R.id.cbRow_ConfirmTask);
        textRow_TaskName = itemView.findViewById(R.id.textRow_TaskName);
        textRow_TaskDate = itemView.findViewById(R.id.textRow_TaskDate);
        rlRow_ = itemView.findViewById(R.id.rlRow_);

    }

    public void bindData(Task task) {
        // Lugar onde trata os itens do row
        textRow_TaskName.setText(task.getTaskTitle());

        // date
        SimpleDateFormat formatDate = new SimpleDateFormat("dd");
        Date date = new Date();
        String dateFormat = formatDate.format(date);

        int intDate = Integer.parseInt(dateFormat);
        int intDay = Integer.parseInt(task.getTaskDay());

        if (dateFormat.equals(task.getTaskDay())){
            textRow_TaskDate.setText("Hoje");

        }else if (intDate < intDay && intDay == intDate + 1){
            textRow_TaskDate.setText("Amanhã");
        }
        else{
            textRow_TaskDate.setText(task.getTaskDate());
        }
    }
}
