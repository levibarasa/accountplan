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
public class ClientEmployeeMaster {
     OperationsDal ops;

    public ClientEmployeeMaster() {
        ops = OperationsDalImpl.getInstance(Databases.ACCPLAN);
    }
    
   public  ArrayList<ClientEmployeeModel> getClientEmployeeInfo(String rmCode) { 
       ArrayList<ClientEmployeeModel>  clientEmployeeList = new ArrayList<ClientEmployeeModel> ();
        ClientEmployeeMaster cle = new ClientEmployeeMaster();
         CoreQuery coreQuery = new CoreQuery("from ClientEmployee where clientMaster.rmCodelistByRmCode.rmCode =:rmCode", true);
        coreQuery.addParam("rmCode", rmCode);
        List cliempMaster = ops.fetch(coreQuery);
        for (Object cleObject : cliempMaster) {
            ClientEmployee  clientEmployee = (ClientEmployee) cleObject;
            ClientEmployeeModel clientEmployeeModel = new ClientEmployeeModel(); 
            clientEmployeeModel.setClientMaster(cle.getClientMaster(rmCode).getClientname());  
            clientEmployeeModel.setClientemployeeid(clientEmployee.getClientemployeeid());
            clientEmployeeModel.setClientEmployeeContactperson(clientEmployee.getClientEmployeeContactperson());
            clientEmployeeModel.setClientEmployeeEmail(clientEmployee.getClientEmployeeEmail());
            clientEmployeeModel.setClientEmployeeLocation(clientEmployee.getClientEmployeeLocation());
            clientEmployeeModel.setClientEmployeePhonenumber(clientEmployee.getClientEmployeePhonenumber());
            clientEmployeeModel.setLookupmaster(clientEmployee.getLookupmaster().getValue());
            clientEmployeeModel.setNoofbankedemployeesallbanks(clientEmployee.getNoofbankedemployeesallbanks());
            clientEmployeeModel.setNoofbankedemployeeswithim(clientEmployee.getNoofbankedemployeeswithim());
            clientEmployeeModel.setNoofemployees(clientEmployee.getNoofemployees());
            clientEmployeeModel.setTargetnoofemployeesbyim(clientEmployee.getTargetnoofemployeesbyim());
              clientEmployeeList.add(clientEmployeeModel);
        }
        return clientEmployeeList;
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
    
 
}
