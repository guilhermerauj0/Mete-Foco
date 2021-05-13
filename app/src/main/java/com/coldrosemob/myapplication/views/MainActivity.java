package com.coldrosemob.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.adapter.TaskAdapter;
import com.coldrosemob.myapplication.data.TaskMock;
import com.coldrosemob.myapplication.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewHolder.addTaskFAB = findViewById(R.id.fabAdd);
        mViewHolder.textUsuario = findViewById(R.id.textUsuario);
        mViewHolder.rvTask = findViewById(R.id.rvTask_main);

        TaskMock taskMock = new TaskMock();
        List<Task> listaTask = new ArrayList<>();
        listaTask.addAll(taskMock.getListaTask());

        // adapter
        TaskAdapter taskAdapter = new TaskAdapter(listaTask);
        mViewHolder.rvTask.setAdapter(taskAdapter);

        // layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.rvTask.setLayoutManager(linearLayoutManager);

        mViewHolder.addTaskFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddNewTaskActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    public static class ViewHolder{

        FloatingActionButton addTaskFAB;
        TextView textUsuario;
        RecyclerView rvTask;

    }
}