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
public class SignOffMaster {
   OperationsDal ops;

    public SignOffMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteSignOffMaster(SignOffModel signOffModel ) {
     return ops.delete(signOffModel);
 }
    public  void createSignOff(SignOffModel signOffModel ) {
         SignOff signOff = new SignOff(); 
         SignOffMaster som = new SignOffMaster();  
         signOff.setClientMaster(som.getClientMasterByID(signOffModel.getClientMaster()));
         signOff.setHeadofcorporatesignoff(signOffModel.getHeadofcorporatesignoff());
         signOff.setRmsignoff(signOffModel.getRmsignoff());
         signOff.setSignoffid(signOffModel.getSignoffid());
       ops.save(signOff);
    }
     public  void updateSignOff(SignOffModel signOffModel ) {
         SignOff signOff = new SignOff(); 
         SignOffMaster som = new SignOffMaster();  
         signOff.setClientMaster(som.getClientMasterByID(signOffModel.getClientMaster()));
         signOff.setHeadofcorporatesignoff(signOffModel.getHeadofcorporatesignoff());
         signOff.setRmsignoff(signOffModel.getRmsignoff());
         signOff.setSignoffid(signOffModel.getSignoffid());
       ops.saveOrUpdate(signOff);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
    public ArrayList<SignOffModel> getSignOff(String rmCode) {
         ArrayList<SignOffModel> signOffModels = new ArrayList<SignOffModel>();
       SignOffMaster som = new SignOffMaster();
         CoreQuery coreQuery = new CoreQuery("from SignOff where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List soMaster = ops.fetch(coreQuery);
        for (Object soObject : soMaster) {
            SignOff signOff = (SignOff) soObject;
            SignOffModel signOffModel = new SignOffModel(); 
            signOffModel.setClientMaster(som.getClientMaster(signOff.getClientMaster().getClientid()).getClientname()); 
            signOffModel.setHeadofcorporatesignoff(signOff.getHeadofcorporatesignoff());
            signOffModel.setRmsignoff(signOff.getRmsignoff());
            signOffModel.setSignoffid(signOff.getSignoffid());
              signOffModels.add(signOffModel);
        }

        return signOffModels;
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
     public ArrayList<SignOffModel> getSignOff(String rmCode,String clientid) {
         ArrayList<SignOffModel> signOffModels = new ArrayList<SignOffModel>();
       SignOffMaster som = new SignOffMaster();
         CoreQuery coreQuery = new CoreQuery("from SignOff where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List soMaster = ops.fetch(coreQuery);
        for (Object soObject : soMaster) {
            SignOff signOff = (SignOff) soObject;
            SignOffModel signOffModel = new SignOffModel(); 
            signOffModel.setClientMaster(som.getClientMaster(signOff.getClientMaster().getClientid()).getClientname()); 
            signOffModel.setHeadofcorporatesignoff(signOff.getHeadofcorporatesignoff());
            signOffModel.setRmsignoff(signOff.getRmsignoff());
            signOffModel.setSignoffid(signOff.getSignoffid());
              signOffModels.add(signOffModel);
        }

        return signOffModels;
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
