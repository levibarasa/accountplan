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
}
