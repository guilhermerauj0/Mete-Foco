package com.coldrosemob.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mViewHolder.btnVoltar = findViewById(R.id.btnVoltar);
        mViewHolder.editNome = findViewById(R.id.editNome);
        mViewHolder.editSobrenome = findViewById(R.id.editSobrenome);
        mViewHolder.btnAddLogin = findViewById(R.id.btnAddLogin);

        mViewHolder.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i3 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i3);
                finish();

            }
        });

        mViewHolder.btnAddLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.usuario = String.valueOf(new LoginUsuario(mViewHolder.editNome.getText().toString(),
                        mViewHolder.editSobrenome.getText().toString()));

                Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                i2.putExtra("usuario", mViewHolder.usuario);
                setResult(2, i2);
                finish();
            }
        });
    }

    public static class ViewHolder{

        ImageView btnVoltar;
        EditText editNome, editSobrenome;
        String usuario;
        Button btnAddLogin;

    }
}