package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Model.AddStudentModel;

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
}
