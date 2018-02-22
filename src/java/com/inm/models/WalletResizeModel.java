/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;
import java.math.BigDecimal;
/**
 *
 * @author Levi
 */
public class WalletResizeModel {
    private int walletResizeId;
     private int lookupmasterByProduct;
     private int lookupmasterByCurrencyLookupid;
     private String clientMaster;
     private BigDecimal interestRate;
     private BigDecimal ftpRate;
     private BigDecimal processingRate;
     private BigDecimal tenor;
     private BigDecimal margin;
     private BigDecimal dealMount;
     private BigDecimal limit;
     private BigDecimal averageUtilizationAmount;
     private BigDecimal annualAverageFloat;
     private BigDecimal totalrevenue;

    public WalletResizeModel() {
    }

    public WalletResizeModel(int walletResizeId, int lookupmasterByProduct, int lookupmasterByCurrencyLookupid, String clientMaster, BigDecimal interestRate, BigDecimal ftpRate, BigDecimal processingRate, BigDecimal tenor, BigDecimal margin, BigDecimal dealMount, BigDecimal limit, BigDecimal averageUtilizationAmount, BigDecimal annualAverageFloat, BigDecimal totalrevenue) {
        this.walletResizeId = walletResizeId;
        this.lookupmasterByProduct = lookupmasterByProduct;
        this.lookupmasterByCurrencyLookupid = lookupmasterByCurrencyLookupid;
        this.clientMaster = clientMaster;
        this.interestRate = interestRate;
        this.ftpRate = ftpRate;
        this.processingRate = processingRate;
        this.tenor = tenor;
        this.margin = margin;
        this.dealMount = dealMount;
        this.limit = limit;
        this.averageUtilizationAmount = averageUtilizationAmount;
        this.annualAverageFloat = annualAverageFloat;
        this.totalrevenue = totalrevenue;
    }

    public int getWalletResizeId() {
        return walletResizeId;
    }

    public void setWalletResizeId(int walletResizeId) {
        this.walletResizeId = walletResizeId;
    }

    public int getLookupmasterByProduct() {
        return lookupmasterByProduct;
    }

    public void setLookupmasterByProduct(int lookupmasterByProduct) {
        this.lookupmasterByProduct = lookupmasterByProduct;
    }

    public int getLookupmasterByCurrencyLookupid() {
        return lookupmasterByCurrencyLookupid;
    }

    public void setLookupmasterByCurrencyLookupid(int lookupmasterByCurrencyLookupid) {
        this.lookupmasterByCurrencyLookupid = lookupmasterByCurrencyLookupid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getFtpRate() {
        return ftpRate;
    }

    public void setFtpRate(BigDecimal ftpRate) {
        this.ftpRate = ftpRate;
    }

    public BigDecimal getProcessingRate() {
        return processingRate;
    }

    public void setProcessingRate(BigDecimal processingRate) {
        this.processingRate = processingRate;
    }

    public BigDecimal getTenor() {
        return tenor;
    }

    public void setTenor(BigDecimal tenor) {
        this.tenor = tenor;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public BigDecimal getDealMount() {
        return dealMount;
    }

    public void setDealMount(BigDecimal dealMount) {
        this.dealMount = dealMount;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getAverageUtilizationAmount() {
        return averageUtilizationAmount;
    }

    public void setAverageUtilizationAmount(BigDecimal averageUtilizationAmount) {
        this.averageUtilizationAmount = averageUtilizationAmount;
    }

    public BigDecimal getAnnualAverageFloat() {
        return annualAverageFloat;
    }

    public void setAnnualAverageFloat(BigDecimal annualAverageFloat) {
        this.annualAverageFloat = annualAverageFloat;
    }

    public BigDecimal getTotalrevenue() {
        return totalrevenue;
    }

    public void setTotalrevenue(BigDecimal totalrevenue) {
        this.totalrevenue = totalrevenue;
    }

      
}
