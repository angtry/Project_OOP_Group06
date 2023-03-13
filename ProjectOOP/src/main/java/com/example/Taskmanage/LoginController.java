package com.example.Taskmanage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


    @FXML
    TextField id;
    private String name, pass;
    DBconnect connectnow = new DBconnect();
    Connection connection = connectnow.getConnection();

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
                showname.setText(queryOutput.getString("username"));
                showpass.setText(queryOutput.getString("pass"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void login()  {
        inputname.setText(username.getText());
        inputpass.setText(password.getText());


    }

    public void signup(ActionEvent event) throws IOException {
        //switch scene
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
       // root = loader.load();

        //MainMenuController mainMenuController = loader.getController();


        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void SignInWithGoogle(ActionEvent actionEvent) {
    }
    public void SignInWithFacebook(ActionEvent actionEvent) {
    }
    public void SignInWithAppleID(ActionEvent actionEvent) {
    }
}