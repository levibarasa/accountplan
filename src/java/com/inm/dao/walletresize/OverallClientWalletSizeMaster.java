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
public class OverallClientWalletSizeMaster {
      OperationsDal ops;

    public OverallClientWalletSizeMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
     public  boolean deleteOverallClientWalletSizeMaster(OverallClientWalletSizeModel ocwsModel ) {
     return ops.delete(ocwsModel);
 }
    public  void createOverallClientWalletSize(OverallClientWalletSizeModel ocwsModel ) {
         Overallclientwalletsize ocws = new Overallclientwalletsize(); 
         OverallClientWalletSizeMaster ocwsm = new OverallClientWalletSizeMaster();  
         ocws.setClientMaster(ocwsm.getClientMasterByID(ocwsModel.getClientMaster()));
         ocws.setAssetsinterestincome(ocwsModel.getAssetsinterestincome());
         ocws.setAverageimdepositmargin(ocwsModel.getAverageimdepositmargin());
         ocws.setAverageimloanmargin(ocwsModel.getAverageimloanmargin());
         ocws.setClientbankingwallet(ocwsModel.getClientbankingwallet());
         ocws.setClientwalletsizeid(ocwsModel.getClientwalletsizeid());
         ocws.setEstimatedcorporatedeposits(ocwsModel.getEstimatedcorporatedeposits());
         ocws.setEstimatedwalletshare(ocwsModel.getEstimatedwalletshare());
         ocws.setImfeeincome(ocwsModel.getImfeeincome());
         ocws.setImrevenue(ocwsModel.getImrevenue());
         ocws.setNetintrstliabltyincome(ocwsModel.getNetintrstliabltyincome());
         ocws.setTotalcorporatedebt(ocwsModel.getTotalcorporatedebt());
         ocws.setTotalfeeincome(ocwsModel.getTotalfeeincome());
         ocws.setTotalnetinterestincome(ocwsModel.getTotalnetinterestincome()); 
         ocws.setTotalnii(ocwsModel.getTotalnii());
         ops.save(ocws);
    }
    public  void updateOverallClientWalletSize(OverallClientWalletSizeModel ocwsModel ) {
         Overallclientwalletsize ocws = new Overallclientwalletsize(); 
         OverallClientWalletSizeMaster ocwsm = new OverallClientWalletSizeMaster();  
         ocws.setClientMaster(ocwsm.getClientMasterByID(ocwsModel.getClientMaster()));
         ocws.setAssetsinterestincome(ocwsModel.getAssetsinterestincome());
         ocws.setAverageimdepositmargin(ocwsModel.getAverageimdepositmargin());
         ocws.setAverageimloanmargin(ocwsModel.getAverageimloanmargin());
         ocws.setClientbankingwallet(ocwsModel.getClientbankingwallet());
         ocws.setClientwalletsizeid(ocwsModel.getClientwalletsizeid());
         ocws.setEstimatedcorporatedeposits(ocwsModel.getEstimatedcorporatedeposits());
         ocws.setEstimatedwalletshare(ocwsModel.getEstimatedwalletshare());
         ocws.setImfeeincome(ocwsModel.getImfeeincome());
         ocws.setImrevenue(ocwsModel.getImrevenue());
         ocws.setNetintrstliabltyincome(ocwsModel.getNetintrstliabltyincome());
         ocws.setTotalcorporatedebt(ocwsModel.getTotalcorporatedebt());
         ocws.setTotalfeeincome(ocwsModel.getTotalfeeincome());
         ocws.setTotalnetinterestincome(ocwsModel.getTotalnetinterestincome()); 
         ocws.setTotalnii(ocwsModel.getTotalnii());
         ops.saveOrUpdate(ocws);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
    public ArrayList<OverallClientWalletSizeModel> getOverallclientwalletsizeInfo(String rmCode) {
         ArrayList<OverallClientWalletSizeModel> overallClientWalletSizeModelLst = new ArrayList<OverallClientWalletSizeModel>();
       OverallClientWalletSizeMaster ocws = new OverallClientWalletSizeMaster();
         CoreQuery coreQuery = new CoreQuery("from Overallclientwalletsize where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List ocwsMaster = ops.fetch(coreQuery);
        for (Object ocwsObject : ocwsMaster) {
            Overallclientwalletsize overallclientwalletsize = (Overallclientwalletsize) ocwsObject;
            OverallClientWalletSizeModel clientWalletSizeModel = new OverallClientWalletSizeModel(); 
            clientWalletSizeModel.setClientMaster(ocws.getClientMaster(overallclientwalletsize.getClientMaster().getClientid()).getClientname());
            clientWalletSizeModel.setAssetsinterestincome(overallclientwalletsize.getAssetsinterestincome());
            clientWalletSizeModel.setAverageimdepositmargin(overallclientwalletsize.getAverageimdepositmargin());
            clientWalletSizeModel.setAverageimloanmargin(overallclientwalletsize.getAverageimloanmargin());
            clientWalletSizeModel.setClientbankingwallet(overallclientwalletsize.getClientbankingwallet());
            clientWalletSizeModel.setClientwalletsizeid(overallclientwalletsize.getClientwalletsizeid());
            clientWalletSizeModel.setEstimatedcorporatedeposits(overallclientwalletsize.getEstimatedcorporatedeposits());
            clientWalletSizeModel.setEstimatedwalletshare(overallclientwalletsize.getEstimatedwalletshare());
            clientWalletSizeModel.setImfeeincome(overallclientwalletsize.getImfeeincome());
            clientWalletSizeModel.setImrevenue(overallclientwalletsize.getImrevenue());
            clientWalletSizeModel.setNetintrstliabltyincome(overallclientwalletsize.getNetintrstliabltyincome());
            clientWalletSizeModel.setTotalcorporatedebt(overallclientwalletsize.getTotalcorporatedebt());
            clientWalletSizeModel.setTotalfeeincome(overallclientwalletsize.getTotalfeeincome());
            clientWalletSizeModel.setTotalnetinterestincome(overallclientwalletsize.getTotalnetinterestincome());
            clientWalletSizeModel.setTotalnii(overallclientwalletsize.getTotalnii());
              overallClientWalletSizeModelLst.add(clientWalletSizeModel);
        }

        return overallClientWalletSizeModelLst;
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
     public ArrayList<OverallClientWalletSizeModel> getOverallclientwalletsizeInfoByClientId(String rmCode,String clientid) {
         ArrayList<OverallClientWalletSizeModel> overallClientWalletSizeModelLst = new ArrayList<OverallClientWalletSizeModel>();
       OverallClientWalletSizeMaster ocws = new OverallClientWalletSizeMaster();
         CoreQuery coreQuery = new CoreQuery("from Overallclientwalletsize where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid ", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List ocwsMaster = ops.fetch(coreQuery);
        for (Object ocwsObject : ocwsMaster) {
            Overallclientwalletsize overallclientwalletsize = (Overallclientwalletsize) ocwsObject;
            OverallClientWalletSizeModel clientWalletSizeModel = new OverallClientWalletSizeModel(); 
            clientWalletSizeModel.setClientMaster(ocws.getClientMaster(overallclientwalletsize.getClientMaster().getClientid()).getClientname());
            clientWalletSizeModel.setAssetsinterestincome(overallclientwalletsize.getAssetsinterestincome());
            clientWalletSizeModel.setAverageimdepositmargin(overallclientwalletsize.getAverageimdepositmargin());
            clientWalletSizeModel.setAverageimloanmargin(overallclientwalletsize.getAverageimloanmargin());
            clientWalletSizeModel.setClientbankingwallet(overallclientwalletsize.getClientbankingwallet());
            clientWalletSizeModel.setClientwalletsizeid(overallclientwalletsize.getClientwalletsizeid());
            clientWalletSizeModel.setEstimatedcorporatedeposits(overallclientwalletsize.getEstimatedcorporatedeposits());
            clientWalletSizeModel.setEstimatedwalletshare(overallclientwalletsize.getEstimatedwalletshare());
            clientWalletSizeModel.setImfeeincome(overallclientwalletsize.getImfeeincome());
            clientWalletSizeModel.setImrevenue(overallclientwalletsize.getImrevenue());
            clientWalletSizeModel.setNetintrstliabltyincome(overallclientwalletsize.getNetintrstliabltyincome());
            clientWalletSizeModel.setTotalcorporatedebt(overallclientwalletsize.getTotalcorporatedebt());
            clientWalletSizeModel.setTotalfeeincome(overallclientwalletsize.getTotalfeeincome());
            clientWalletSizeModel.setTotalnetinterestincome(overallclientwalletsize.getTotalnetinterestincome());
            clientWalletSizeModel.setTotalnii(overallclientwalletsize.getTotalnii());
              overallClientWalletSizeModelLst.add(clientWalletSizeModel);
        }

        return overallClientWalletSizeModelLst;
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
