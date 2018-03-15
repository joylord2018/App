package com.app.entity;

import java.io.Serializable;
import java.util.Date;

public class Backend_User implements Serializable
{
    private Integer id;//”√ªßid

    private String usercode;

    private String username;

    private Long usertype;

    private Long createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

    private String userpassword;
    //
    private String valuename;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUsertype() {
		return usertype;
	}

	public void setUsertype(Long usertype) {
		this.usertype = usertype;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
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

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getValuename() {
		return valuename;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}

	public Backend_User(Integer id, String usercode, String username,
			Long usertype, Long createdby, Date creationdate, Integer modifyby,
			Date modifydate, String userpassword, String valuename) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.usertype = usertype;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
		this.userpassword = userpassword;
		this.valuename = valuename;
	}

	public Backend_User() {
		super();
	}
	
}