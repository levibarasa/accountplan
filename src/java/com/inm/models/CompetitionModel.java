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
public class CompetitionModel {
         private int competitionid;
     private String clientMaster;
     private String bank;
     private String estimatedwalletshare;
     private String strengths;
     private String weaknesses;

    public CompetitionModel() {
    }

    public CompetitionModel(int competitionid, String clientMaster, String bank, String estimatedwalletshare, String strengths, String weaknesses) {
        this.competitionid = competitionid;
        this.clientMaster = clientMaster;
        this.bank = bank;
        this.estimatedwalletshare = estimatedwalletshare;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    public int getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(int competitionid) {
        this.competitionid = competitionid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getEstimatedwalletshare() {
        return estimatedwalletshare;
    }

    public void setEstimatedwalletshare(String estimatedwalletshare) {
        this.estimatedwalletshare = estimatedwalletshare;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }
     
}
