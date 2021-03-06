package com.inm.ap.mode.hibernate;
// Generated Feb 19, 2018 4:06:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * EmployeeDetails generated by hbm2java
 */
public class EmployeeDetails  implements java.io.Serializable {


     private int employeeid;
     private String employeename;
     private String mobilenumber;
     private String emailid;
     private String dateofbirth;
     private String designation;
     private BigDecimal accesslevelid;
     private String password;
     private BigDecimal areaid;
     private String windowsusername;

    public EmployeeDetails() {
    }

	
    public EmployeeDetails(int employeeid) {
        this.employeeid = employeeid;
    }
    public EmployeeDetails(int employeeid, String employeename, String mobilenumber, String emailid, String dateofbirth, String designation, BigDecimal accesslevelid, String password, BigDecimal areaid, String windowsusername) {
       this.employeeid = employeeid;
       this.employeename = employeename;
       this.mobilenumber = mobilenumber;
       this.emailid = emailid;
       this.dateofbirth = dateofbirth;
       this.designation = designation;
       this.accesslevelid = accesslevelid;
       this.password = password;
       this.areaid = areaid;
       this.windowsusername = windowsusername;
    }
   
    public int getEmployeeid() {
        return this.employeeid;
    }
    
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }
    public String getEmployeename() {
        return this.employeename;
    }
    
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }
    public String getMobilenumber() {
        return this.mobilenumber;
    }
    
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
    public String getEmailid() {
        return this.emailid;
    }
    
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getDateofbirth() {
        return this.dateofbirth;
    }
    
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public BigDecimal getAccesslevelid() {
        return this.accesslevelid;
    }
    
    public void setAccesslevelid(BigDecimal accesslevelid) {
        this.accesslevelid = accesslevelid;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public BigDecimal getAreaid() {
        return this.areaid;
    }
    
    public void setAreaid(BigDecimal areaid) {
        this.areaid = areaid;
    }
    public String getWindowsusername() {
        return this.windowsusername;
    }
    
    public void setWindowsusername(String windowsusername) {
        this.windowsusername = windowsusername;
    }




}


