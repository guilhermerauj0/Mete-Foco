package com.coldrosemob.myapplication.views;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.adapter.TaskAdapter;
import com.coldrosemob.myapplication.model.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        // informações da tarefa para o banco de dados
        mViewHolder.taskId = new ArrayList<>();
        mViewHolder.taskDate = new ArrayList<>();
        mViewHolder.taskDescription = new ArrayList<>();
        mViewHolder.taskTitle = new ArrayList<>();
        mViewHolder.taskType = new ArrayList<>();

        listarTarefas();

        mViewHolder.imgTaskOff = findViewById(R.id.imgTaskOff);
        mViewHolder.textTaskOff = findViewById(R.id.textTaskOff);
        mViewHolder.addTaskFAB = findViewById(R.id.fabAdd);
        mViewHolder.textUsuario = findViewById(R.id.textUsuario);
        mViewHolder.rvTask = findViewById(R.id.rvTask_main);

        // TODO Aparecer imagem e texto informando que não há tarefas
        // TODO Criar menu de visualização detalhada da tarefa

        // adapter
        mViewHolder.taskAdapter = new TaskAdapter(MainActivity.this, this, mViewHolder.taskId, mViewHolder.taskTitle,
                mViewHolder.taskDescription, mViewHolder.taskType, mViewHolder.taskDate);
        mViewHolder.rvTask.setAdapter(mViewHolder.taskAdapter);

        // layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.rvTask.setLayoutManager(linearLayoutManager);

        mViewHolder.addTaskFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.i = new Intent(MainActivity.this, AddNewTaskActivity.class);
                startActivityForResult(mViewHolder.i, 1);
            }
        });
    }

    public static class ViewHolder {
        FloatingActionButton addTaskFAB;
        Intent i;
        TextView textUsuario, textTaskOff;
        ArrayList<String> taskId, taskTitle, taskDescription, taskType, taskDate;
        TaskAdapter taskAdapter;
        ImageView imgTaskOff;
        RecyclerView rvTask;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            recreate();
        }
    }

    public void listarTarefas() {
        Cursor cursor = db.selectAll_Tarefa();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Sem banco de dados", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                mViewHolder.taskId.add(cursor.getString(0));
                mViewHolder.taskTitle.add(cursor.getString(1));
                mViewHolder.taskDescription.add(cursor.getString(2));
                mViewHolder.taskType.add(cursor.getString(3));
                mViewHolder.taskDate.add(cursor.getString(4));
            }
        }
    }
}