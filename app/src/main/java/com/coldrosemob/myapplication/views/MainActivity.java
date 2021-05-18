package com.coldrosemob.myapplication.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.adapter.TaskAdapter;
import com.coldrosemob.myapplication.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.imgTaskOff = findViewById(R.id.imgTaskOff);
        mViewHolder.textTaskOff = findViewById(R.id.textTaskOff);
        mViewHolder.addTaskFAB = findViewById(R.id.fabAdd);
        mViewHolder.textUsuario = findViewById(R.id.textUsuario);
        mViewHolder.rvTask = findViewById(R.id.rvTask_main);

        mViewHolder.listaTask = new ArrayList<>();

        // adapter
        mViewHolder.taskAdapter = new TaskAdapter(mViewHolder.listaTask);
        mViewHolder.rvTask.setAdapter(mViewHolder.taskAdapter);

        // layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.rvTask.setLayoutManager(linearLayoutManager);

        mViewHolder.addTaskFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.i = new Intent(MainActivity.this, AddNewTaskActivity.class);
                mViewHolder.i.putExtra("title", mViewHolder.title);
                mViewHolder.i.putExtra("description", mViewHolder.description);
                mViewHolder.i.putExtra("date", mViewHolder.currentDate);
                mViewHolder.i.putExtra("day", mViewHolder.day);
                startActivityForResult(mViewHolder.i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == 1 && data != null){
            mViewHolder.title = data.getExtras().getString("title");
            mViewHolder.description = data.getExtras().getString("description");
            mViewHolder.currentDate = data.getExtras().getString("date");
            mViewHolder.day = data.getExtras().getString("day");
            addTask();
            mViewHolder.taskAdapter.notifyDataSetChanged();
        }
    }

    public static class ViewHolder{

        String title = "", description = "", currentDate, day;
        FloatingActionButton addTaskFAB;
        Intent i;
        TextView textUsuario, textTaskOff;
        List<Task> listaTask;
        TaskAdapter taskAdapter;
        ImageView imgTaskOff;
        RecyclerView rvTask;

    }

    private void addTask(){
        mViewHolder.taskAdapter.getListaTask().add(0, Task.TaskBuilder.builder()
                .setTaskTitle(mViewHolder.title)
                .setTaskDescription(mViewHolder.description)
                .setTaskDate(mViewHolder.currentDate)
                .setTaskDay(mViewHolder.day)
                .build());
    }
}