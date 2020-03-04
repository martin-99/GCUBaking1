package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import sample.Customer;
import sample.SQLiteConnection;

public class ViewCustomersController implements Initializable {
    @FXML
    TableView<Customer> customerTable;
    TableColumn<Customer,Integer> customerId;
    TableColumn<Customer,String> customerName;
    TableColumn<Customer,String> customerSurname;
    TableColumn<Customer,String> customerPhone;
    TableColumn<Customer,String> customerEmail;
    ObservableList<Customer> customers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = SQLiteConnection.Connector();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM  student;");
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("phone"),resultSet.getString("email")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        customerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerTable.setItems(customers);




    }
}
