package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Model.AddCustomerModel;

import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerController {
    @FXML
    TextField studentName;
    @FXML
    TextField studentSurname;
    @FXML
    TextField studentPhone;
    @FXML
    TextField studentEmail;
    @FXML
    Button succesBtn;


    public void AddCustomer(ActionEvent actionEvent) throws SQLException {
        AddCustomerModel studentModel = new AddCustomerModel();
        studentModel.AddCustomer(studentName.getText(),studentSurname.getText(),studentPhone.getText(),studentEmail.getText());

        studentName.setText("");
        studentSurname.setText("");
        studentPhone.setText("");
        studentEmail.setText("");





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

    public void ViewCustomer(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane scene = loader.load(getClass().getResource("/sample/View/ViewCustomers.fxml").openStream());
        primaryStage.setTitle("View Customer");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }
}
