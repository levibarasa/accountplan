/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.qualitativeinformation;

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
public class SaleActionPlan {
  OperationsDal ops;

    public SaleActionPlan() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteSaleActionPlan(SalesactionplanModel salesactionplanModel) {
     return ops.delete(salesactionplanModel);
 }
    public  void createSaleActionPlan(SalesactionplanModel salesactionplanModel ) {
         Salesactionplan salesactionplan = new Salesactionplan(); 
         SaleActionPlan sap = new SaleActionPlan();  
         salesactionplan.setClientMaster(sap.getClientMasterByID(salesactionplanModel.getClientMaster()));
         salesactionplan.setClocontactpersion(salesactionplanModel.getClocontactpersion());
         salesactionplan.setClodeadlinedate(salesactionplanModel.getClodatelinedate());
         salesactionplan.setClopersonresponsibleforaction(salesactionplanModel.getClopersonresponsibleforaction());
         salesactionplan.setSalesactionplanid(salesactionplanModel.getSalesactionplanid());
         salesactionplan.setSpecificAction(salesactionplanModel.getSpecification());
       ops.save(salesactionplan);
    }
    public  void updateSaleActionPlan(SalesactionplanModel salesactionplanModel ) {
         Salesactionplan salesactionplan = new Salesactionplan(); 
         SaleActionPlan sap = new SaleActionPlan();  
         salesactionplan.setClientMaster(sap.getClientMasterByID(salesactionplanModel.getClientMaster()));
         salesactionplan.setClocontactpersion(salesactionplanModel.getClocontactpersion());
         salesactionplan.setClodeadlinedate(salesactionplanModel.getClodatelinedate());
         salesactionplan.setClopersonresponsibleforaction(salesactionplanModel.getClopersonresponsibleforaction());
         salesactionplan.setSalesactionplanid(salesactionplanModel.getSalesactionplanid());
         salesactionplan.setSpecificAction(salesactionplanModel.getSpecification());
       ops.saveOrUpdate(salesactionplan);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
   public  ArrayList<SalesactionplanModel> getSaleActionPlanInfo(String rmCode) { 
       ArrayList<SalesactionplanModel>  salesactionplanModelList = new ArrayList<SalesactionplanModel> ();
        SaleActionPlan saleActionPlan = new SaleActionPlan();
         CoreQuery coreQuery = new CoreQuery("from Salesactionplan where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List sspMaster = ops.fetch(coreQuery);
        for (Object sspObject : sspMaster) {
            Salesactionplan  salesactionplan = (Salesactionplan) sspObject;
            SalesactionplanModel salesactionplanModel = new SalesactionplanModel(); 
            salesactionplanModel.setClientMaster(saleActionPlan.getClientMaster(salesactionplan.getClientMaster().getClientid()).getClientname());
            salesactionplanModel.setClocontactpersion(salesactionplan.getClocontactpersion());
            salesactionplanModel.setClodatelinedate(salesactionplan.getClodeadlinedate());
            salesactionplanModel.setClopersonresponsibleforaction(salesactionplan.getClopersonresponsibleforaction());
            salesactionplanModel.setSalesactionplanid(salesactionplan.getSalesactionplanid());
            salesactionplanModel.setSpecification(salesactionplan.getSpecificAction());
            salesactionplanModelList.add(salesactionplanModel);
        }
        return salesactionplanModelList;
      }
   public  ArrayList<SalesactionplanModel> getSaleActionPlanInfoByClientId(String rmCode,String clientid) { 
       ArrayList<SalesactionplanModel>  salesactionplanModelList = new ArrayList<SalesactionplanModel> ();
        SaleActionPlan saleActionPlan = new SaleActionPlan();
         CoreQuery coreQuery = new CoreQuery("from Salesactionplan where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List sspMaster = ops.fetch(coreQuery);
        for (Object sspObject : sspMaster) {
            Salesactionplan  salesactionplan = (Salesactionplan) sspObject;
            SalesactionplanModel salesactionplanModel = new SalesactionplanModel(); 
            salesactionplanModel.setClientMaster(saleActionPlan.getClientMaster(salesactionplan.getClientMaster().getClientid()).getClientname());
            salesactionplanModel.setClocontactpersion(salesactionplan.getClocontactpersion());
            salesactionplanModel.setClodatelinedate(salesactionplan.getClodeadlinedate());
            salesactionplanModel.setClopersonresponsibleforaction(salesactionplan.getClopersonresponsibleforaction());
            salesactionplanModel.setSalesactionplanid(salesactionplan.getSalesactionplanid());
            salesactionplanModel.setSpecification(salesactionplan.getSpecificAction());
            salesactionplanModelList.add(salesactionplanModel);
        }
        return salesactionplanModelList;
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
                     
                     ClientModel clientModel =   new ClientModel(clientMaster.getClientid(), clientMaster.getRmCodelistByRmCode().getRmCode(), clientMaster.getRmCodelistByAlternativeRmCode().getRmCode(), clientMaster.getLookupmaster().getValue(), clientMaster.getClientname(), clientMaster.getCurrentDate(),clientMaster.getTradeserviceprovider(), clientMaster.getCashmanagementpartner(), clientMaster.getECommercepartner(), clientMaster.getCreditmanager(), clientMaster.getTreasurypartner(), clientMaster.getInternetbankingpartner(),clientMaster.getAssetfinancepartner(), clientMaster.getCardspartner(),clientMaster.getBancassurancepartner());
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
}
