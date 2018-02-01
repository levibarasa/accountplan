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
public class ClientCoverageModel {
    private int clientcoverageprofileid;
     private String clientMaster;
     private String clientofficername;
     private String clientofficerposition;
     private String clientofficercontact;
     private String clientofcerrnshipqlty;
     private String clientofficerlastcontact;
     private String clientofficerdiscussionsummary;
     private String clientofficernextplanedcontact;
     private String clientofficernxtcntctpurpose;

    public ClientCoverageModel() {
    }

    public ClientCoverageModel(int clientcoverageprofileid, String clientMaster, String clientofficername, String clientofficerposition, String clientofficercontact, String clientofcerrnshipqlty, String clientofficerlastcontact, String clientofficerdiscussionsummary, String clientofficernextplanedcontact, String clientofficernxtcntctpurpose) {
        this.clientcoverageprofileid = clientcoverageprofileid;
        this.clientMaster = clientMaster;
        this.clientofficername = clientofficername;
        this.clientofficerposition = clientofficerposition;
        this.clientofficercontact = clientofficercontact;
        this.clientofcerrnshipqlty = clientofcerrnshipqlty;
        this.clientofficerlastcontact = clientofficerlastcontact;
        this.clientofficerdiscussionsummary = clientofficerdiscussionsummary;
        this.clientofficernextplanedcontact = clientofficernextplanedcontact;
        this.clientofficernxtcntctpurpose = clientofficernxtcntctpurpose;
    }

    public int getClientcoverageprofileid() {
        return clientcoverageprofileid;
    }

    public void setClientcoverageprofileid(int clientcoverageprofileid) {
        this.clientcoverageprofileid = clientcoverageprofileid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getClientofficername() {
        return clientofficername;
    }

    public void setClientofficername(String clientofficername) {
        this.clientofficername = clientofficername;
    }

    public String getClientofficerposition() {
        return clientofficerposition;
    }

    public void setClientofficerposition(String clientofficerposition) {
        this.clientofficerposition = clientofficerposition;
    }

    public String getClientofficercontact() {
        return clientofficercontact;
    }

    public void setClientofficercontact(String clientofficercontact) {
        this.clientofficercontact = clientofficercontact;
    }

    public String getClientofcerrnshipqlty() {
        return clientofcerrnshipqlty;
    }

    public void setClientofcerrnshipqlty(String clientofcerrnshipqlty) {
        this.clientofcerrnshipqlty = clientofcerrnshipqlty;
    }

    public String getClientofficerlastcontact() {
        return clientofficerlastcontact;
    }

    public void setClientofficerlastcontact(String clientofficerlastcontact) {
        this.clientofficerlastcontact = clientofficerlastcontact;
    }

    public String getClientofficerdiscussionsummary() {
        return clientofficerdiscussionsummary;
    }

    public void setClientofficerdiscussionsummary(String clientofficerdiscussionsummary) {
        this.clientofficerdiscussionsummary = clientofficerdiscussionsummary;
    }

    public String getClientofficernextplanedcontact() {
        return clientofficernextplanedcontact;
    }

    public void setClientofficernextplanedcontact(String clientofficernextplanedcontact) {
        this.clientofficernextplanedcontact = clientofficernextplanedcontact;
    }

    public String getClientofficernxtcntctpurpose() {
        return clientofficernxtcntctpurpose;
    }

    public void setClientofficernxtcntctpurpose(String clientofficernxtcntctpurpose) {
        this.clientofficernxtcntctpurpose = clientofficernxtcntctpurpose;
    }
     
     
}
