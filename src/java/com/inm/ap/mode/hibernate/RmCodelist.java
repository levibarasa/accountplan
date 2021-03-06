package com.inm.ap.mode.hibernate;
// Generated Feb 19, 2018 4:06:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * RmCodelist generated by hbm2java
 */
public class RmCodelist  implements java.io.Serializable {


     private String rmCode;
     private String designation;
     private String branch;
     private String branchcode;
     private String region;
     private String category;
     private String rmName;
     private Set clientMastersForRmCode = new HashSet(0);
     private Set clientMastersForAlternativeRmCode = new HashSet(0);
     private Set employeeLeaves = new HashSet(0);

    public RmCodelist() {
    }

	
    public RmCodelist(String rmCode) {
        this.rmCode = rmCode;
    }
    public RmCodelist(String rmCode, String designation, String branch, String branchcode, String region, String category, String rmName, Set clientMastersForRmCode, Set clientMastersForAlternativeRmCode, Set employeeLeaves) {
       this.rmCode = rmCode;
       this.designation = designation;
       this.branch = branch;
       this.branchcode = branchcode;
       this.region = region;
       this.category = category;
       this.rmName = rmName;
       this.clientMastersForRmCode = clientMastersForRmCode;
       this.clientMastersForAlternativeRmCode = clientMastersForAlternativeRmCode;
       this.employeeLeaves = employeeLeaves;
    }
   
    public String getRmCode() {
        return this.rmCode;
    }
    
    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getBranch() {
        return this.branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getBranchcode() {
        return this.branchcode;
    }
    
    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getRmName() {
        return this.rmName;
    }
    
    public void setRmName(String rmName) {
        this.rmName = rmName;
    }
    public Set getClientMastersForRmCode() {
        return this.clientMastersForRmCode;
    }
    
    public void setClientMastersForRmCode(Set clientMastersForRmCode) {
        this.clientMastersForRmCode = clientMastersForRmCode;
    }
    public Set getClientMastersForAlternativeRmCode() {
        return this.clientMastersForAlternativeRmCode;
    }
    
    public void setClientMastersForAlternativeRmCode(Set clientMastersForAlternativeRmCode) {
        this.clientMastersForAlternativeRmCode = clientMastersForAlternativeRmCode;
    }
    public Set getEmployeeLeaves() {
        return this.employeeLeaves;
    }
    
    public void setEmployeeLeaves(Set employeeLeaves) {
        this.employeeLeaves = employeeLeaves;
    }




}


