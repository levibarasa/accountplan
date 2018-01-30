/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;
 import java.util.Date;
/**
 *
 * @author Levi
 */
public class ClientModel {
    
     private String clientid;
     private String rmCode;
     private String alternativeRmCode;
     private String affiliate;
     private String clientname;
     private Date currentDate;
     private String tradeserviceprovider;
     private String cashmanagementpartner;
     private String EBankingpartner;
     private String riskmanagementpartner;

    public ClientModel() {
    }

    public ClientModel(String clientid, String rmCode, String alternativeRmCode, String affiliate, String clientname, Date currentDate, String tradeserviceprovider, String cashmanagementpartner, String EBankingpartner) {
        this.clientid = clientid;
        this.rmCode = rmCode;
        this.alternativeRmCode = alternativeRmCode;
        this.affiliate = affiliate;
        this.clientname = clientname;
        this.currentDate = currentDate;
        this.tradeserviceprovider = tradeserviceprovider;
        this.cashmanagementpartner = cashmanagementpartner;
        this.EBankingpartner = EBankingpartner;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getAlternativeRmCode() {
        return alternativeRmCode;
    }

    public void setAlternativeRmCode(String alternativeRmCode) {
        this.alternativeRmCode = alternativeRmCode;
    }

    public String getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(String affiliate) {
        this.affiliate = affiliate;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getTradeserviceprovider() {
        return tradeserviceprovider;
    }

    public void setTradeserviceprovider(String tradeserviceprovider) {
        this.tradeserviceprovider = tradeserviceprovider;
    }

    public String getCashmanagementpartner() {
        return cashmanagementpartner;
    }

    public void setCashmanagementpartner(String cashmanagementpartner) {
        this.cashmanagementpartner = cashmanagementpartner;
    }

    public String getEBankingpartner() {
        return EBankingpartner;
    }

    public void setEBankingpartner(String EBankingpartner) {
        this.EBankingpartner = EBankingpartner;
    }

    public String getRiskmanagementpartner() {
        return riskmanagementpartner;
    }

    public void setRiskmanagementpartner(String riskmanagementpartner) {
        this.riskmanagementpartner = riskmanagementpartner;
    }
}
