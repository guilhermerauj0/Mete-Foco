package com.coldrosemob.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.Task;

import java.util.List;

public class AddNewTaskActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        mViewHolder.btnVoltar = findViewById(R.id.btnMenu);
        mViewHolder.editDescription = findViewById(R.id.editAddTask_Descricao);
        mViewHolder.editTitle = findViewById(R.id.editAddTask_Title);
        mViewHolder.btnAddTask = findViewById(R.id.btnAddTask_AddTask);
        mViewHolder.i = getIntent();

        mViewHolder.btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewHolder.i.putExtra("title", mViewHolder.editTitle.getText().toString());
                mViewHolder.i.putExtra("description",  mViewHolder.editDescription.getText().toString());
                setResult(1, mViewHolder.i);
                finish();
            }
        });

        mViewHolder.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static class ViewHolder{
        EditText editTitle, editDescription;
        ImageView btnVoltar;
        Button btnAddTask;
        Intent i;
    }
}