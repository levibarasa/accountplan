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
public class AccountRevenueModel {
String Account_RevenueID;
String ClientID;
String RM_Code;
String CurrentYearRevenueTarget;
String PriorYearActualRevenue;
String PercentageGrowthRevenue;
String CurrentYearFeeIncomeTarget;
String PriorYearActualFeeIncome;
String PercentageGrowthFeeIncome;
String CurrentShareOfWallet;
String TargetShareOfWallet;
String TotalValueOfIdentifiedOpportunities;

    public AccountRevenueModel() {
    }

    public AccountRevenueModel(String Account_RevenueID, String ClientID, String RM_Code, String CurrentYearRevenueTarget, String PriorYearActualRevenue, String PercentageGrowthRevenue, String CurrentYearFeeIncomeTarget, String PriorYearActualFeeIncome, String PercentageGrowthFeeIncome, String CurrentShareOfWallet, String TargetShareOfWallet, String TotalValueOfIdentifiedOpportunities) {
        this.Account_RevenueID = Account_RevenueID;
        this.ClientID = ClientID;
        this.RM_Code = RM_Code;
        this.CurrentYearRevenueTarget = CurrentYearRevenueTarget;
        this.PriorYearActualRevenue = PriorYearActualRevenue;
        this.PercentageGrowthRevenue = PercentageGrowthRevenue;
        this.CurrentYearFeeIncomeTarget = CurrentYearFeeIncomeTarget;
        this.PriorYearActualFeeIncome = PriorYearActualFeeIncome;
        this.PercentageGrowthFeeIncome = PercentageGrowthFeeIncome;
        this.CurrentShareOfWallet = CurrentShareOfWallet;
        this.TargetShareOfWallet = TargetShareOfWallet;
        this.TotalValueOfIdentifiedOpportunities = TotalValueOfIdentifiedOpportunities;
    }

    public String getAccount_RevenueID() {
        return Account_RevenueID;
    }

    public void setAccount_RevenueID(String Account_RevenueID) {
        this.Account_RevenueID = Account_RevenueID;
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

    public String getCurrentYearRevenueTarget() {
        return CurrentYearRevenueTarget;
    }

    public void setCurrentYearRevenueTarget(String CurrentYearRevenueTarget) {
        this.CurrentYearRevenueTarget = CurrentYearRevenueTarget;
    }

    public String getPriorYearActualRevenue() {
        return PriorYearActualRevenue;
    }

    public void setPriorYearActualRevenue(String PriorYearActualRevenue) {
        this.PriorYearActualRevenue = PriorYearActualRevenue;
    }

    public String getPercentageGrowthRevenue() {
        return PercentageGrowthRevenue;
    }

    public void setPercentageGrowthRevenue(String PercentageGrowthRevenue) {
        this.PercentageGrowthRevenue = PercentageGrowthRevenue;
    }

    public String getCurrentYearFeeIncomeTarget() {
        return CurrentYearFeeIncomeTarget;
    }

    public void setCurrentYearFeeIncomeTarget(String CurrentYearFeeIncomeTarget) {
        this.CurrentYearFeeIncomeTarget = CurrentYearFeeIncomeTarget;
    }

    public String getPriorYearActualFeeIncome() {
        return PriorYearActualFeeIncome;
    }

    public void setPriorYearActualFeeIncome(String PriorYearActualFeeIncome) {
        this.PriorYearActualFeeIncome = PriorYearActualFeeIncome;
    }

    public String getPercentageGrowthFeeIncome() {
        return PercentageGrowthFeeIncome;
    }

    public void setPercentageGrowthFeeIncome(String PercentageGrowthFeeIncome) {
        this.PercentageGrowthFeeIncome = PercentageGrowthFeeIncome;
    }

    public String getCurrentShareOfWallet() {
        return CurrentShareOfWallet;
    }

    public void setCurrentShareOfWallet(String CurrentShareOfWallet) {
        this.CurrentShareOfWallet = CurrentShareOfWallet;
    }

    public String getTargetShareOfWallet() {
        return TargetShareOfWallet;
    }

    public void setTargetShareOfWallet(String TargetShareOfWallet) {
        this.TargetShareOfWallet = TargetShareOfWallet;
    }

    public String getTotalValueOfIdentifiedOpportunities() {
        return TotalValueOfIdentifiedOpportunities;
    }

    public void setTotalValueOfIdentifiedOpportunities(String TotalValueOfIdentifiedOpportunities) {
        this.TotalValueOfIdentifiedOpportunities = TotalValueOfIdentifiedOpportunities;
    }



}
