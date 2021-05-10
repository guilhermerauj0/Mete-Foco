package com.coldrosemob.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewHolder.addTaskFAB = findViewById(R.id.fabAdd);
        mViewHolder.textLogin = findViewById(R.id.textLogin);
        mViewHolder.textUsuario = findViewById(R.id.textUsuario);

        mViewHolder.addTaskFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddNewTaskActivity.class);
                startActivity(i);
            }
        });

        mViewHolder.textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                i.putExtra("usuario", mViewHolder.usuario);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == 2 && data != null){
            mViewHolder.usuario = data.getExtras().getString("usuario");
            mViewHolder.textUsuario.setText(mViewHolder.usuario + "!");
        }else{
            Toast.makeText(this, "Refaça seu Login", Toast.LENGTH_SHORT).show();
        }
    }

    public static class ViewHolder{

        FloatingActionButton addTaskFAB;
        TextView textLogin, textUsuario;
        String usuario = "";

    }
}