package com.coldrosemob.myapplication.model;

public class Task {

    private String taskTitle;
    private String taskDescription;
    private String taskDate;
    private String taskType;

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

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
        private String taskDate;
        private String taskType;

        public TaskBuilder setTaskDate(String taskDate) {
            this.taskDate = taskDate;
            return this;
        }

        public TaskBuilder setTaskType(String taskType) {
            this.taskType = taskType;
            return this;
        }

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
            task.taskDate = taskDate;
            task.taskType = taskType;
            return task;
        }
    }

    @Override
    public String toString() {
        return taskTitle;
    }
}
