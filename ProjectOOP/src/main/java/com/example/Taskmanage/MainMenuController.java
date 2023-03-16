package com.example.Taskmanage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class MainMenuController extends DBconnect implements Initializable {

    //textfield
        @FXML
        private TextField id;
        @FXML
        private TextField tasktitle;
        @FXML
        private DatePicker deadline;
        @FXML
        private TextField taskdetails;
        //Buttons
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button logout;


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
    @FXML
    TableColumn<Tasks, Integer> userColumn;


    LocalDate localDate;

    public MainMenuController() throws SQLException {
    }


    // -----Functions-----//

            //Database Query
       /* public Connection getConnection() {
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


         */
           // DBconnect connectnow = new DBconnect();
            //Connection connectiontask = connectnow.getConnection("tasks","root","1234");
            public void executeQuery(String query) {

                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
     String DbtaskID;
    int DbtaskUser;
            String DbtaskTitle,DbtaskDetail,DbtaskDeadline;


    Statement statement = connection.createStatement();
    ResultSet queryOutput;

    public ObservableList<Tasks> getTasks()  {
        ObservableList<Tasks> TasksList = FXCollections.observableArrayList();
        //Connection connectiontask = getConnection();
        String query = "SELECT t.* FROM Tasks t JOIN users u ON u.user_id = t. user_id WHERE u.username ='try' and u.pass = '12345';";
        //Statement st;
        //ResultSet rs;
        //String querygetUSerID = "SELECT user_id FROM users WHERE username = '"+username+"';";

        try {
             statement = connection.createStatement();
             queryOutput = statement.executeQuery(query);



            while(queryOutput.next()) {
                //tasks = new Tasks(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                Tasks tasks;
                //TasksList.add(tasks);

               //  DbtaskID = queryOutput.getString("task_id");
                 //DbtaskTitle = queryOutput.getString("task_title");
                 //DbtaskDeadline = queryOutput.getString("task_deadline");
                 //DbtaskDetail = queryOutput.getString("task_detail");
                 //DbtaskUser = queryOutput.getString("user");

                 tasks = new Tasks(queryOutput.getInt(1),queryOutput.getString(2),queryOutput.getString(3),queryOutput.getString(4), queryOutput.getInt(5));
TasksList.add(tasks);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TasksList;
    }

    public void showtasks() {
        ObservableList<Tasks> list = getTasks();

        idColumn.setCellValueFactory(new PropertyValueFactory<Tasks,Integer>("id"));
        tasktitleColumn.setCellValueFactory(new PropertyValueFactory<Tasks,String>("tasktitle"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<Tasks,String>("deadline"));
        taskdetailColumn.setCellValueFactory(new PropertyValueFactory<Tasks,String>("taskdetail"));
        userColumn.setCellValueFactory(new PropertyValueFactory<Tasks,Integer>("user"));

        TableView.setItems(list);
    }

        // Buttons
    public void addButton() {

        String query = null;
        try {
            query = "insert into Tasks values("+id.getText()+",'" + tasktitle.getText()+"','"+deadline.getValue()+"','"+taskdetails.getText()+"',"+queryOutput.getString(5) +");";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //String query = "insert into tasks value(8,'Angtry','try', 'try', '1');";
        executeQuery(query);
        showtasks();

        /*    String username = nameTextField.getText();


        String connectQuery = "select * from tasks;";
        String AddQuery = "insert into tasks value(1,1,'JavaFX',curdate());";

        String listQuery = "select task_name from tasks;";
        try{
            Statement statement = connectiontask.createStatement();
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

    public void deleteButton()  {
        String query = "DELETE FROM tasks WHERE task_id="+id.getText()+"";
        executeQuery(query);
        showtasks();
    }
    public void updateButton()  {
        String query = "UPDATE Tasks SET task_title='" + tasktitle.getText() + "', task_Deadline ='" + deadline.getValue()+ "', task_detail='" + taskdetails.getText() +"' WHERE task_id =" + id.getText()+ ";";
        executeQuery(query);
        showtasks();
    }
    public void cleartextfield(){
                id.setText(null);
                tasktitle.setText(null);
                deadline.setValue(null);
                taskdetails.setText(null);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void logout(ActionEvent logout) throws IOException {
        System.out.println("logout");
        root = FXMLLoader.load(getClass().getResource("loginD.fxml"));
        stage = (Stage) ((Node) logout.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public void initialize(URL location, ResourceBundle resources) {
            showtasks();

    }













}