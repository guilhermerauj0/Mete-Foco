package com.coldrosemob.myapplication.data;

import com.coldrosemob.myapplication.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMock {

    private List<Task> listaTask;

    public TaskMock() {
        listaTask = new ArrayList<>();
        listaTask.add(new Task("Fazer tutorial", "Tutorial para o youtube"));

    }

    public List<Task> getListaTask() {
        return listaTask;
    }

    public void setListaTask(List<Task> listaTask) {
        this.listaTask = listaTask;
    }
}