/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.ap.conn;

/**
 *
 * @author Levi
 */
import com.inm.prop.APProp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    Connection conn;
    APProp pr;

    public DBConnection() {
        pr = new APProp();
    }

    public Connection getDbConnection() {
        try {
            Class.forName(pr.getDBProperty().getProperty("database.driver"));
            String driver = pr.getDBProperty().getProperty("database.driver");
            String url = pr.getDBProperty().getProperty("database.url");
            String host = pr.getDBProperty().getProperty("database.host");
            String port = pr.getDBProperty().getProperty("database.port");
            String sid = pr.getDBProperty().getProperty("database.sid");
            String userName = pr.getDBProperty().getProperty("database.user");
            String pass = pr.getDBProperty().getProperty("database.pass");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.205.71:1521:INTRFC", userName, pass);
           
        } catch (ClassNotFoundException | SQLException asd) {
            System.err.println(asd.getMessage());
        }
        return conn;
    }

    public static void closeConn(Connection con) {
        if (con != null) {
        }
    }

//    public static void main(String[] args) {
//        DBConnection bConnection = new DBConnection();
//        if (bConnection.getDbConnection() != null) {
//            System.out.println("Connected");
//        } else {
//
//            System.out.println("Not Connected");
//        }
//     }
}
