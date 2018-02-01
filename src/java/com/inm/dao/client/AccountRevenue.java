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
public class AccountRevenue {
     OperationsDal ops;

    public AccountRevenue() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
     public  void createAccountRevenue(AccountRevenueModel accountRevenueModel ) {
         AccountRevenueInformation accountRevenueInformation = new AccountRevenueInformation(); 
         AccountRevenue ar = new AccountRevenue();  
         accountRevenueInformation.setClientMaster(ar.getClientMasterByID(accountRevenueModel.getClientMaster())); 
         accountRevenueInformation.setAccountRevenueid(accountRevenueModel.getAccountRevenueid());
         accountRevenueInformation.setCurrentshareofwallet(accountRevenueModel.getCurrentshareofwallet());
         accountRevenueInformation.setCurrentyearfeeincometarget(accountRevenueModel.getCurrentyearfeeincometarget());
         accountRevenueInformation.setCurrentyearrevenuetarget(accountRevenueModel.getCurrentyearrevenuetarget());
         accountRevenueInformation.setPercentagegrowthfeeincome(accountRevenueModel.getPercentagegrowthfeeincome());
         accountRevenueInformation.setPercentagegrowthrevenue(accountRevenueModel.getPercentagegrowthrevenue());
         accountRevenueInformation.setPrioryearactualfeeincome(accountRevenueModel.getPrioryearactualfeeincome());
         accountRevenueInformation.setPrioryearactualrevenue(accountRevenueModel.getPrioryearactualrevenue());
         accountRevenueInformation.setTargetshareofwallet(accountRevenueModel.getTargetshareofwallet());
         accountRevenueInformation.setTotalvalueofidopportunities(accountRevenueModel.getTotalvalueofidopportunities());
          ops.save(accountRevenueInformation);
    }
     public  void updateAccountRevenue(AccountRevenueModel accountRevenueModel ) {
         AccountRevenueInformation accountRevenueInformation = new AccountRevenueInformation(); 
         AccountRevenue ar = new AccountRevenue();  
         accountRevenueInformation.setClientMaster(ar.getClientMasterByID(accountRevenueModel.getClientMaster())); 
         accountRevenueInformation.setAccountRevenueid(accountRevenueModel.getAccountRevenueid());
         accountRevenueInformation.setCurrentshareofwallet(accountRevenueModel.getCurrentshareofwallet());
         accountRevenueInformation.setCurrentyearfeeincometarget(accountRevenueModel.getCurrentyearfeeincometarget());
         accountRevenueInformation.setCurrentyearrevenuetarget(accountRevenueModel.getCurrentyearrevenuetarget());
         accountRevenueInformation.setPercentagegrowthfeeincome(accountRevenueModel.getPercentagegrowthfeeincome());
         accountRevenueInformation.setPercentagegrowthrevenue(accountRevenueModel.getPercentagegrowthrevenue());
         accountRevenueInformation.setPrioryearactualfeeincome(accountRevenueModel.getPrioryearactualfeeincome());
         accountRevenueInformation.setPrioryearactualrevenue(accountRevenueModel.getPrioryearactualrevenue());
         accountRevenueInformation.setTargetshareofwallet(accountRevenueModel.getTargetshareofwallet());
         accountRevenueInformation.setTotalvalueofidopportunities(accountRevenueModel.getTotalvalueofidopportunities());
          ops.saveOrUpdate(accountRevenueInformation);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
      public ArrayList<AccountRevenueModel> getAccountRevenuenfo(String rmCode) {
        AccountRevenue ar = new AccountRevenue();
        ArrayList<AccountRevenueModel> accountRevenueModelList = new ArrayList<AccountRevenueModel>();
        CoreQuery coreQuery = new CoreQuery("from AccountRevenueInformation where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List accRev = ops.fetch(coreQuery);
        for (Object accRevObject : accRev) {
            AccountRevenueInformation accountRevenueInformation = (AccountRevenueInformation) accRevObject;
            AccountRevenueModel accountRevenueModel = new AccountRevenueModel(); 
            accountRevenueModel.setClientMaster(ar.getClientMaster(rmCode).getClientname()); 
            accountRevenueModel.setAccountRevenueid(accountRevenueInformation.getAccountRevenueid());
            accountRevenueModel.setCurrentshareofwallet(accountRevenueInformation.getCurrentshareofwallet());
            accountRevenueModel.setCurrentyearfeeincometarget(accountRevenueInformation.getCurrentyearfeeincometarget());
            accountRevenueModel.setCurrentyearrevenuetarget(accountRevenueInformation.getCurrentyearrevenuetarget());
            accountRevenueModel.setPercentagegrowthfeeincome(accountRevenueInformation.getPercentagegrowthfeeincome());
            accountRevenueModel.setPercentagegrowthrevenue(accountRevenueInformation.getPercentagegrowthrevenue());
            accountRevenueModel.setPrioryearactualfeeincome(accountRevenueInformation.getPrioryearactualfeeincome());
            accountRevenueModel.setPrioryearactualrevenue(accountRevenueInformation.getPrioryearactualrevenue());
            accountRevenueModel.setTargetshareofwallet(accountRevenueInformation.getTargetshareofwallet());
            accountRevenueModel.setTotalvalueofidopportunities(accountRevenueInformation.getTotalvalueofidopportunities());
              accountRevenueModelList.add(accountRevenueModel);
        }

        return accountRevenueModelList;
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
public ArrayList<AccountRevenueModel> getAccountRevenuenfoByClientId(String rmCode, String clientId) {
        AccountRevenue ar = new AccountRevenue();
        ArrayList<AccountRevenueModel> accountRevenueModelList = new ArrayList<AccountRevenueModel>();
        CoreQuery coreQuery = new CoreQuery("from AccountRevenueInformation where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientId =:clientId", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientId", clientId);
        List accRev = ops.fetch(coreQuery);
        for (Object accRevObject : accRev) {
            AccountRevenueInformation accountRevenueInformation = (AccountRevenueInformation) accRevObject;
            AccountRevenueModel accountRevenueModel = new AccountRevenueModel(); 
            accountRevenueModel.setClientMaster(ar.getClientMaster(rmCode).getClientname()); 
            accountRevenueModel.setAccountRevenueid(accountRevenueInformation.getAccountRevenueid());
            accountRevenueModel.setCurrentshareofwallet(accountRevenueInformation.getCurrentshareofwallet());
            accountRevenueModel.setCurrentyearfeeincometarget(accountRevenueInformation.getCurrentyearfeeincometarget());
            accountRevenueModel.setCurrentyearrevenuetarget(accountRevenueInformation.getCurrentyearrevenuetarget());
            accountRevenueModel.setPercentagegrowthfeeincome(accountRevenueInformation.getPercentagegrowthfeeincome());
            accountRevenueModel.setPercentagegrowthrevenue(accountRevenueInformation.getPercentagegrowthrevenue());
            accountRevenueModel.setPrioryearactualfeeincome(accountRevenueInformation.getPrioryearactualfeeincome());
            accountRevenueModel.setPrioryearactualrevenue(accountRevenueInformation.getPrioryearactualrevenue());
            accountRevenueModel.setTargetshareofwallet(accountRevenueInformation.getTargetshareofwallet());
            accountRevenueModel.setTotalvalueofidopportunities(accountRevenueInformation.getTotalvalueofidopportunities());
              accountRevenueModelList.add(accountRevenueModel);
        }

        return accountRevenueModelList;
    }
}
