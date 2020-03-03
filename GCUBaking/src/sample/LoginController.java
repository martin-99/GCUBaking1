package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import sample.LoginModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class LoginController implements Initializable {
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
        // Check if db is connected
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }
        else {
            isConnected.setText("Not connected");
        }

    }
    @FXML
    public void Login(ActionEvent event) {
        try {
            if (loginModel.isLogin(username.getText(), password.getText())) {


          isConnected.setText("Correct username and password");
          isConnected.setStyle("-fx-background-color: #2196F3");

          ((Node)event.getSource()).getScene().getWindow().hide();
          Stage primaryStage = new Stage();
           FXMLLoader loader = new FXMLLoader();
           loader.setRoot(new AnchorPane());
           Pane scene = loader.load(getClass().getResource("Admin.fxml").openStream());
          AdminPanelController adminPanelController = (AdminPanelController)loader.getController();
           primaryStage.setTitle("Admin Panel");
           primaryStage.setScene(new Scene(scene));
           primaryStage.show();






            } else {
               isConnected.setText("Wrong username and/or password ");
               isConnected.setStyle("-fx-background-color: #f52323");
               isConnected.setTextFill(Paint.valueOf("white"));


            }
        }catch (SQLException e){
            isConnected.setText("Username and password is not correct");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void Loggin(){
        System.out.println("d");
    }
}
