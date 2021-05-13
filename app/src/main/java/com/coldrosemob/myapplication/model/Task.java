package com.coldrosemob.myapplication.model;

public class Task {

    private String taskNome;
    private String taskDescription;

    public Task(String taskNome, String taskDescription) {
        this.taskNome = taskNome;
        this.taskDescription = taskDescription;
    }

    public String getTaskNome() {
        return taskNome;
    }

    public void setTaskNome(String taskNome) {
        this.taskNome = taskNome;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return taskNome;
    }
}
