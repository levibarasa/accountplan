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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Levi
 */
public class KeyDistributor {
    
     OperationsDal ops;

    public KeyDistributor() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    public  boolean deleteKeyDistributor(KeyDistributorModel keyDistributorModel ) {
     return ops.delete(keyDistributorModel);
 }
    public  void createKeyDistributor(KeyDistributorModel keyDistributorModel ) {
         Keydistributormaster keydistributormaster = new Keydistributormaster(); 
         KeyDistributor kd = new KeyDistributor();  
         keydistributormaster.setClientMaster(kd.getClientMasterByID(keyDistributorModel.getClientMaster()));
         keydistributormaster.setLookupmaster(kd.getLookUpMasterByID(keyDistributorModel.getLookupmaster()));
         keydistributormaster.setBankedbyim(keyDistributorModel.getBankedbyim());
         keydistributormaster.setClientturnover(keyDistributorModel.getClientturnover());
         keydistributormaster.setComments(keyDistributorModel.getComments());
         keydistributormaster.setKdContactperson(keyDistributorModel.getKdContactperson());
         keydistributormaster.setKdEmail(keyDistributorModel.getKdEmail());
         keydistributormaster.setKdLocation(keyDistributorModel.getKdLocation());
         keydistributormaster.setKdPhonenumber(keyDistributorModel.getKdPhonenumber());
         keydistributormaster.setKdandclients(keyDistributorModel.getKdandclients());
         keydistributormaster.setKdid(keyDistributorModel.getKdid());
         keydistributormaster.setVolofbusnskdandclient(BigDecimal.ONE);
           ops.save(keydistributormaster);
    }
    public  void updateKeyDistributor(KeyDistributorModel keyDistributorModel ) {
         Keydistributormaster keydistributormaster = new Keydistributormaster(); 
         KeyDistributor kd = new KeyDistributor();  
         keydistributormaster.setClientMaster(kd.getClientMasterByID(keyDistributorModel.getClientMaster()));
         keydistributormaster.setLookupmaster(kd.getLookUpMasterByID(keyDistributorModel.getLookupmaster()));
         keydistributormaster.setBankedbyim(keyDistributorModel.getBankedbyim());
         keydistributormaster.setClientturnover(keyDistributorModel.getClientturnover());
         keydistributormaster.setComments(keyDistributorModel.getComments());
         keydistributormaster.setKdContactperson(keyDistributorModel.getKdContactperson());
         keydistributormaster.setKdEmail(keyDistributorModel.getKdEmail());
         keydistributormaster.setKdLocation(keyDistributorModel.getKdLocation());
         keydistributormaster.setKdPhonenumber(keyDistributorModel.getKdPhonenumber());
         keydistributormaster.setKdandclients(keyDistributorModel.getKdandclients());
         keydistributormaster.setKdid(keyDistributorModel.getKdid());
         keydistributormaster.setVolofbusnskdandclient(BigDecimal.ONE);
           ops.saveOrUpdate(keydistributormaster);
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
     public ArrayList<KeyDistributorModel> getDistributorInfo(String rmCode) {
         ArrayList<KeyDistributorModel> keyDistributorList = new ArrayList<KeyDistributorModel>();
       KeyDistributor kd = new KeyDistributor();
         CoreQuery coreQuery = new CoreQuery("from Keydistributormaster where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List kdMaster = ops.fetch(coreQuery);
        for (Object kdObject : kdMaster) {
            Keydistributormaster keydistributormaster = (Keydistributormaster) kdObject;
            KeyDistributorModel distributorModel = new KeyDistributorModel(); 
            distributorModel.setClientMaster(kd.getClientMaster(keydistributormaster.getClientMaster().getClientid()).getClientname()); 
            distributorModel.setBankedbyim(keydistributormaster.getBankedbyim());
            distributorModel.setClientturnover(keydistributormaster.getClientturnover());
            distributorModel.setComments(keydistributormaster.getComments());
            distributorModel.setKdContactperson(keydistributormaster.getKdContactperson());
            distributorModel.setKdEmail(keydistributormaster.getKdEmail());
            distributorModel.setKdLocation(keydistributormaster.getKdLocation());
            distributorModel.setKdPhonenumber(keydistributormaster.getKdPhonenumber());
            distributorModel.setKdandclients(keydistributormaster.getKdandclients());
            distributorModel.setKdid(keydistributormaster.getKdid());
            distributorModel.setLookupmaster(keydistributormaster.getLookupmaster().getLookupmasterid());
            distributorModel.setVolofbusnskdandclient(keydistributormaster.getVolofbusnskdandclient());
              keyDistributorList.add(distributorModel);
        }

        return keyDistributorList;
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
     
   
       public   String getRMNameByCode(String rmCode) {
       AdminDb ad = new AdminDb();
        String sql = "select  employeeName from Employee_Details where employeeID = ?";
        String str = ad.getStringValue(sql, 1, 1, rmCode);
        return str;
    }
       public static ArrayList getSegment() {
        String sql = "select Segment from [dbo].[SegmentMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    } 
    public static ArrayList getAllRms() {
        String sql = "select RM_Code,RM_Name from  [dbo].[RM_Codelist]";
        return AdminDb.execArrayLists(sql, 0, "", 2);
    }
    public static ArrayList getAffiliate() {
        String sql = "select AffiliateName from [dbo].[AffiliateMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }
        public static ArrayList getIndustry() {
        String sql = "select IndustryDescription from [dbo].[IndustryMaster]";
        return AdminDb.execArrayLists(sql, 0, "", 1);
    }
        public static ArrayList getClientName() {
        String sql = "select ClientID,ClientName from  [dbo].[Client_Master]";
        return AdminDb.execArrayLists(sql, 0, "", 2);
    } 
     public  String getClientNameByID(String clientId) {
       AdminDb ad = new AdminDb();
        String sql = "select ClientName from [dbo].[Client_Master] where ClientID = ?";
        String str = ad.getStringValue(sql, 1, 1, clientId);
        return str;
    }
      public ArrayList<KeyDistributorModel> getDistributorInfoByClientId(String rmCode, String clientid) {
         ArrayList<KeyDistributorModel> keyDistributorList = new ArrayList<KeyDistributorModel>();
       KeyDistributor kd = new KeyDistributor();
         CoreQuery coreQuery = new CoreQuery("from Keydistributormaster where clientMaster.rmCodelistByRmCode.rmCode =:rmCode and clientMaster.clientid =:clientid", true);
        coreQuery.addParam("rmCode", rmCode);
        coreQuery.addParam("clientid", clientid);
        List kdMaster = ops.fetch(coreQuery);
        for (Object kdObject : kdMaster) {
            Keydistributormaster keydistributormaster = (Keydistributormaster) kdObject;
            KeyDistributorModel distributorModel = new KeyDistributorModel(); 
            distributorModel.setClientMaster(kd.getClientMaster(keydistributormaster.getClientMaster().getClientid()).getClientname()); 
            distributorModel.setBankedbyim(keydistributormaster.getBankedbyim());
            distributorModel.setClientturnover(keydistributormaster.getClientturnover());
            distributorModel.setComments(keydistributormaster.getComments());
            distributorModel.setKdContactperson(keydistributormaster.getKdContactperson());
            distributorModel.setKdEmail(keydistributormaster.getKdEmail());
            distributorModel.setKdLocation(keydistributormaster.getKdLocation());
            distributorModel.setKdPhonenumber(keydistributormaster.getKdPhonenumber());
            distributorModel.setKdandclients(keydistributormaster.getKdandclients());
            distributorModel.setKdid(keydistributormaster.getKdid());
            distributorModel.setLookupmaster(keydistributormaster.getLookupmaster().getLookupmasterid());
            distributorModel.setVolofbusnskdandclient(keydistributormaster.getVolofbusnskdandclient());
              keyDistributorList.add(distributorModel);
        }

        return keyDistributorList;
    }
}
