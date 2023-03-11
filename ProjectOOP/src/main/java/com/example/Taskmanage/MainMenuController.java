package com.example.Taskmanage;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MainMenuController extends LoginController{



    public void add (ActionEvent event) throws IOException {

        /*    String username = nameTextField.getText();
            // switch scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(username);

        //root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
*/

    /*    String connectQuery = "select * from tasks;";
        String AddQuery = "insert into tasks value(1,1,'JavaFX',curdate());";

        String listQuery = "select task_name from tasks;";
        try{
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            ResultSet AddQueryOutput = statement.executeQuery(AddQuery);
            ResultSet Listtaskoutput = statement.executeQuery(listQuery);


            while(queryOutput.next()){
                System.out.println(Listtaskoutput);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
*/

        listtask.getItems().add(nameTextField.getText());

    }
    public void delete(ActionEvent event) throws IOException {}


}