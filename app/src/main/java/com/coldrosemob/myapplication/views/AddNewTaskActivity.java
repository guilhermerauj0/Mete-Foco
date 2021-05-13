package com.coldrosemob.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        mViewHolder.editNome = findViewById(R.id.editNome);
        mViewHolder.btnVoltar = findViewById(R.id.btnMenu);
        mViewHolder.editDescription = findViewById(R.id.editDescricao);
        mViewHolder.editTitle = findViewById(R.id.editTitle);
        mViewHolder.i = getIntent();

        mViewHolder.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    public static class ViewHolder{
        EditText editNome, editTitle, editDescription;
        ImageView btnVoltar;
        Intent i;
    }
}