package com.inm.ap.mode.hibernate;
// Generated Jan 31, 2018 3:59:00 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Currentandfutureopportunities generated by hbm2java
 */
public class Currentandfutureopportunities  implements java.io.Serializable {


     private int cafoppid;
     private Lookupmaster lookupmaster;
     private ClientMaster clientMaster;
     private BigDecimal estimatedtotalasset;
     private BigDecimal imaverageinterestmargin;
     private BigDecimal assetsnetinterestincome;
     private BigDecimal estimatedtotalliability;
     private BigDecimal imavrgliabilityintrestmargin;
     private BigDecimal liabilitynetinterestincome;
     private BigDecimal totalnetinterestincome;
     private BigDecimal assetestimatedtotal;
     private BigDecimal imassetaveragefeerate;
     private BigDecimal assetsfeeincome;
     private BigDecimal liabilityestimatedtotal;
     private BigDecimal imliabilityaveragefeerate;
     private BigDecimal liabilityfeeincome;
     private BigDecimal incometotalfee;
     private BigDecimal imwalletsize;
     private BigDecimal improjectedwalletshare;
     private BigDecimal imexpectedrevenue;
     private BigDecimal allbankswalletsizrevmanual;
     private BigDecimal percentwalletsharemanual;
     private BigDecimal dealvolumefees;
     private BigDecimal dealvolassets;
     private BigDecimal dealvolliabilities;
     private BigDecimal dealvolrevenue;

    public Currentandfutureopportunities() {
    }

	
    public Currentandfutureopportunities(int cafoppid, Lookupmaster lookupmaster, ClientMaster clientMaster) {
        this.cafoppid = cafoppid;
        this.lookupmaster = lookupmaster;
        this.clientMaster = clientMaster;
    }
    public Currentandfutureopportunities(int cafoppid, Lookupmaster lookupmaster, ClientMaster clientMaster, BigDecimal estimatedtotalasset, BigDecimal imaverageinterestmargin, BigDecimal assetsnetinterestincome, BigDecimal estimatedtotalliability, BigDecimal imavrgliabilityintrestmargin, BigDecimal liabilitynetinterestincome, BigDecimal totalnetinterestincome, BigDecimal assetestimatedtotal, BigDecimal imassetaveragefeerate, BigDecimal assetsfeeincome, BigDecimal liabilityestimatedtotal, BigDecimal imliabilityaveragefeerate, BigDecimal liabilityfeeincome, BigDecimal incometotalfee, BigDecimal imwalletsize, BigDecimal improjectedwalletshare, BigDecimal imexpectedrevenue, BigDecimal allbankswalletsizrevmanual, BigDecimal percentwalletsharemanual, BigDecimal dealvolumefees, BigDecimal dealvolassets, BigDecimal dealvolliabilities, BigDecimal dealvolrevenue) {
       this.cafoppid = cafoppid;
       this.lookupmaster = lookupmaster;
       this.clientMaster = clientMaster;
       this.estimatedtotalasset = estimatedtotalasset;
       this.imaverageinterestmargin = imaverageinterestmargin;
       this.assetsnetinterestincome = assetsnetinterestincome;
       this.estimatedtotalliability = estimatedtotalliability;
       this.imavrgliabilityintrestmargin = imavrgliabilityintrestmargin;
       this.liabilitynetinterestincome = liabilitynetinterestincome;
       this.totalnetinterestincome = totalnetinterestincome;
       this.assetestimatedtotal = assetestimatedtotal;
       this.imassetaveragefeerate = imassetaveragefeerate;
       this.assetsfeeincome = assetsfeeincome;
       this.liabilityestimatedtotal = liabilityestimatedtotal;
       this.imliabilityaveragefeerate = imliabilityaveragefeerate;
       this.liabilityfeeincome = liabilityfeeincome;
       this.incometotalfee = incometotalfee;
       this.imwalletsize = imwalletsize;
       this.improjectedwalletshare = improjectedwalletshare;
       this.imexpectedrevenue = imexpectedrevenue;
       this.allbankswalletsizrevmanual = allbankswalletsizrevmanual;
       this.percentwalletsharemanual = percentwalletsharemanual;
       this.dealvolumefees = dealvolumefees;
       this.dealvolassets = dealvolassets;
       this.dealvolliabilities = dealvolliabilities;
       this.dealvolrevenue = dealvolrevenue;
    }
   
    public int getCafoppid() {
        return this.cafoppid;
    }
    
    public void setCafoppid(int cafoppid) {
        this.cafoppid = cafoppid;
    }
    public Lookupmaster getLookupmaster() {
        return this.lookupmaster;
    }
    
