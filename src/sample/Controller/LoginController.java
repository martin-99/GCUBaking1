package sample.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import sample.Controller.AdminPanelController;
import sample.Model.LoginModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class LoginController implements Initializable {

    /*
     In following rows we create instance of each element of our Log in form
     such as username,password
     We will use the logic from the LoginModel class
     to check if Database is connected
     and if there are users with username and password provided in our Log in form
     */

    @FXML
    AnchorPane rootPane;
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Check if db is connected
           and if it is the our label will print message
           Connected if not will execute else statement
         */
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }
        else {
            isConnected.setText("Not connected");
        }

    }
    /*
    Following method receives ActionEvent
    then will check if the result of method isLogin in the  instance of LoginModel
    returns true with parameters username and password from Log in scene

    If it returns true will execute our if statement and will change our Scene
    closing Log in Scene

    if not Label will change it's colour and text
     */
    @FXML
    public void Login(ActionEvent event) {
        try {
                    if (loginModel.isLogin(username.getText(), password.getText())) {
                        isConnected.setText("Correct username and password");
                        isConnected.setStyle("-fx-background-color: #2196F3");

                        ((Node) event.getSource()).getScene().getWindow().hide();
                        Stage primaryStage = new Stage();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setRoot(new AnchorPane());
                        Pane scene = loader.load(getClass().getResource("/sample/View/Admin.fxml").openStream());
                        AdminPanelController adminPanelController = (AdminPanelController) loader.getController();
                        primaryStage.setTitle("Admin Panel");
                        primaryStage.setScene(new Scene(scene));
                        primaryStage.show();




                    } else {
                        isConnected.setText("Wrong username and/or password ");
                        isConnected.setStyle("-fx-background-color: #f52323");
                        isConnected.setTextFill(Paint.valueOf("white"));
                        password.setText("");
                    }

            }catch(SQLException e){
                isConnected.setText("Username and password is not correct");
                System.out.println("it stays in catch");
                e.printStackTrace();

            } catch(IOException e){
                e.printStackTrace();
            }



    }
    public void Loggin(){
        System.out.println("d");
    }
}
