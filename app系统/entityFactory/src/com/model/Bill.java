package com.model;

import java.util.Date;

public class Bill {
    private Integer id;

    private String billcode;

    private String productname;

    private String prodcutdesc;

    private String productunit;

    private Double productcount;

    private Double totleprice;

    private Integer ispayment;

    private Integer providerid;

    private Integer createby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode == null ? null : billcode.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProdcutdesc() {
        return prodcutdesc;
    }

    public void setProdcutdesc(String prodcutdesc) {
        this.prodcutdesc = prodcutdesc == null ? null : prodcutdesc.trim();
    }

    public String getProductunit() {
        return productunit;
    }

    public void setProductunit(String productunit) {
        this.productunit = productunit == null ? null : productunit.trim();
    }

    public Double getProductcount() {
        return productcount;
    }

    public void setProductcount(Double productcount) {
        this.productcount = productcount;
    }

    public Double getTotleprice() {
        return totleprice;
    }

    public void setTotleprice(Double totleprice) {
        this.totleprice = totleprice;
    }

    public Integer getIspayment() {
        return ispayment;
    }

    public void setIspayment(Integer ispayment) {
        this.ispayment = ispayment;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getModifyby() {
        return modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}