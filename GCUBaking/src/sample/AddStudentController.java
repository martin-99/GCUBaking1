package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class AddStudentController {

    @FXML
    TextField studentName;

    @FXML
    TextField studentSurname;

    @FXML
    TextField studentPhone;
    @FXML
    TextField studentEmail;







    public void  AddCustomer(ActionEvent event) throws SQLException {
        Connection connection  = SQLiteConnection.Connector();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO student(name,surname,phone,email)\nVALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentName.getText());
            preparedStatement.setString(2, studentSurname.getText());
            preparedStatement.setString(1, studentPhone.getText());
            preparedStatement.setString(2, studentEmail.getText());
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e){

            e.printStackTrace();

        }






    }
}
