package com.inm.ap.mode.hibernate;
// Generated Jan 31, 2018 3:59:00 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * TblUsercurrentloggedin generated by hbm2java
 */
public class TblUsercurrentloggedin  implements java.io.Serializable {


     private int loggedinid;
     private String txtUsername;
     private String txtEmployeeid;
     private String txtUsertype;
     private Date dtLastlogintime;

    public TblUsercurrentloggedin() {
    }

	
    public TblUsercurrentloggedin(int loggedinid) {
        this.loggedinid = loggedinid;
    }
    public TblUsercurrentloggedin(int loggedinid, String txtUsername, String txtEmployeeid, String txtUsertype, Date dtLastlogintime) {
       this.loggedinid = loggedinid;
       this.txtUsername = txtUsername;
       this.txtEmployeeid = txtEmployeeid;
       this.txtUsertype = txtUsertype;
       this.dtLastlogintime = dtLastlogintime;
    }
   
    public int getLoggedinid() {
        return this.loggedinid;
    }
    
    public void setLoggedinid(int loggedinid) {
        this.loggedinid = loggedinid;
    }
    public String getTxtUsername() {
        return this.txtUsername;
    }
    
    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }
    public String getTxtEmployeeid() {
        return this.txtEmployeeid;
    }
    
    public void setTxtEmployeeid(String txtEmployeeid) {
        this.txtEmployeeid = txtEmployeeid;
    }
    public String getTxtUsertype() {
        return this.txtUsertype;
    }
    
    public void setTxtUsertype(String txtUsertype) {
        this.txtUsertype = txtUsertype;
    }
    public Date getDtLastlogintime() {
        return this.dtLastlogintime;
    }
    
    public void setDtLastlogintime(Date dtLastlogintime) {
        this.dtLastlogintime = dtLastlogintime;
    }




}


