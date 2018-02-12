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
public class KeySupplierModel {
     private int ksid;
     private int lookupmaster;
     private String clientMaster;
     private String ksname;
     private String ksContactperson;
     private String ksPhonenumber;
     private String ksEmail;
     private String ksLocation;
     private String volofbusiness;
     private String bankedbyim;
     private String comments;
    public KeySupplierModel() {
    }

    public KeySupplierModel(int ksid, int lookupmaster, String clientMaster, String ksname, String ksContactperson, String ksPhonenumber, String ksEmail, String ksLocation, String volofbusiness, String bankedbyim, String comments) {
        this.ksid = ksid;
        this.lookupmaster = lookupmaster;
        this.clientMaster = clientMaster;
        this.ksname = ksname;
        this.ksContactperson = ksContactperson;
        this.ksPhonenumber = ksPhonenumber;
        this.ksEmail = ksEmail;
        this.ksLocation = ksLocation;
        this.volofbusiness = volofbusiness;
        this.bankedbyim = bankedbyim;
        this.comments = comments;
    }

    public int getKsid() {
        return ksid;
    }

    public void setKsid(int ksid) {
        this.ksid = ksid;
    }

    public int getLookupmaster() {
        return lookupmaster;
    }

    public void setLookupmaster(int lookupmaster) {
        this.lookupmaster = lookupmaster;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getKsname() {
        return ksname;
    }

    public void setKsname(String ksname) {
        this.ksname = ksname;
    }

    public String getKsContactperson() {
        return ksContactperson;
    }

    public void setKsContactperson(String ksContactperson) {
        this.ksContactperson = ksContactperson;
    }

    public String getKsPhonenumber() {
        return ksPhonenumber;
    }

    public void setKsPhonenumber(String ksPhonenumber) {
        this.ksPhonenumber = ksPhonenumber;
    }

    public String getKsEmail() {
        return ksEmail;
    }

    public void setKsEmail(String ksEmail) {
        this.ksEmail = ksEmail;
    }

    public String getKsLocation() {
        return ksLocation;
    }

    public void setKsLocation(String ksLocation) {
        this.ksLocation = ksLocation;
    }

    public String getVolofbusiness() {
        return volofbusiness;
    }

    public void setVolofbusiness(String volofbusiness) {
        this.volofbusiness = volofbusiness;
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

    
}
