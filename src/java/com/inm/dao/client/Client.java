/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import com.inm.models.ClientModel;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/**
 *
 * @author Levi
 */
public class Client {
    
     public static ArrayList<ClientModel> getClientInfo(String rmCode) {
         ArrayList<ClientModel>  clientList = new ArrayList<ClientModel> ();
         Client client = new Client();
      String sql = "select ClientID,ClientName,RM_Code,Alternative_RM_Code,AffiliateId,[Current_Date],TradeServiceProvider,CashManagementPartner,E_BankingPartner,RiskManagementPartner,Client_Category  from [dbo].[Client_Master] where RM_Code = ?";
        String in = rmCode;
        ArrayList list = AdminDb.execArrayLists(sql, 1, in, 11);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        ClientModel clientModel = new ClientModel();
        clientModel.setClientName((String) clientItem.get(1));
        clientModel.setClientID((String) clientItem.get(0));
        clientModel.setAffiliateId((String) clientItem.get(4));
        clientModel.setAlternative_RM_Code(client.getRMNameByCode((String) clientItem.get(3)));
        clientModel.setClient_Category((String) clientItem.get(10));
        clientModel.setCurrent_Date((String) clientItem.get(5));
        clientModel.setE_BankingPartner((String) clientItem.get(8));
        clientModel.setRM_Code(client.getRMNameByCode((String) clientItem.get(2)));
        clientModel.setRiskManagementPartner((String) clientItem.get(9));
        clientModel.setTradeServiceProvider((String) clientItem.get(6));
        clientModel.setCashManagementPartner((String) clientItem.get(7));
        clientList.add(clientModel);
         }
        return clientList;
       
     }
   public  String getRMNameByCode(String rmCode) {
       AdminDb ad = new AdminDb();
        String sql = "select  employeeName from Employee_Details where employeeID = ?";
        String str = ad.getStringValue(sql, 1, 1, rmCode);
        return str;
    }
         public  ArrayList<ClientModel> getClientInfoByClientID(String rmCode , String ClientID) {
         ArrayList<ClientModel>  clientList = new ArrayList<ClientModel> ();
         Client client = new Client();
      String sql = "select ClientID,ClientName,RM_Code,Alternative_RM_Code,AffiliateId,[Current_Date],TradeServiceProvider,CashManagementPartner,E_BankingPartner,RiskManagementPartner,Client_Category  from [dbo].[Client_Master] where RM_Code = ? and ClientID = ?";
        String in = rmCode+ "," + ClientID;
        ArrayList list = AdminDb.execArrayLists(sql, 2, in, 11);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        ClientModel clientModel = new ClientModel();
        clientModel.setClientName((String) clientItem.get(3));
        clientModel.setClientID((String) clientItem.get(0));
        clientModel.setAffiliateId((String) clientItem.get(4));
        clientModel.setAlternative_RM_Code(client.getRMNameByCode((String) clientItem.get(3)));
        clientModel.setClient_Category((String) clientItem.get(10));
        clientModel.setCurrent_Date((String) clientItem.get(5));
        clientModel.setE_BankingPartner((String) clientItem.get(8));
        clientModel.setRM_Code(client.getRMNameByCode((String) clientItem.get(2)));
        clientModel.setRiskManagementPartner((String) clientItem.get(9));
        clientModel.setTradeServiceProvider((String) clientItem.get(6));
        clientModel.setCashManagementPartner((String) clientItem.get(7));
        clientList.add(clientModel);
        }
        return clientList;
     }
         public static ArrayList getAllRms() {
        String sql = "select RM_Code,RM_Name from  [dbo].[RM_Codelist]";
        return AdminDb.execArrayLists(sql, 0, "", 2);
    }
         
       
          public static ArrayList getAffiliate() {
        String sql = "select AffiliateName from [dbo].[AffiliateMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }
        public static void createClient(ClientModel clientModel ) {
        String sql = "insert into Client_Master (ClientName,RM_Code,Alternative_RM_Code,AffiliateId,[Current_Date],TradeServiceProvider,CashManagementPartner,E_BankingPartner,RiskManagementPartner,Client_Category) "
                + "values(?,?,?,?,?,?,?,?,?,'Banking')";
        String in = clientModel.getClientName() + "," + clientModel.getRM_Code() + "," + clientModel.getAlternative_RM_Code() + "," + clientModel.getAffiliateId() + "," + clientModel.getCurrent_Date()+ "," + clientModel.getTradeServiceProvider()
                + "," + clientModel.getCashManagementPartner()+ "," + clientModel.getE_BankingPartner()+ "," + clientModel.getRiskManagementPartner();
        AdminDb.dbWork(sql, 9, in);
    } 
        public static void updateClient(ClientModel clientModel ) {
        String sql = "update [dbo].[Client_Master] set ClientName = ?, RM_Code = ?,Alternative_RM_Code = ?, AffiliateId = ?,[Current_Date] =  ?,TradeServiceProvider= ?, CashManagementPartner = ?,E_BankingPartner= ?,RiskManagementPartner= ? where ClientID = ?";
        String in = clientModel.getClientName() + "," + clientModel.getRM_Code() + "," + clientModel.getAlternative_RM_Code() + "," + clientModel.getAffiliateId() + "," + clientModel.getCurrent_Date()+ "," + clientModel.getTradeServiceProvider()
                + "," + clientModel.getCashManagementPartner()+ "," + clientModel.getE_BankingPartner()+ "," + clientModel.getRiskManagementPartner()+ "," + clientModel.getClientID();
        AdminDb.dbWork(sql, 10, in);
    } 
         
}
