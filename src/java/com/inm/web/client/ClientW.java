/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.web.client;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inm.dao.client.*; 
import com.inm.dao.valuechain.*;
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
import java.math.BigDecimal;
import java.lang.*;
import java.math.RoundingMode;
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
        String grpnamea = request.getParameter("grpnamea");
        String indrustrya = request.getParameter("indrustrya");
        String uname = request.getParameter("uname");
        String hqcountrya = request.getParameter("hqcountrya"); 
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
        
         public static void handleAddCreditInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
         CreditInfo crInfo = new CreditInfo();
        String contextPath = request.getContextPath(); 
        String ratingagencya = request.getParameter("ratingagencya");
        String riskratinga = request.getParameter("riskratinga");
        String outstandingamta = request.getParameter("outstandingamta");
        String approvedlinesa = request.getParameter("approvedlinesa");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+approvedlinesa+" "+outstandingamta+" "+riskratinga+" "+ratingagencya);
        CreditInfoModel creditInfoModel = new CreditInfoModel(); 
        creditInfoModel.setClientMaster(clientnamea); 
        creditInfoModel.setApprovedlines(approvedlinesa);
        creditInfoModel.setCreditid(100);
        creditInfoModel.setOutstandingamount(new BigDecimal(outstandingamta));
        creditInfoModel.setRatingagency(ratingagencya);
        creditInfoModel.setRiskrating(riskratinga);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          crInfo.createCreditInformation(creditInfoModel);
       session.setAttribute("content_page", contextPath+"/client/creditinfo.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/creditinfo.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/creditinfo.jsp");
        } 
        }
          public static void handleAddCreditFinancial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        ClientFinacial cf = new ClientFinacial();
        String contextPath = request.getContextPath();
        String cashflowcyclea = request.getParameter("cashflowcyclea");
        String geeringratioa = request.getParameter("geeringratioa"); 
        String totaldeposita = request.getParameter("totaldeposita");
        String totaldebta = request.getParameter("totaldebta");
        String operatingprofta = request.getParameter("operatingprofta");
        String trunovera = request.getParameter("trunovera");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+trunovera+" "+operatingprofta+" "+totaldebta+" "+totaldeposita+" "+geeringratioa);
        ClientFinacialModel cfmodel = new ClientFinacialModel(); 
        cfmodel.setClientMaster(clientnamea); 
        cfmodel.setCashflowcycle(new BigDecimal(cashflowcyclea));
        cfmodel.setClientFinancialid(100);
        cfmodel.setGearingratio(new BigDecimal(geeringratioa));
        cfmodel.setOperatingprofit(new BigDecimal(operatingprofta));
        cfmodel.setTotaldebt(new BigDecimal(totaldebta));
        cfmodel.setTotaldeposits(new BigDecimal(totaldeposita));
        cfmodel.setTurnover(new BigDecimal(trunovera));
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          cf.createClientFinacial(cfmodel);
       session.setAttribute("content_page", contextPath+"/client/creditfinacial.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/creditfinacial.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/creditfinacial.jsp");
        } 
        }
           public static void handleAddClientCoverage(HttpServletRequest request, HttpServletResponse response)
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
      public static void handleAddCompetition(HttpServletRequest request, HttpServletResponse response)
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
      public static void handleAddDealInProgress(HttpServletRequest request, HttpServletResponse response)
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
       public static void handleAddQualitativeInfo(HttpServletRequest request, HttpServletResponse response)
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
     public static void handleAddSaleActionPlan(HttpServletRequest request, HttpServletResponse response)
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
      public static void handleAddClientEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        ClientEmployeeMaster cem = new ClientEmployeeMaster();
        String contextPath = request.getContextPath();
        String contactpersona = request.getParameter("contactpersona");
        String phonea = request.getParameter("phonea");
        String emaila = request.getParameter("emaila");
        String locationa = request.getParameter("locationa");
        String segmenta = request.getParameter("segmenta");
        String noofemployeea = request.getParameter("noofemployeea");
        String employeenoallbanksa = request.getParameter("employeenoallbanksa");
        String employeenoinma = request.getParameter("employeenoinma");
        String targetemployeenoinma = request.getParameter("targetemployeenoinma");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+targetemployeenoinma+" "+segmenta+" "+employeenoinma+" "+locationa+" "+emaila);
        ClientEmployeeModel clientEmpModel = new ClientEmployeeModel();
        clientEmpModel.setClientEmployeeContactperson(contactpersona);
        clientEmpModel.setClientEmployeeEmail(emaila);
        clientEmpModel.setClientEmployeeLocation(locationa);
        clientEmpModel.setClientEmployeePhonenumber(phonea);
        clientEmpModel.setClientMaster(clientnamea);
        clientEmpModel.setClientemployeeid(100);
        clientEmpModel.setLookupmaster(segmenta);
        clientEmpModel.setNoofbankedemployeesallbanks(employeenoallbanksa);
        clientEmpModel.setNoofbankedemployeeswithim(employeenoinma);
        clientEmpModel.setNoofemployees(noofemployeea);
        clientEmpModel.setTargetnoofemployeesbyim(targetemployeenoinma);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          cem.createClientEmployee(clientEmpModel);
       session.setAttribute("content_page", contextPath+"/client/clientemployee.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/clientemployee.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/clientemployee.jsp");
        } 
        }
       public static void handleAddKeyDistributor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        KeyDistributor kd = new KeyDistributor();
        String contextPath = request.getContextPath();
        String commenta = request.getParameter("commenta");
        String rmCodea = request.getParameter("rmCodea");
        String bankedbyima = request.getParameter("bankedbyima");
        String volofbusinessa = request.getParameter("volofbusinessa");
        String locationa = request.getParameter("locationa");
        String phonea = request.getParameter("phonea");
        String segmenta = request.getParameter("segmenta");
        String emaila = request.getParameter("emaila");
        String contactpersona = request.getParameter("contactpersona");
        String kdandclienta = request.getParameter("kdandclienta");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+contactpersona+" "+segmenta+" "+emaila+" "+locationa+" "+commenta);
        KeyDistributorModel keyDistributorModel = new KeyDistributorModel(); 
        keyDistributorModel.setBankedbyim(bankedbyima);
        keyDistributorModel.setClientMaster(clientnamea);
        keyDistributorModel.setClientturnover(BigDecimal.ZERO);
        keyDistributorModel.setComments(commenta);
        keyDistributorModel.setKdContactperson(contactpersona);
        keyDistributorModel.setKdEmail(emaila);
        keyDistributorModel.setKdLocation(locationa);
        keyDistributorModel.setKdPhonenumber(phonea);
        keyDistributorModel.setKdandclients(kdandclienta);
        keyDistributorModel.setKdid(100);
        keyDistributorModel.setLookupmaster(segmenta);
        keyDistributorModel.setVolofbusnskdandclient(new BigDecimal(volofbusinessa));
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          kd.createKeyDistributor(keyDistributorModel);
       session.setAttribute("content_page", contextPath+"/client/keydistributor.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/keydistributor.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/keydistributor.jsp");
        } 
        }
       public static void handleAddKeySupplier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        KeySupplier ks = new KeySupplier();
        String contextPath = request.getContextPath();
        String commenta = request.getParameter("commenta");
        String phonea = request.getParameter("phonea");
        String bankedbyima = request.getParameter("bankedbyima");
        String volofbusinessa = request.getParameter("volofbusinessa");
        String locationa = request.getParameter("locationa");
        String emaila = request.getParameter("emaila");
        String segmenta = request.getParameter("segmenta");
        String contactpersona = request.getParameter("contactpersona"); 
        String ksnamea = request.getParameter("ksnamea");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+ksnamea+" "+segmenta+" "+contactpersona+" "+emaila+" "+commenta);
       
            KeySupplierModel keySupplierModel = new KeySupplierModel(); 
            keySupplierModel.setBankedbyim(bankedbyima);
            keySupplierModel.setClientMaster(clientnamea);
            keySupplierModel.setComments(commenta);
            keySupplierModel.setKsContactperson(contactpersona);
            keySupplierModel.setKsEmail(emaila);
            keySupplierModel.setKsLocation(locationa);
            keySupplierModel.setKsPhonenumber(phonea);
            keySupplierModel.setKsid(100);
            keySupplierModel.setKsname(ksnamea);
            keySupplierModel.setLookupmaster(segmenta);
            keySupplierModel.setVolofbusiness(volofbusinessa);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          ks.createKeySupplier(keySupplierModel);
       session.setAttribute("content_page", contextPath+"/client/keysupplier.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/keysupplier.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/keysupplier.jsp");
        } 
        }
       public static void handleAddSignOff(HttpServletRequest request, HttpServletResponse response)
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
    public static void handleAddCFOpportunity(HttpServletRequest request, HttpServletResponse response)
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
      public static void handleAddOClientWalletSize(HttpServletRequest request, HttpServletResponse response)
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
      public static void handleAddAccountRevenue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        AccountRevenue ar = new AccountRevenue();
        String contextPath = request.getContextPath();
        String totidoppa = request.getParameter("totidoppa");
        String totwalshra = request.getParameter("totwalshra");
        String curwalletshra = request.getParameter("curwalletshra"); 
        String priyractfeea = request.getParameter("priyractfeea");
        String curyrfeetarga = request.getParameter("curyrfeetarga");
        String priyractreva = request.getParameter("priyractreva");
        String curyrrevtarga = request.getParameter("curyrrevtarga");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+totwalshra+" "+curwalletshra+" "+priyractfeea+" "+curyrfeetarga+" "+curyrfeetarga);
        AccountRevenueModel armodel = new AccountRevenueModel();
        armodel.setAccountRevenueid(100);
        armodel.setClientMaster(clientnamea);
        armodel.setCurrentshareofwallet(new BigDecimal(curwalletshra));
        armodel.setCurrentyearfeeincometarget(new BigDecimal(curyrfeetarga));
        armodel.setCurrentyearrevenuetarget(new BigDecimal(curyrrevtarga));
        armodel.setPercentagegrowthfeeincome(new BigDecimal(curwalletshra));
        armodel.setPrioryearactualfeeincome(new BigDecimal(priyractfeea));
        armodel.setPrioryearactualrevenue(new BigDecimal(priyractreva));
        armodel.setTargetshareofwallet(new BigDecimal(totwalshra));
        armodel.setTotalvalueofidopportunities(new BigDecimal(totidoppa));
        armodel.setPercentagegrowthfeeincome(new BigDecimal(curyrfeetarga).divide(new BigDecimal(priyractfeea), 3, RoundingMode.CEILING));
        armodel.setPercentagegrowthrevenue(new BigDecimal(curyrrevtarga).divide(new BigDecimal(priyractreva), 3, RoundingMode.CEILING));
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) { 
             ar.createAccountRevenue(armodel);
       session.setAttribute("content_page", contextPath+"/client/accountrevenueinfo.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/accountrevenueinfo.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/accountrevenueinfo.jsp");
        } 
        }
}
