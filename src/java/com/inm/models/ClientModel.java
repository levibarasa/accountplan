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
public class ClientModel {
 String ClientID;
 String ClientName;
 String RM_Code;
 String Alternative_RM_Code;
 String AffiliateId;
 String Current_Date;
 String TradeServiceProvider;
 String CashManagementPartner;
 String E_BankingPartner;
 String RiskManagementPartner;
 String Client_Category;

    public ClientModel() {
    }

    public ClientModel(String ClientID, String RM_Code, String Alternative_RM_Code, String AffiliateId, String Current_Date, String TradeServiceProvider, String CashManagementPartner, String E_BankingPartner, String RiskManagementPartner, String Client_Category) {
        this.ClientID = ClientID;
        this.RM_Code = RM_Code;
        this.Alternative_RM_Code = Alternative_RM_Code;
        this.AffiliateId = AffiliateId;
        this.Current_Date = Current_Date;
        this.TradeServiceProvider = TradeServiceProvider;
        this.CashManagementPartner = CashManagementPartner;
        this.E_BankingPartner = E_BankingPartner;
        this.RiskManagementPartner = RiskManagementPartner;
        this.Client_Category = Client_Category;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getRM_Code() {
        return RM_Code;
    }

    public void setRM_Code(String RM_Code) {
        this.RM_Code = RM_Code;
    }

    public String getAlternative_RM_Code() {
        return Alternative_RM_Code;
    }

    public void setAlternative_RM_Code(String Alternative_RM_Code) {
        this.Alternative_RM_Code = Alternative_RM_Code;
    }

    public String getAffiliateId() {
        return AffiliateId;
    }

    public void setAffiliateId(String AffiliateId) {
        this.AffiliateId = AffiliateId;
    }

    public String getCurrent_Date() {
        return Current_Date;
    }

    public void setCurrent_Date(String Current_Date) {
        this.Current_Date = Current_Date;
    }

    public String getTradeServiceProvider() {
        return TradeServiceProvider;
    }

    public void setTradeServiceProvider(String TradeServiceProvider) {
        this.TradeServiceProvider = TradeServiceProvider;
    }

    public String getCashManagementPartner() {
        return CashManagementPartner;
    }

    public void setCashManagementPartner(String CashManagementPartner) {
        this.CashManagementPartner = CashManagementPartner;
    }

    public String getE_BankingPartner() {
        return E_BankingPartner;
    }

    public void setE_BankingPartner(String E_BankingPartner) {
        this.E_BankingPartner = E_BankingPartner;
    }

    public String getRiskManagementPartner() {
        return RiskManagementPartner;
    }

    public void setRiskManagementPartner(String RiskManagementPartner) {
        this.RiskManagementPartner = RiskManagementPartner;
    }

    public String getClient_Category() {
        return Client_Category;
    }

    public void setClient_Category(String Client_Category) {
        this.Client_Category = Client_Category;
    }
   
}
