package com.inm.ap.mode.hibernate;
// Generated Jan 31, 2018 3:59:00 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Dealinprogress generated by hbm2java
 */
public class Dealinprogress  implements java.io.Serializable {


     private int dealinprogressid;
     private Lookupmaster lookupmasterByDealpropabilitylookupid;
     private Lookupmaster lookupmasterByProductlookupid;
     private Lookupmaster lookupmasterByDealstagelookupmasterid;
     private Lookupmaster lookupmasterByCompletionmonthlookupid;
     private Lookupmaster lookupmasterByDealstatuslookupmasterid;
     private Lookupmaster lookupmasterByDealtypelookupmasterid;
     private ClientMaster clientMaster;
     private String currentlyused;
     private BigDecimal imdealamount;
     private BigDecimal allbankswalletsize;
     private BigDecimal improjectedwalletshare;
     private BigDecimal imexpectedrevenue;
     private String comments;

    public Dealinprogress() {
    }

	
    public Dealinprogress(int dealinprogressid, Lookupmaster lookupmasterByDealpropabilitylookupid, Lookupmaster lookupmasterByProductlookupid, Lookupmaster lookupmasterByDealstagelookupmasterid, Lookupmaster lookupmasterByCompletionmonthlookupid, Lookupmaster lookupmasterByDealstatuslookupmasterid, Lookupmaster lookupmasterByDealtypelookupmasterid, ClientMaster clientMaster) {
        this.dealinprogressid = dealinprogressid;
        this.lookupmasterByDealpropabilitylookupid = lookupmasterByDealpropabilitylookupid;
        this.lookupmasterByProductlookupid = lookupmasterByProductlookupid;
        this.lookupmasterByDealstagelookupmasterid = lookupmasterByDealstagelookupmasterid;
        this.lookupmasterByCompletionmonthlookupid = lookupmasterByCompletionmonthlookupid;
        this.lookupmasterByDealstatuslookupmasterid = lookupmasterByDealstatuslookupmasterid;
        this.lookupmasterByDealtypelookupmasterid = lookupmasterByDealtypelookupmasterid;
        this.clientMaster = clientMaster;
    }
    public Dealinprogress(int dealinprogressid, Lookupmaster lookupmasterByDealpropabilitylookupid, Lookupmaster lookupmasterByProductlookupid, Lookupmaster lookupmasterByDealstagelookupmasterid, Lookupmaster lookupmasterByCompletionmonthlookupid, Lookupmaster lookupmasterByDealstatuslookupmasterid, Lookupmaster lookupmasterByDealtypelookupmasterid, ClientMaster clientMaster, String currentlyused, BigDecimal imdealamount, BigDecimal allbankswalletsize, BigDecimal improjectedwalletshare, BigDecimal imexpectedrevenue, String comments) {
       this.dealinprogressid = dealinprogressid;
       this.lookupmasterByDealpropabilitylookupid = lookupmasterByDealpropabilitylookupid;
       this.lookupmasterByProductlookupid = lookupmasterByProductlookupid;
       this.lookupmasterByDealstagelookupmasterid = lookupmasterByDealstagelookupmasterid;
       this.lookupmasterByCompletionmonthlookupid = lookupmasterByCompletionmonthlookupid;
       this.lookupmasterByDealstatuslookupmasterid = lookupmasterByDealstatuslookupmasterid;
       this.lookupmasterByDealtypelookupmasterid = lookupmasterByDealtypelookupmasterid;
       this.clientMaster = clientMaster;
       this.currentlyused = currentlyused;
       this.imdealamount = imdealamount;
       this.allbankswalletsize = allbankswalletsize;
       this.improjectedwalletshare = improjectedwalletshare;
       this.imexpectedrevenue = imexpectedrevenue;
       this.comments = comments;
    }
   
    public int getDealinprogressid() {
        return this.dealinprogressid;
    }
    
    public void setDealinprogressid(int dealinprogressid) {
        this.dealinprogressid = dealinprogressid;
    }
    public Lookupmaster getLookupmasterByDealpropabilitylookupid() {
        return this.lookupmasterByDealpropabilitylookupid;
    }
    
    public void setLookupmasterByDealpropabilitylookupid(Lookupmaster lookupmasterByDealpropabilitylookupid) {
        this.lookupmasterByDealpropabilitylookupid = lookupmasterByDealpropabilitylookupid;
    }
    public Lookupmaster getLookupmasterByProductlookupid() {
        return this.lookupmasterByProductlookupid;
    }
    
    public void setLookupmasterByProductlookupid(Lookupmaster lookupmasterByProductlookupid) {
        this.lookupmasterByProductlookupid = lookupmasterByProductlookupid;
    }
    public Lookupmaster getLookupmasterByDealstagelookupmasterid() {
        return this.lookupmasterByDealstagelookupmasterid;
    }
    
    public void setLookupmasterByDealstagelookupmasterid(Lookupmaster lookupmasterByDealstagelookupmasterid) {
        this.lookupmasterByDealstagelookupmasterid = lookupmasterByDealstagelookupmasterid;
    }
    public Lookupmaster getLookupmasterByCompletionmonthlookupid() {
        return this.lookupmasterByCompletionmonthlookupid;
    }
    
    public void setLookupmasterByCompletionmonthlookupid(Lookupmaster lookupmasterByCompletionmonthlookupid) {
        this.lookupmasterByCompletionmonthlookupid = lookupmasterByCompletionmonthlookupid;
    }
    public Lookupmaster getLookupmasterByDealstatuslookupmasterid() {
        return this.lookupmasterByDealstatuslookupmasterid;
    }
    
    public void setLookupmasterByDealstatuslookupmasterid(Lookupmaster lookupmasterByDealstatuslookupmasterid) {
        this.lookupmasterByDealstatuslookupmasterid = lookupmasterByDealstatuslookupmasterid;
    }
    public Lookupmaster getLookupmasterByDealtypelookupmasterid() {
        return this.lookupmasterByDealtypelookupmasterid;
    }
    
    public void setLookupmasterByDealtypelookupmasterid(Lookupmaster lookupmasterByDealtypelookupmasterid) {
        this.lookupmasterByDealtypelookupmasterid = lookupmasterByDealtypelookupmasterid;
    }
    public ClientMaster getClientMaster() {
        return this.clientMaster;
    }
    
    public void setClientMaster(ClientMaster clientMaster) {
        this.clientMaster = clientMaster;
    }
    public String getCurrentlyused() {
        return this.currentlyused;
    }
    
    public void setCurrentlyused(String currentlyused) {
        this.currentlyused = currentlyused;
    }
    public BigDecimal getImdealamount() {
        return this.imdealamount;
    }
    
    public void setImdealamount(BigDecimal imdealamount) {
        this.imdealamount = imdealamount;
    }
    public BigDecimal getAllbankswalletsize() {
        return this.allbankswalletsize;
    }
    
    public void setAllbankswalletsize(BigDecimal allbankswalletsize) {
        this.allbankswalletsize = allbankswalletsize;
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
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }




}


