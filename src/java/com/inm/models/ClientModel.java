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
     private String ECommercepartner;
     private String creditmanager;
     private String treasurypartner;
     private String internetbankingpartner;
     private String assetfinancepartner;
     private String cardspartner;
     private String bancassurancepartner;

    public ClientModel() {
    }

    public ClientModel(String clientid, String rmCode, String alternativeRmCode, String affiliate, String clientname, Date currentDate, String tradeserviceprovider, String cashmanagementpartner, String ECommercepartner, String creditmanager, String treasurypartner, String internetbankingpartner, String assetfinancepartner, String cardspartner, String bancassurancepartner) {
        this.clientid = clientid;
        this.rmCode = rmCode;
        this.alternativeRmCode = alternativeRmCode;
        this.affiliate = affiliate;
        this.clientname = clientname;
        this.currentDate = currentDate;
        this.tradeserviceprovider = tradeserviceprovider;
        this.cashmanagementpartner = cashmanagementpartner;
        this.ECommercepartner = ECommercepartner;
        this.creditmanager = creditmanager;
        this.treasurypartner = treasurypartner;
        this.internetbankingpartner = internetbankingpartner;
        this.assetfinancepartner = assetfinancepartner;
        this.cardspartner = cardspartner;
        this.bancassurancepartner = bancassurancepartner;
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

    public String getECommercepartner() {
        return ECommercepartner;
    }

    public void setECommercepartner(String ECommercepartner) {
        this.ECommercepartner = ECommercepartner;
    }

    public String getCreditmanager() {
        return creditmanager;
    }

    public void setCreditmanager(String creditmanager) {
        this.creditmanager = creditmanager;
    }

    public String getTreasurypartner() {
        return treasurypartner;
    }

    public void setTreasurypartner(String treasurypartner) {
        this.treasurypartner = treasurypartner;
    }

    public String getInternetbankingpartner() {
        return internetbankingpartner;
    }

    public void setInternetbankingpartner(String internetbankingpartner) {
        this.internetbankingpartner = internetbankingpartner;
    }

    public String getAssetfinancepartner() {
        return assetfinancepartner;
    }

    public void setAssetfinancepartner(String assetfinancepartner) {
        this.assetfinancepartner = assetfinancepartner;
    }

    public String getCardspartner() {
        return cardspartner;
    }

    public void setCardspartner(String cardspartner) {
        this.cardspartner = cardspartner;
    }

    public String getBancassurancepartner() {
        return bancassurancepartner;
    }

    public void setBancassurancepartner(String bancassurancepartner) {
        this.bancassurancepartner = bancassurancepartner;
    }

     
}