    public void setLookupmaster(Lookupmaster lookupmaster) {
        this.lookupmaster = lookupmaster;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public BigDecimal getEstimatedtotalasset() {
        return this.estimatedtotalasset;
    }
    
    public void setEstimatedtotalasset(BigDecimal estimatedtotalasset) {
        this.estimatedtotalasset = estimatedtotalasset;
    }
    public BigDecimal getImaverageinterestmargin() {
        return this.imaverageinterestmargin;
    }
    
    public void setImaverageinterestmargin(BigDecimal imaverageinterestmargin) {
        this.imaverageinterestmargin = imaverageinterestmargin;
    }
    public BigDecimal getAssetsnetinterestincome() {
        return this.assetsnetinterestincome;
    }
    
    public void setAssetsnetinterestincome(BigDecimal assetsnetinterestincome) {
        this.assetsnetinterestincome = assetsnetinterestincome;
    }
    public BigDecimal getEstimatedtotalliability() {
        return this.estimatedtotalliability;
    }
    
    public void setEstimatedtotalliability(BigDecimal estimatedtotalliability) {
        this.estimatedtotalliability = estimatedtotalliability;
    }
    public BigDecimal getImavrgliabilityintrestmargin() {
        return this.imavrgliabilityintrestmargin;
    }
    
    public void setImavrgliabilityintrestmargin(BigDecimal imavrgliabilityintrestmargin) {
        this.imavrgliabilityintrestmargin = imavrgliabilityintrestmargin;
    }
    public BigDecimal getLiabilitynetinterestincome() {
        return this.liabilitynetinterestincome;
    }
    
    public void setLiabilitynetinterestincome(BigDecimal liabilitynetinterestincome) {
        this.liabilitynetinterestincome = liabilitynetinterestincome;
    }
    public BigDecimal getTotalnetinterestincome() {
        return this.totalnetinterestincome;
    }
    
    public void setTotalnetinterestincome(BigDecimal totalnetinterestincome) {
        this.totalnetinterestincome = totalnetinterestincome;
    }
    public BigDecimal getAssetestimatedtotal() {
        return this.assetestimatedtotal;
    }
    
    public void setAssetestimatedtotal(BigDecimal assetestimatedtotal) {
        this.assetestimatedtotal = assetestimatedtotal;
    }
    public BigDecimal getImassetaveragefeerate() {
        return this.imassetaveragefeerate;
    }
    
    public void setImassetaveragefeerate(BigDecimal imassetaveragefeerate) {
        this.imassetaveragefeerate = imassetaveragefeerate;
    }
    public BigDecimal getAssetsfeeincome() {
        return this.assetsfeeincome;
    }
    
    public void setAssetsfeeincome(BigDecimal assetsfeeincome) {
        this.assetsfeeincome = assetsfeeincome;
    }
    public BigDecimal getLiabilityestimatedtotal() {
        return this.liabilityestimatedtotal;
    }
    
    public void setLiabilityestimatedtotal(BigDecimal liabilityestimatedtotal) {
        this.liabilityestimatedtotal = liabilityestimatedtotal;
    }
    public BigDecimal getImliabilityaveragefeerate() {
        return this.imliabilityaveragefeerate;
    }
    
    public void setImliabilityaveragefeerate(BigDecimal imliabilityaveragefeerate) {
        this.imliabilityaveragefeerate = imliabilityaveragefeerate;
    }
    public BigDecimal getLiabilityfeeincome() {
        return this.liabilityfeeincome;
    }
    
    public void setLiabilityfeeincome(BigDecimal liabilityfeeincome) {
        this.liabilityfeeincome = liabilityfeeincome;
    }
    public BigDecimal getIncometotalfee() {
        return this.incometotalfee;
    }
    
    public void setIncometotalfee(BigDecimal incometotalfee) {
        this.incometotalfee = incometotalfee;
    }
    public BigDecimal getImwalletsize() {
        return this.imwalletsize;
    }
    
    public void setImwalletsize(BigDecimal imwalletsize) {
        this.imwalletsize = imwalletsize;
    }
    public BigDecimal getImprojectedwalletshare() {
        return this.improjectedwalletshare;
    }
    
    public void setImprojectedwalletshare(BigDecimal improjectedwalletshare) {
        this.improjectedwalletshare = improjectedwalletshare;
    }
    public BigDecimal getImexpectedrevenue() {
        return this.imexpectedrevenue;
    }
    
    public void setImexpectedrevenue(BigDecimal imexpectedrevenue) {
        this.imexpectedrevenue = imexpectedrevenue;
    }
    public BigDecimal getAllbankswalletsizrevmanual() {
        return this.allbankswalletsizrevmanual;
    }
    
    public void setAllbankswalletsizrevmanual(BigDecimal allbankswalletsizrevmanual) {
        this.allbankswalletsizrevmanual = allbankswalletsizrevmanual;
    }
    public BigDecimal getPercentwalletsharemanual() {
        return this.percentwalletsharemanual;
    }
    
    public void setPercentwalletsharemanual(BigDecimal percentwalletsharemanual) {
        this.percentwalletsharemanual = percentwalletsharemanual;
    }
    public BigDecimal getDealvolumefees() {
        return this.dealvolumefees;
    }
    
    public void setDealvolumefees(BigDecimal dealvolumefees) {
        this.dealvolumefees = dealvolumefees;
    }
    public BigDecimal getDealvolassets() {
        return this.dealvolassets;
    }
    
    public void setDealvolassets(BigDecimal dealvolassets) {
        this.dealvolassets = dealvolassets;
    }
    public BigDecimal getDealvolliabilities() {
        return this.dealvolliabilities;
    }
    
    public void setDealvolliabilities(BigDecimal dealvolliabilities) {
        this.dealvolliabilities = dealvolliabilities;
    }
    public BigDecimal getDealvolrevenue() {
        return this.dealvolrevenue;
    }
    
    public void setDealvolrevenue(BigDecimal dealvolrevenue) {
        this.dealvolrevenue = dealvolrevenue;
    }




}


