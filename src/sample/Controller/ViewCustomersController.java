package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Customer;
import sample.SQLiteConnection;

public class ViewCustomersController implements Initializable {
    @FXML
    TableView<Customer> customerTable;
    @FXML
    TableColumn<Customer,String> customerId;
    @FXML
    TableColumn<Customer,String> customerName;
    @FXML
    TableColumn<Customer,String> customerSurname;
    @FXML
    TableColumn<Customer,String> customerPhone;
    @FXML
    TableColumn<Customer,String> customerEmail;
    ObservableList<Customer> customers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = SQLiteConnection.Connector();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM  customer;");
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("phone"),resultSet.getString("email")));
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
    @FXML
    public void AddCustomer(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane scene = loader.load(getClass().getResource("/sample/View/AddCustomer.fxml").openStream());
        primaryStage.setTitle("Add Customer");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();
    }
    @FXML
    public void goBack(javafx.event.ActionEvent event) throws IOException {
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

    public void AddCustomer(javafx.event.ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane scene = loader.load(getClass().getResource("/sample/View/AddCustomer.fxml").openStream());
        primaryStage.setTitle("Add Customer");
        primaryStage.setScene(new Scene(scene));
        primaryStage.show();

    }
}
