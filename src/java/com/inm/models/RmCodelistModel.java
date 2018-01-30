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
public class RmCodelistModel {
    private String rmCode;
     private String designation;
     private String branch;
     private String branchcode;
     private String region;
     private String category;
     private String rmName;

    public RmCodelistModel() {
    }

    public RmCodelistModel(String rmCode, String designation, String branch, String branchcode, String region, String category, String rmName) {
        this.rmCode = rmCode;
        this.designation = designation;
        this.branch = branch;
        this.branchcode = branchcode;
        this.region = region;
        this.category = category;
        this.rmName = rmName;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }
     
}
