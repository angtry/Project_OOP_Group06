package com.example.switchscene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



import javafx.scene.Parent;



public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            //stage.setTitle("Tasks Management");
            //stage.show();
            //stage.setResizable(false);
            //Image icon = new Image("icon.png");
            //stage.getIcons().add(icon);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}