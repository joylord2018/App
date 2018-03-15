package com.app.entity;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
    private Integer id;

    private String categorycode;

    private String categoryname;

    private Integer parentid;

    private Integer createdby;

    private Date creationtime;

    private Integer modifyby;

    private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
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

	public Category(Integer id, String categorycode, String categoryname,
			Integer parentid, Integer createdby, Date creationtime,
			Integer modifyby, Date modifydate) {
		super();
		this.id = id;
		this.categorycode = categorycode;
		this.categoryname = categoryname;
		this.parentid = parentid;
		this.createdby = createdby;
		this.creationtime = creationtime;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	public Category() {
		super();
	}

}