package com.inm.ap.mode.hibernate;
// Generated Jan 31, 2018 3:59:00 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Keydistributormaster generated by hbm2java
 */
public class Keydistributormaster  implements java.io.Serializable {


     private int kdid;
     private Lookupmaster lookupmaster;
     private ClientMaster clientMaster;
     private String kdandclients;
     private String kdContactperson;
     private String kdPhonenumber;
     private String kdEmail;
     private String kdLocation;
     private String bankedbyim;
     private String comments;
     private BigDecimal clientturnover;
     private BigDecimal volofbusnskdandclient;

    public Keydistributormaster() {
    }

	
    public Keydistributormaster(int kdid, Lookupmaster lookupmaster, ClientMaster clientMaster) {
        this.kdid = kdid;
        this.lookupmaster = lookupmaster;
        this.clientMaster = clientMaster;
    }
    public Keydistributormaster(int kdid, Lookupmaster lookupmaster, ClientMaster clientMaster, String kdandclients, String kdContactperson, String kdPhonenumber, String kdEmail, String kdLocation, String bankedbyim, String comments, BigDecimal clientturnover, BigDecimal volofbusnskdandclient) {
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
        return this.kdid;
    }
    
    public void setKdid(int kdid) {
        this.kdid = kdid;
    }
    public Lookupmaster getLookupmaster() {
        return this.lookupmaster;
    }
    
    public void setLookupmaster(Lookupmaster lookupmaster) {
        this.lookupmaster = lookupmaster;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public String getKdandclients() {
        return this.kdandclients;
    }
    
    public void setKdandclients(String kdandclients) {
        this.kdandclients = kdandclients;
    }
    public String getKdContactperson() {
        return this.kdContactperson;
    }
    
    public void setKdContactperson(String kdContactperson) {
        this.kdContactperson = kdContactperson;
    }
    public String getKdPhonenumber() {
        return this.kdPhonenumber;
    }
    
    public void setKdPhonenumber(String kdPhonenumber) {
        this.kdPhonenumber = kdPhonenumber;
    }
    public String getKdEmail() {
        return this.kdEmail;
    }
    
    public void setKdEmail(String kdEmail) {
        this.kdEmail = kdEmail;
    }
    public String getKdLocation() {
        return this.kdLocation;
    }
    
    public void setKdLocation(String kdLocation) {
        this.kdLocation = kdLocation;
    }
    public String getBankedbyim() {
        return this.bankedbyim;
    }
    
    public void setBankedbyim(String bankedbyim) {
        this.bankedbyim = bankedbyim;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    public BigDecimal getClientturnover() {
        return this.clientturnover;
    }
    
    public void setClientturnover(BigDecimal clientturnover) {
        this.clientturnover = clientturnover;
    }
    public BigDecimal getVolofbusnskdandclient() {
        return this.volofbusnskdandclient;
    }
    
    public void setVolofbusnskdandclient(BigDecimal volofbusnskdandclient) {
        this.volofbusnskdandclient = volofbusnskdandclient;
    }




}


