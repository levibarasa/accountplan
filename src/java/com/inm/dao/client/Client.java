/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.client;

import com.inm.ap.conn.AdminDb;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inm.ap.hibernate.Util.*;
import com.inm.ap.mode.hibernate.*;
import com.inm.models.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author Levi
 */
public class Client {

    OperationsDal ops;

    public Client() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
 
    public  void createClient(ClientModel clientModel ) {
         ClientMaster clMaster = new ClientMaster(); 
         Client cl = new Client();
         clMaster.setClientname(clientModel.getClientname());
         clMaster.setRmCodelistByRmCode(cl.getRmCodeList(clientModel.getRmCode()));
         clMaster.setRmCodelistByAlternativeRmCode(cl.getRmCodeList(clientModel.getRmCode()));
         clMaster.setLookupmaster(cl.getLookUpMaster("AFFILIATE", Integer.parseInt(clientModel.getAffiliate())));
         clMaster.setCurrentDate(clientModel.getCurrentDate());
         clMaster.setTradeserviceprovider(clientModel.getTradeserviceprovider());
         clMaster.setCashmanagementpartner(clientModel.getCashmanagementpartner());
         clMaster.setEBankingpartner(clientModel.getEBankingpartner());
         clMaster.setRiskmanagementpartner(clientModel.getRiskmanagementpartner());
         clMaster.setClientid(clientModel.getClientid());
         ops.save(clMaster);
    } 
    public  void updateClient(ClientModel clientModel ) {
         ClientMaster clMaster = new ClientMaster(); 
         Client cl = new Client();
         clMaster.setClientname(clientModel.getClientname());
         clMaster.setRmCodelistByRmCode(cl.getRmCodeList(clientModel.getRmCode()));
         clMaster.setRmCodelistByAlternativeRmCode(cl.getRmCodeList(clientModel.getRmCode()));
         clMaster.setLookupmaster(cl.getLookUpMaster("AFFILIATE", Integer.parseInt(clientModel.getAffiliate())));
         clMaster.setCurrentDate(clientModel.getCurrentDate());
         clMaster.setTradeserviceprovider(clientModel.getTradeserviceprovider());
         clMaster.setCashmanagementpartner(clientModel.getCashmanagementpartner());
         clMaster.setEBankingpartner(clientModel.getEBankingpartner());
         clMaster.setRiskmanagementpartner(clientModel.getRiskmanagementpartner());
         clMaster.setClientid(clientModel.getClientid());
         ops.saveOrUpdate(clMaster);
    } 
  private ClientMaster getClientMasterByID(int clientId) {
        List client = ops.fetch(new CoreQuery("from ClientMaster where clientid = :id", "id", clientId));
        if (Validator.validateListFirstObject(client)) {
            return (ClientMaster) client.get(0);
        }
        return null;
    }
    public ArrayList<ClientModel> getClientInfo(String rmCode) {
        ArrayList<ClientModel> clientList = new ArrayList<ClientModel>();
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List clientMaster = ops.fetch(coreQuery);
        for (Object userObject : clientMaster) {
            ClientMaster clMaster = (ClientMaster) userObject;
            ClientModel clientModel = new ClientModel();
            clientModel.setClientid(clMaster.getClientid());
            clientModel.setClientname(clMaster.getClientname());
            clientModel.setRmCode(clMaster.getRmCodelistByRmCode().getRmName());
            clientModel.setAlternativeRmCode(clMaster.getRmCodelistByAlternativeRmCode().getRmName());
            clientModel.setAffiliate(getLookUpMaster("AFFILIATE", clMaster.getLookupmaster().getLookupmasterid()).getValue());
            clientModel.setCurrentDate(clMaster.getCurrentDate());
            clientModel.setTradeserviceprovider(clMaster.getTradeserviceprovider());
            clientModel.setCashmanagementpartner(clMaster.getCashmanagementpartner());
            clientModel.setEBankingpartner(clMaster.getEBankingpartner());
            clientModel.setRiskmanagementpartner(clMaster.getRiskmanagementpartner());
            clientList.add(clientModel);
        }

        return clientList;
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
      public RmCodelist getRmCodeList(String rmCode) {
        CoreQuery coreQuery = new CoreQuery("from RmCodelist where rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode); 
        List rmCodes = ops.fetch(coreQuery);
        return (RmCodelist) rmCodes.get(0);
    }
    public Lookupmaster getLookUpMaster(String code, int lookupId) {
        CoreQuery coreQuery = new CoreQuery("from Lookupmaster where code =:code and lookupmasterid =:lookupId", true);
        coreQuery.addParam("code", code);
        coreQuery.addParam("lookupId", lookupId);
        List lookups = ops.fetch(coreQuery);
        return (Lookupmaster) lookups.get(0);
    }

    public String getRMNameByCode(String rmCode) {
        AdminDb ad = new AdminDb();
        String sql = "select  employeeName from Employee_Details where employeeID = ?";
        String str = ad.getStringValue(sql, 1, 1, rmCode);
        return str;
    }

     

    public static ArrayList getAffiliate() {
        String sql = "select AffiliateName from [dbo].[AffiliateMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }

   

//    public static void updateClient(ClientModel clientModel) {
//        String sql = "update [dbo].[Client_Master] set ClientName = ?, RM_Code = ?,Alternative_RM_Code = ?, AffiliateId = ?,[Current_Date] =  ?,TradeServiceProvider= ?, CashManagementPartner = ?,E_BankingPartner= ?,RiskManagementPartner= ? where ClientID = ?";
//        String in = clientModel.getClientName() + "," + clientModel.getRM_Code() + "," + clientModel.getAlternative_RM_Code() + "," + clientModel.getAffiliateId() + "," + clientModel.getCurrent_Date() + "," + clientModel.getTradeServiceProvider()
//                + "," + clientModel.getCashManagementPartner() + "," + clientModel.getE_BankingPartner() + "," + clientModel.getRiskManagementPartner() + "," + clientModel.getClientID();
//        AdminDb.dbWork(sql, 10, in);
//    }
}
