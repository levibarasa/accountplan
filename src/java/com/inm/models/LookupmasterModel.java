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
public class LookupmasterModel {
    private int lookupmasterid;
     private String code;
     private String value;

    public LookupmasterModel() {
    }

    public LookupmasterModel(int lookupmasterid, String code, String value) {
        this.lookupmasterid = lookupmasterid;
        this.code = code;
        this.value = value;
    }

    public int getLookupmasterid() {
        return lookupmasterid;
    }

    public void setLookupmasterid(int lookupmasterid) {
        this.lookupmasterid = lookupmasterid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
     
}
