package com.example.Taskmanage;

public class Tasks {
    private int id;
    private String tasktitle;
    private String deadline;
    private String taskDetail;

    public Tasks(){}
    public Tasks(int id, String tasktitle, String deadline, String taskDetail) {
        this.id = id;
        this.tasktitle = tasktitle;
        this.deadline = deadline;
        this.taskDetail = taskDetail;
    }

    public int getId() {
        return id;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getTaskDetail() {
        return taskDetail;
    }
}
