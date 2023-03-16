package com.example.Taskmanage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

public class SignUpController extends DBconnect {
    @FXML
    Button backLogin;

    @FXML
    Button createAccount;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void backlogin(ActionEvent backlogin) throws IOException {

            root = FXMLLoader.load(getClass().getResource("loginD.fxml"));
            stage = (Stage) ((Node) backlogin.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private TextField usernameUP;
    @FXML
    private TextField passUP;



    public void executeQuery(String query) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Random random = new Random();
    int randomUserID = random.nextInt(100);

    Users users = new Users();
    public void createAcc(ActionEvent event) throws IOException  {

        String nameCreate = usernameUP.getText();
        String passCreate = passUP.getText();

        if(nameCreate.isEmpty() && passCreate.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("The username and password are empty.");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Create Account Confimation");
            alert.setContentText("Please click Ok to confirm ! or cancel to go back edit your info");

           // alert.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("Creat acoount Confirm ");
                    System.out.println(randomUserID);
                    String createQuery = "INSERT INTO `tasks_manage`.`users` (`user_id`, `username`, `pass`) VALUES ('"+randomUserID+"','"+ nameCreate+"', '"+passCreate+"');";
                    executeQuery(createQuery);
                }
                else {
                    alert.close();
                }
            });



        }

    }




}
