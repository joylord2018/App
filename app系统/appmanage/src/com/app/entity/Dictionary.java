package com.app.entity;

import java.io.Serializable;
import java.util.Date;

public class Dictionary implements Serializable{
    private Integer id;

    private String typecode;

    private String typename;

    private Integer valueid;

    private String valuename;

    private Integer createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getValueid() {
		return valueid;
	}

	public void setValueid(Integer valueid) {
		this.valueid = valueid;
	}

	public String getValuename() {
		return valuename;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
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

	public Dictionary(Integer id, String typecode, String typename,
			Integer valueid, String valuename, Integer createdby,
			Date creationdate, Integer modifyby, Date modifydate) {
		super();
		this.id = id;
		this.typecode = typecode;
		this.typename = typename;
		this.valueid = valueid;
		this.valuename = valuename;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	public Dictionary() {
		super();
	}

}