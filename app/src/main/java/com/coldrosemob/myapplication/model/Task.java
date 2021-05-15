package com.coldrosemob.myapplication.model;

public class Task {

    private String taskTitle;
    private String taskDescription;

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public static class TaskBuilder{
        private String taskTitle;
        private String taskDescription;

        public TaskBuilder setTaskTitle(String taskTitle) {
            this.taskTitle = taskTitle;
            return this;
        }

        public TaskBuilder setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
            return this;
        }

        public static TaskBuilder builder(){
            return new TaskBuilder();

        }

        public Task build(){
            Task task = new Task();
            task.taskTitle = taskTitle;
            task.taskDescription = taskDescription;
            return task;
        }
    }

    @Override
    public String toString() {
        return taskTitle;
    }
}
