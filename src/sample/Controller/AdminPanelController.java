package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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

//    public void logout() throws IOException {
//        Stage primaryStage = new Stage();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setRoot(new AnchorPane());
//        Pane root = loader.load(getClass().getResource("Login.fxml").openStream());
//        AdminPanelController adminPanelController = (AdminPanelController)loader.getController();
//        primaryStage.setTitle("GCUBaking Log in");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }

}
