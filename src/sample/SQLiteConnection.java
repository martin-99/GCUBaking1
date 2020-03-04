package sample;

import java.sql.Connection;
import java.sql.*;
public class SQLiteConnection {
    // Create method that returns Connection sql packet
public static Connection Connector(){
    try {
        //Connect to the Database
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:src/sample/database/GCUBaking.db");
        return conn;

    }catch (Exception e){
        System.out.println(e);
        return null;

    }


}

}
