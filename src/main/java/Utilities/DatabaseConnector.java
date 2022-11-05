package Utilities;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnector extends Utils{


    static String dbUrl = "jdbc:oracle:thin:@10.50.11.209:1521:DEVDB";
    static String username = "PSSQA5";
    static String password = "pssQA9630";
    static Connection dbConnection;

    static {
        try {
            dbConnection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Statement runSQL;

    static {
        try {
            runSQL = dbConnection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DatabaseConnector() throws FileNotFoundException {
    }


    public static String getuserName () throws SQLException {
        String query = "select * from t_user where user_id = 19687";
        ResultSet queryResult = runSQL.executeQuery(query);
        queryResult.next();
        String userName = queryResult.getString("login_name");
        System.out.println(queryResult.getString("login_name"));
        return userName;
    }
}
