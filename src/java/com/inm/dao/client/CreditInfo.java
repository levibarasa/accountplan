/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import com.inm.ap.hibernate.Util.*; 
import com.inm.models.*;
import java.util.ArrayList;
import com.inm.ap.mode.hibernate.*;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Levi
 */
public class CreditInfo {
         OperationsDal ops;

    public CreditInfo() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
      public  boolean deleteCreditInfo(CreditInfoModel creditInfoModel ) {
     return ops.delete(creditInfoModel);
 }
    public  void createCreditInformation(CreditInfoModel creditInfoModel ) {
         CreditInformation creditInformation = new CreditInformation(); 
         CreditInfo cr = new CreditInfo();  
         creditInformation.setClientMaster(cr.getClientMasterByID(creditInfoModel.getClientMaster()));
         creditInformation.setApprovedlines(creditInfoModel.getApprovedlines());
         creditInformation.setCreditid(creditInfoModel.getCreditid());
         creditInformation.setOutstandingamount(creditInfoModel.getOutstandingamount());
         creditInformation.setRatingagency(creditInfoModel.getRatingagency());
         creditInformation.setRiskrating(creditInfoModel.getRiskrating());
          ops.save(creditInformation);
    }
    public  void updateCreditInformation(CreditInfoModel creditInfoModel ) {
         CreditInformation creditInformation = new CreditInformation(); 
         CreditInfo cr = new CreditInfo();  
         creditInformation.setClientMaster(cr.getClientMasterByID(creditInfoModel.getClientMaster()));
         creditInformation.setApprovedlines(creditInfoModel.getApprovedlines());
         creditInformation.setCreditid(creditInfoModel.getCreditid());
         creditInformation.setOutstandingamount(creditInfoModel.getOutstandingamount());
         creditInformation.setRatingagency(creditInfoModel.getRatingagency());
         creditInformation.setRiskrating(creditInfoModel.getRiskrating());
          ops.saveOrUpdate(creditInformation);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
        public ArrayList<CreditInfoModel> getCreditInfoByClientId(String rmCode,String clientid) {
         ArrayList<CreditInfoModel> creditInfoList = new ArrayList<CreditInfoModel>();
       CreditInfo cr = new CreditInfo();
         CoreQuery coreQuery = new CoreQuery("from CreditInformation where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List companyMaster = ops.fetch(coreQuery);
        for (Object creObject : companyMaster) {
            CreditInformation creMaster = (CreditInformation) creObject;
            CreditInfoModel creditInfoModel = new CreditInfoModel();
            creditInfoModel.setCreditid(creMaster.getCreditid());
            creditInfoModel.setApprovedlines(creMaster.getApprovedlines());
            creditInfoModel.setRatingagency(creMaster.getRatingagency());
            creditInfoModel.setRiskrating(creMaster.getRatingagency());
            creditInfoModel.setClientMaster(cr.getClientMaster(creMaster.getClientMaster().getClientid()).getClientname()); 
            creditInfoModel.setOutstandingamount(creMaster.getOutstandingamount());
            
              creditInfoList.add(creditInfoModel);
        }

        return creditInfoList;
    }
    public ArrayList<CreditInfoModel> getCreditInfo(String rmCode) {
         ArrayList<CreditInfoModel> creditInfoList = new ArrayList<CreditInfoModel>();
       CreditInfo cr = new CreditInfo();
         CoreQuery coreQuery = new CoreQuery("from CreditInformation where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List companyMaster = ops.fetch(coreQuery);
        for (Object creObject : companyMaster) {
            CreditInformation creMaster = (CreditInformation) creObject;
            CreditInfoModel creditInfoModel = new CreditInfoModel();
            creditInfoModel.setCreditid(creMaster.getCreditid());
            creditInfoModel.setApprovedlines(creMaster.getApprovedlines());
            creditInfoModel.setRatingagency(creMaster.getRatingagency());
            creditInfoModel.setRiskrating(creMaster.getRatingagency());
            creditInfoModel.setClientMaster(cr.getClientMaster(creMaster.getClientMaster().getClientid()).getClientname()); 
            creditInfoModel.setOutstandingamount(creMaster.getOutstandingamount());
            
              creditInfoList.add(creditInfoModel);
        }

        return creditInfoList;
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
     public ClientMaster getClientMaster(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
     public RmCodelist getRmCodeList(String rmCode) {
        CoreQuery coreQuery = new CoreQuery("from RmCodelist where rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List rmCodes = ops.fetch(coreQuery);
        return (RmCodelist) rmCodes.get(0);
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
