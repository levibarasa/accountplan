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
                    case "doLog":
                        Accessw.handleLogin(request, response);
                        break;
                    case "Logout":
                        Accessw.handleLogout(request, response);
                        break;
                    case "doGetClient":
                        ClientW.handleGetAllClients(request, response);
                        break;
                    case "doAddClient":
                        ClientW.handleAddClient(request, response);
                        break;
                    case "doAddCompany":
                        ClientW.handleAddCompany(request, response);
                        break;
                    case "doAddDirector":
                        ClientW.handleAddDirector(request, response);
                        break;
                    case "doAddShareholder":
                        ClientW.handleAddShareholder(request, response);
                        break;
                    case "doAddCreditInfo":
                        ClientW.handleAddCreditInfo(request, response);
                        break;
                    case "doAddCreditFinancial":
                        ClientW.handleAddCreditFinancial(request, response);
                        break;
                    case "doAddAccountRevenue":
                        ClientW.handleAddAccountRevenue(request, response);
                        break;
                    case "doAddClientCoverage":
                        ClientW.handleAddClientCoverage(request, response);
                        break;
                    case "doAddCompetition":
                        ClientW.handleAddCompetition(request, response);
                        break;
                    case "doAddDealInProgress":
                        ClientW.handleAddDealInProgress(request, response);
                        break;
                    case "doAddQualitativeInfo":
                        ClientW.handleAddQualitativeInfo(request, response);
                        break;
                    case "doAddSaleActionPlan":
                        ClientW.handleAddSaleActionPlan(request, response);
                        break;
                    case "doAddClientEmployee":
                        ClientW.handleAddClientEmployee(request, response);
                        break;
                    case "doAddKeyDistributor":
                        ClientW.handleAddKeyDistributor(request, response);
                        break;
                    case "doAddKeySupplier":
                        ClientW.handleAddKeySupplier(request, response);
                        break;
                    case "doAddSignOff":
                        ClientW.handleAddSignOff(request, response);
                        break;
                    case "doAddCFOpportunity":
                        ClientW.handleAddCFOpportunity(request, response);
                        break;
                   case "doAddOClientWalletSize":
                        ClientW.handleAddOClientWalletSize(request, response);
                        break;
                   case "doAddWalletSize":
                        ClientW.handleAddWalletSize(request, response);
                        break;
                   case "doEditWalletSize":
                        ClientW.handleEditWalletSize(request, response);
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
