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
public class ClientCoverageMaster {
   OperationsDal ops;

    public ClientCoverageMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteClientCoverageMaster(ClientCoverageModel clientCoverageModel ) {
     return ops.delete(clientCoverageModel);
 }
      public  void createClientcoverageprofile(ClientCoverageModel clientCoverageModel ) {
         Clientcoverageprofile clientcoverageprofile = new Clientcoverageprofile(); 
         ClientCoverageMaster ccm = new ClientCoverageMaster();  
         clientcoverageprofile.setClientMaster(ccm.getClientMasterByID(clientCoverageModel.getClientMaster()));
         clientcoverageprofile.setClientcoverageprofileid(0);
         clientcoverageprofile.setClientofcerrnshipqlty(clientCoverageModel.getClientofcerrnshipqlty());
         clientcoverageprofile.setClientofficercontact(clientCoverageModel.getClientofficercontact());
         clientcoverageprofile.setClientofficerdiscussionsummary(clientCoverageModel.getClientofficerdiscussionsummary());
         clientcoverageprofile.setClientofficerlastcontact(clientCoverageModel.getClientofficerlastcontact());
         clientcoverageprofile.setClientofficername(clientCoverageModel.getClientofficername());
         clientcoverageprofile.setClientofficernextplanedcontact(clientCoverageModel.getClientofficernextplanedcontact());
         clientcoverageprofile.setClientofficernxtcntctpurpose(clientCoverageModel.getClientofficernxtcntctpurpose());
         clientcoverageprofile.setClientofficerposition(clientCoverageModel.getClientofficerposition());
               ops.save(clientcoverageprofile);
    }
       public  void updateClientcoverageprofile(ClientCoverageModel clientCoverageModel ) {
         Clientcoverageprofile clientcoverageprofile = new Clientcoverageprofile(); 
         ClientCoverageMaster ccm = new ClientCoverageMaster();  
         clientcoverageprofile.setClientMaster(ccm.getClientMasterByID(clientCoverageModel.getClientMaster()));
         clientcoverageprofile.setClientcoverageprofileid(0);
         clientcoverageprofile.setClientofcerrnshipqlty(clientCoverageModel.getClientofcerrnshipqlty());
         clientcoverageprofile.setClientofficercontact(clientCoverageModel.getClientofficercontact());
         clientcoverageprofile.setClientofficerdiscussionsummary(clientCoverageModel.getClientofficerdiscussionsummary());
         clientcoverageprofile.setClientofficerlastcontact(clientCoverageModel.getClientofficerlastcontact());
         clientcoverageprofile.setClientofficername(clientCoverageModel.getClientofficername());
         clientcoverageprofile.setClientofficernextplanedcontact(clientCoverageModel.getClientofficernextplanedcontact());
         clientcoverageprofile.setClientofficernxtcntctpurpose(clientCoverageModel.getClientofficernxtcntctpurpose());
         clientcoverageprofile.setClientofficerposition(clientCoverageModel.getClientofficerposition());
               ops.saveOrUpdate(clientcoverageprofile);
    }
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
   public  ArrayList<ClientCoverageModel> getClientCoverageInfo(String rmCode) { 
       ArrayList<ClientCoverageModel>  clientCoverageModels = new ArrayList<ClientCoverageModel> ();
        ClientCoverageMaster ccm = new ClientCoverageMaster();
         CoreQuery coreQuery = new CoreQuery("from Clientcoverageprofile where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List ClientcoverageprofileMaster = ops.fetch(coreQuery);
        for (Object ccmObject : ClientcoverageprofileMaster) {
            Clientcoverageprofile  clientcoverageprofile = (Clientcoverageprofile) ccmObject;
            ClientCoverageModel clientCoverageModel = new ClientCoverageModel(); 
            clientCoverageModel.setClientMaster(ccm.getClientMaster(clientcoverageprofile.getClientMaster().getClientid()).getClientname());
            clientCoverageModel.setClientcoverageprofileid(clientcoverageprofile.getClientcoverageprofileid());
            clientCoverageModel.setClientofcerrnshipqlty(clientcoverageprofile.getClientofcerrnshipqlty());
            clientCoverageModel.setClientofficercontact(clientcoverageprofile.getClientofficercontact());
            clientCoverageModel.setClientofficerdiscussionsummary(clientcoverageprofile.getClientofficerdiscussionsummary());
            clientCoverageModel.setClientofficerlastcontact(clientcoverageprofile.getClientofficerlastcontact());
            clientCoverageModel.setClientofficername(clientcoverageprofile.getClientofficername());
            clientCoverageModel.setClientofficernextplanedcontact(clientcoverageprofile.getClientofficernextplanedcontact());
            clientCoverageModel.setClientofficernxtcntctpurpose(clientcoverageprofile.getClientofficernxtcntctpurpose());
            clientCoverageModel.setClientofficerposition(clientcoverageprofile.getClientofficerposition());
              clientCoverageModels.add(clientCoverageModel);
        }
        return clientCoverageModels;
      }
   public  ArrayList<ClientCoverageModel> getClientCoverageInfoByClientId(String rmCode,String clientid) { 
       ArrayList<ClientCoverageModel>  clientCoverageModels = new ArrayList<ClientCoverageModel> ();
        ClientCoverageMaster ccm = new ClientCoverageMaster();
         CoreQuery coreQuery = new CoreQuery("from Clientcoverageprofile where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List ClientcoverageprofileMaster = ops.fetch(coreQuery);
        for (Object ccmObject : ClientcoverageprofileMaster) {
            Clientcoverageprofile  clientcoverageprofile = (Clientcoverageprofile) ccmObject;
            ClientCoverageModel clientCoverageModel = new ClientCoverageModel(); 
            clientCoverageModel.setClientMaster(ccm.getClientMaster(clientcoverageprofile.getClientMaster().getClientid()).getClientname());
            clientCoverageModel.setClientcoverageprofileid(clientcoverageprofile.getClientcoverageprofileid());
            clientCoverageModel.setClientofcerrnshipqlty(clientcoverageprofile.getClientofcerrnshipqlty());
            clientCoverageModel.setClientofficercontact(clientcoverageprofile.getClientofficercontact());
            clientCoverageModel.setClientofficerdiscussionsummary(clientcoverageprofile.getClientofficerdiscussionsummary());
            clientCoverageModel.setClientofficerlastcontact(clientcoverageprofile.getClientofficerlastcontact());
            clientCoverageModel.setClientofficername(clientcoverageprofile.getClientofficername());
            clientCoverageModel.setClientofficernextplanedcontact(clientcoverageprofile.getClientofficernextplanedcontact());
            clientCoverageModel.setClientofficernxtcntctpurpose(clientcoverageprofile.getClientofficernxtcntctpurpose());
            clientCoverageModel.setClientofficerposition(clientcoverageprofile.getClientofficerposition());
              clientCoverageModels.add(clientCoverageModel);
        }
        return clientCoverageModels;
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
