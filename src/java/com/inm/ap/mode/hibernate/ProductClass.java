package com.inm.ap.mode.hibernate;
// Generated Feb 19, 2018 4:06:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * ProductClass generated by hbm2java
 */
public class ProductClass  implements java.io.Serializable {


     private int productClassId;
     private String product;
     private String productClass;

    public ProductClass() {
    }

	
    public ProductClass(int productClassId) {
        this.productClassId = productClassId;
    }
    public ProductClass(int productClassId, String product, String productClass) {
       this.productClassId = productClassId;
       this.product = product;
       this.productClass = productClass;
    }
   
    public int getProductClassId() {
        return this.productClassId;
    }
    
    public void setProductClassId(int productClassId) {
        this.productClassId = productClassId;
    }
    public String getProduct() {
        return this.product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }
    public String getProductClass() {
        return this.productClass;
    }
    
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }




}


