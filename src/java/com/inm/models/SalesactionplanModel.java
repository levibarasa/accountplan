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
public class SalesactionplanModel {
    private int salesactionplanid;
     private String clientMaster;
     private String specification;
     private String clocontactpersion;
     private String clopersonresponsibleforaction;
     private String clodatelinedate;

    public SalesactionplanModel() {
    }

    public SalesactionplanModel(int salesactionplanid, String clientMaster, String specification, String clocontactpersion, String clopersonresponsibleforaction, String clodatelinedate) {
        this.salesactionplanid = salesactionplanid;
        this.clientMaster = clientMaster;
        this.specification = specification;
        this.clocontactpersion = clocontactpersion;
        this.clopersonresponsibleforaction = clopersonresponsibleforaction;
        this.clodatelinedate = clodatelinedate;
    }

    public int getSalesactionplanid() {
        return salesactionplanid;
    }

    public void setSalesactionplanid(int salesactionplanid) {
        this.salesactionplanid = salesactionplanid;
    }

    public String getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(String clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getClocontactpersion() {
        return clocontactpersion;
    }

    public void setClocontactpersion(String clocontactpersion) {
        this.clocontactpersion = clocontactpersion;
    }

    public String getClopersonresponsibleforaction() {
        return clopersonresponsibleforaction;
    }

    public void setClopersonresponsibleforaction(String clopersonresponsibleforaction) {
        this.clopersonresponsibleforaction = clopersonresponsibleforaction;
    }

    public String getClodatelinedate() {
        return clodatelinedate;
    }

    public void setClodatelinedate(String clodatelinedate) {
        this.clodatelinedate = clodatelinedate;
    }
     
     
}
