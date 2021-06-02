package com.coldrosemob.myapplication.views;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.coldrosemob.myapplication.R;
import com.coldrosemob.myapplication.model.DBHelper;
import com.coldrosemob.myapplication.model.DatePickerFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class AddNewTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ViewHolder mViewHolder = new ViewHolder();
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        db = new DBHelper(this);
        mViewHolder.btnVoltar = findViewById(R.id.btnMenu);
        mViewHolder.editDescription = findViewById(R.id.editAddTask_Descricao);
        mViewHolder.editTitle = findViewById(R.id.editAddTask_Title);
        mViewHolder.btnAddTask = findViewById(R.id.btnAddTask_AddTask);
        mViewHolder.spinTipo = findViewById(R.id.spinAddTask_Tipo);
        mViewHolder.layoutAddTask_date = findViewById(R.id.layoutAddTask_date);
        mViewHolder.textAddTask_date = findViewById(R.id.textAddTask_date);
        mViewHolder.i = getIntent();

        String[] valueTipo = {"Casa", "Profissional", "Geral", "Estudo", "Urgentes"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(valueTipo));
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(this, R.layout.style_spinner_textview, arrayList);
        mViewHolder.spinTipo.setAdapter(spinAdapter);

        // Add Task
        mViewHolder.btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.title = mViewHolder.editTitle.getText().toString();
                mViewHolder.description = mViewHolder.editDescription.getText().toString();

                if (mViewHolder.title.isEmpty() || mViewHolder.description.isEmpty()) {
                    Toast.makeText(AddNewTaskActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                }
                else {
                    mViewHolder.titulo = mViewHolder.editTitle.getText().toString();
                    mViewHolder.descricao = mViewHolder.editDescription.getText().toString();
                    mViewHolder.tipo = mViewHolder.spinTipo.getSelectedItem().toString();
                    db.insert_Tarefa(mViewHolder.titulo, mViewHolder.descricao, mViewHolder.tipo, mViewHolder.currentDate, 0);
                    setResult(1);
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
        mViewHolder.currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        SimpleDateFormat formatDate = new SimpleDateFormat("d");
        Date date = new Date();
        String dateFormat = formatDate.format(date);
        int intDate = Integer.parseInt(dateFormat);

        if (dateFormat.equals(String.valueOf(dayOfMonth))){
            mViewHolder.textAddTask_date.setText("Hoje");
        }else if (intDate < dayOfMonth && dayOfMonth == intDate + 1) {
            mViewHolder.textAddTask_date.setText("Amanhã");
        } else if (intDate > dayOfMonth && dayOfMonth == intDate - 1) { // <-- CORRIGIR
            mViewHolder.textAddTask_date.setText("Ontem");
        } else {
            mViewHolder.textAddTask_date.setText(mViewHolder.currentDate);
        }
    }

    public static class ViewHolder {
        EditText editTitle, editDescription;
        Spinner spinTipo;
        LinearLayout layoutAddTask_date;
        TextView textAddTask_date;
        String title, description;
        String currentDate, day, titulo, descricao, tipo;
        ImageView btnVoltar;
        Button btnAddTask;
        Intent i;
    }
}