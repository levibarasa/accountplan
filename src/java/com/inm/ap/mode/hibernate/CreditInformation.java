package com.inm.ap.mode.hibernate;
// Generated Jan 31, 2018 3:59:00 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CreditInformation generated by hbm2java
 */
public class CreditInformation  implements java.io.Serializable {


     private int creditid;
     private ClientMaster clientMaster;
     private String approvedlines;
     private BigDecimal outstandingamount;
     private String riskrating;
     private String ratingagency;

    public CreditInformation() {
    }

	
    public CreditInformation(int creditid, ClientMaster clientMaster) {
        this.creditid = creditid;
        this.clientMaster = clientMaster;
    }
    public CreditInformation(int creditid, ClientMaster clientMaster, String approvedlines, BigDecimal outstandingamount, String riskrating, String ratingagency) {
       this.creditid = creditid;
       this.clientMaster = clientMaster;
       this.approvedlines = approvedlines;
       this.outstandingamount = outstandingamount;
       this.riskrating = riskrating;
       this.ratingagency = ratingagency;
    }
   
    public int getCreditid() {
        return this.creditid;
    }
    
    public void setCreditid(int creditid) {
        this.creditid = creditid;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public String getApprovedlines() {
        return this.approvedlines;
    }
    
    public void setApprovedlines(String approvedlines) {
        this.approvedlines = approvedlines;
    }
    public BigDecimal getOutstandingamount() {
        return this.outstandingamount;
    }
    
    public void setOutstandingamount(BigDecimal outstandingamount) {
        this.outstandingamount = outstandingamount;
    }
    public String getRiskrating() {
        return this.riskrating;
    }
    
    public void setRiskrating(String riskrating) {
        this.riskrating = riskrating;
    }
    public String getRatingagency() {
        return this.ratingagency;
    }
    
    public void setRatingagency(String ratingagency) {
        this.ratingagency = ratingagency;
    }




}


