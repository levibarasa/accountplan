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
public class CompetitionMaster {
   OperationsDal ops;

    public CompetitionMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteCompetitionMaster(CompetitionModel competitionModel ) {
     return ops.delete(competitionModel);
 }
    public  void createCompetition(CompetitionModel competitionModel ) {
         Competition competition = new Competition(); 
         CompetitionMaster compe = new CompetitionMaster();  
         competition.setClientMaster(compe.getClientMasterByID(competitionModel.getClientMaster()));
         competition.setBank(competitionModel.getBank());
         competition.setCompetitionid(competitionModel.getCompetitionid());
         competition.setEstimatedwalletshare(competitionModel.getEstimatedwalletshare());
         competition.setStrengths(competitionModel.getStrengths());
         competition.setWeaknesses(competitionModel.getWeaknesses());
              ops.save(competition);
    }
    public  void updateCompetition(CompetitionModel competitionModel ) {
         Competition competition = new Competition(); 
         CompetitionMaster compe = new CompetitionMaster();  
         competition.setClientMaster(compe.getClientMasterByID(competitionModel.getClientMaster()));
         competition.setBank(competitionModel.getBank());
         competition.setCompetitionid(competitionModel.getCompetitionid());
         competition.setEstimatedwalletshare(competitionModel.getEstimatedwalletshare());
         competition.setStrengths(competitionModel.getStrengths());
         competition.setWeaknesses(competitionModel.getWeaknesses());
              ops.saveOrUpdate(competition);
    }
         
     public ClientMaster getClientMasterByID(String clientid) {
        CoreQuery coreQuery = new CoreQuery("from ClientMaster where clientid =:clientid", true);
        coreQuery.addParam("clientid", clientid); 
        List clientMaster = ops.fetch(coreQuery);
        return (ClientMaster) clientMaster.get(0);
    }
   public  ArrayList<CompetitionModel> getCompetitionInfo(String rmCode) { 
       ArrayList<CompetitionModel>  competitionList = new ArrayList<CompetitionModel> ();
        CompetitionMaster compe = new CompetitionMaster();
         CoreQuery coreQuery = new CoreQuery("from Competition where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List compeList = ops.fetch(coreQuery);
        for (Object compeObject : compeList) {
            Competition  competition = (Competition) compeObject;
            CompetitionModel competitionModel = new CompetitionModel(); 
            competitionModel.setClientMaster(compe.getClientMaster(competition.getClientMaster().getClientid()).getClientname());  
            competitionModel.setBank(competition.getBank());
            competitionModel.setCompetitionid(competition.getCompetitionid());
            competitionModel.setEstimatedwalletshare(competition.getEstimatedwalletshare());
            competitionModel.setStrengths(competition.getStrengths());
            competitionModel.setWeaknesses(competition.getWeaknesses());
              competitionList.add(competitionModel);
        }
        return competitionList;
      }
   public  ArrayList<CompetitionModel> getCompetitionInfo(String rmCode,String clientid) { 
       ArrayList<CompetitionModel>  competitionList = new ArrayList<CompetitionModel> ();
        CompetitionMaster compe = new CompetitionMaster();
         CoreQuery coreQuery = new CoreQuery("from Competition where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List compeList = ops.fetch(coreQuery);
        for (Object compeObject : compeList) {
            Competition  competition = (Competition) compeObject;
            CompetitionModel competitionModel = new CompetitionModel(); 
            competitionModel.setClientMaster(compe.getClientMaster(competition.getClientMaster().getClientid()).getClientname());  
            competitionModel.setBank(competition.getBank());
            competitionModel.setCompetitionid(competition.getCompetitionid());
            competitionModel.setEstimatedwalletshare(competition.getEstimatedwalletshare());
            competitionModel.setStrengths(competition.getStrengths());
            competitionModel.setWeaknesses(competition.getWeaknesses());
              competitionList.add(competitionModel);
        }
        return competitionList;
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
