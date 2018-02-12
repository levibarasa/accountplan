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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Levi
 */
public class DealInProgressMaster {
   OperationsDal ops;

    public DealInProgressMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteDealInProgressMaster(DealProgressModel dealProgressModel) {
     return ops.delete(dealProgressModel);
 }
      public  void createDealInProgress(DealProgressModel dealProgressModel ) {
         Dealinprogress dealinprogress = new Dealinprogress(); 
         DealInProgressMaster dip = new DealInProgressMaster();  
         dealinprogress.setClientMaster(dip.getClientMasterByID(dealProgressModel.getClientMaster()));
         dealinprogress.setAllbankswalletsize(dealProgressModel.getAllbankswalletsize());
         dealinprogress.setComments(dealProgressModel.getComments());
         dealinprogress.setCurrentlyused(dealProgressModel.getCurrentlyused());
         dealinprogress.setDealinprogressid(dealProgressModel.getDealinprogressid());
         dealinprogress.setImdealamount(dealProgressModel.getImdealamount());
         dealinprogress.setImexpectedrevenue(dealProgressModel.getImexpectedrevenue());
         dealinprogress.setImprojectedwalletshare(dealProgressModel.getImprojectedwalletshare());
         dealinprogress.setLookupmasterByCompletionmonthlookupid(dip.getLookUpMasterByID(dealProgressModel.getCompletionmonthlookupid()));
         dealinprogress.setLookupmasterByDealpropabilitylookupid(dip.getLookUpMasterByID(dealProgressModel.getDealpropabilitylookupid()));
         dealinprogress.setLookupmasterByDealstagelookupmasterid(dip.getLookUpMasterByID(dealProgressModel.getDealstagelookupmasterid()));
         dealinprogress.setLookupmasterByDealtypelookupmasterid(dip.getLookUpMasterByID(dealProgressModel.getDealtypelookupmasterid()));
         dealinprogress.setLookupmasterByProductlookupid(dip.getLookUpMasterByID(dealProgressModel.getProductlookupid()));
         dealinprogress.setLookupmasterByDealstatuslookupmasterid(dip.getLookUpMasterByID(dealProgressModel.getDealstatuslookupmasterid()));
         ops.save(dealinprogress);
    }
      public  void updateDealInProgress(DealProgressModel dealProgressModel ) {
         Dealinprogress dealinprogress = new Dealinprogress(); 
         DealInProgressMaster dip = new DealInProgressMaster();  
         dealinprogress.setClientMaster(dip.getClientMasterByID(dealProgressModel.getClientMaster()));
         dealinprogress.setAllbankswalletsize(dealProgressModel.getAllbankswalletsize());
         dealinprogress.setComments(dealProgressModel.getComments());
         dealinprogress.setCurrentlyused(dealProgressModel.getCurrentlyused());
         dealinprogress.setDealinprogressid(dealProgressModel.getDealinprogressid());
         dealinprogress.setImdealamount(dealProgressModel.getImdealamount());
         dealinprogress.setImexpectedrevenue(dealProgressModel.getImexpectedrevenue());
         dealinprogress.setImprojectedwalletshare(dealProgressModel.getImprojectedwalletshare());
         dealinprogress.setLookupmasterByCompletionmonthlookupid(dip.getLookUpMasterByID(dealProgressModel.getCompletionmonthlookupid()));
         dealinprogress.setLookupmasterByDealpropabilitylookupid(dip.getLookUpMasterByID(dealProgressModel.getDealpropabilitylookupid()));
         dealinprogress.setLookupmasterByDealstagelookupmasterid(dip.getLookUpMasterByID(dealProgressModel.getDealstagelookupmasterid()));
         dealinprogress.setLookupmasterByDealtypelookupmasterid(dip.getLookUpMasterByID(dealProgressModel.getDealtypelookupmasterid()));
         dealinprogress.setLookupmasterByProductlookupid(dip.getLookUpMasterByID(dealProgressModel.getProductlookupid()));
       dealinprogress.setLookupmasterByDealstatuslookupmasterid(dip.getLookUpMasterByID(dealProgressModel.getDealstatuslookupmasterid()));
         ops.saveOrUpdate(dealinprogress);
    }
      public Lookupmaster getLookUpMasterByID(int lookupmasterid) {
        CoreQuery coreQuery = new CoreQuery("from Lookupmaster where lookupmasterid =:lookupmasterid", true);
        coreQuery.addParam("lookupmasterid", lookupmasterid); 
        List lkup = ops.fetch(coreQuery);
        return (Lookupmaster) lkup.get(0);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
   public  ArrayList<DealProgressModel> getDealInProgressInfo(String rmCode) { 
       ArrayList<DealProgressModel>  dealProgressModelList = new ArrayList<DealProgressModel> ();
        DealInProgressMaster dip = new DealInProgressMaster();
         CoreQuery coreQuery = new CoreQuery("from Dealinprogress where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List dipMaster = ops.fetch(coreQuery);
        for (Object dipObject : dipMaster) {
            Dealinprogress  dealinprogress = (Dealinprogress) dipObject;
            DealProgressModel  dealProgressModel = new DealProgressModel(); 
            dealProgressModel.setClientMaster(dip.getClientMaster(dealinprogress.getClientMaster().getClientid()).getClientname());   
            dealProgressModel.setAllbankswalletsize(dealinprogress.getAllbankswalletsize());
            dealProgressModel.setComments(dealinprogress.getComments());
            dealProgressModel.setCompletionmonthlookupid(dealinprogress.getLookupmasterByCompletionmonthlookupid().getLookupmasterid());
            dealProgressModel.setCurrentlyused(dealinprogress.getCurrentlyused());
            dealProgressModel.setDealinprogressid(dealinprogress.getDealinprogressid());
            dealProgressModel.setDealpropabilitylookupid(dealinprogress.getLookupmasterByDealpropabilitylookupid().getLookupmasterid());
            dealProgressModel.setDealstagelookupmasterid(dealinprogress.getLookupmasterByDealstagelookupmasterid().getLookupmasterid());
            dealProgressModel.setDealstatuslookupmasterid(dealinprogress.getLookupmasterByDealstatuslookupmasterid().getLookupmasterid());
            dealProgressModel.setDealtypelookupmasterid(dealinprogress.getLookupmasterByDealtypelookupmasterid().getLookupmasterid());
            dealProgressModel.setImdealamount(dealinprogress.getImdealamount());
            dealProgressModel.setImexpectedrevenue(dealinprogress.getImexpectedrevenue());
            dealProgressModel.setImprojectedwalletshare(dealinprogress.getImprojectedwalletshare());
            dealProgressModel.setProductlookupid(dealinprogress.getLookupmasterByProductlookupid().getLookupmasterid());
                dealProgressModelList.add(dealProgressModel);
        }
        return dealProgressModelList;
      }
   public  ArrayList<DealProgressModel> getDealInProgressInfoByClientId(String rmCode,String clientid) { 
       ArrayList<DealProgressModel>  dealProgressModelList = new ArrayList<DealProgressModel> ();
        DealInProgressMaster dip = new DealInProgressMaster();
         CoreQuery coreQuery = new CoreQuery("from Dealinprogress where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List dipMaster = ops.fetch(coreQuery);
        for (Object dipObject : dipMaster) {
            Dealinprogress  dealinprogress = (Dealinprogress) dipObject;
            DealProgressModel  dealProgressModel = new DealProgressModel(); 
            dealProgressModel.setClientMaster(dip.getClientMaster(dealinprogress.getClientMaster().getClientid()).getClientname());   
            dealProgressModel.setAllbankswalletsize(dealinprogress.getAllbankswalletsize());
            dealProgressModel.setComments(dealinprogress.getComments());
            dealProgressModel.setCompletionmonthlookupid(dealinprogress.getLookupmasterByCompletionmonthlookupid().getLookupmasterid());
            dealProgressModel.setCurrentlyused(dealinprogress.getCurrentlyused());
            dealProgressModel.setDealinprogressid(dealinprogress.getDealinprogressid());
            dealProgressModel.setDealpropabilitylookupid(dealinprogress.getLookupmasterByDealpropabilitylookupid().getLookupmasterid());
            dealProgressModel.setDealstagelookupmasterid(dealinprogress.getLookupmasterByDealstagelookupmasterid().getLookupmasterid());
            dealProgressModel.setDealstatuslookupmasterid(dealinprogress.getLookupmasterByDealstatuslookupmasterid().getLookupmasterid());
            dealProgressModel.setDealtypelookupmasterid(dealinprogress.getLookupmasterByDealtypelookupmasterid().getLookupmasterid());
            dealProgressModel.setImdealamount(dealinprogress.getImdealamount());
            dealProgressModel.setImexpectedrevenue(dealinprogress.getImexpectedrevenue());
            dealProgressModel.setImprojectedwalletshare(dealinprogress.getImprojectedwalletshare());
            dealProgressModel.setProductlookupid(dealinprogress.getLookupmasterByProductlookupid().getLookupmasterid());
                dealProgressModelList.add(dealProgressModel);
        }
        return dealProgressModelList;
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
