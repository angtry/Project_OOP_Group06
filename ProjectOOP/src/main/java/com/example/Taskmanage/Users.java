package com.example.Taskmanage;

import java.util.UUID;

public class Users {

    private String name;
    private String pass;
    public UUID userid;

    public  Users(){}
    public Users(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.userid = UUID.randomUUID();
    }
}
