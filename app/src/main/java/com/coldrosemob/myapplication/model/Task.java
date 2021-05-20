package com.coldrosemob.myapplication.model;

public class Task {

    private String taskTitle;
    private String taskDescription;
    private String taskDate;
    private String taskType;
    private String taskDay;
    private boolean taskSelected;

    public boolean isTaskSelected() {
        return taskSelected;
    }

    public void setTaskSelected(boolean taskSelected) {
        this.taskSelected = taskSelected;
    }

    public String getTaskDay() {
        return taskDay;
    }

    public void setTaskDay(String taskDay) {
        this.taskDay = taskDay;
    }

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
        private String taskDay;
        private boolean taskSelected;

        public TaskBuilder setTaskSelected(boolean taskSelected) {
            this.taskSelected = taskSelected;
            return this;
        }

        public TaskBuilder setTaskDay(String taskDay) {
            this.taskDay = taskDay;
            return this;
        }

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
            task.taskDay = taskDay;
            task.taskSelected = taskSelected;
            return task;
        }
    }

    @Override
    public String toString() {
        return taskTitle;
    }
}
