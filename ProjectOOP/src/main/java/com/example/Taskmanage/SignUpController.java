package com.example.Taskmanage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignUpController extends DBconnect {


    public void backlogin(){

    }

    @FXML
    private TextField usernameUP;
    @FXML
    private TextField passUP;



    public void connectDB(ActionEvent event) throws IOException {

        String connectQuery = "select * from users;";
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                //message.setText("DB Connect success !");
                String Dbname = queryOutput.getString("username");
                String Dbpass = queryOutput.getString("pass");
                // message.setText(Dbname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createAcc(ActionEvent event) throws Exception  {

        String createQuery = "INSERT INTO `tasks_manage`.`users` (`user_id`, `username`, `pass`) VALUES ('3', 'kalim', '1111');";
        try {
            Statement statement = connection.createStatement();

            ResultSet Output = statement.executeQuery(createQuery);
            while (Output.next()) {
                System.out.println("Sucess");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
