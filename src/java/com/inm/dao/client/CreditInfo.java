/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import com.inm.models.CreditInfoModel;
import java.util.ArrayList;

/**
 *
 * @author Levi
 */
public class CreditInfo {
    
 public static ArrayList<CreditInfoModel> getCreditInfo(String rmCode) {
         ArrayList<CreditInfoModel>  creditInfoList = new ArrayList<CreditInfoModel> ();
         CreditInfo creditInfo = new CreditInfo();
      String sql = "select ClientID,RM_Code,ApprovedLines,OutstandingAmount,RiskRating,RatingAgency from [dbo].[Credit_Information] where RM_Code = ?";
        String in = rmCode;
        ArrayList list = AdminDb.execArrayLists(sql, 1, in, 6);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        CreditInfoModel creditInfoModel = new CreditInfoModel(); 
        creditInfoModel.setClientID(creditInfo.getClientNameByID((String) clientItem.get(0)));
        creditInfoModel.setRM_Code((String) clientItem.get(1));
        creditInfoModel.setApprovedLines((String) clientItem.get(2));
        creditInfoModel.setOutstandingAmount((String) clientItem.get(3));
        creditInfoModel.setRiskRating((String) clientItem.get(4));
        creditInfoModel.setRatingAgency((String) clientItem.get(5));
        creditInfoList.add(creditInfoModel);
         }
        return creditInfoList;
       
     }
  public static ArrayList<CreditInfoModel> getCreditInfoByClient(String rmCode,String clientId) {
         ArrayList<CreditInfoModel>  creditInfoList = new ArrayList<CreditInfoModel> ();
         CreditInfo creditInfo = new CreditInfo();
      String sql = "select ClientID,RM_Code,ApprovedLines,OutstandingAmount,RiskRating,RatingAgency from [dbo].[Credit_Information] where RM_Code = ? and ClientID = ?";
        String in = rmCode+ "," + clientId;
        ArrayList list = AdminDb.execArrayLists(sql, 2, in, 6);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        CreditInfoModel creditInfoModel = new CreditInfoModel(); 
        creditInfoModel.setClientID(creditInfo.getClientNameByID((String) clientItem.get(0)));
        creditInfoModel.setRM_Code((String) clientItem.get(1));
        creditInfoModel.setApprovedLines((String) clientItem.get(2));
        creditInfoModel.setOutstandingAmount((String) clientItem.get(3));
        creditInfoModel.setRiskRating((String) clientItem.get(4));
        creditInfoModel.setRatingAgency((String) clientItem.get(5));
        creditInfoList.add(creditInfoModel);
         }
        return creditInfoList;
       
     }
      public  String getClientNameByID(String clientId) {
       AdminDb ad = new AdminDb();
        String sql = "select ClientName from [dbo].[Client_Master] where ClientID = ?";
        String str = ad.getStringValue(sql, 1, 1, clientId);
        return str;
    }
   public  String getRMNameByCode(String rmCode) {
       AdminDb ad = new AdminDb();
        String sql = "select  employeeName from Employee_Details where employeeID = ?";
        String str = ad.getStringValue(sql, 1, 1, rmCode);
        return str;
    }

}
