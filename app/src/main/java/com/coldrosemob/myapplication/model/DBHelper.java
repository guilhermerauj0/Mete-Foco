package com.coldrosemob.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nomeDB = "meteFocoTask.db";
    // codigo para adicionar os elementos
    String[] sql = {"CREATE TABLE tarefa ( id INTEGER NOT NULL UNIQUE, titulo TEXT NOT NULL, descricao TEXT NOT NULL, tipo	TEXT NOT NULL, data	TEXT NOT NULL, selecionado INTEGER NOT NULL, PRIMARY KEY(id AUTOINCREMENT));"
    };

    public DBHelper(@Nullable Context context) {
        super(context, nomeDB, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int i = 0; i < sql.length; i++) {
            db.execSQL(sql[i]);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //===================================UTILIZADOR======================================
    // INSERT
    public long insert_Tarefa(String titulo, String descricao, String tipo, String data, int selected) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", titulo);
        values.put("descricao", descricao);
        values.put("tipo", tipo);
        values.put("data", data);
        values.put("selecionado", selected);
        return db.insert("tarefa", null, values);

    }

    // UPDATE
    public long update_Tarefa(int id, String titulo, String descricao, String tipo, String data, int selected) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", titulo);
        values.put("descricao", descricao);
        values.put("tipo", tipo);
        values.put("data", data);
        values.put("selecionado", selected);
        return db.update("tarefa", values, "id=?", new String[]{String.valueOf(id)});
    }

    public long update_Selected(int selected){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("selecionado", selected);
        return db.update("tarefa", values, "selecionado=?", new String[]{String.valueOf(selected)});
    }

    // DELETE
    public long delete_Tarefa(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("tarefa", "id=?", new String[]{String.valueOf(id)});
    }

    // SELECT
    public Cursor select_Tarefa(int id) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM tarefa WHERE id=?",
                new String[]{String.valueOf(id)});
    }

    // SELECT ALL
    public Cursor selectAll_Tarefa() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        if (db != null) {
            c = db.rawQuery("SELECT * FROM tarefa", null);
        }
        return c;
    }

    // SELECT BY ID
    public Task selectById_Tarefas(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM tarefa WHERE id=?", new String[]{String.valueOf(id)});
        c.moveToFirst();

        if (c.getCount() == 1) {
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String descricao = c.getString(c.getColumnIndex("descricao"));
            String tipo = c.getString(c.getColumnIndex("tipo"));
            String data = c.getString(c.getColumnIndex("data"));
            int selecionado = c.getInt(c.getColumnIndex("selecionado"));
            return new Task(id, titulo, descricao, tipo, data, selecionado);
        } else {
            return null;
        }
    }
    //===================================================================================
}
