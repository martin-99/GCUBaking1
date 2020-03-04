package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Model.AddStudentModel;

import java.io.IOException;
import java.sql.SQLException;

public class AddStudentController {
    @FXML
    TextField studentName;
    @FXML
    TextField studentSurname;
    @FXML
    TextField studentPhone;
    @FXML
    TextField studentEmail;


    public void AddCustomer(ActionEvent actionEvent) throws SQLException {
        AddStudentModel studentModel = new AddStudentModel();
        studentModel.AddCustomer(studentName.getText(),studentSurname.getText(),studentPhone.getText(),studentEmail.getText());

    }
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setRoot(new AnchorPane());
        Pane scene = loader.load(getClass().getResource("/sample/View/Admin.fxml").openStream());
        AdminPanelController adminPanelController = (AdminPanelController) loader.getController();
        primaryStage.setTitle("Admin Panel");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }
}
