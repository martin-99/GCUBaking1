package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    /**
     *
     * @param event
     * @throws IOException
     */
@FXML
public void SignOut(ActionEvent event) throws IOException {
    try {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane scene = loader.load(getClass().getResource("Login.fxml").openStream());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
       
    }catch (Exception e){
       e.printStackTrace();
    }

}
public void AddStudent(ActionEvent event) throws IOException {
    ((Node)event.getSource()).getScene().getWindow().hide();
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    loader.setRoot(new AnchorPane());

    Pane scene = loader.load(getClass().getResource("src/sample/AddStudent.fxml").openStream());
    primaryStage.setTitle("Add Student");
    primaryStage.setScene(new Scene(scene));
    primaryStage.show();
}

}
