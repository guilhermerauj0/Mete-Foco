package com.coldrosemob.myapplication.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;


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
}
