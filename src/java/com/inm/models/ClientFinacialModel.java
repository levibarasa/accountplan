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
public class ClientFinacialModel {
  String  Client_FinancialID;
String  ClientID;
String  RM_Code;
String  Turnover;
String  OperatingProfit;
String  TotalDebt;
String  TotalDeposits;
String  GearingRatio;
String  CashFlowCycle;

    public ClientFinacialModel() {
    }

    public ClientFinacialModel(String Client_FinancialID, String ClientID, String RM_Code, String Turnover, String OperatingProfit, String TotalDebt, String TotalDeposits, String GearingRatio, String CashFlowCycle) {
        this.Client_FinancialID = Client_FinancialID;
        this.ClientID = ClientID;
        this.RM_Code = RM_Code;
        this.Turnover = Turnover;
        this.OperatingProfit = OperatingProfit;
        this.TotalDebt = TotalDebt;
        this.TotalDeposits = TotalDeposits;
        this.GearingRatio = GearingRatio;
        this.CashFlowCycle = CashFlowCycle;
    }

    public String getClient_FinancialID() {
        return Client_FinancialID;
    }

    public void setClient_FinancialID(String Client_FinancialID) {
        this.Client_FinancialID = Client_FinancialID;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    public String getRM_Code() {
        return RM_Code;
    }

    public void setRM_Code(String RM_Code) {
        this.RM_Code = RM_Code;
    }

    public String getTurnover() {
        return Turnover;
    }

    public void setTurnover(String Turnover) {
        this.Turnover = Turnover;
    }

    public String getOperatingProfit() {
        return OperatingProfit;
    }

    public void setOperatingProfit(String OperatingProfit) {
        this.OperatingProfit = OperatingProfit;
    }

    public String getTotalDebt() {
        return TotalDebt;
    }

    public void setTotalDebt(String TotalDebt) {
        this.TotalDebt = TotalDebt;
    }

    public String getTotalDeposits() {
        return TotalDeposits;
    }

    public void setTotalDeposits(String TotalDeposits) {
        this.TotalDeposits = TotalDeposits;
    }

    public String getGearingRatio() {
        return GearingRatio;
    }

    public void setGearingRatio(String GearingRatio) {
        this.GearingRatio = GearingRatio;
    }

    public String getCashFlowCycle() {
        return CashFlowCycle;
    }

    public void setCashFlowCycle(String CashFlowCycle) {
        this.CashFlowCycle = CashFlowCycle;
    }

}
