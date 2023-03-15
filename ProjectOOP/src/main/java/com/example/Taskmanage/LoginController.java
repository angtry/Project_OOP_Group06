package com.example.Taskmanage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
    private Label message;

    @FXML
    private TextField username;
    @FXML
    private TextField password;



    @FXML
    TextField id;
    private String name, pass;
    DBconnect connectnow = new DBconnect();
    Connection connection = connectnow.getConnection("Tasks","root","Astrowizd47##");

    // maninmenu
    // textfeild


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void connectDB(ActionEvent event) throws IOException {


        String connectQuery = "select * from users;";
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                //message.setText("DB Connect success !");
                String Dbname = queryOutput.getString("username");
                String Dbpass = queryOutput.getString("pass");
                message.setText(Dbname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        public void login(ActionEvent event) throws IOException  {
            //inputname.setText(username.getText());
            //inputpass.setText(password.getText());
            String userinput = username.getText();
            String passinput = password.getText();

            //System.out.println(user);

            String connectQuery = "select * from users;";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryOutput = statement.executeQuery(connectQuery);

                while (queryOutput.next()) {
                    //message.setText("DB Connect success !");
                    String Dbname = queryOutput.getString("username");
                    String Dbpass = queryOutput.getString("pass");
                    message.setText(Dbname);

                    if (userinput.isEmpty() && passinput.isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setContentText("The username and password are empty.");
                        alert.showAndWait();
                        //alert.setGraphic(new ImageView(this.getClass().getResource("")));
                        //alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

                        System.out.println("Input Your username and password. ");

                    } else if (Dbname.equals(userinput) && Dbpass.equals(passinput) ) {
                        System.out.println("Correct");
                        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        System.out.println("Notcoreect");

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Login");
                        alert.setContentText("The username or password are Incorrect.");
                        alert.showAndWait();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void signup()  {
            //switch scene
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
           // root = loader.load();

            //MainMenuController mainMenuController = loader.getController();
            stage.close();


        }
        public void exit(){

        }



}