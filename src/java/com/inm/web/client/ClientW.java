/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.web.client;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inm.dao.client.Client;
import static com.inm.dao.client.Client.getClientInfo;
import com.inm.models.ClientModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
/**
 *
 * @author Levi
 */
public class ClientW {
        public static void handleGetAllClients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
             PrintWriter out = response.getWriter();
            ArrayList<ClientModel> list = getClientInfo("242");
         Gson gson = new Gson();
         Type type = new TypeToken<ArrayList<ClientModel>>() {}.getType(); 
                String json = gson.toJson(list, type);
               // System.out.println(json);
        out.print(json);
                
        }
        public static void handleAddClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
            HttpSession session = request.getSession(false); 
            String contextPath = request.getContextPath();
             String clientname = request.getParameter("clientnamea");
        String rmCode = request.getParameter("rmCodea");
        String altrmCode = request.getParameter("altrmCodea");
        String affiliate = request.getParameter("affiliatea");
        String currentdate = request.getParameter("currentdatea");
        String tradesp = request.getParameter("tradespa");
        String cashmp = request.getParameter("cashmpa");
        String ebankp = request.getParameter("ebankpa");
        String riskmp = request.getParameter("riskmpa");   
        String uname = request.getParameter("uname");
            System.out.println(clientname+" "+rmCode+" "+altrmCode+" "+affiliate+" "+tradesp+" "+cashmp+" "+ebankp+" "+riskmp);
        ClientModel clientModel = new ClientModel();
        clientModel.setAffiliateId(affiliate);
        clientModel.setAlternative_RM_Code(altrmCode);
        clientModel.setCashManagementPartner(cashmp);
        clientModel.setClientName(clientname);
        clientModel.setClient_Category("");
        clientModel.setCurrent_Date(currentdate);
        clientModel.setE_BankingPartner(ebankp);
        clientModel.setRM_Code(rmCode);
        clientModel.setRiskManagementPartner(riskmp);
        clientModel.setTradeServiceProvider(tradesp);
        String user = (String) session.getAttribute("uname");
            System.out.println("username:"+user);
         if ( user != null) {

           Client.createClient(clientModel);

            session.setAttribute("content_page", contextPath+"/client/clientinfo.jsp");
            session.setAttribute("uname", uname);
            // session.setAttribute("rmCode", rmCode);
            response.sendRedirect(contextPath+"/client/clientinfo.jsp");

        } else {
            session.setAttribute("content_page", contextPath+"/client/clientinfo.jsp");
        }
        //  session.setAttribute("content_page", "populatelist.jsp");
        //response.sendRedirect("weeklycalllist.jsp");
       
           
        }
        public static void handleUpdateClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);

        String custId = request.getParameter("custId");

        if ((String) session.getAttribute("uname") != null) {
//            String rmCode = request.getParameter("rmCode");
//
//            Customer.createNewExistingCustomer(custId, rmCode);
//
//            session.setAttribute("content_page", "weeklycalllist.jsp");
//            session.setAttribute("uname", rmCode);
//            // session.setAttribute("rmCode", rmCode);
//            response.sendRedirect("weeklycalllist.jsp");

        } else {
            session.setAttribute("content_page", "weeklycalllist.jsp");
        }
        //  session.setAttribute("content_page", "populatelist.jsp");
        //response.sendRedirect("weeklycalllist.jsp");
                
        }
}
