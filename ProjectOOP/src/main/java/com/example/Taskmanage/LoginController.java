package com.example.Taskmanage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController {

    @FXML
    TextField nameTextField;

    @FXML
    public ListView<String> listtask;


    @FXML
    private Label showname;

    @FXML
    private Label showpass;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label inputname, inputpass;
    private String name, pass;
    DBconnect connectnow = new DBconnect();
    Connection connection = connectnow.getConnection();



    private Stage stage;


    public void connectDB (ActionEvent event) throws IOException{


        String connectQuery = "select * from users;";
        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                showname.setText(queryOutput.getString("username"));
                showpass.setText(queryOutput.getString("pass"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void login (ActionEvent event) throws IOException{
        inputname.setText(username.getText());
        inputpass.setText(password.getText());



    }
    public void signup (ActionEvent event) throws IOException{

    }


    public void delete(ActionEvent event) throws IOException {}
    public void add (ActionEvent event) throws IOException {}
}