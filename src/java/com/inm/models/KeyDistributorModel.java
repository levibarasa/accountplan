/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;
 
import java.math.BigDecimal;

/**
 *
 * @author Levi
 */
public class KeyDistributorModel {
  private int kdid;
     private String lookupmaster;
     private String clientMaster;
     private String kdandclients;
     private String kdContactperson;
     private String kdPhonenumber;
     private String kdEmail;
     private String kdLocation;
     private String bankedbyim;
     private String comments;
     private BigDecimal clientturnover;
     private BigDecimal volofbusnskdandclient;

    public KeyDistributorModel() {
    }

    public KeyDistributorModel(int kdid, String lookupmaster, String clientMaster, String kdandclients, String kdContactperson, String kdPhonenumber, String kdEmail, String kdLocation, String bankedbyim, String comments, BigDecimal clientturnover, BigDecimal volofbusnskdandclient) {
        this.kdid = kdid;
        this.lookupmaster = lookupmaster;
        this.clientMaster = clientMaster;
        this.kdandclients = kdandclients;
        this.kdContactperson = kdContactperson;
        this.kdPhonenumber = kdPhonenumber;
        this.kdEmail = kdEmail;
        this.kdLocation = kdLocation;
        this.bankedbyim = bankedbyim;
        this.comments = comments;
        this.clientturnover = clientturnover;
        this.volofbusnskdandclient = volofbusnskdandclient;
    }

    public int getKdid() {
        return kdid;
    }

    public void setKdid(int kdid) {
        this.kdid = kdid;
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

    public String getKdandclients() {
        return kdandclients;
    }

    public void setKdandclients(String kdandclients) {
        this.kdandclients = kdandclients;
    }

    public String getKdContactperson() {
        return kdContactperson;
    }

    public void setKdContactperson(String kdContactperson) {
        this.kdContactperson = kdContactperson;
    }

    public String getKdPhonenumber() {
        return kdPhonenumber;
    }

    public void setKdPhonenumber(String kdPhonenumber) {
        this.kdPhonenumber = kdPhonenumber;
    }

    public String getKdEmail() {
        return kdEmail;
    }

    public void setKdEmail(String kdEmail) {
        this.kdEmail = kdEmail;
    }

    public String getKdLocation() {
        return kdLocation;
    }

    public void setKdLocation(String kdLocation) {
        this.kdLocation = kdLocation;
    }

    public String getBankedbyim() {
        return bankedbyim;
    }

    public void setBankedbyim(String bankedbyim) {
        this.bankedbyim = bankedbyim;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getClientturnover() {
        return clientturnover;
    }

    public void setClientturnover(BigDecimal clientturnover) {
        this.clientturnover = clientturnover;
    }

    public BigDecimal getVolofbusnskdandclient() {
        return volofbusnskdandclient;
    }

    public void setVolofbusnskdandclient(BigDecimal volofbusnskdandclient) {
        this.volofbusnskdandclient = volofbusnskdandclient;
    }

    

}
