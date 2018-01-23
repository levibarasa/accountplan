/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import com.inm.models.ClientFinacialModel;
import java.util.ArrayList;

/**
 *
 * @author Levi
 */
public class ClientFinacial {
      public static ArrayList<ClientFinacialModel> getClientFinancialInfo(String rmCode) {
         ArrayList<ClientFinacialModel>  clientFinancialList = new ArrayList<ClientFinacialModel> ();
         ClientFinacial clientFinacial = new ClientFinacial();
      String sql = "select Client_FinancialID,ClientID,RM_Code,Turnover,OperatingProfit,TotalDebt,TotalDeposits,GearingRatio,CashFlowCycle from [dbo].[Client_Financial] where RM_Code = ?";
        String in = rmCode;
        ArrayList list = AdminDb.execArrayLists(sql, 1, in, 9);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        ClientFinacialModel creditInfoModel = new ClientFinacialModel(); 
        creditInfoModel.setClient_FinancialID((String) clientItem.get(0));
        creditInfoModel.setClientID( clientFinacial.getClientNameByID((String) clientItem.get(1)));
        creditInfoModel.setTurnover((String) clientItem.get(2));
        creditInfoModel.setOperatingProfit((String) clientItem.get(3));
        creditInfoModel.setTotalDebt((String) clientItem.get(4));
        creditInfoModel.setTotalDeposits((String) clientItem.get(5));
        creditInfoModel.setGearingRatio((String) clientItem.get(6));
        creditInfoModel.setCashFlowCycle((String) clientItem.get(7));
        clientFinancialList.add(creditInfoModel);
         }
        return clientFinancialList;
      }
       public   String getRMNameByCode(String rmCode) {
       AdminDb ad = new AdminDb();
        String sql = "select  employeeName from Employee_Details where employeeID = ?";
        String str = ad.getStringValue(sql, 1, 1, rmCode);
        return str;
    }
       
     public  String getClientNameByID(String clientId) {
       AdminDb ad = new AdminDb();
        String sql = "select ClientName from [dbo].[Client_Master] where ClientID = ?";
        String str = ad.getStringValue(sql, 1, 1, clientId);
        return str;
    }
           public static ArrayList<ClientFinacialModel> getClientFinancialInfoByClientID(String rmCode,String clientId) {
         ArrayList<ClientFinacialModel>  clientFinancialList = new ArrayList<ClientFinacialModel> ();
         ClientFinacial clientFinacial = new ClientFinacial();
      String sql = "select Client_FinancialID,ClientID,RM_Code,Turnover,OperatingProfit,TotalDebt,TotalDeposits,GearingRatio,CashFlowCycle from [dbo].[Client_Financial] where RM_Code = ? and ClientID = ?";
        String in = rmCode+ "," + clientId;
        ArrayList list = AdminDb.execArrayLists(sql, 2, in, 9);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        ClientFinacialModel creditInfoModel = new ClientFinacialModel(); 
        creditInfoModel.setClient_FinancialID((String) clientItem.get(0));
        creditInfoModel.setClientID( clientFinacial.getClientNameByID((String) clientItem.get(1)));
        creditInfoModel.setTurnover((String) clientItem.get(2));
        creditInfoModel.setOperatingProfit((String) clientItem.get(3));
        creditInfoModel.setTotalDebt((String) clientItem.get(4));
        creditInfoModel.setGearingRatio((String) clientItem.get(5));
        creditInfoModel.setCashFlowCycle((String) clientItem.get(6));
        clientFinancialList.add(creditInfoModel);
         }
        return clientFinancialList;
      }
}
