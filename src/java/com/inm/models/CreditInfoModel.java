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
     private String approvedlines;
     private BigDecimal outstandingamount;
     private String riskrating;
     private String ratingagency;

    public CreditInfoModel() {
    }

    public CreditInfoModel(int creditid, String clientMaster, String approvedlines, BigDecimal outstandingamount, String riskrating, String ratingagency) {
        this.creditid = creditid;
        this.clientMaster = clientMaster;
        this.approvedlines = approvedlines;
        this.outstandingamount = outstandingamount;
        this.riskrating = riskrating;
        this.ratingagency = ratingagency;
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

    public String getApprovedlines() {
        return approvedlines;
    }

    public void setApprovedlines(String approvedlines) {
        this.approvedlines = approvedlines;
    }

    public BigDecimal getOutstandingamount() {
        return outstandingamount;
    }

    public void setOutstandingamount(BigDecimal outstandingamount) {
        this.outstandingamount = outstandingamount;
    }

    public String getRiskrating() {
        return riskrating;
    }

    public void setRiskrating(String riskrating) {
        this.riskrating = riskrating;
    }

    public String getRatingagency() {
        return ratingagency;
    }

    public void setRatingagency(String ratingagency) {
        this.ratingagency = ratingagency;
    }

     
}
