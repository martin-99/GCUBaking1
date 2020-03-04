package sample.Model;

import sample.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
        // Create instance of our Connection class
        Connection connection;

public LoginModel(){
        //runnig methot connector to connect to db
        connection = SQLiteConnection.Connector();
        if (connection==null)System.exit(1);
        }

        //Checking if our db is closed and  returning the opposite
public boolean isDbConnected() {
        try {
        return !connection.isClosed();

        } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
        }
        /*
          isLogin is our main method
          @params
          user and pass are our username and password from our Login scene form
          PreparedStatement is pre build class in JDBC package which contains methods as execute
          our variable query contains string with sqlite query in this case we select every row of our
          employee table where username and password are equal to our parameter variables
          then execute the query and if there are rows with these parameters we return true

          In finally statement we close our prepareted statment and result set in order to use our db
          in other part of our application

         */
public boolean isLogin(String user,String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
        try{
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2,pass);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
        return true;
        }
        else {
        return false;
        }
        }catch (Exception e){
        return false;
        }finally {
                preparedStatement.close();
                resultSet.close();
        }
        }
        }
