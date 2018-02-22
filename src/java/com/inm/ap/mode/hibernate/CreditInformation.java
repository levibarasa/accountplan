package com.inm.ap.mode.hibernate;
// Generated Feb 19, 2018 4:06:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * CreditInformation generated by hbm2java
 */
public class CreditInformation  implements java.io.Serializable {


     private int creditid;
     private ClientMaster clientMaster;
     private String imapprovedlines;
     private BigDecimal imoutstandingamount;
     private String riskrating;
     private String approvedlinesallbanks;
     private BigDecimal outstandingamountallbanks;

    public CreditInformation() {
    }

	
    public CreditInformation(int creditid, ClientMaster clientMaster) {
        this.creditid = creditid;
        this.clientMaster = clientMaster;
    }
    public CreditInformation(int creditid, ClientMaster clientMaster, String imapprovedlines, BigDecimal imoutstandingamount, String riskrating, String approvedlinesallbanks, BigDecimal outstandingamountallbanks) {
       this.creditid = creditid;
       this.clientMaster = clientMaster;
       this.imapprovedlines = imapprovedlines;
       this.imoutstandingamount = imoutstandingamount;
       this.riskrating = riskrating;
       this.approvedlinesallbanks = approvedlinesallbanks;
       this.outstandingamountallbanks = outstandingamountallbanks;
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
    public String getImapprovedlines() {
        return this.imapprovedlines;
    }
    
    public void setImapprovedlines(String imapprovedlines) {
        this.imapprovedlines = imapprovedlines;
    }
    public BigDecimal getImoutstandingamount() {
        return this.imoutstandingamount;
    }
    
    public void setImoutstandingamount(BigDecimal imoutstandingamount) {
        this.imoutstandingamount = imoutstandingamount;
    }
    public String getRiskrating() {
        return this.riskrating;
    }
    
    public void setRiskrating(String riskrating) {
        this.riskrating = riskrating;
    }
    public String getApprovedlinesallbanks() {
        return this.approvedlinesallbanks;
    }
    
    public void setApprovedlinesallbanks(String approvedlinesallbanks) {
        this.approvedlinesallbanks = approvedlinesallbanks;
    }
    public BigDecimal getOutstandingamountallbanks() {
        return this.outstandingamountallbanks;
    }
    
    public void setOutstandingamountallbanks(BigDecimal outstandingamountallbanks) {
        this.outstandingamountallbanks = outstandingamountallbanks;
    }




}


