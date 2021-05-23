package com.coldrosemob.myapplication.model;

public class Task {

    private int id;
    private String taskTitle;
    private String taskDescription;
    private String taskDate;
    private String taskType;
    private String taskDay;
    private boolean taskSelected;

    public Task(Task task) {
        id = task.id;
        taskTitle = task.taskTitle;
        taskDescription = task.taskDescription;
        taskDate = task.taskDate;
        taskType = task.taskType;
        taskDay = task.taskDay;
        taskSelected = false;
    }

    public Task() {
        id = 0;
        taskTitle = "";
        taskDescription = "";
        taskDate = "";
        taskType = "";
        taskDay = "";
        taskSelected = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Task(int id, String taskTitle, String taskDescription, String taskType, String taskDate, boolean taskSelected) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskType = taskType;
        this.taskSelected = taskSelected;
    }

    public static class TaskBuilder {
        private String taskTitle;
        private String taskDescription;
        private String taskDate;
        private String taskType;
        private String taskDay;
        private boolean taskSelected;
        private int id;

        public TaskBuilder setId(int id) {
            this.id = id;
            return this;
        }

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
            task.id = id;
            return task;
        }
    }

    @Override
    public String toString() {
        return taskTitle;
    }
}
