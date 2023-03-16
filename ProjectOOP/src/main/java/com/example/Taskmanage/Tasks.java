package com.example.Taskmanage;

public class Tasks {
    private int id;
    private String tasktitle;
    private String deadline;
    private String taskdetail;
    private int user;

    public Tasks(){}
    public Tasks(int id, String tasktitle, String deadline, String taskdetail ,int user) {
        this.id = id;
        this.tasktitle = tasktitle;
        this.deadline = deadline;
        this.taskdetail = taskdetail;
        this.user = user;
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

    public String getTaskdetail() {
        return taskdetail;
    }
}
