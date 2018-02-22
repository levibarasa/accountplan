/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;

import com.inm.ap.mode.hibernate.ClientMaster;
import java.math.BigDecimal;

/**
 *
 * @author Levi
 */
public class CreditInfoModel {
    private int creditid;
     private String clientMaster;
     private String imapprovedlines;
     private BigDecimal imoutstandingamount;
     private String riskrating;
     private String approvedlinesallbanks;
     private BigDecimal outstandingamountallbanks;

    public CreditInfoModel() {
    }

    public CreditInfoModel(int creditid, String clientMaster, String imapprovedlines, BigDecimal imoutstandingamount, String riskrating, String approvedlinesallbanks, BigDecimal outstandingamountallbanks) {
        this.creditid = creditid;
        this.clientMaster = clientMaster;
        this.imapprovedlines = imapprovedlines;
        this.imoutstandingamount = imoutstandingamount;
        this.riskrating = riskrating;
        this.approvedlinesallbanks = approvedlinesallbanks;
        this.outstandingamountallbanks = outstandingamountallbanks;
    }

    public int getCreditid() {
        return creditid;
    }

    public void setCreditid(int creditid) {
        this.creditid = creditid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getImapprovedlines() {
        return imapprovedlines;
    }

    public void setImapprovedlines(String imapprovedlines) {
        this.imapprovedlines = imapprovedlines;
    }

    public BigDecimal getImoutstandingamount() {
        return imoutstandingamount;
    }

    public void setImoutstandingamount(BigDecimal imoutstandingamount) {
        this.imoutstandingamount = imoutstandingamount;
    }

    public String getRiskrating() {
        return riskrating;
    }

    public void setRiskrating(String riskrating) {
        this.riskrating = riskrating;
    }

    public String getApprovedlinesallbanks() {
        return approvedlinesallbanks;
    }

    public void setApprovedlinesallbanks(String approvedlinesallbanks) {
        this.approvedlinesallbanks = approvedlinesallbanks;
    }

    public BigDecimal getOutstandingamountallbanks() {
        return outstandingamountallbanks;
    }

    public void setOutstandingamountallbanks(BigDecimal outstandingamountallbanks) {
        this.outstandingamountallbanks = outstandingamountallbanks;
    }

       
}
