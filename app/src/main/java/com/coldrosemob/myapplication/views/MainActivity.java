package com.coldrosemob.myapplication.views;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
        mViewHolder.taskSelected = new ArrayList<>();

        mViewHolder.imgTaskOff = findViewById(R.id.imgTaskOff);
        mViewHolder.textTaskOff = findViewById(R.id.textTaskOff);
        mViewHolder.layoutMain_InfoTaskOff = findViewById(R.id.layoutMain_InfoTaskOff);
        mViewHolder.addTaskFAB = findViewById(R.id.fabAdd);
        mViewHolder.textUsuario = findViewById(R.id.textUsuario);
        mViewHolder.rvTask = findViewById(R.id.rvTask_main);
        mViewHolder.swipeRefresh = findViewById(R.id.swipeRefresh);
        mViewHolder.textMain_Sobre = findViewById(R.id.textMain_Sobre);

        listarTarefas();

        mViewHolder.textMain_Sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("App Beta!")
                        .setMessage("Este app é beta, logo diversos bugs podem aparecer. Desenvolvido por" +
                                " Arthur Guilherme")
                        .setNegativeButton("OK", null).show();
            }
        });

        // adapter
        mViewHolder.taskAdapter = new TaskAdapter(MainActivity.this, this, mViewHolder.taskId, mViewHolder.taskTitle,
                mViewHolder.taskDescription, mViewHolder.taskType, mViewHolder.taskDate, mViewHolder.taskSelected);
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

        mViewHolder.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recreate();
                mViewHolder.swipeRefresh.setRefreshing(false);
            }
        });
    }

    public static class ViewHolder {
        SwipeRefreshLayout swipeRefresh;
        FloatingActionButton addTaskFAB;
        TextView textMain_Sobre;
        LinearLayout layoutMain_InfoTaskOff;
        Intent i;
        TextView textUsuario, textTaskOff;
        ArrayList<String> taskId, taskTitle, taskDescription, taskType, taskDate, taskSelected;
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
            mostrarInfoTaskOff();
        } else {
            while (cursor.moveToNext()) {
                ocultarInfoTaskOff();
                mViewHolder.taskId.add(cursor.getString(0));
                mViewHolder.taskTitle.add(cursor.getString(1));
                mViewHolder.taskDescription.add(cursor.getString(2));
                mViewHolder.taskType.add(cursor.getString(3));
                mViewHolder.taskDate.add(cursor.getString(4));
                mViewHolder.taskSelected.add(cursor.getString(5));
            }
        }
    }

    public void mostrarInfoTaskOff() {
        mViewHolder.layoutMain_InfoTaskOff.setVisibility(View.VISIBLE);
    }

    public void ocultarInfoTaskOff() {
        mViewHolder.layoutMain_InfoTaskOff.setVisibility(View.INVISIBLE);
    }
}