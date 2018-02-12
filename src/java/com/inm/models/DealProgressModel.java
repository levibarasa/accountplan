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
public class DealProgressModel {
    private int dealinprogressid;
     private int dealpropabilitylookupid;
     private int productlookupid;
     private int dealstagelookupmasterid;
     private int completionmonthlookupid;
     private int dealstatuslookupmasterid;
     private int dealtypelookupmasterid;
     private String clientMaster;
     private String currentlyused;
     private BigDecimal imdealamount;
     private BigDecimal allbankswalletsize;
     private BigDecimal improjectedwalletshare;
     private BigDecimal imexpectedrevenue;
     private String comments; 

    public DealProgressModel() {
    }

    public DealProgressModel(int dealinprogressid, int dealpropabilitylookupid, int productlookupid, int dealstagelookupmasterid, int completionmonthlookupid, int dealstatuslookupmasterid, int dealtypelookupmasterid, String clientMaster, String currentlyused, BigDecimal imdealamount, BigDecimal allbankswalletsize, BigDecimal improjectedwalletshare, BigDecimal imexpectedrevenue, String comments) {
        this.dealinprogressid = dealinprogressid;
        this.dealpropabilitylookupid = dealpropabilitylookupid;
        this.productlookupid = productlookupid;
        this.dealstagelookupmasterid = dealstagelookupmasterid;
        this.completionmonthlookupid = completionmonthlookupid;
        this.dealstatuslookupmasterid = dealstatuslookupmasterid;
        this.dealtypelookupmasterid = dealtypelookupmasterid;
        this.clientMaster = clientMaster;
        this.currentlyused = currentlyused;
        this.imdealamount = imdealamount;
        this.allbankswalletsize = allbankswalletsize;
        this.improjectedwalletshare = improjectedwalletshare;
        this.imexpectedrevenue = imexpectedrevenue;
        this.comments = comments;
    }

    public int getDealinprogressid() {
        return dealinprogressid;
    }

    public void setDealinprogressid(int dealinprogressid) {
        this.dealinprogressid = dealinprogressid;
    }

    public int getDealpropabilitylookupid() {
        return dealpropabilitylookupid;
    }

    public void setDealpropabilitylookupid(int dealpropabilitylookupid) {
        this.dealpropabilitylookupid = dealpropabilitylookupid;
    }

    public int getProductlookupid() {
        return productlookupid;
    }

    public void setProductlookupid(int productlookupid) {
        this.productlookupid = productlookupid;
    }

    public int getDealstagelookupmasterid() {
        return dealstagelookupmasterid;
    }

    public void setDealstagelookupmasterid(int dealstagelookupmasterid) {
        this.dealstagelookupmasterid = dealstagelookupmasterid;
    }

    public int getCompletionmonthlookupid() {
        return completionmonthlookupid;
    }

    public void setCompletionmonthlookupid(int completionmonthlookupid) {
        this.completionmonthlookupid = completionmonthlookupid;
    }

    public int getDealstatuslookupmasterid() {
        return dealstatuslookupmasterid;
    }

    public void setDealstatuslookupmasterid(int dealstatuslookupmasterid) {
        this.dealstatuslookupmasterid = dealstatuslookupmasterid;
    }

    public int getDealtypelookupmasterid() {
        return dealtypelookupmasterid;
    }

    public void setDealtypelookupmasterid(int dealtypelookupmasterid) {
        this.dealtypelookupmasterid = dealtypelookupmasterid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getCurrentlyused() {
        return currentlyused;
    }

    public void setCurrentlyused(String currentlyused) {
        this.currentlyused = currentlyused;
    }

    public BigDecimal getImdealamount() {
        return imdealamount;
    }

    public void setImdealamount(BigDecimal imdealamount) {
        this.imdealamount = imdealamount;
    }

    public BigDecimal getAllbankswalletsize() {
        return allbankswalletsize;
    }

    public void setAllbankswalletsize(BigDecimal allbankswalletsize) {
        this.allbankswalletsize = allbankswalletsize;
    }

    public BigDecimal getImprojectedwalletshare() {
        return improjectedwalletshare;
    }

    public void setImprojectedwalletshare(BigDecimal improjectedwalletshare) {
        this.improjectedwalletshare = improjectedwalletshare;
    }

    public BigDecimal getImexpectedrevenue() {
        return imexpectedrevenue;
    }

    public void setImexpectedrevenue(BigDecimal imexpectedrevenue) {
        this.imexpectedrevenue = imexpectedrevenue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

     
}
