package com.coldrosemob.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.coldrosemob.myapplication.R;

public class AddNewTaskActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        mViewHolder.editNome = findViewById(R.id.editNome);
        mViewHolder.btnVoltar = findViewById(R.id.btnMenu);

        mViewHolder.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddNewTaskActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public static class ViewHolder{
        EditText editNome;
        ImageView btnVoltar;
    }
}