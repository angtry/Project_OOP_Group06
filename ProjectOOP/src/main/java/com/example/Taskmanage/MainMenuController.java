package com.example.Taskmanage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainMenuController {

    //textfield
        @FXML
        private TextField id;
        @FXML
        private TextField tasktitle;
        @FXML
        private TextField deadline;
        @FXML
        private TextField taskdetails;
        //Buttons
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    // Table View
    @FXML
    TableView<Tasks> TableView;
    // Table Colums

    @FXML
    TableColumn<Tasks, int> idColumn;
    @FXML
    TableColumn<Tasks, String> tasktitleColumn;

    @FXML
    TableColumn<Tasks, String> deadlineColumn;
    @FXML
    TableColumn<Tasks, String> taskdetailColumn;
    public void addButton(ActionEvent event) throws IOException {

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

    }

    public void updateButton (ActionEvent event) throws IOException {}
    public void deleteButton(ActionEvent event) throws IOException {}


}