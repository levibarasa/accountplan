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
            clientFinacialModel.setClientMaster(cf.getClientMaster(rmCode).getClientname()); 
            
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
    
//      public static ArrayList<ClientFinacialModel> getClientFinancialInfo(String rmCode) {
//         ArrayList<ClientFinacialModel>  clientFinancialList = new ArrayList<ClientFinacialModel> ();
//         ClientFinacial clientFinacial = new ClientFinacial();
//      String sql = "select Client_FinancialID,ClientID,RM_Code,Turnover,OperatingProfit,TotalDebt,TotalDeposits,GearingRatio,CashFlowCycle from [dbo].[Client_Financial] where RM_Code = ?";
//        String in = rmCode;
//        ArrayList list = AdminDb.execArrayLists(sql, 1, in, 9);
//        for(int n =0;n<list.size(); n++){
//            ArrayList clientItem = (ArrayList) list.get(n);
//        ClientFinacialModel creditInfoModel = new ClientFinacialModel(); 
//        creditInfoModel.setClient_FinancialID((String) clientItem.get(0));
//        creditInfoModel.setClientID( clientFinacial.getClientNameByID((String) clientItem.get(1)));
//        creditInfoModel.setTurnover((String) clientItem.get(2));
//        creditInfoModel.setOperatingProfit((String) clientItem.get(3));
//        creditInfoModel.setTotalDebt((String) clientItem.get(4));
//        creditInfoModel.setTotalDeposits((String) clientItem.get(5));
//        creditInfoModel.setGearingRatio((String) clientItem.get(6));
//        creditInfoModel.setCashFlowCycle((String) clientItem.get(7));
//        clientFinancialList.add(creditInfoModel);
//         }
//        return clientFinancialList;
//      }
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
           public ArrayList<ClientFinacialModel> getClientFinancialInfoByClientId(String rmCode,String clientid ) {
        ClientFinacial cf = new ClientFinacial();
        ArrayList<ClientFinacialModel> creditFinancialList = new ArrayList<ClientFinacialModel>();
        CoreQuery coreQuery = new CoreQuery("from ClientFinancial where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientid =:clientid", true);
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
            clientFinacialModel.setClientMaster(cf.getClientMaster(rmCode).getClientname()); 
            
              creditFinancialList.add(clientFinacialModel);
        }

        return creditFinancialList;
    }
}
