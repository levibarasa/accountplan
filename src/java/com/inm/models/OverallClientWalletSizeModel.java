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
public class OverallClientWalletSizeModel {
    private int clientwalletsizeid;
     private String clientMaster;
     private BigDecimal totalcorporatedebt;
     private BigDecimal averageimloanmargin;
     private BigDecimal assetsinterestincome;
     private BigDecimal estimatedcorporatedeposits;
     private BigDecimal averageimdepositmargin;
     private BigDecimal netintrstliabltyincome;
     private BigDecimal totalnetinterestincome;
     private BigDecimal totalnii;
     private BigDecimal imfeeincome;
     private BigDecimal totalfeeincome;
     private BigDecimal clientbankingwallet;
     private BigDecimal imrevenue;
     private BigDecimal estimatedwalletshare;

    public OverallClientWalletSizeModel() {
    }

    public OverallClientWalletSizeModel(int clientwalletsizeid, String clientMaster, BigDecimal totalcorporatedebt, BigDecimal averageimloanmargin, BigDecimal assetsinterestincome, BigDecimal estimatedcorporatedeposits, BigDecimal averageimdepositmargin, BigDecimal netintrstliabltyincome, BigDecimal totalnetinterestincome, BigDecimal totalnii, BigDecimal imfeeincome, BigDecimal totalfeeincome, BigDecimal clientbankingwallet, BigDecimal imrevenue, BigDecimal estimatedwalletshare) {
        this.clientwalletsizeid = clientwalletsizeid;
        this.clientMaster = clientMaster;
        this.totalcorporatedebt = totalcorporatedebt;
        this.averageimloanmargin = averageimloanmargin;
        this.assetsinterestincome = assetsinterestincome;
        this.estimatedcorporatedeposits = estimatedcorporatedeposits;
        this.averageimdepositmargin = averageimdepositmargin;
        this.netintrstliabltyincome = netintrstliabltyincome;
        this.totalnetinterestincome = totalnetinterestincome;
        this.totalnii = totalnii;
        this.imfeeincome = imfeeincome;
        this.totalfeeincome = totalfeeincome;
        this.clientbankingwallet = clientbankingwallet;
        this.imrevenue = imrevenue;
        this.estimatedwalletshare = estimatedwalletshare;
    }

    public int getClientwalletsizeid() {
        return clientwalletsizeid;
    }

    public void setClientwalletsizeid(int clientwalletsizeid) {
        this.clientwalletsizeid = clientwalletsizeid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public BigDecimal getTotalcorporatedebt() {
        return totalcorporatedebt;
    }

    public void setTotalcorporatedebt(BigDecimal totalcorporatedebt) {
        this.totalcorporatedebt = totalcorporatedebt;
    }

    public BigDecimal getAverageimloanmargin() {
        return averageimloanmargin;
    }

    public void setAverageimloanmargin(BigDecimal averageimloanmargin) {
        this.averageimloanmargin = averageimloanmargin;
    }

    public BigDecimal getAssetsinterestincome() {
        return assetsinterestincome;
    }

    public void setAssetsinterestincome(BigDecimal assetsinterestincome) {
        this.assetsinterestincome = assetsinterestincome;
    }

    public BigDecimal getEstimatedcorporatedeposits() {
        return estimatedcorporatedeposits;
    }

    public void setEstimatedcorporatedeposits(BigDecimal estimatedcorporatedeposits) {
        this.estimatedcorporatedeposits = estimatedcorporatedeposits;
    }

    public BigDecimal getAverageimdepositmargin() {
        return averageimdepositmargin;
    }

    public void setAverageimdepositmargin(BigDecimal averageimdepositmargin) {
        this.averageimdepositmargin = averageimdepositmargin;
    }

    public BigDecimal getNetintrstliabltyincome() {
        return netintrstliabltyincome;
    }

    public void setNetintrstliabltyincome(BigDecimal netintrstliabltyincome) {
        this.netintrstliabltyincome = netintrstliabltyincome;
    }

    public BigDecimal getTotalnetinterestincome() {
        return totalnetinterestincome;
    }

    public void setTotalnetinterestincome(BigDecimal totalnetinterestincome) {
        this.totalnetinterestincome = totalnetinterestincome;
    }

    public BigDecimal getTotalnii() {
        return totalnii;
    }

    public void setTotalnii(BigDecimal totalnii) {
        this.totalnii = totalnii;
    }

    public BigDecimal getImfeeincome() {
        return imfeeincome;
    }

    public void setImfeeincome(BigDecimal imfeeincome) {
        this.imfeeincome = imfeeincome;
    }

    public BigDecimal getTotalfeeincome() {
        return totalfeeincome;
    }

    public void setTotalfeeincome(BigDecimal totalfeeincome) {
        this.totalfeeincome = totalfeeincome;
    }

    public BigDecimal getClientbankingwallet() {
        return clientbankingwallet;
    }

    public void setClientbankingwallet(BigDecimal clientbankingwallet) {
        this.clientbankingwallet = clientbankingwallet;
    }

    public BigDecimal getImrevenue() {
        return imrevenue;
    }

    public void setImrevenue(BigDecimal imrevenue) {
        this.imrevenue = imrevenue;
    }

    public BigDecimal getEstimatedwalletshare() {
        return estimatedwalletshare;
    }

    public void setEstimatedwalletshare(BigDecimal estimatedwalletshare) {
        this.estimatedwalletshare = estimatedwalletshare;
    }

     
}
