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
import com.inm.dao.qualitativeinformation.*;
import com.inm.models.*;
import com.inm.dao.walletresize.*;
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
import java.util.Random;
/**
 *
 * @author Levi
 */
public class ClientW {
    static Random ran = new Random();
    static int n = ran.nextInt(600000) + 5; 
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
//uname,clientnamea,rmCodea,altrmCodea,affiliatea,currentdatea,tradespa,
//cashmpa,ecommpa,credmana,treaspa,ibpa,afpa,cardspa,bancasspa 
             String clientname = request.getParameter("clientnamea");
        String rmCode = request.getParameter("rmCodea");
        String altrmCode = request.getParameter("altrmCodea");
        String affiliate = request.getParameter("affiliatea");
        String currentdate = request.getParameter("currentdatea");
        String tradesp = request.getParameter("tradespa");
        String cashmp = request.getParameter("cashmpa");
        String ecommpa = request.getParameter("ecommpa");
        String credmana = request.getParameter("credmana");
        String treaspa = request.getParameter("treaspa");
        String ibpa = request.getParameter("ibpa");
        String afpa = request.getParameter("afpa");
        String cardspa = request.getParameter("cardspa");
        String bancasspa = request.getParameter("bancasspa");
        String uname = request.getParameter("uname");
            System.out.println(clientname+" "+rmCode+" "+altrmCode+" "+affiliate+" "+tradesp+" "+cashmp+" "+ecommpa+" "+credmana);
        ClientModel clientModel = new ClientModel();
        clientModel.setAffiliate(affiliate);
        clientModel.setAlternativeRmCode(altrmCode);
        clientModel.setCashmanagementpartner(cashmp);
        clientModel.setClientname(clientname); 
        clientModel.setCurrentDate(new Date());
        clientModel.setRmCode(rmCode); 
        clientModel.setCashmanagementpartner(cashmp); 
        clientModel.setCreditmanager(credmana);
        clientModel.setTreasurypartner(treaspa);
        clientModel.setInternetbankingpartner(ibpa); 
        clientModel.setAssetfinancepartner(afpa);
        clientModel.setCardspartner(cardspa);
        clientModel.setECommercepartner(ecommpa);
        clientModel.setBancassurancepartner(bancasspa);
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
//uname,clientnamea,companyaddressa,grpnamea,hqcountrya,indrustrya,segmenta,noofsubsidiarya
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
        companyModel.setCompanyid(n);
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
         //riskratinga,alloutstandingamta,allapprovedlinesa,imoutstandingamta,imapprovedlinesa,clientnamea
        String contextPath = request.getContextPath(); 
        String imapprovedlinesa = request.getParameter("imapprovedlinesa");
        String imoutstandingamta = request.getParameter("imoutstandingamta");
        String riskratinga = request.getParameter("riskratinga");
        String alloutstandingamta = request.getParameter("alloutstandingamta");
        String allapprovedlinesa = request.getParameter("allapprovedlinesa");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+imapprovedlinesa+" "+imoutstandingamta+" "+riskratinga+" "+allapprovedlinesa);
        CreditInfoModel creditInfoModel = new CreditInfoModel(); 
        creditInfoModel.setClientMaster(clientnamea); 
        creditInfoModel.setApprovedlinesallbanks(allapprovedlinesa);
        creditInfoModel.setImapprovedlines(imapprovedlinesa); 
        creditInfoModel.setCreditid(n);
        creditInfoModel.setImoutstandingamount(new BigDecimal(imoutstandingamta));
        creditInfoModel.setOutstandingamountallbanks(new BigDecimal(alloutstandingamta));
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
        cfmodel.setClientFinancialid(n);
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
        ClientCoverageMaster ccm = new ClientCoverageMaster();
        String contextPath = request.getContextPath();
