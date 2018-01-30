/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 *
 * @author Levi
 */
public class APProp {
     Properties prop;

    public APProp() {
    }

    public Properties getDBProperty() {
        prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream url = classLoader.getResourceAsStream("com/inm/prop/ApProp.properties");
            prop.load(url);
        } catch (IOException asd) {
            System.out.println(asd.getMessage());
        }
        return prop;
    }
        public String getDatabaseUrl() {
      //  String url = prop.getProperty("database.url");
        return "jdbc:oracle:thin";
    }

    public String getDataBaseDriver() {
      //  String driver = prop.getProperty("database.driver");
        return "oracle.jdbc.driver.OracleDriver";
    }

    public String getDatabaseHost() {
        //String host = prop.getProperty("database.host");
        return "192.168.205.71";
    }

    public String getDatabasePort() {
       // String port = prop.getProperty("database.port");
        return "1521";
    }

    public String getDatabaseSid() {
      //  String sid = prop.getProperty("database.sid");
        return "NTRFC";
    }

    public String getDatabaseUser() {
      //  String user = prop.getProperty("database.user");
        return "accplan";
    }

    public String getDatabasePassWord() {
        //String pass = prop.getProperty("database.pass");
        return "accplan";
    }
}
