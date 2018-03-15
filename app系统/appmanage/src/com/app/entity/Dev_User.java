package com.app.entity;

import java.io.Serializable;
import java.util.Date;

public class Dev_User implements Serializable{
    private Integer id;

    private String devcode;

    private String devname;

    private String devpassword;

    private String devemail;

    private String devinfo;

    private Integer createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

	//
	private String valuename;

	public Dev_User(Integer id, String devcode, String devname,
			String devpassword, String devemail, String devinfo,
			Integer createdby, Date creationdate, Integer modifyby,
			Date modifydate, String valuename) {
		super();
		this.id = id;
		this.devcode = devcode;
		this.devname = devname;
		this.devpassword = devpassword;
		this.devemail = devemail;
		this.devinfo = devinfo;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
		this.valuename = valuename;
	}

	public Dev_User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevcode() {
		return devcode;
	}

	public void setDevcode(String devcode) {
		this.devcode = devcode;
	}

	public String getDevname() {
		return devname;
	}

	public void setDevname(String devname) {
		this.devname = devname;
	}

	public String getDevpassword() {
		return devpassword;
	}

	public void setDevpassword(String devpassword) {
		this.devpassword = devpassword;
	}

	public String getDevemail() {
		return devemail;
	}

	public void setDevemail(String devemail) {
		this.devemail = devemail;
	}

	public String getDevinfo() {
		return devinfo;
	}

	public void setDevinfo(String devinfo) {
		this.devinfo = devinfo;
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

	public String getValuename() {
		return valuename;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}
	
}