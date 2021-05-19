package com.coldrosemob.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.DatePickerFragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class AddNewTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        mViewHolder.btnVoltar = findViewById(R.id.btnMenu);
        mViewHolder.editDescription = findViewById(R.id.editAddTask_Descricao);
        mViewHolder.editTitle = findViewById(R.id.editAddTask_Title);
        mViewHolder.btnAddTask = findViewById(R.id.btnAddTask_AddTask);
        mViewHolder.editTipo = findViewById(R.id.editAddTask_Tipo);
        mViewHolder.layoutAddTask_date = findViewById(R.id.layoutAddTask_date);
        mViewHolder.textAddTask_date = findViewById(R.id.textAddTask_date);
        mViewHolder.i = getIntent();

        // Add Task
        mViewHolder.btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.title = mViewHolder.editTitle.getText().toString();
                mViewHolder.description = mViewHolder.editDescription.getText().toString();

                if(mViewHolder.title.isEmpty() && mViewHolder.description.isEmpty()){
                    Toast.makeText(AddNewTaskActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                }
                else{
                    mViewHolder.i.putExtra("title", mViewHolder.editTitle.getText().toString());
                    mViewHolder.i.putExtra("description",  mViewHolder.editDescription.getText().toString());
                    mViewHolder.i.putExtra("date", mViewHolder.currentDate);
                    mViewHolder.i.putExtra("day", mViewHolder.day);
                    setResult(1, mViewHolder.i);
                    finish();
                }
            }
        });

        mViewHolder.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mViewHolder.layoutAddTask_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    // date picker
    @Override
    public void onDateSet(DatePicker view,  int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        mViewHolder.currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());

        SimpleDateFormat formatDate = new SimpleDateFormat("dd");
        Date date = new Date();
        String dateFormat = formatDate.format(date);
        int intDate = Integer.parseInt(dateFormat);

        mViewHolder.day = String.valueOf(dayOfMonth);

        if (dateFormat.equals(String.valueOf(dayOfMonth))){
            mViewHolder.textAddTask_date.setText("Hoje");
        }else if (intDate < dayOfMonth && dayOfMonth == intDate+ 1){
            mViewHolder.textAddTask_date.setText("Amanhã");
        }else {
            mViewHolder.textAddTask_date.setText(mViewHolder.currentDate);
        }
    }

    public static class ViewHolder{
        EditText editTitle, editDescription, editTipo;
        LinearLayout layoutAddTask_date;
        TextView textAddTask_date;
        String title, description;
        String currentDate, day;
        ImageView btnVoltar;
        Button btnAddTask;
        Intent i;
    }
}