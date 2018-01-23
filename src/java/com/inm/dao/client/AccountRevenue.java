/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import com.inm.models.AccountRevenueModel;
import java.util.ArrayList;

/**
 *
 * @author Levi
 */
public class AccountRevenue {
        public static ArrayList<AccountRevenueModel> getAccountRevenuenfo(String rmCode) {
         ArrayList<AccountRevenueModel>  accountRevenueList = new ArrayList<AccountRevenueModel> ();
         AccountRevenue accountRevenue = new AccountRevenue();
      String sql = " select Account_RevenueID,ClientID,RM_Code,CurrentYearRevenueTarget,PriorYearActualRevenue,"
              + "PercentageGrowthRevenue,CurrentYearFeeIncomeTarget,PriorYearActualFeeIncome,PercentageGrowthFeeIncome,"
              + "CurrentShareOfWallet,TargetShareOfWallet,TotalValueOfIdentifiedOpportunities from [dbo].[Account_Revenue_Information] where RM_Code = ?";
        String in = rmCode;
        ArrayList list = AdminDb.execArrayLists(sql, 1, in, 12);
          for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        AccountRevenueModel accountRevenueModel = new AccountRevenueModel();
       accountRevenueModel.setAccount_RevenueID((String) clientItem.get(0));
       accountRevenueModel.setClientID(accountRevenue.getClientNameByID((String) clientItem.get(1)));
       accountRevenueModel.setRM_Code(accountRevenue.getRMNameByCode((String) clientItem.get(2)));
       accountRevenueModel.setCurrentYearRevenueTarget((String) clientItem.get(3));
       accountRevenueModel.setPriorYearActualRevenue((String) clientItem.get(4));
       accountRevenueModel.setPercentageGrowthRevenue((String) clientItem.get(5));
       accountRevenueModel.setCurrentYearFeeIncomeTarget((String) clientItem.get(6));
       accountRevenueModel.setPriorYearActualFeeIncome((String) clientItem.get(7));
       accountRevenueModel.setPercentageGrowthFeeIncome((String) clientItem.get(8));
       accountRevenueModel.setCurrentShareOfWallet((String) clientItem.get(9));
       accountRevenueModel.setTargetShareOfWallet((String) clientItem.get(10));
       accountRevenueModel.setTotalValueOfIdentifiedOpportunities((String) clientItem.get(11));
        accountRevenueList.add(accountRevenueModel);
         }
        return accountRevenueList;
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
          public static ArrayList<AccountRevenueModel> getAccountRevenuenfo(String rmCode,String clientId) {
         ArrayList<AccountRevenueModel>  accountRevenueList = new ArrayList<AccountRevenueModel> ();
         AccountRevenue accountRevenue = new AccountRevenue();
      String sql = " select Account_RevenueID,ClientID,RM_Code,CurrentYearRevenueTarget,PriorYearActualRevenue,"
              + "PercentageGrowthRevenue,CurrentYearFeeIncomeTarget,PriorYearActualFeeIncome,PercentageGrowthFeeIncome,"
              + "CurrentShareOfWallet,TargetShareOfWallet,TotalValueOfIdentifiedOpportunities from [dbo].[Account_Revenue_Information] where RM_Code = ? and ClientID = ?";
        String in = rmCode+ "," + clientId;
        ArrayList list = AdminDb.execArrayLists(sql, 2, in, 12);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        AccountRevenueModel accountRevenueModel = new AccountRevenueModel();
       accountRevenueModel.setAccount_RevenueID((String) clientItem.get(0));
       accountRevenueModel.setClientID(accountRevenue.getClientNameByID((String) clientItem.get(1)));
       accountRevenueModel.setRM_Code(accountRevenue.getRMNameByCode((String) clientItem.get(2)));
       accountRevenueModel.setCurrentYearRevenueTarget((String) clientItem.get(3));
       accountRevenueModel.setPriorYearActualRevenue((String) clientItem.get(4));
       accountRevenueModel.setPercentageGrowthRevenue((String) clientItem.get(5));
       accountRevenueModel.setCurrentYearFeeIncomeTarget((String) clientItem.get(6));
       accountRevenueModel.setPriorYearActualFeeIncome((String) clientItem.get(7));
       accountRevenueModel.setPercentageGrowthFeeIncome((String) clientItem.get(8));
       accountRevenueModel.setCurrentShareOfWallet((String) clientItem.get(9));
       accountRevenueModel.setTargetShareOfWallet((String) clientItem.get(10));
       accountRevenueModel.setTotalValueOfIdentifiedOpportunities((String) clientItem.get(11));
         }
        return accountRevenueList;
      }
}
