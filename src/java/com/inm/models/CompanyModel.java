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
public class CompanyModel {
   private int companyid;
     private String lookupmasterByIndustrylookupmasterid;
     private String lookupmasterByAffiliatelookupmasterid;
     private String lookupmasterBySegmentlookupmasterid;
     private String clientMaster;
     private String companyAddress;
     private String groupname;
     private int noofsubsidiaries;
    private String companydirector;
     private String directorposition;
     
    public CompanyModel() {
    }

    public CompanyModel(int companyid, String lookupmasterByIndustrylookupmasterid, String lookupmasterByAffiliatelookupmasterid, String lookupmasterBySegmentlookupmasterid, String clientMaster, String companyAddress, String groupname, int noofsubsidiaries, String companydirector, String directorposition) {
        this.companyid = companyid;
        this.lookupmasterByIndustrylookupmasterid = lookupmasterByIndustrylookupmasterid;
        this.lookupmasterByAffiliatelookupmasterid = lookupmasterByAffiliatelookupmasterid;
        this.lookupmasterBySegmentlookupmasterid = lookupmasterBySegmentlookupmasterid;
        this.clientMaster = clientMaster;
        this.companyAddress = companyAddress;
        this.groupname = groupname;
        this.noofsubsidiaries = noofsubsidiaries;
        this.companydirector = companydirector;
        this.directorposition = directorposition;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getLookupmasterByIndustrylookupmasterid() {
        return lookupmasterByIndustrylookupmasterid;
    }

    public void setLookupmasterByIndustrylookupmasterid(String lookupmasterByIndustrylookupmasterid) {
        this.lookupmasterByIndustrylookupmasterid = lookupmasterByIndustrylookupmasterid;
    }

    public String getLookupmasterByAffiliatelookupmasterid() {
        return lookupmasterByAffiliatelookupmasterid;
    }

    public void setLookupmasterByAffiliatelookupmasterid(String lookupmasterByAffiliatelookupmasterid) {
        this.lookupmasterByAffiliatelookupmasterid = lookupmasterByAffiliatelookupmasterid;
    }

    public String getLookupmasterBySegmentlookupmasterid() {
        return lookupmasterBySegmentlookupmasterid;
    }

    public void setLookupmasterBySegmentlookupmasterid(String lookupmasterBySegmentlookupmasterid) {
        this.lookupmasterBySegmentlookupmasterid = lookupmasterBySegmentlookupmasterid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getNoofsubsidiaries() {
        return noofsubsidiaries;
    }

    public void setNoofsubsidiaries(int noofsubsidiaries) {
        this.noofsubsidiaries = noofsubsidiaries;
    }

    public String getCompanydirector() {
        return companydirector;
    }

    public void setCompanydirector(String companydirector) {
        this.companydirector = companydirector;
    }

    public String getDirectorposition() {
        return directorposition;
    }

    public void setDirectorposition(String directorposition) {
        this.directorposition = directorposition;
    }

     
}