//nxtplanedcontactpurposa,nxtplanedcontacta,discussionsummarya,lastcontacta,rshpqltya,contacta,
//contactpositiona,contactnamea,clientnamea
         String nxtplanedcontactpurposa = request.getParameter("nxtplanedcontactpurposa");
        String nxtplanedcontacta = request.getParameter("nxtplanedcontacta");
        String discussionsummarya = request.getParameter("discussionsummarya");
        String lastcontacta = request.getParameter("lastcontacta");
        String rshpqltya = request.getParameter("rshpqltya");
        String contacta = request.getParameter("contacta");
        String contactpositiona = request.getParameter("contactpositiona");
        String contactnamea = request.getParameter("contactnamea");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+contactnamea+" "+contactpositiona+" "+contacta+" "+discussionsummarya+" "+rshpqltya);
        ClientCoverageModel clientCoverageModel = new ClientCoverageModel();
        clientCoverageModel.setClientcoverageprofileid(n); 
        clientCoverageModel.setClientMaster(clientnamea);
        clientCoverageModel.setClientofcerrnshipqlty(rshpqltya);
        clientCoverageModel.setClientofficercontact(contacta);
        clientCoverageModel.setClientofficerdiscussionsummary(discussionsummarya);
        clientCoverageModel.setClientofficerlastcontact(lastcontacta);
        clientCoverageModel.setClientofficername(contactnamea);
        clientCoverageModel.setClientofficernextplanedcontact(nxtplanedcontacta);
        clientCoverageModel.setClientofficernxtcntctpurpose(nxtplanedcontactpurposa);
        clientCoverageModel.setClientofficerposition(contactpositiona);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          ccm.createClientcoverageprofile(clientCoverageModel);
       session.setAttribute("content_page", contextPath+"/qualitativeinformation/clientcoverage.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/qualitativeinformation/clientcoverage.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/qualitativeinformation/clientcoverage.jsp");
        } 
        }
      public static void handleAddCompetition(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        CompetitionMaster compe = new CompetitionMaster();
        String contextPath =  request.getContextPath(); 
        String uname = request.getParameter("uname");
        String weaknessesa = request.getParameter("weaknessesa");
        String strengthsa = request.getParameter("strengthsa");
        String estimatedwalletsharea = request.getParameter("estimatedwalletsharea");
        String banka = request.getParameter("banka");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+banka+" "+estimatedwalletsharea+" "+strengthsa+" "+weaknessesa);
        CompetitionModel competitionModel = new CompetitionModel(); 
        competitionModel.setCompetitionid(n);
        competitionModel.setClientMaster(clientnamea);
        competitionModel.setBank(banka);
        competitionModel.setEstimatedwalletshare(estimatedwalletsharea);
        competitionModel.setStrengths(strengthsa);
        competitionModel.setWeaknesses(weaknessesa);
         uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
         compe.createCompetition(competitionModel);
       session.setAttribute("content_page", contextPath+"/qualitativeinformation/competition.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/qualitativeinformation/competition.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/qualitativeinformation/competition.jsp");
        } 
        }
      public static void handleAddDealInProgress(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        DealInProgressMaster dip = new DealInProgressMaster();
        String contextPath = request.getContextPath(); 
        String commenta = request.getParameter("commenta");
        String imexpectedrevenuea = request.getParameter("imexpectedrevenuea");
        String improjectedwalletsharea = request.getParameter("improjectedwalletsharea");
        String allbankswalletsizea = request.getParameter("allbankswalletsizea");
        String imdealamounta = request.getParameter("imdealamounta");
        String currentlyuseda = request.getParameter("currentlyuseda");
        String dealstagea = request.getParameter("dealstagea");
        String dealtypea = request.getParameter("dealtypea");
        String dealstatusa = request.getParameter("dealstatusa");
        String completionmontha = request.getParameter("completionmontha");
        String dealprobabilitya = request.getParameter("dealprobabilitya");
        String producta = request.getParameter("producta"); 
        String clientnamea = request.getParameter("clientnamea"); 
            System.out.println(clientnamea+" "+producta+" "+dealprobabilitya+" "+dealstatusa+" "+dealtypea+" "+currentlyuseda);
        DealProgressModel dipModel = new DealProgressModel(); 
        dipModel.setAllbankswalletsize(new BigDecimal(allbankswalletsizea));
        dipModel.setClientMaster(clientnamea);
        dipModel.setComments(commenta);
        dipModel.setCompletionmonthlookupid(Integer.parseInt(completionmontha));
        dipModel.setCurrentlyused(currentlyuseda);
        dipModel.setDealinprogressid(n);
        dipModel.setDealpropabilitylookupid(Integer.parseInt(dealprobabilitya));
        dipModel.setDealstagelookupmasterid(Integer.parseInt(dealstagea));
        dipModel.setDealstatuslookupmasterid(Integer.parseInt(dealstatusa));
        dipModel.setDealtypelookupmasterid(Integer.parseInt(dealtypea));
        dipModel.setImdealamount(new BigDecimal(imdealamounta));
        dipModel.setImexpectedrevenue(new BigDecimal(imexpectedrevenuea));
        dipModel.setImprojectedwalletshare(new BigDecimal(improjectedwalletsharea));
        dipModel.setProductlookupid(Integer.parseInt(producta));
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          dip.createDealInProgress(dipModel);
       session.setAttribute("content_page", contextPath+"/qualitativeinformation/dealsinprogress.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/qualitativeinformation/dealsinprogress.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/qualitativeinformation/dealsinprogress.jsp");
        } 
        }
       public static void handleAddQualitativeInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        QualitativeInfo qInfo = new QualitativeInfo();
        String contextPath = request.getContextPath();
         String rshpqltya = request.getParameter("rshpqltya");
        String specchallengesa = request.getParameter("specchallengesa");
        String opportunitiesa = request.getParameter("opportunitiesa");
        String clientwalletalloctnlogica = request.getParameter("clientwalletalloctnlogica");
        String clientstrategya = request.getParameter("clientstrategya"); 
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+clientstrategya+" "+opportunitiesa+" "+specchallengesa+" "+rshpqltya+" "+clientwalletalloctnlogica);
        QualitativeinformationModel qiModel = new QualitativeinformationModel(); 
        qiModel.setClientMaster(clientnamea);
        qiModel.setClientstrategy(clientstrategya);
        qiModel.setClientwalletalloctnlogic(clientwalletalloctnlogica);
        qiModel.setOpportunities(opportunitiesa);
        qiModel.setQinfoid(n);
        qiModel.setRelationshipquality(rshpqltya);
        qiModel.setSpecificchallenges(specchallengesa);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          qInfo.createQualitativeInfo(qiModel);
       session.setAttribute("content_page", contextPath+"/qualitativeinformation/qualitativeinfo.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/qualitativeinformation/qualitativeinfo.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/qualitativeinformation/qualitativeinfo.jsp");
        } 
        }
     public static void handleAddSaleActionPlan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        SaleActionPlan sap = new SaleActionPlan();
        String contextPath = request.getContextPath();
        //dateLinea,presponsibleforactiona,contactpersona,specificationa , clientnamea 
        String dateLinea = request.getParameter("dateLinea");
        String presponsibleforactiona = request.getParameter("presponsibleforactiona");
        String contactpersona = request.getParameter("contactpersona");
        String specificationa = request.getParameter("specificationa");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+specificationa+" "+contactpersona+" "+presponsibleforactiona+" "+dateLinea);
        SalesactionplanModel sapModel = new SalesactionplanModel(); 
        sapModel.setClientMaster(clientnamea);
        sapModel.setClocontactpersion(contactpersona);
        sapModel.setClodatelinedate(dateLinea);
        sapModel.setClopersonresponsibleforaction(presponsibleforactiona);
        sapModel.setSalesactionplanid(n);
        sapModel.setSpecification(specificationa);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          sap.createSaleActionPlan(sapModel);
       session.setAttribute("content_page", contextPath+"/qualitativeinformation/salesactionplan.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/qualitativeinformation/salesactionplan.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/qualitativeinformation/salesactionplan.jsp");
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
        clientEmpModel.setClientemployeeid(n);
        clientEmpModel.setLookupmaster(Integer.parseInt(segmenta));
        clientEmpModel.setNoofbankedemployeesallbanks(employeenoallbanksa);
        clientEmpModel.setNoofbankedemployeeswithim(employeenoinma);
        clientEmpModel.setNoofemployees(noofemployeea);
        clientEmpModel.setTargetnoofemployeesbyim(targetemployeenoinma);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          cem.createClientEmployee(clientEmpModel);
       session.setAttribute("content_page", contextPath+"/valuechain/clientemployee.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/valuechain/clientemployee.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/valuechain/clientemployee.jsp");
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
        keyDistributorModel.setKdid(n);
        keyDistributorModel.setLookupmaster(Integer.parseInt(segmenta));
        keyDistributorModel.setVolofbusnskdandclient(new BigDecimal(volofbusinessa));
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          kd.createKeyDistributor(keyDistributorModel);
       session.setAttribute("content_page", contextPath+"/valuechain/keydistributor.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/valuechain/keydistributor.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/valuechain/keydistributor.jsp");
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
            keySupplierModel.setKsid(n);
            keySupplierModel.setKsname(ksnamea);
            keySupplierModel.setLookupmaster(Integer.parseInt(segmenta));
            keySupplierModel.setVolofbusiness(volofbusinessa);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          ks.createKeySupplier(keySupplierModel);
       session.setAttribute("content_page", contextPath+"/valuechain/keysupplier.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/valuechain/keysupplier.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/valuechain/keysupplier.jsp");
        } 
        }
       public static void handleAddSignOff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        SignOffMaster som = new SignOffMaster();
        String contextPath = request.getContextPath(); 
        String headofcorporatesignoffa = request.getParameter("headofcorporatesignoffa");
        String rmsignoffa = request.getParameter("rmsignoffa");
        String uname = request.getParameter("uname"); 
        String clientnamea = request.getParameter("clientnamea");
        System.out.println(clientnamea+" "+uname+" "+rmsignoffa+" "+headofcorporatesignoffa);
        SignOffModel somModel = new SignOffModel(); 
        somModel.setClientMaster(clientnamea);
        somModel.setSignoffid(n);
        somModel.setHeadofcorporatesignoff(headofcorporatesignoffa);
        somModel.setRmsignoff(rmsignoffa);
        uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          som.createSignOff(somModel);
       session.setAttribute("content_page", contextPath+"/walletresizing/signoff.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/walletresizing/signoff.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/walletresizing/signoff.jsp");
        } 
        }
    public static void handleAddCFOpportunity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        CurrentAndFutureOpportunityMaster cfoMaster = new CurrentAndFutureOpportunityMaster();
        String contextPath = request.getContextPath(); 
        String esttotasseta = request.getParameter("esttotasseta");
        String imfeerateassetsa = request.getParameter("imfeerateassetsa");
        String esttotliabilitya = request.getParameter("esttotliabilitya");
        String imfeerateliabilitya = request.getParameter("imfeerateliabilitya");
        String projectedwalletsharea = request.getParameter("projectedwalletsharea");
        String iminterstmarginliabilitya = request.getParameter("iminterstmarginliabilitya");
        String feeincomeesttotliabilitya = request.getParameter("feeincomeesttotliabilitya");
        String imintrstmargina = request.getParameter("imintrstmargina");
        String assetesttotala = request.getParameter("assetesttotala");
        String producta = request.getParameter("producta");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+producta+" "+assetesttotala+" "+imintrstmargina+" "+esttotliabilitya+" "+iminterstmarginliabilitya);
        CurrentAndFutureOpportunityModel cfoModel = new CurrentAndFutureOpportunityModel(); 
        cfoModel.setAllbankswalletsizrevmanual(BigDecimal.TEN);
        cfoModel.setAssetestimatedtotal(new BigDecimal(assetesttotala));
        cfoModel.setAssetsfeeincome(BigDecimal.TEN);
        cfoModel.setAssetsnetinterestincome(BigDecimal.ZERO);
        cfoModel.setCafoppid(n);
        cfoModel.setClientMaster(clientnamea);
        cfoModel.setDealvolassets(BigDecimal.ZERO);
        cfoModel.setDealvolliabilities(BigDecimal.ZERO);
        cfoModel.setDealvolrevenue(BigDecimal.ONE);
        cfoModel.setDealvolumefees(BigDecimal.ZERO);
        cfoModel.setEstimatedtotalasset(BigDecimal.ZERO);
        cfoModel.setEstimatedtotalliability(BigDecimal.ZERO);
        cfoModel.setImassetaveragefeerate(BigDecimal.ZERO);
        cfoModel.setEstimatedtotalliability(BigDecimal.ZERO);
        cfoModel.setImassetaveragefeerate(BigDecimal.ZERO);
        cfoModel.setImaverageinterestmargin(new BigDecimal(imintrstmargina));
        cfoModel.setImavrgliabilityintrestmargin(BigDecimal.TEN);
        cfoModel.setImexpectedrevenue(BigDecimal.TEN);
        cfoModel.setImliabilityaveragefeerate(BigDecimal.ZERO);
        cfoModel.setImprojectedwalletshare(BigDecimal.ZERO);
        cfoModel.setImwalletsize(BigDecimal.ZERO);
        cfoModel.setIncometotalfee(new BigDecimal(feeincomeesttotliabilitya));
        cfoModel.setLiabilityestimatedtotal(BigDecimal.ZERO);
        cfoModel.setLiabilityfeeincome(BigDecimal.TEN);
        cfoModel.setLiabilitynetinterestincome(BigDecimal.ZERO);
        cfoModel.setLookupmaster(Integer.parseInt(producta));
        cfoModel.setPercentwalletsharemanual(BigDecimal.TEN);
        cfoModel.setTotalnetinterestincome(BigDecimal.ZERO);
        cfoModel.setImexpectedrevenue(BigDecimal.TEN);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          cfoMaster.createCurrentAndFutureOpportunity(cfoModel);
       session.setAttribute("content_page", contextPath+"/walletresizing/currentandfutureopportunities.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/walletresizing/currentandfutureopportunities.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/walletresizing/currentandfutureopportunities.jsp");
        } 
        }
      public static void handleAddOClientWalletSize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        OverallClientWalletSizeMaster ocwsm = new OverallClientWalletSizeMaster();
        String contextPath = request.getContextPath();
 // imincomeinteresta , avgimmargindepositsa , imavgloanmargina , clientnamea 
        String imincomeinteresta = request.getParameter("imincomeinteresta");
        String avgimmargindepositsa = request.getParameter("avgimmargindepositsa");
        String imavgloanmargina = request.getParameter("imavgloanmargina");
        String clientnamea = request.getParameter("clientnamea");
            System.out.println(clientnamea+" "+imavgloanmargina+" "+avgimmargindepositsa+" "+imincomeinteresta);
        OverallClientWalletSizeModel ocwsModel = new OverallClientWalletSizeModel(); 
        ocwsModel.setAssetsinterestincome(BigDecimal.ZERO);
        ocwsModel.setAverageimdepositmargin(new BigDecimal(avgimmargindepositsa));
        ocwsModel.setClientMaster(clientnamea);
        ocwsModel.setClientbankingwallet(BigDecimal.ONE);
        ocwsModel.setClientwalletsizeid(n);
        ocwsModel.setEstimatedcorporatedeposits(BigDecimal.ZERO);
        ocwsModel.setEstimatedwalletshare(BigDecimal.ZERO);
        ocwsModel.setImfeeincome(BigDecimal.ZERO);
        ocwsModel.setImrevenue(BigDecimal.ONE);
        ocwsModel.setNetintrstliabltyincome(BigDecimal.ZERO);
        ocwsModel.setTotalcorporatedebt(BigDecimal.ZERO);
        ocwsModel.setTotalfeeincome(BigDecimal.ONE);
        ocwsModel.setTotalnetinterestincome(BigDecimal.ZERO);
        ocwsModel.setTotalnii(BigDecimal.ONE);
        String uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
         ocwsm.createOverallClientWalletSize(ocwsModel);
       session.setAttribute("content_page", contextPath+"/walletresizing/overallclientwalletsize.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/walletresizing/overallclientwalletsize.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/walletresizing/overallclientwalletsize.jsp");
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
        armodel.setAccountRevenueid(n);
        armodel.setClientMaster(clientnamea);
        armodel.setCurrentshareofwallet(new BigDecimal(curwalletshra));
        armodel.setCurrentyearnfitarget(new BigDecimal(curyrfeetarga));
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
      public static void handleAddWalletSize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        WalletResizeMaster wrm = new WalletResizeMaster();
        String contextPath = request.getContextPath();  
        String interstratea = request.getParameter("interstratea");
        String processfeeratea = request.getParameter("processfeeratea");
        String tenora = request.getParameter("tenora");
        String limita = request.getParameter("limita");
        String avgutilamta = request.getParameter("avgutilamta");
        String annualavgfloata = request.getParameter("annualavgfloata");
        String imdealamounta = request.getParameter("imdealamounta");
        String currencya = request.getParameter("currencya");
        String producta = request.getParameter("producta");
        String uname = request.getParameter("uname"); 
        String clientnamea = request.getParameter("clientnamea");
        System.out.println(clientnamea+" "+uname+" "+producta+" "+imdealamounta);
        
        WalletResizeModel wrModel = new WalletResizeModel(); 
        wrModel.setAnnualAverageFloat(new BigDecimal(annualavgfloata));
        wrModel.setAverageUtilizationAmount(new BigDecimal(avgutilamta));
        wrModel.setClientMaster(clientnamea);
        wrModel.setDealMount(new BigDecimal(imdealamounta));
        wrModel.setFtpRate(BigDecimal.ZERO);
        wrModel.setInterestRate(new BigDecimal(interstratea));
        wrModel.setLimit(new BigDecimal(limita));
        wrModel.setLookupmasterByCurrencyLookupid(Integer.parseInt(currencya));
        wrModel.setLookupmasterByProduct(Integer.parseInt(producta));
        wrModel.setMargin(BigDecimal.ZERO);
        wrModel.setProcessingRate(new BigDecimal(processfeeratea));
        wrModel.setTenor(new BigDecimal(tenora));
        wrModel.setWalletResizeId(n);
        uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          wrm.createWalletResize(wrModel);
       session.setAttribute("content_page", contextPath+"/walletresizing/walletresize.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/walletresizing/walletresize.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/walletresizing/walletresize.jsp");
        } 
        }
      public static void handleEditWalletSize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        SignOffMaster som = new SignOffMaster();
        String contextPath = request.getContextPath(); 
        String headofcorporatesignoffa = request.getParameter("headofcorporatesignoffa");
        String rmsignoffa = request.getParameter("rmsignoffa");
        String uname = request.getParameter("uname"); 
        String clientnamea = request.getParameter("clientnamea");
        System.out.println(clientnamea+" "+uname+" "+rmsignoffa+" "+headofcorporatesignoffa);
        SignOffModel somModel = new SignOffModel(); 
        somModel.setClientMaster(clientnamea);
        somModel.setSignoffid(n);
        somModel.setHeadofcorporatesignoff(headofcorporatesignoffa);
        somModel.setRmsignoff(rmsignoffa);
        uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          som.createSignOff(somModel);
       session.setAttribute("content_page", contextPath+"/walletresizing/walletresize.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/walletresizing/walletresize.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/walletresizing/walletresize.jsp");
        } 
        }
      public static void handleAddDirector(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
        //uname,directornamea,directorposta
        Company c = new Company();
        String contextPath = request.getContextPath(); 
        String directorposta = request.getParameter("directorposta");
        String directornamea = request.getParameter("directornamea");
        String companya = request.getParameter("companya");
        String uname = request.getParameter("uname");  
        System.out.println(uname+" "+directornamea+" "+directorposta);
        
        Director director = new Director();  
        director.setDirectorId(n);
        director.setDirectorName(directornamea);
        director.setCompanyId(Integer.parseInt(companya));
        director.setDirectorPosition(directorposta);
        uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          c.createDirector(director);
       session.setAttribute("content_page", contextPath+"/walletresizing/signoff.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/walletresizing/signoff.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/walletresizing/signoff.jsp");
        } 
        }
      public static void handleAddShareholder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession(false);
         Company c = new Company();
        String contextPath = request.getContextPath();  
        String shareholdera = request.getParameter("shareholdera");
        String shareholdinga = request.getParameter("shareholdinga");
        String companya = request.getParameter("companya");
        String uname = request.getParameter("uname");  
        System.out.println(uname+" "+shareholdera+" "+shareholdinga);
        
        Shareholder  shareholder  = new Shareholder(); 
        shareholder.setSharedolderId(n);
        shareholder.setCompanyId(Integer.parseInt(companya));
        shareholder.setShareholderName(shareholdera);
        shareholder.setShareholderPercent(new BigDecimal(shareholdinga));
        uname = (String) session.getAttribute("uname");
            System.out.println("username:"+uname);
         if ( uname != null) {
          c.createShareholder(shareholder);
          
       session.setAttribute("content_page", contextPath+"/client/companyinfo.jsp");
            session.setAttribute("uname", uname); 
            response.sendRedirect(contextPath+"/client/companyinfo.jsp");
         } else {
            session.setAttribute("content_page", contextPath+"/client/companyinfo.jsp");
        } 
        }
}
