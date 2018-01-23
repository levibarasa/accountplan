/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import com.inm.models.CompanyModel;
import java.util.ArrayList;

/**
 *
 * @author Levi
 */
public class Company {
    public static ArrayList<CompanyModel> getCompanyInfo(String rmCode) {
         ArrayList<CompanyModel>  companyList = new ArrayList<CompanyModel> ();
         Company company = new Company();
      String sql = "select CompanyID,ClientID,RM_Code,Company_Address,GroupName,HQ_Affiliate,Industry,Segment,NumberOfSubsidiaries from [dbo].[Company_Master] where RM_Code = ?";
        String in = rmCode;
        ArrayList list = AdminDb.execArrayLists(sql, 1, in, 9);
        for(int n =0;n<list.size(); n++){
            ArrayList clientItem = (ArrayList) list.get(n);
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyID((String) clientItem.get(0));
        companyModel.setClientID(company.getClientNameByID((String) clientItem.get(1)));
        companyModel.setRM_Code(company.getRMNameByCode((String) clientItem.get(2)));
        companyModel.setCompany_Address((String) clientItem.get(3));
        companyModel.setGroupName((String) clientItem.get(4));
        companyModel.setHQ_Affiliate((String) clientItem.get(5));
        companyModel.setIndustry((String) clientItem.get(6));
        companyModel.setSegment((String) clientItem.get(7));
        companyModel.setNumberOfSubsidiaries((String) clientItem.get(8));
        companyList.add(companyModel);
         }
        return companyList;
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
      public static ArrayList getClientName() {
        String sql = "select ClientID,ClientName from  [dbo].[Client_Master]";
        return AdminDb.execArrayLists(sql, 0, "", 2);
    }  
      public static ArrayList getIndustry() {
        String sql = "select IndustryDescription from [dbo].[IndustryMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }
     public static ArrayList<CompanyModel> getCompanyInfoByClientId(String rmCode,String clientId) {
         ArrayList<CompanyModel>  companyList = new ArrayList<CompanyModel> ();
        Company company = new Company();
      String sql = "select CompanyID,ClientID,RM_Code,Company_Address,GroupName,HQ_Affiliate,Industry,Segment,NumberOfSubsidiaries from [dbo].[Company_Master] where RM_Code = ? and ClientID = ?";
        String in = rmCode+ "," + clientId;
        ArrayList list = AdminDb.execArrayLists(sql, 2, in, 9);
        for(int n =0;n<list.size(); n++){
        ArrayList clientItem = (ArrayList) list.get(n);
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyID((String) clientItem.get(0));
        companyModel.setClientID(company.getClientNameByID((String) clientItem.get(1)));
        companyModel.setRM_Code(company.getRMNameByCode((String) clientItem.get(2)));
        companyModel.setCompany_Address((String) clientItem.get(3));
        companyModel.setGroupName((String) clientItem.get(4));
        companyModel.setHQ_Affiliate((String) clientItem.get(5));
        companyModel.setIndustry((String) clientItem.get(6));
        companyModel.setSegment((String) clientItem.get(7));
        companyModel.setNumberOfSubsidiaries((String) clientItem.get(8));
        companyList.add(companyModel);
         }
        return companyList;
      }
}
