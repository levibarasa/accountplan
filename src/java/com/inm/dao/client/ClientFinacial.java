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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Levi
 */
public class ClientFinacial {
      OperationsDal ops;

    public ClientFinacial() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
     public  boolean deleteClientFinacial(ClientFinacialModel clientFinacialModel ) {
     return ops.delete(clientFinacialModel);
 }
    public  void createClientFinacial(ClientFinacialModel clientFinacialModel ) {
         ClientFinancial clientFinancial = new ClientFinancial(); 
         ClientFinacial cf = new ClientFinacial();  
         clientFinancial.setClientMaster(cf.getClientMasterByID(clientFinacialModel.getClientMaster()));
         clientFinancial.setCashflowcycle(clientFinacialModel.getCashflowcycle());
         clientFinancial.setClientFinancialid(clientFinacialModel.getClientFinancialid());
         clientFinancial.setGearingratio(clientFinacialModel.getGearingratio());
         clientFinancial.setOperatingprofit(clientFinacialModel.getOperatingprofit());
         clientFinancial.setTotaldebt(clientFinacialModel.getTotaldebt());
         clientFinancial.setTotaldeposits(clientFinacialModel.getTotaldeposits());
         clientFinancial.setTurnover(clientFinacialModel.getTurnover());
           ops.save(clientFinancial);
    }
    public  void updateClientFinacial(ClientFinacialModel clientFinacialModel ) {
         ClientFinancial clientFinancial = new ClientFinancial(); 
         ClientFinacial cf = new ClientFinacial();  
         clientFinancial.setClientMaster(cf.getClientMasterByID(clientFinacialModel.getClientMaster()));
         clientFinancial.setCashflowcycle(clientFinacialModel.getCashflowcycle());
         clientFinancial.setClientFinancialid(clientFinacialModel.getClientFinancialid());
         clientFinancial.setGearingratio(clientFinacialModel.getGearingratio());
         clientFinancial.setOperatingprofit(clientFinacialModel.getOperatingprofit());
         clientFinancial.setTotaldebt(clientFinacialModel.getTotaldebt());
         clientFinancial.setTotaldeposits(clientFinacialModel.getTotaldeposits());
         clientFinancial.setTurnover(clientFinacialModel.getTurnover());
           ops.saveOrUpdate(clientFinancial);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
      public ArrayList<ClientFinacialModel> getClientFinancialInfo(String rmCode) {
        ClientFinacial cf = new ClientFinacial();
        ArrayList<ClientFinacialModel> creditFinancialList = new ArrayList<ClientFinacialModel>();
        CoreQuery coreQuery = new CoreQuery("from ClientFinancial where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List creditFinMaster = ops.fetch(coreQuery);
        for (Object creObject : creditFinMaster) {
            ClientFinancial clientFinancial = (ClientFinancial) creObject;
            ClientFinacialModel clientFinacialModel = new ClientFinacialModel();
            clientFinacialModel.setClientFinancialid(clientFinancial.getClientFinancialid());
            clientFinacialModel.setCashflowcycle(clientFinancial.getCashflowcycle());
            clientFinacialModel.setGearingratio(clientFinancial.getGearingratio());
            clientFinacialModel.setOperatingprofit(clientFinancial.getOperatingprofit());
            clientFinacialModel.setTotaldebt(clientFinancial.getTotaldebt());
            clientFinacialModel.setTotaldeposits(clientFinancial.getTotaldeposits() );
            clientFinacialModel.setTurnover(clientFinancial.getTurnover()); 
            clientFinacialModel.setClientMaster(cf.getClientMaster(clientFinancial.getClientMaster().getClientid()).getClientname()); 
            
              creditFinancialList.add(clientFinacialModel);
        }

        return creditFinancialList;
    }
        
      public ArrayList<ClientFinacialModel> getClientFinancialInfoByClientId(String rmCode,String clientid) {
        ClientFinacial cf = new ClientFinacial();
        ArrayList<ClientFinacialModel> creditFinancialList = new ArrayList<ClientFinacialModel>();
        CoreQuery coreQuery = new CoreQuery("from ClientFinancial where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List creditFinMaster = ops.fetch(coreQuery);
        for (Object creObject : creditFinMaster) {
            ClientFinancial clientFinancial = (ClientFinancial) creObject;
            ClientFinacialModel clientFinacialModel = new ClientFinacialModel();
            clientFinacialModel.setClientFinancialid(clientFinancial.getClientFinancialid());
            clientFinacialModel.setCashflowcycle(clientFinancial.getCashflowcycle());
            clientFinacialModel.setGearingratio(clientFinancial.getGearingratio());
            clientFinacialModel.setOperatingprofit(clientFinancial.getOperatingprofit());
            clientFinacialModel.setTotaldebt(clientFinancial.getTotaldebt());
            clientFinacialModel.setTotaldeposits(clientFinancial.getTotaldeposits() );
            clientFinacialModel.setTurnover(clientFinancial.getTurnover()); 
            clientFinacialModel.setClientMaster(cf.getClientMaster(clientFinancial.getClientMaster().getClientid()).getClientname()); 
            
              creditFinancialList.add(clientFinacialModel);
        }

        return creditFinancialList;
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
        
}
