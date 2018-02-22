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
public class AccountRevenueModel {
private int accountRevenueid;
     private String clientMaster;
     private BigDecimal currentyearrevenuetarget;
     private BigDecimal prioryearactualrevenue;
     private BigDecimal percentagegrowthrevenue;
     private BigDecimal currentyearnfitarget;
     private BigDecimal prioryearactualfeeincome;
     private BigDecimal percentagegrowthfeeincome;
     private BigDecimal currentshareofwallet;
     private BigDecimal targetshareofwallet;
     private BigDecimal totalvalueofidopportunities;

    public AccountRevenueModel() {
    }

    public AccountRevenueModel(int accountRevenueid, String clientMaster, BigDecimal currentyearrevenuetarget, BigDecimal prioryearactualrevenue, BigDecimal percentagegrowthrevenue, BigDecimal currentyearnfitarget, BigDecimal prioryearactualfeeincome, BigDecimal percentagegrowthfeeincome, BigDecimal currentshareofwallet, BigDecimal targetshareofwallet, BigDecimal totalvalueofidopportunities) {
        this.accountRevenueid = accountRevenueid;
        this.clientMaster = clientMaster;
        this.currentyearrevenuetarget = currentyearrevenuetarget;
        this.prioryearactualrevenue = prioryearactualrevenue;
        this.percentagegrowthrevenue = percentagegrowthrevenue;
        this.currentyearnfitarget = currentyearnfitarget;
        this.prioryearactualfeeincome = prioryearactualfeeincome;
        this.percentagegrowthfeeincome = percentagegrowthfeeincome;
        this.currentshareofwallet = currentshareofwallet;
        this.targetshareofwallet = targetshareofwallet;
        this.totalvalueofidopportunities = totalvalueofidopportunities;
    }

    public int getAccountRevenueid() {
        return accountRevenueid;
    }

    public void setAccountRevenueid(int accountRevenueid) {
        this.accountRevenueid = accountRevenueid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public BigDecimal getCurrentyearrevenuetarget() {
        return currentyearrevenuetarget;
    }

    public void setCurrentyearrevenuetarget(BigDecimal currentyearrevenuetarget) {
        this.currentyearrevenuetarget = currentyearrevenuetarget;
    }

    public BigDecimal getPrioryearactualrevenue() {
        return prioryearactualrevenue;
    }

    public void setPrioryearactualrevenue(BigDecimal prioryearactualrevenue) {
        this.prioryearactualrevenue = prioryearactualrevenue;
    }

    public BigDecimal getPercentagegrowthrevenue() {
        return percentagegrowthrevenue;
    }

    public void setPercentagegrowthrevenue(BigDecimal percentagegrowthrevenue) {
        this.percentagegrowthrevenue = percentagegrowthrevenue;
    }

    public BigDecimal getCurrentyearnfitarget() {
        return currentyearnfitarget;
    }

    public void setCurrentyearnfitarget(BigDecimal currentyearnfitarget) {
        this.currentyearnfitarget = currentyearnfitarget;
    }

    public BigDecimal getPrioryearactualfeeincome() {
        return prioryearactualfeeincome;
    }

    public void setPrioryearactualfeeincome(BigDecimal prioryearactualfeeincome) {
        this.prioryearactualfeeincome = prioryearactualfeeincome;
    }

    public BigDecimal getPercentagegrowthfeeincome() {
        return percentagegrowthfeeincome;
    }

    public void setPercentagegrowthfeeincome(BigDecimal percentagegrowthfeeincome) {
        this.percentagegrowthfeeincome = percentagegrowthfeeincome;
    }

    public BigDecimal getCurrentshareofwallet() {
        return currentshareofwallet;
    }

    public void setCurrentshareofwallet(BigDecimal currentshareofwallet) {
        this.currentshareofwallet = currentshareofwallet;
    }

    public BigDecimal getTargetshareofwallet() {
        return targetshareofwallet;
    }

    public void setTargetshareofwallet(BigDecimal targetshareofwallet) {
        this.targetshareofwallet = targetshareofwallet;
    }

    public BigDecimal getTotalvalueofidopportunities() {
        return totalvalueofidopportunities;
    }

    public void setTotalvalueofidopportunities(BigDecimal totalvalueofidopportunities) {
        this.totalvalueofidopportunities = totalvalueofidopportunities;
    }

     
}
