package sample.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.SQLiteConnection;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class AddCustomerModel {


    public void AddCustomer(String name, String surname, String phone, String email) throws SQLException {


        Connection connection = SQLiteConnection.Connector();
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO customer(name,surname,phone,email) VALUES(?,?,?,?)";
        try {

            assert connection != null;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }


    }

}
