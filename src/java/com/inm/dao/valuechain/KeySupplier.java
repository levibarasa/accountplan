/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.dao.valuechain;

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
public class KeySupplier {
      OperationsDal ops;

    public KeySupplier() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteKeySupplier(KeySupplierModel keySupplierModel ) {
     return ops.delete(keySupplierModel);
 }
    public  void createKeySupplier(KeySupplierModel keySupplierModel ) {
         Keysuppliermaster keysuppliermaster = new Keysuppliermaster(); 
         KeySupplier ks = new KeySupplier();  
         keysuppliermaster.setClientMaster(ks.getClientMasterByID(keySupplierModel.getClientMaster()));
         keysuppliermaster.setLookupmaster(ks.getLookUpMasterByID(keySupplierModel.getLookupmaster()));
         keysuppliermaster.setBankedbyim(keySupplierModel.getBankedbyim());
         keysuppliermaster.setComments(keySupplierModel.getComments());
         keysuppliermaster.setKsContactperson(keySupplierModel.getKsContactperson());
         keysuppliermaster.setKsEmail(keySupplierModel.getKsEmail());
         keysuppliermaster.setKsLocation(keySupplierModel.getKsLocation());
         keysuppliermaster.setKsPhonenumber(keySupplierModel.getKsPhonenumber());
         keysuppliermaster.setKsid(keySupplierModel.getKsid());
         keysuppliermaster.setKsname(keySupplierModel.getKsname());
         keysuppliermaster.setVolofbusiness(keySupplierModel.getVolofbusiness());
         ops.save(keysuppliermaster);
    }
     public  void updateKeySupplier(KeySupplierModel keySupplierModel ) {
         Keysuppliermaster keysuppliermaster = new Keysuppliermaster(); 
         KeySupplier ks = new KeySupplier();  
         keysuppliermaster.setClientMaster(ks.getClientMasterByID(keySupplierModel.getClientMaster()));
         keysuppliermaster.setLookupmaster(ks.getLookUpMasterByID(keySupplierModel.getLookupmaster()));
         keysuppliermaster.setBankedbyim(keySupplierModel.getBankedbyim());
         keysuppliermaster.setComments(keySupplierModel.getComments());
         keysuppliermaster.setKsContactperson(keySupplierModel.getKsContactperson());
         keysuppliermaster.setKsEmail(keySupplierModel.getKsEmail());
         keysuppliermaster.setKsLocation(keySupplierModel.getKsLocation());
         keysuppliermaster.setKsPhonenumber(keySupplierModel.getKsPhonenumber());
         keysuppliermaster.setKsid(keySupplierModel.getKsid());
         keysuppliermaster.setKsname(keySupplierModel.getKsname());
         keysuppliermaster.setVolofbusiness(keySupplierModel.getVolofbusiness());
         ops.saveOrUpdate(keysuppliermaster);
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
    public ArrayList<KeySupplierModel> getKeySupplierInfo(String rmCode) {
         ArrayList<KeySupplierModel> keySupplierModelList = new ArrayList<KeySupplierModel>();
       KeySupplier ks = new KeySupplier();
         CoreQuery coreQuery = new CoreQuery("from Keysuppliermaster where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List ksMaster = ops.fetch(coreQuery);
        for (Object ksObject : ksMaster) {
            Keysuppliermaster keysuppliermaster = (Keysuppliermaster) ksObject;
            KeySupplierModel keySupplierModel = new KeySupplierModel(); 
            keySupplierModel.setClientMaster(ks.getClientMaster(keysuppliermaster.getClientMaster().getClientid()).getClientname());
            keySupplierModel.setLookupmaster(keysuppliermaster.getLookupmaster().getLookupmasterid()); 
            keySupplierModel.setBankedbyim(keysuppliermaster.getBankedbyim());
            keySupplierModel.setComments(keysuppliermaster.getComments());
            keySupplierModel.setKsContactperson(keysuppliermaster.getKsContactperson());
            keySupplierModel.setKsEmail(keysuppliermaster.getKsEmail());
            keySupplierModel.setKsLocation(keysuppliermaster.getKsLocation());
            keySupplierModel.setKsPhonenumber(keysuppliermaster.getKsPhonenumber());
            keySupplierModel.setKsid(keysuppliermaster.getKsid());
            keySupplierModel.setKsname(keysuppliermaster.getKsname());
            keySupplierModel.setVolofbusiness(keysuppliermaster.getVolofbusiness());
              keySupplierModelList.add(keySupplierModel);
        }

        return keySupplierModelList;
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
    public ArrayList<KeySupplierModel> getKeySupplierInfoByClientId(String rmCode, String clientid) {
         ArrayList<KeySupplierModel> keySupplierModelList = new ArrayList<KeySupplierModel>();
       KeySupplier ks = new KeySupplier();
         CoreQuery coreQuery = new CoreQuery("from Keysuppliermaster where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode); 
        coreQuery.addParam("clientid", clientid);
        List ksMaster = ops.fetch(coreQuery);
        for (Object ksObject : ksMaster) {
            Keysuppliermaster keysuppliermaster = (Keysuppliermaster) ksObject;
            KeySupplierModel keySupplierModel = new KeySupplierModel(); 
            keySupplierModel.setClientMaster(ks.getClientMaster(keysuppliermaster.getClientMaster().getClientid()).getClientname());
            keySupplierModel.setLookupmaster(keysuppliermaster.getLookupmaster().getLookupmasterid()); 
            keySupplierModel.setBankedbyim(keysuppliermaster.getBankedbyim());
            keySupplierModel.setComments(keysuppliermaster.getComments());
            keySupplierModel.setKsContactperson(keysuppliermaster.getKsContactperson());
            keySupplierModel.setKsEmail(keysuppliermaster.getKsEmail());
            keySupplierModel.setKsLocation(keysuppliermaster.getKsLocation());
            keySupplierModel.setKsPhonenumber(keysuppliermaster.getKsPhonenumber());
            keySupplierModel.setKsid(keysuppliermaster.getKsid());
            keySupplierModel.setKsname(keysuppliermaster.getKsname());
            keySupplierModel.setVolofbusiness(keysuppliermaster.getVolofbusiness());
              keySupplierModelList.add(keySupplierModel);
        }

        return keySupplierModelList;
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
