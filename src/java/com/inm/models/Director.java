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
public class Director {
     private int directorId;
     private int companyId;
     private String directorName;
     private String directorPosition;

    public Director() {
    }

    public Director(int directorId, int companyId, String directorName, String directorPosition) {
        this.directorId = directorId;
        this.companyId = companyId;
        this.directorName = directorName;
        this.directorPosition = directorPosition;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorPosition() {
        return directorPosition;
    }

    public void setDirectorPosition(String directorPosition) {
        this.directorPosition = directorPosition;
    }

    
}
