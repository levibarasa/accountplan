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
     private String dealpropabilitylookupid;
     private String productlookupid;
     private String dealstagelookupmasterid;
     private String completionmonthlookupid;
     private String dealstatuslookupmasterid;
     private String dealtypelookupmasterid;
     private String clientMaster;
     private String currentlyused;
     private BigDecimal imdealamount;
     private BigDecimal allbankswalletsize;
     private BigDecimal improjectedwalletshare;
     private BigDecimal imexpectedrevenue;
     private String comments; 

    public DealProgressModel() {
    }

    public DealProgressModel(int dealinprogressid, String dealpropabilitylookupid, String productlookupid, String dealstagelookupmasterid, String completionmonthlookupid, String dealstatuslookupmasterid, String dealtypelookupmasterid, String clientMaster, String currentlyused, BigDecimal imdealamount, BigDecimal allbankswalletsize, BigDecimal improjectedwalletshare, BigDecimal imexpectedrevenue, String comments) {
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

    public String getDealpropabilitylookupid() {
        return dealpropabilitylookupid;
    }

    public void setDealpropabilitylookupid(String dealpropabilitylookupid) {
        this.dealpropabilitylookupid = dealpropabilitylookupid;
    }

    public String getProductlookupid() {
        return productlookupid;
    }

    public void setProductlookupid(String productlookupid) {
        this.productlookupid = productlookupid;
    }

    public String getDealstagelookupmasterid() {
        return dealstagelookupmasterid;
    }

    public void setDealstagelookupmasterid(String dealstagelookupmasterid) {
        this.dealstagelookupmasterid = dealstagelookupmasterid;
    }

    public String getCompletionmonthlookupid() {
        return completionmonthlookupid;
    }

    public void setCompletionmonthlookupid(String completionmonthlookupid) {
        this.completionmonthlookupid = completionmonthlookupid;
    }

    public String getDealstatuslookupmasterid() {
        return dealstatuslookupmasterid;
    }

    public void setDealstatuslookupmasterid(String dealstatuslookupmasterid) {
        this.dealstatuslookupmasterid = dealstatuslookupmasterid;
    }

    public String getDealtypelookupmasterid() {
        return dealtypelookupmasterid;
    }

    public void setDealtypelookupmasterid(String dealtypelookupmasterid) {
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
