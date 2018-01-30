package com.inm.ap.mode.hibernate;
// Generated Jan 25, 2018 9:36:12 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Overallclientwalletsize generated by hbm2java
 */
public class Overallclientwalletsize  implements java.io.Serializable {


     private BigDecimal clientwalletsizeid;
     private ClientMaster clientMaster;
     private BigDecimal totalcorporatedebt;
     private BigDecimal averageimloanmargin;
     private BigDecimal assetsinterestincome;
     private BigDecimal estimatedcorporatedeposits;
     private BigDecimal averageimdepositmargin;
     private BigDecimal netintrstliabltyincome;
     private BigDecimal totalnetinterestincome;
     private BigDecimal totalnii;
     private BigDecimal imfeeincome;

    public Overallclientwalletsize() {
    }

	
    public Overallclientwalletsize(BigDecimal clientwalletsizeid, ClientMaster clientMaster) {
        this.clientwalletsizeid = clientwalletsizeid;
        this.clientMaster = clientMaster;
    }
    public Overallclientwalletsize(BigDecimal clientwalletsizeid, ClientMaster clientMaster, BigDecimal totalcorporatedebt, BigDecimal averageimloanmargin, BigDecimal assetsinterestincome, BigDecimal estimatedcorporatedeposits, BigDecimal averageimdepositmargin, BigDecimal netintrstliabltyincome, BigDecimal totalnetinterestincome, BigDecimal totalnii, BigDecimal imfeeincome) {
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
    }
   
    public BigDecimal getClientwalletsizeid() {
        return this.clientwalletsizeid;
    }
    
    public void setClientwalletsizeid(BigDecimal clientwalletsizeid) {
        this.clientwalletsizeid = clientwalletsizeid;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public BigDecimal getTotalcorporatedebt() {
        return this.totalcorporatedebt;
    }
    
    public void setTotalcorporatedebt(BigDecimal totalcorporatedebt) {
        this.totalcorporatedebt = totalcorporatedebt;
    }
    public BigDecimal getAverageimloanmargin() {
        return this.averageimloanmargin;
    }
    
    public void setAverageimloanmargin(BigDecimal averageimloanmargin) {
        this.averageimloanmargin = averageimloanmargin;
    }
    public BigDecimal getAssetsinterestincome() {
        return this.assetsinterestincome;
    }
    
    public void setAssetsinterestincome(BigDecimal assetsinterestincome) {
        this.assetsinterestincome = assetsinterestincome;
    }
    public BigDecimal getEstimatedcorporatedeposits() {
        return this.estimatedcorporatedeposits;
    }
    
    public void setEstimatedcorporatedeposits(BigDecimal estimatedcorporatedeposits) {
        this.estimatedcorporatedeposits = estimatedcorporatedeposits;
    }
    public BigDecimal getAverageimdepositmargin() {
        return this.averageimdepositmargin;
    }
    
    public void setAverageimdepositmargin(BigDecimal averageimdepositmargin) {
        this.averageimdepositmargin = averageimdepositmargin;
    }
    public BigDecimal getNetintrstliabltyincome() {
        return this.netintrstliabltyincome;
    }
    
    public void setNetintrstliabltyincome(BigDecimal netintrstliabltyincome) {
        this.netintrstliabltyincome = netintrstliabltyincome;
    }
    public BigDecimal getTotalnetinterestincome() {
        return this.totalnetinterestincome;
    }
    
    public void setTotalnetinterestincome(BigDecimal totalnetinterestincome) {
        this.totalnetinterestincome = totalnetinterestincome;
    }
    public BigDecimal getTotalnii() {
        return this.totalnii;
    }
    
    public void setTotalnii(BigDecimal totalnii) {
        this.totalnii = totalnii;
    }
    public BigDecimal getImfeeincome() {
        return this.imfeeincome;
    }
    
    public void setImfeeincome(BigDecimal imfeeincome) {
        this.imfeeincome = imfeeincome;
    }




}

