package com.example.Taskmanage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    TableColumn<Tasks, Integer> idColumn;
    @FXML
    TableColumn<Tasks, String> tasktitleColumn;

    @FXML
    TableColumn<Tasks, String> deadlineColumn;
    @FXML
    TableColumn<Tasks, String> taskdetailColumn;


        // -----Functions-----//

            //Databse
        public Connection getConnection() {
            Connection conn;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tasks","root","1234");
                return conn;
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
            //
            public void executeQuery(String query) {
                Connection conn = getConnection();
                Statement st;
                try {
                    st = conn.createStatement();
                    st.executeUpdate(query);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    public ObservableList<Tasks> getBooksList(){
        ObservableList<Tasks> TasksList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM Tasks ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Tasks tasks;
            while(rs.next()) {
                tasks = new Tasks(rs.getInt("id"),rs.getString("tasktitle"),rs.getString("deadline"),rs.getString("taskDetail"));
                TasksList.add(tasks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TasksList;
    }

    public void showtasks() {
        ObservableList<Tasks> list = getBooksList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Tasks,Integer>("id"));
        tasktitleColumn.setCellValueFactory(new PropertyValueFactory<Tasks,String>("tasktitle"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<Tasks,String>("deadline"));
        taskdetailColumn.setCellValueFactory(new PropertyValueFactory<Tasks,String>("taskdetail"));

        TableView.setItems(list);
    }






    public void addButton(ActionEvent event) throws IOException {

        String query = "insert into Tasks values("+id.getText()+",'" + tasktitle.getText()+"','"+deadline.getText()+"',"+taskdetails.getText()+");";
        executeQuery(query);
        showtasks();

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

    public void deleteButton(ActionEvent event) throws IOException {
        String query = "DELETE FROM books WHERE ID="+id.getText()+"";
        executeQuery(query);
        showtasks();
    }
    public void updateButton(ActionEvent event) throws IOException {
        String query = "UPDATE Tasks SET task_title='" + tasktitle.getText() + ", SET task_Deadline ='" + deadline.getText()+ ", SET task_detail='" + taskdetails.getText() +"'" ;
        executeQuery(query);
        showtasks();
    }

}