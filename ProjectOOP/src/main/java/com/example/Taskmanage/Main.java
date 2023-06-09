package com.example.Taskmanage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.Parent;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("loginD.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tasks Management");
            stage.show();
            stage.setResizable(false);
            Image icon = new Image("logo.png");
            stage.getIcons().add(icon);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}