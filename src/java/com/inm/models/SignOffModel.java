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
public class SignOffModel {
    private int signoffid;
     private String clientMaster;
     private String headofcorporatesignoff;
     private String rmsignoff;

    public SignOffModel() {
    }

    public SignOffModel(int signoffid, String clientMaster, String headofcorporatesignoff, String rmsignoff) {
        this.signoffid = signoffid;
        this.clientMaster = clientMaster;
        this.headofcorporatesignoff = headofcorporatesignoff;
        this.rmsignoff = rmsignoff;
    }

    public int getSignoffid() {
        return signoffid;
    }

    public void setSignoffid(int signoffid) {
        this.signoffid = signoffid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getHeadofcorporatesignoff() {
        return headofcorporatesignoff;
    }

    public void setHeadofcorporatesignoff(String headofcorporatesignoff) {
        this.headofcorporatesignoff = headofcorporatesignoff;
    }

    public String getRmsignoff() {
        return rmsignoff;
    }

    public void setRmsignoff(String rmsignoff) {
        this.rmsignoff = rmsignoff;
    }
     
}
