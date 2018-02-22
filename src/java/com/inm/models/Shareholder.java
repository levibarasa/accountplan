/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.models;

import java.math.BigDecimal;

/**
 *
 * @author Levi
 */
public class Shareholder {
     private int sharedolderId;
     private int companyId;
     private String shareholderName;
     private BigDecimal shareholderPercent;

    public Shareholder() {
    }

    public Shareholder(int sharedolderId, int companyId, String shareholderName, BigDecimal shareholderPercent) {
        this.sharedolderId = sharedolderId;
        this.companyId = companyId;
        this.shareholderName = shareholderName;
        this.shareholderPercent = shareholderPercent;
    }

    public int getSharedolderId() {
        return sharedolderId;
    }

    public void setSharedolderId(int sharedolderId) {
        this.sharedolderId = sharedolderId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public BigDecimal getShareholderPercent() {
        return shareholderPercent;
    }

    public void setShareholderPercent(BigDecimal shareholderPercent) {
        this.shareholderPercent = shareholderPercent;
    }

    
}
