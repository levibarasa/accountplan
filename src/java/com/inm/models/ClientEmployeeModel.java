/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;

/**
 *
 * @author Levi
 */
public class ClientEmployeeModel {
      private int clientemployeeid;
     private String lookupmaster;
     private String clientMaster;
     private String clientEmployeeContactperson;
     private String clientEmployeePhonenumber;
     private String clientEmployeeEmail;
     private String clientEmployeeLocation;
     private String noofemployees;
     private String noofbankedemployeesallbanks;
     private String noofbankedemployeeswithim;
     private String targetnoofemployeesbyim;

    public ClientEmployeeModel() {
    }

    public ClientEmployeeModel(int clientemployeeid, String lookupmaster, String clientMaster, String clientEmployeeContactperson, String clientEmployeePhonenumber, String clientEmployeeEmail, String clientEmployeeLocation, String noofemployees, String noofbankedemployeesallbanks, String noofbankedemployeeswithim, String targetnoofemployeesbyim) {
        this.clientemployeeid = clientemployeeid;
        this.lookupmaster = lookupmaster;
        this.clientMaster = clientMaster;
        this.clientEmployeeContactperson = clientEmployeeContactperson;
        this.clientEmployeePhonenumber = clientEmployeePhonenumber;
        this.clientEmployeeEmail = clientEmployeeEmail;
        this.clientEmployeeLocation = clientEmployeeLocation;
        this.noofemployees = noofemployees;
        this.noofbankedemployeesallbanks = noofbankedemployeesallbanks;
        this.noofbankedemployeeswithim = noofbankedemployeeswithim;
        this.targetnoofemployeesbyim = targetnoofemployeesbyim;
    }

    public int getClientemployeeid() {
        return clientemployeeid;
    }

    public void setClientemployeeid(int clientemployeeid) {
        this.clientemployeeid = clientemployeeid;
    }

    public String getLookupmaster() {
        return lookupmaster;
    }

    public void setLookupmaster(String lookupmaster) {
        this.lookupmaster = lookupmaster;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getClientEmployeeContactperson() {
        return clientEmployeeContactperson;
    }

    public void setClientEmployeeContactperson(String clientEmployeeContactperson) {
        this.clientEmployeeContactperson = clientEmployeeContactperson;
    }

    public String getClientEmployeePhonenumber() {
        return clientEmployeePhonenumber;
    }

    public void setClientEmployeePhonenumber(String clientEmployeePhonenumber) {
        this.clientEmployeePhonenumber = clientEmployeePhonenumber;
    }

    public String getClientEmployeeEmail() {
        return clientEmployeeEmail;
    }

    public void setClientEmployeeEmail(String clientEmployeeEmail) {
        this.clientEmployeeEmail = clientEmployeeEmail;
    }

    public String getClientEmployeeLocation() {
        return clientEmployeeLocation;
    }

    public void setClientEmployeeLocation(String clientEmployeeLocation) {
        this.clientEmployeeLocation = clientEmployeeLocation;
    }

    public String getNoofemployees() {
        return noofemployees;
    }

    public void setNoofemployees(String noofemployees) {
        this.noofemployees = noofemployees;
    }

    public String getNoofbankedemployeesallbanks() {
        return noofbankedemployeesallbanks;
    }

    public void setNoofbankedemployeesallbanks(String noofbankedemployeesallbanks) {
        this.noofbankedemployeesallbanks = noofbankedemployeesallbanks;
    }

    public String getNoofbankedemployeeswithim() {
        return noofbankedemployeeswithim;
    }

    public void setNoofbankedemployeeswithim(String noofbankedemployeeswithim) {
        this.noofbankedemployeeswithim = noofbankedemployeeswithim;
    }

    public String getTargetnoofemployeesbyim() {
        return targetnoofemployeesbyim;
    }

    public void setTargetnoofemployeesbyim(String targetnoofemployeesbyim) {
        this.targetnoofemployeesbyim = targetnoofemployeesbyim;
    }

     
}
