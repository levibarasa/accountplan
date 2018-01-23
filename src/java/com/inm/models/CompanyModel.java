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
   String CompanyID;
String ClientID;
String RM_Code;
String Company_Address;
String GroupName;
String HQ_Affiliate;
String Industry;
String Segment;
String NumberOfSubsidiaries;

    public CompanyModel() {
    }

    public CompanyModel(String CompanyID, String ClientID, String RM_Code, String Company_Address, String GroupName, String HQ_Affiliate, String Industry, String Segment, String NumberOfSubsidiaries) {
        this.CompanyID = CompanyID;
        this.ClientID = ClientID;
        this.RM_Code = RM_Code;
        this.Company_Address = Company_Address;
        this.GroupName = GroupName;
        this.HQ_Affiliate = HQ_Affiliate;
        this.Industry = Industry;
        this.Segment = Segment;
        this.NumberOfSubsidiaries = NumberOfSubsidiaries;
    }

    public String getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(String CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    public String getRM_Code() {
        return RM_Code;
    }

    public void setRM_Code(String RM_Code) {
        this.RM_Code = RM_Code;
    }

    public String getCompany_Address() {
        return Company_Address;
    }

    public void setCompany_Address(String Company_Address) {
        this.Company_Address = Company_Address;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public String getHQ_Affiliate() {
        return HQ_Affiliate;
    }

    public void setHQ_Affiliate(String HQ_Affiliate) {
        this.HQ_Affiliate = HQ_Affiliate;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String Industry) {
        this.Industry = Industry;
    }

    public String getSegment() {
        return Segment;
    }

    public void setSegment(String Segment) {
        this.Segment = Segment;
    }

    public String getNumberOfSubsidiaries() {
        return NumberOfSubsidiaries;
    }

    public void setNumberOfSubsidiaries(String NumberOfSubsidiaries) {
        this.NumberOfSubsidiaries = NumberOfSubsidiaries;
    }



}
