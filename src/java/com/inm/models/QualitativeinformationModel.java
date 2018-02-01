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
public class QualitativeinformationModel {
  private int qinfoid;
     private String clientMaster;
     private String clientstrategy;
     private String clientwalletalloctnlogic;
     private String opportunities;
     private String specificchallenges;
     private String relationshipquality;

    public QualitativeinformationModel() {
    }

    public QualitativeinformationModel(int qinfoid, String clientMaster, String clientstrategy, String clientwalletalloctnlogic, String opportunities, String specificchallenges, String relationshipquality) {
        this.qinfoid = qinfoid;
        this.clientMaster = clientMaster;
        this.clientstrategy = clientstrategy;
        this.clientwalletalloctnlogic = clientwalletalloctnlogic;
        this.opportunities = opportunities;
        this.specificchallenges = specificchallenges;
        this.relationshipquality = relationshipquality;
    }

    public int getQinfoid() {
        return qinfoid;
    }

    public void setQinfoid(int qinfoid) {
        this.qinfoid = qinfoid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getClientstrategy() {
        return clientstrategy;
    }

    public void setClientstrategy(String clientstrategy) {
        this.clientstrategy = clientstrategy;
    }

    public String getClientwalletalloctnlogic() {
        return clientwalletalloctnlogic;
    }

    public void setClientwalletalloctnlogic(String clientwalletalloctnlogic) {
        this.clientwalletalloctnlogic = clientwalletalloctnlogic;
    }

    public String getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(String opportunities) {
        this.opportunities = opportunities;
    }

    public String getSpecificchallenges() {
        return specificchallenges;
    }

    public void setSpecificchallenges(String specificchallenges) {
        this.specificchallenges = specificchallenges;
    }

    public String getRelationshipquality() {
        return relationshipquality;
    }

    public void setRelationshipquality(String relationshipquality) {
        this.relationshipquality = relationshipquality;
    }
     
}
