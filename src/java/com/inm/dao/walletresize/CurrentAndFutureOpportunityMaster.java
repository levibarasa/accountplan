/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.walletresize;

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
public class CurrentAndFutureOpportunityMaster {
   OperationsDal ops;

    public CurrentAndFutureOpportunityMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteCurrentAndFutureOpportunityMaster(CurrentAndFutureOpportunityModel cfoModel ) {
     return ops.delete(cfoModel);
 }
    public  void createCurrentAndFutureOpportunity(CurrentAndFutureOpportunityModel cfoModel ) {
         Currentandfutureopportunities cfo = new Currentandfutureopportunities(); 
         CurrentAndFutureOpportunityMaster cfom = new CurrentAndFutureOpportunityMaster();  
         cfo.setClientMaster(cfom.getClientMasterByID(cfoModel.getClientMaster()));
         cfo.setLookupmaster(cfom.getLookUpMasterByID(cfoModel.getLookupmaster()));
         cfo.setAllbankswalletsizrevmanual(cfoModel.getAllbankswalletsizrevmanual());
         cfo.setAssetestimatedtotal(cfoModel.getAssetestimatedtotal());
         cfo.setAssetsnetinterestincome(cfoModel.getAssetsnetinterestincome());
         cfo.setCafoppid(cfoModel.getCafoppid());
         cfo.setDealvolassets(cfoModel.getDealvolassets());
         cfo.setDealvolliabilities(cfoModel.getDealvolliabilities());
         cfo.setDealvolrevenue(cfoModel.getDealvolrevenue());
         cfo.setDealvolumefees(cfoModel.getDealvolumefees());
         cfo.setEstimatedtotalasset(cfoModel.getEstimatedtotalasset());
         cfo.setEstimatedtotalliability(cfoModel.getEstimatedtotalliability());
         cfo.setImassetaveragefeerate(cfoModel.getImassetaveragefeerate());
         cfo.setImaverageinterestmargin(cfoModel.getImaverageinterestmargin());
         cfo.setImavrgliabilityintrestmargin(cfoModel.getImavrgliabilityintrestmargin());
         cfo.setImexpectedrevenue(cfoModel.getImexpectedrevenue());
         cfo.setImliabilityaveragefeerate(cfoModel.getImliabilityaveragefeerate());
         cfo.setImprojectedwalletshare(cfoModel.getImprojectedwalletshare());
         cfo.setImwalletsize(cfoModel.getImwalletsize());
         cfo.setIncometotalfee(cfoModel.getIncometotalfee()); 
         cfo.setLiabilityestimatedtotal(cfoModel.getLiabilityestimatedtotal());
         cfo.setLiabilityfeeincome(cfoModel.getLiabilityfeeincome());
         cfo.setLiabilitynetinterestincome(cfoModel.getLiabilitynetinterestincome());
         cfo.setPercentwalletsharemanual(cfoModel.getPercentwalletsharemanual());
         cfo.setTotalnetinterestincome(cfoModel.getTotalnetinterestincome());
            ops.save(cfo);
    }
    public  void updateCurrentAndFutureOpportunity(CurrentAndFutureOpportunityModel cfoModel ) {
         Currentandfutureopportunities cfo = new Currentandfutureopportunities(); 
         CurrentAndFutureOpportunityMaster cfom = new CurrentAndFutureOpportunityMaster();  
         cfo.setClientMaster(cfom.getClientMasterByID(cfoModel.getClientMaster()));
         cfo.setLookupmaster(cfom.getLookUpMasterByID(cfoModel.getLookupmaster()));
         cfo.setAllbankswalletsizrevmanual(cfoModel.getAllbankswalletsizrevmanual());
         cfo.setAssetestimatedtotal(cfoModel.getAssetestimatedtotal());
         cfo.setAssetsnetinterestincome(cfoModel.getAssetsnetinterestincome());
         cfo.setCafoppid(cfoModel.getCafoppid());
         cfo.setDealvolassets(cfoModel.getDealvolassets());
         cfo.setDealvolliabilities(cfoModel.getDealvolliabilities());
         cfo.setDealvolrevenue(cfoModel.getDealvolrevenue());
         cfo.setDealvolumefees(cfoModel.getDealvolumefees());
         cfo.setEstimatedtotalasset(cfoModel.getEstimatedtotalasset());
         cfo.setEstimatedtotalliability(cfoModel.getEstimatedtotalliability());
         cfo.setImassetaveragefeerate(cfoModel.getImassetaveragefeerate());
         cfo.setImaverageinterestmargin(cfoModel.getImaverageinterestmargin());
         cfo.setImavrgliabilityintrestmargin(cfoModel.getImavrgliabilityintrestmargin());
         cfo.setImexpectedrevenue(cfoModel.getImexpectedrevenue());
         cfo.setImliabilityaveragefeerate(cfoModel.getImliabilityaveragefeerate());
         cfo.setImprojectedwalletshare(cfoModel.getImprojectedwalletshare());
         cfo.setImwalletsize(cfoModel.getImwalletsize());
         cfo.setIncometotalfee(cfoModel.getIncometotalfee()); 
         cfo.setLiabilityestimatedtotal(cfoModel.getLiabilityestimatedtotal());
         cfo.setLiabilityfeeincome(cfoModel.getLiabilityfeeincome());
         cfo.setLiabilitynetinterestincome(cfoModel.getLiabilitynetinterestincome());
         cfo.setPercentwalletsharemanual(cfoModel.getPercentwalletsharemanual());
         cfo.setTotalnetinterestincome(cfoModel.getTotalnetinterestincome());
            ops.saveOrUpdate(cfo);
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
    public ArrayList<CurrentAndFutureOpportunityModel> getCurrentAndFutureOpportunitiesInfo(String rmCode) {
         ArrayList<CurrentAndFutureOpportunityModel> currentAndFutureOpportunityModels = new ArrayList<CurrentAndFutureOpportunityModel>();
       CurrentAndFutureOpportunityMaster cfo = new CurrentAndFutureOpportunityMaster();
         CoreQuery coreQuery = new CoreQuery("from Currentandfutureopportunities where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List ocwsMaster = ops.fetch(coreQuery);
        for (Object cfoObject : ocwsMaster) {
            Currentandfutureopportunities currentandfutureopportunities = (Currentandfutureopportunities) cfoObject;
            CurrentAndFutureOpportunityModel currentAndFutureOpportunityModel = new CurrentAndFutureOpportunityModel(); 
            currentAndFutureOpportunityModel.setClientMaster(cfo.getClientMaster(currentandfutureopportunities.getClientMaster().getClientid()).getClientname()); 
            currentAndFutureOpportunityModel.setAllbankswalletsizrevmanual(currentandfutureopportunities.getAllbankswalletsizrevmanual());
            currentAndFutureOpportunityModel.setAssetestimatedtotal(currentandfutureopportunities.getAssetestimatedtotal());
            currentAndFutureOpportunityModel.setAssetsfeeincome(currentandfutureopportunities.getAssetsfeeincome());
            currentAndFutureOpportunityModel.setCafoppid(currentandfutureopportunities.getCafoppid());
            currentAndFutureOpportunityModel.setDealvolassets(currentandfutureopportunities.getDealvolassets());
            currentAndFutureOpportunityModel.setDealvolliabilities(currentandfutureopportunities.getDealvolliabilities());
            currentAndFutureOpportunityModel.setDealvolrevenue(currentandfutureopportunities.getDealvolrevenue());
            currentAndFutureOpportunityModel.setDealvolumefees(currentandfutureopportunities.getDealvolumefees());
            currentAndFutureOpportunityModel.setEstimatedtotalasset(currentandfutureopportunities.getEstimatedtotalasset());
            currentAndFutureOpportunityModel.setEstimatedtotalliability(currentandfutureopportunities.getEstimatedtotalliability());
            currentAndFutureOpportunityModel.setImassetaveragefeerate(currentandfutureopportunities.getImassetaveragefeerate());
            currentAndFutureOpportunityModel.setImaverageinterestmargin(currentandfutureopportunities.getImaverageinterestmargin());
            currentAndFutureOpportunityModel.setImavrgliabilityintrestmargin(currentandfutureopportunities.getImavrgliabilityintrestmargin());
            currentAndFutureOpportunityModel.setImexpectedrevenue(currentandfutureopportunities.getImexpectedrevenue());
            currentAndFutureOpportunityModel.setImliabilityaveragefeerate(currentandfutureopportunities.getImliabilityaveragefeerate());
            currentAndFutureOpportunityModel.setImprojectedwalletshare(currentandfutureopportunities.getImprojectedwalletshare());
            currentAndFutureOpportunityModel.setImwalletsize(currentandfutureopportunities.getImwalletsize());
            currentAndFutureOpportunityModel.setIncometotalfee(currentandfutureopportunities.getIncometotalfee());
            currentAndFutureOpportunityModel.setLiabilityestimatedtotal(currentandfutureopportunities.getLiabilityestimatedtotal());
            currentAndFutureOpportunityModel.setLiabilityfeeincome(currentandfutureopportunities.getLiabilityfeeincome());
            currentAndFutureOpportunityModel.setLiabilitynetinterestincome(currentandfutureopportunities.getLiabilitynetinterestincome());
            currentAndFutureOpportunityModel.setLookupmaster(currentandfutureopportunities.getLookupmaster().getLookupmasterid());
            currentAndFutureOpportunityModel.setPercentwalletsharemanual(currentandfutureopportunities.getPercentwalletsharemanual());
            currentAndFutureOpportunityModel.setTotalnetinterestincome(currentandfutureopportunities.getTotalnetinterestincome()); 
              currentAndFutureOpportunityModels.add(currentAndFutureOpportunityModel);
        }

        return currentAndFutureOpportunityModels;
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
    public ArrayList<CurrentAndFutureOpportunityModel> getCurrentAndFutureOpportunitiesInfoByClientid(String rmCode,String clientid) {
         ArrayList<CurrentAndFutureOpportunityModel> currentAndFutureOpportunityModels = new ArrayList<CurrentAndFutureOpportunityModel>();
       CurrentAndFutureOpportunityMaster cfo = new CurrentAndFutureOpportunityMaster();
         CoreQuery coreQuery = new CoreQuery("from Currentandfutureopportunities where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid ", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List ocwsMaster = ops.fetch(coreQuery);
        for (Object cfoObject : ocwsMaster) {
            Currentandfutureopportunities currentandfutureopportunities = (Currentandfutureopportunities) cfoObject;
            CurrentAndFutureOpportunityModel currentAndFutureOpportunityModel = new CurrentAndFutureOpportunityModel(); 
            currentAndFutureOpportunityModel.setClientMaster(cfo.getClientMaster(currentandfutureopportunities.getClientMaster().getClientid()).getClientname()); 
            currentAndFutureOpportunityModel.setAllbankswalletsizrevmanual(currentandfutureopportunities.getAllbankswalletsizrevmanual());
            currentAndFutureOpportunityModel.setAssetestimatedtotal(currentandfutureopportunities.getAssetestimatedtotal());
            currentAndFutureOpportunityModel.setAssetsfeeincome(currentandfutureopportunities.getAssetsfeeincome());
            currentAndFutureOpportunityModel.setCafoppid(currentandfutureopportunities.getCafoppid());
            currentAndFutureOpportunityModel.setDealvolassets(currentandfutureopportunities.getDealvolassets());
            currentAndFutureOpportunityModel.setDealvolliabilities(currentandfutureopportunities.getDealvolliabilities());
            currentAndFutureOpportunityModel.setDealvolrevenue(currentandfutureopportunities.getDealvolrevenue());
            currentAndFutureOpportunityModel.setDealvolumefees(currentandfutureopportunities.getDealvolumefees());
            currentAndFutureOpportunityModel.setEstimatedtotalasset(currentandfutureopportunities.getEstimatedtotalasset());
            currentAndFutureOpportunityModel.setEstimatedtotalliability(currentandfutureopportunities.getEstimatedtotalliability());
            currentAndFutureOpportunityModel.setImassetaveragefeerate(currentandfutureopportunities.getImassetaveragefeerate());
            currentAndFutureOpportunityModel.setImaverageinterestmargin(currentandfutureopportunities.getImaverageinterestmargin());
            currentAndFutureOpportunityModel.setImavrgliabilityintrestmargin(currentandfutureopportunities.getImavrgliabilityintrestmargin());
            currentAndFutureOpportunityModel.setImexpectedrevenue(currentandfutureopportunities.getImexpectedrevenue());
            currentAndFutureOpportunityModel.setImliabilityaveragefeerate(currentandfutureopportunities.getImliabilityaveragefeerate());
            currentAndFutureOpportunityModel.setImprojectedwalletshare(currentandfutureopportunities.getImprojectedwalletshare());
            currentAndFutureOpportunityModel.setImwalletsize(currentandfutureopportunities.getImwalletsize());
            currentAndFutureOpportunityModel.setIncometotalfee(currentandfutureopportunities.getIncometotalfee());
            currentAndFutureOpportunityModel.setLiabilityestimatedtotal(currentandfutureopportunities.getLiabilityestimatedtotal());
            currentAndFutureOpportunityModel.setLiabilityfeeincome(currentandfutureopportunities.getLiabilityfeeincome());
            currentAndFutureOpportunityModel.setLiabilitynetinterestincome(currentandfutureopportunities.getLiabilitynetinterestincome());
            currentAndFutureOpportunityModel.setLookupmaster(currentandfutureopportunities.getLookupmaster().getLookupmasterid());
            currentAndFutureOpportunityModel.setPercentwalletsharemanual(currentandfutureopportunities.getPercentwalletsharemanual());
            currentAndFutureOpportunityModel.setTotalnetinterestincome(currentandfutureopportunities.getTotalnetinterestincome()); 
              currentAndFutureOpportunityModels.add(currentAndFutureOpportunityModel);
        }

        return currentAndFutureOpportunityModels;
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
}
