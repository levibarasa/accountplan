/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.hibernate.Util.*;
import com.inm.ap.mode.hibernate.*;
import com.inm.models.*;
import com.inm.ap.conn.AdminDb; 
import com.inm.models.CompanyModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Levi
 */
public class Company {
     OperationsDal ops;

    public Company() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
//    public static void main(String[] args) {
//        Company com = new Company();   
//        CompanyModel companyModel = new CompanyModel(); 
//        companyModel.setCompanyid(0);
//        companyModel.setGroupname("The Standard Group LTD");
//        companyModel.setCompanyAddress("po box 1244");
//        companyModel.setNoofsubsidiaries(Integer.parseInt("1"));
//        companyModel.setClientMaster("6");
//        companyModel.setLookupmasterByAffiliatelookupmasterid("1");
//        companyModel.setLookupmasterByIndustrylookupmasterid("133");
//        companyModel.setLookupmasterBySegmentlookupmasterid("87");
//       com.createCompany(companyModel);  
//    }
     public  void createCompany(CompanyModel companyModel ) {
         CompanyMaster companyMaster = new CompanyMaster(); 
         Company c = new Company(); 
         companyMaster.setCompanyid(companyModel.getCompanyid());
         companyMaster.setCompanyAddress(companyModel.getCompanyAddress());
         companyMaster.setGroupname(companyModel.getGroupname());
         companyMaster.setNoofsubsidiaries(companyModel.getNoofsubsidiaries());
         companyMaster.setClientMaster(c.getClientMasterByID(companyModel.getClientMaster()));
         companyMaster.setLookupmasterByAffiliatelookupmasterid(c.getLookUpMaster("AFFILIATE", Integer.parseInt(companyModel.getLookupmasterByAffiliatelookupmasterid())));
         companyMaster.setLookupmasterByIndustrylookupmasterid(c.getLookUpMaster("INDUSTRY", Integer.parseInt(companyModel.getLookupmasterByIndustrylookupmasterid())));
         companyMaster.setLookupmasterBySegmentlookupmasterid(c.getLookUpMaster("SEGMENT", Integer.parseInt(companyModel.getLookupmasterBySegmentlookupmasterid()))); 
         ops.save(companyMaster);
    }
     public  void updateCompany(CompanyModel companyModel ) {
         CompanyMaster companyMaster = new CompanyMaster(); 
         Company c = new Company(); 
         companyMaster.setCompanyid(companyModel.getCompanyid());
         companyMaster.setCompanyAddress(companyModel.getCompanyAddress());
         companyMaster.setGroupname(companyModel.getGroupname());
         companyMaster.setNoofsubsidiaries(companyModel.getNoofsubsidiaries());
         companyMaster.setClientMaster(c.getClientMasterByID(companyModel.getClientMaster()));
         companyMaster.setLookupmasterByAffiliatelookupmasterid(c.getLookUpMaster("AFFILIATE", Integer.parseInt(companyModel.getLookupmasterByAffiliatelookupmasterid())));
         companyMaster.setLookupmasterByIndustrylookupmasterid(c.getLookUpMaster("INDUSTRY", Integer.parseInt(companyModel.getLookupmasterByIndustrylookupmasterid())));
         companyMaster.setLookupmasterBySegmentlookupmasterid(c.getLookUpMaster("SEGMENT", Integer.parseInt(companyModel.getLookupmasterBySegmentlookupmasterid()))); 
         ops.saveOrUpdate(companyMaster);
    }
    public Lookupmaster getLookUpMaster(String code, int lookupId) {
        CoreQuery coreQuery = new CoreQuery("from Lookupmaster where code =:code and lookupmasterid =:lookupId", true);
        coreQuery.addParam("code", code);
        coreQuery.addParam("lookupId", lookupId);
        List lookups = ops.fetch(coreQuery);
        return (Lookupmaster) lookups.get(0);
    }
    public ArrayList<CompanyModel> getCompanyInfo(String rmCode) {
        Company company = new Company();
        ArrayList<CompanyModel> companyList = new ArrayList<CompanyModel>();
        CoreQuery coreQuery = new CoreQuery("from CompanyMaster where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List companyMaster = ops.fetch(coreQuery);
        for (Object companyObject : companyMaster) {
            CompanyMaster comMaster = (CompanyMaster) companyObject;
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyid(comMaster.getCompanyid());
            companyModel.setClientMaster(company.getClientMaster(rmCode).getClientname()); 
            companyModel.setCompanyAddress(comMaster.getCompanyAddress());
            companyModel.setGroupname(comMaster.getGroupname());
            companyModel.setNoofsubsidiaries(comMaster.getNoofsubsidiaries());
            companyModel.setLookupmasterByAffiliatelookupmasterid(company.getLookUpMaster("AFFILIATE", comMaster.getLookupmasterByAffiliatelookupmasterid().getLookupmasterid()).getValue());
            companyModel.setLookupmasterByIndustrylookupmasterid(company.getLookUpMaster("INDUSTRY", comMaster.getLookupmasterByIndustrylookupmasterid().getLookupmasterid()).getValue());
            companyModel.setLookupmasterBySegmentlookupmasterid(company.getLookUpMaster("SEGMENT", comMaster.getLookupmasterBySegmentlookupmasterid().getLookupmasterid()).getValue());
            companyList.add(companyModel);
        }

        return companyList;
    }
    public ArrayList<RmCodelistModel> getRmCodeList() {
         ArrayList<RmCodelistModel> rmCodeList = new ArrayList<RmCodelistModel>();
        CoreQuery coreQuery = new CoreQuery("from RmCodelist", true); 
        List rmlst = ops.fetch(coreQuery);
         if (Validator.validateList(rmlst)) {
                for (Object rm : rmlst) {
                    if (rm != null) {
                     RmCodelist codelist = (RmCodelist) rm;
                     RmCodelistModel codelistModel =   new RmCodelistModel(codelist.getRmCode(), codelist.getDesignation(), codelist.getBranch(), codelist.getBranch(), codelist.getRegion(), codelist.getCategory(), codelist.getRmName());
                        rmCodeList.add(codelistModel);
                        }
                }
            }
         return rmCodeList;
     }
     public ArrayList<LookupmasterModel> getLookupList(String code) {
         ArrayList<LookupmasterModel> lookupList = new ArrayList<LookupmasterModel>();
        CoreQuery coreQuery = new CoreQuery("from Lookupmaster where code =:code", true);
        coreQuery.addParam("code", code); 
        List lookups = ops.fetch(coreQuery);
         if (Validator.validateList(lookups)) {
                for (Object lookup : lookups) {
                    if (lookup != null) {
                     Lookupmaster lookupmaster = (Lookupmaster) lookup;
                     LookupmasterModel lookupmasterModel =   new LookupmasterModel(lookupmaster.getLookupmasterid(), lookupmaster.getCode(), lookupmaster.getValue());
                        lookupList.add(lookupmasterModel);
                        }
                }
            }
         return lookupList;
     } 
    public ArrayList<ClientModel> getClientMasterList(String rmCode) {
         ArrayList<ClientModel> clientModelList = new ArrayList<ClientModel>();
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List rms = ops.fetch(coreQuery);
         if (Validator.validateList(rms)) {
                for (Object rm : rms) {
                    if (rm != null) {
                     ClientMaster clientMaster = (ClientMaster) rm;
                     ClientModel clientModel =   new ClientModel(clientMaster.getClientid(), clientMaster.getRmCodelistByRmCode().getRmCode(), clientMaster.getRmCodelistByAlternativeRmCode().getRmCode(), clientMaster.getLookupmaster().getValue(), clientMaster.getClientname(), clientMaster.getCurrentDate(), clientMaster.getTradeserviceprovider(), clientMaster.getCashmanagementpartner(), clientMaster.getEBankingpartner());
                        clientModelList.add(clientModel);
                        }
                }
            }
         return clientModelList;
     }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
     public ClientMaster getClientMaster(String rmCode) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
     public RmCodelist getRmCodeList(String rmCode) {
        CoreQuery coreQuery = new CoreQuery("from RmCodelist where rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List rmCodes = ops.fetch(coreQuery);
        return (RmCodelist) rmCodes.get(0);
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
      public static ArrayList getSegment() {
        String sql = "select Segment from [dbo].[SegmentMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }
      public static ArrayList getIndustry() {
        String sql = "select IndustryDescription from [dbo].[IndustryMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }
     public ArrayList<CompanyModel> getCompanyInfoByClientId(String rmCode, String clientId ) {
        Company company = new Company();
        ArrayList<CompanyModel> companyList = new ArrayList<CompanyModel>();
        CoreQuery coreQuery = new CoreQuery("from CompanyMaster where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientId", clientId);
        List companyMaster = ops.fetch(coreQuery);
        for (Object companyObject : companyMaster) {
            CompanyMaster comMaster = (CompanyMaster) companyObject;
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyid(comMaster.getCompanyid());
            companyModel.setClientMaster(company.getClientMaster(rmCode).getClientname()); 
            companyModel.setCompanyAddress(comMaster.getCompanyAddress());
            companyModel.setGroupname(comMaster.getGroupname());
            companyModel.setNoofsubsidiaries(comMaster.getNoofsubsidiaries());
            companyModel.setLookupmasterByAffiliatelookupmasterid(company.getLookUpMaster("AFFILIATE", comMaster.getLookupmasterByAffiliatelookupmasterid().getLookupmasterid()).getValue());
            companyModel.setLookupmasterByIndustrylookupmasterid(company.getLookUpMaster("INDUSTRY", comMaster.getLookupmasterByIndustrylookupmasterid().getLookupmasterid()).getValue());
            companyModel.setLookupmasterBySegmentlookupmasterid(company.getLookUpMaster("SEGMENT", comMaster.getLookupmasterBySegmentlookupmasterid().getLookupmasterid()).getValue());
            companyList.add(companyModel);
        }

        return companyList;
    }
}
