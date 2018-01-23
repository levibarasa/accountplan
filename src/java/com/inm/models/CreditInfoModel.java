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
public class CreditInfoModel {
   String CreditID;
String ClientID;
String RM_Code;
String ApprovedLines;
String OutstandingAmount;
String RiskRating;
String RatingAgency;

    public CreditInfoModel() {
    }

    public CreditInfoModel(String CreditID, String ClientID, String RM_Code, String ApprovedLines, String OutstandingAmount, String RiskRating, String RatingAgency) {
        this.CreditID = CreditID;
        this.ClientID = ClientID;
        this.RM_Code = RM_Code;
        this.ApprovedLines = ApprovedLines;
        this.OutstandingAmount = OutstandingAmount;
        this.RiskRating = RiskRating;
        this.RatingAgency = RatingAgency;
    }

    public String getCreditID() {
        return CreditID;
    }

    public void setCreditID(String CreditID) {
        this.CreditID = CreditID;
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

    public String getApprovedLines() {
        return ApprovedLines;
    }

    public void setApprovedLines(String ApprovedLines) {
        this.ApprovedLines = ApprovedLines;
    }

    public String getOutstandingAmount() {
        return OutstandingAmount;
    }

    public void setOutstandingAmount(String OutstandingAmount) {
        this.OutstandingAmount = OutstandingAmount;
    }

    public String getRiskRating() {
        return RiskRating;
    }

    public void setRiskRating(String RiskRating) {
        this.RiskRating = RiskRating;
    }

    public String getRatingAgency() {
        return RatingAgency;
    }

    public void setRatingAgency(String RatingAgency) {
        this.RatingAgency = RatingAgency;
    }

}
