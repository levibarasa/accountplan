package com.inm.ap.mode.hibernate;
// Generated Feb 19, 2018 4:06:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Clientcoverageprofile generated by hbm2java
 */
public class Clientcoverageprofile  implements java.io.Serializable {


     private int clientcoverageprofileid;
     private ClientMaster clientMaster;
     private String clientofficername;
     private String clientofficerposition;
     private String clientofficercontact;
     private String clientofcerrnshipqlty;
     private String clientofficerlastcontact;
     private String clientofficerdiscussionsummary;
     private String clientofficernextplanedcontact;
     private String clientofficernxtcntctpurpose;

    public Clientcoverageprofile() {
    }

	
    public Clientcoverageprofile(int clientcoverageprofileid, ClientMaster clientMaster) {
        this.clientcoverageprofileid = clientcoverageprofileid;
        this.clientMaster = clientMaster;
    }
    public Clientcoverageprofile(int clientcoverageprofileid, ClientMaster clientMaster, String clientofficername, String clientofficerposition, String clientofficercontact, String clientofcerrnshipqlty, String clientofficerlastcontact, String clientofficerdiscussionsummary, String clientofficernextplanedcontact, String clientofficernxtcntctpurpose) {
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
        return this.clientcoverageprofileid;
    }
    
    public void setClientcoverageprofileid(int clientcoverageprofileid) {
        this.clientcoverageprofileid = clientcoverageprofileid;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public String getClientofficername() {
        return this.clientofficername;
    }
    
    public void setClientofficername(String clientofficername) {
        this.clientofficername = clientofficername;
    }
    public String getClientofficerposition() {
        return this.clientofficerposition;
    }
    
    public void setClientofficerposition(String clientofficerposition) {
        this.clientofficerposition = clientofficerposition;
    }
    public String getClientofficercontact() {
        return this.clientofficercontact;
    }
    
    public void setClientofficercontact(String clientofficercontact) {
        this.clientofficercontact = clientofficercontact;
    }
    public String getClientofcerrnshipqlty() {
        return this.clientofcerrnshipqlty;
    }
    
    public void setClientofcerrnshipqlty(String clientofcerrnshipqlty) {
        this.clientofcerrnshipqlty = clientofcerrnshipqlty;
    }
    public String getClientofficerlastcontact() {
        return this.clientofficerlastcontact;
    }
    
    public void setClientofficerlastcontact(String clientofficerlastcontact) {
        this.clientofficerlastcontact = clientofficerlastcontact;
    }
    public String getClientofficerdiscussionsummary() {
        return this.clientofficerdiscussionsummary;
    }
    
    public void setClientofficerdiscussionsummary(String clientofficerdiscussionsummary) {
        this.clientofficerdiscussionsummary = clientofficerdiscussionsummary;
    }
    public String getClientofficernextplanedcontact() {
        return this.clientofficernextplanedcontact;
    }
    
    public void setClientofficernextplanedcontact(String clientofficernextplanedcontact) {
        this.clientofficernextplanedcontact = clientofficernextplanedcontact;
    }
    public String getClientofficernxtcntctpurpose() {
        return this.clientofficernxtcntctpurpose;
    }
    
    public void setClientofficernxtcntctpurpose(String clientofficernxtcntctpurpose) {
        this.clientofficernxtcntctpurpose = clientofficernxtcntctpurpose;
    }




}


