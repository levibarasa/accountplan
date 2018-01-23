/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.servlet;

/**
 *
 * @author Levi
 */ 
import com.inm.web.client.ClientW;
import com.inm.web.user.Accessw;
import com.inm.web.user.Userw;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class apServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog("origlogger");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mod = request.getParameter("MOD");
        String act = request.getParameter("ACT");
        switch (mod) {
            case "BOK":
                switch (act) {
                    // client info
                    case "doGetClient":
                        ClientW.handleGetAllClients(request, response);
                        break;
                    case "doAddClient":
                        ClientW.handleAddClient(request, response);
                        break;
                    case "doUpdateClient":
                        ClientW.handleUpdateClient(request, response);
                        break;
                    case "doLog":
                        Accessw.handleLogin(request, response);
                        break;
                    case "dochC":
                        Userw.changePwd(request, response);
                        break;
                    case "chC":
                        Userw.navChangePss(request, response);
                        break;
                    
//                    case "gorpt":
//                        Reports.goReport(request, response);
//                        break;

                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
