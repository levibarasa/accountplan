/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.web.client;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inm.dao.client.*; 
import com.inm.models.*;
import java.io.IOException;
import java.lang.reflect.Type; 
import java.util.ArrayList;
import java.util.Date; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
import java.io.PrintWriter; 
/**
 *
 * @author Levi
 */
public class ClientW {
        public static void handleGetAllClients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
            Client client = new Client();
             PrintWriter out = response.getWriter();
            ArrayList<ClientModel> list = client.getClientInfo("242");
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
            Client cl = new Client();
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
        clientModel.setAffiliate(affiliate);
        clientModel.setAlternativeRmCode(altrmCode);
        clientModel.setCashmanagementpartner(cashmp);
        clientModel.setClientname(clientname); 
        clientModel.setCurrentDate(new Date());
        clientModel.setEBankingpartner(ebankp);
        clientModel.setRmCode(rmCode);
        clientModel.setRiskmanagementpartner(riskmp);
        clientModel.setTradeserviceprovider(tradesp);
        clientModel.setClientid("0");
        String user = (String) session.getAttribute("uname");
            System.out.println("username:"+user);
         if ( user != null) {

           cl.createClient(clientModel);

            session.setAttribute("content_page", contextPath+"/client/clientinfo.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/clientinfo.jsp");

        } else {
            session.setAttribute("content_page", contextPath+"/client/clientinfo.jsp");
        } 
  } 
        public static void handleAddCompany(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        Company co = new Company();
        String contextPath = request.getContextPath();
        String noofsubsidiarya = request.getParameter("noofsubsidiarya");
        String indrustrya = request.getParameter("indrustrya");
        String uname = request.getParameter("uname");
        String hqcountrya = request.getParameter("hqcountrya");
        String grpnamea = request.getParameter("grpnamea");
        String segmenta = request.getParameter("segmenta");
        String companyaddressa = request.getParameter("companyaddressa");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+companyaddressa+" "+segmenta+" "+grpnamea+" "+hqcountrya+" "+noofsubsidiarya);
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyid(100);
        companyModel.setGroupname(grpnamea);
        companyModel.setCompanyAddress(companyaddressa);
        companyModel.setNoofsubsidiaries(Integer.parseInt(noofsubsidiarya));
        companyModel.setClientMaster(clientnamea);
        companyModel.setLookupmasterByAffiliatelookupmasterid(hqcountrya);
        companyModel.setLookupmasterByIndustrylookupmasterid(indrustrya);
        companyModel.setLookupmasterBySegmentlookupmasterid(segmenta);
        String user = (String) session.getAttribute("uname");
            System.out.println("username:"+user);
         if ( user != null) {
          co.createCompany(companyModel);
       session.setAttribute("content_page", contextPath+"/client/companyinfo.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/companyinfo.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/companyinfo.jsp");
        } 
        }
}
