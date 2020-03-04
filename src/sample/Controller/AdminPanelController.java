package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class
AdminPanelController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

   
    /*
    Following method will change our Scene to Login in Action event to our button
     */
@FXML
public void SignOut(ActionEvent event) throws IOException {
    try {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane scene = loader.load(getClass().getResource("/sample/View/Login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }catch (Exception e){
       e.printStackTrace();
    }

}

    /*
       Following method will change our Scene to AddCustomer event to our button
        */
public void AddCustomer(ActionEvent event) throws IOException {
    ((Node)event.getSource()).getScene().getWindow().hide();
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader();


    Pane scene = loader.load(getClass().getResource("/sample/View/AddCustomer.fxml").openStream());
    primaryStage.setTitle("Add Student");
    primaryStage.setScene(new Scene(scene));
    primaryStage.show();
}

}
