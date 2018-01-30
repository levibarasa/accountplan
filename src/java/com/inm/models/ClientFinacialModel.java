/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;
import java.math.*;
/**
 *
 * @author Levi
 */
public class ClientFinacialModel {
      private int clientFinancialid;
     private String clientMaster;
     private BigDecimal turnover = BigDecimal.ZERO;
     private BigDecimal operatingprofit = BigDecimal.ZERO;
     private BigDecimal totaldebt = BigDecimal.ZERO;
     private BigDecimal totaldeposits = BigDecimal.ZERO;
     private BigDecimal gearingratio = BigDecimal.ZERO;
     private BigDecimal cashflowcycle = BigDecimal.ZERO;

    public ClientFinacialModel() {
    }

    public ClientFinacialModel(int clientFinancialid, String clientMaster, BigDecimal turnover, BigDecimal operatingprofit, BigDecimal totaldebt, BigDecimal totaldeposits, BigDecimal gearingratio, BigDecimal cashflowcycle) {
        this.clientFinancialid = clientFinancialid;
        this.clientMaster = clientMaster;
        this.turnover = turnover;
        this.operatingprofit = operatingprofit;
        this.totaldebt = totaldebt;
        this.totaldeposits = totaldeposits;
        this.gearingratio = gearingratio;
        this.cashflowcycle = cashflowcycle;
    }

    public int getClientFinancialid() {
        return clientFinancialid;
    }

    public void setClientFinancialid(int clientFinancialid) {
        this.clientFinancialid = clientFinancialid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getOperatingprofit() {
        return operatingprofit;
    }

    public void setOperatingprofit(BigDecimal operatingprofit) {
        this.operatingprofit = operatingprofit;
    }

    public BigDecimal getTotaldebt() {
        return totaldebt;
    }

    public void setTotaldebt(BigDecimal totaldebt) {
        this.totaldebt = totaldebt;
    }

    public BigDecimal getTotaldeposits() {
        return totaldeposits;
    }

    public void setTotaldeposits(BigDecimal totaldeposits) {
        this.totaldeposits = totaldeposits;
    }

    public BigDecimal getGearingratio() {
        return gearingratio;
    }

    public void setGearingratio(BigDecimal gearingratio) {
        this.gearingratio = gearingratio;
    }

    public BigDecimal getCashflowcycle() {
        return cashflowcycle;
    }

    public void setCashflowcycle(BigDecimal cashflowcycle) {
        this.cashflowcycle = cashflowcycle;
    }
     
}
