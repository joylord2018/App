package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Version implements Serializable{
    private Integer id;
    
    private Integer appid;
    @NotEmpty(message="版本号不能为空")
    private String versionno;
    @NotEmpty(message="版本简介不能为空")
    private String versioninfo;

    private Integer publishstatus;

    private String downloadlink;
    @NotNull(message="版本大小不能为空")
    private Double versionsize;

    private Integer createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

    private String apklocpath;

    private String apkfilename;
    private String sname;
    private String iname;

	public Version() {
		super();
	}

	public Version(Integer id, Integer appid, String versionno,
			String versioninfo, Integer publishstatus, String downloadlink,
			Double versionsize, Integer createdby, Date creationdate,
			Integer modifyby, Date modifydate, String apklocpath,
			String apkfilename, String sname, String iname) {
		super();
		this.id = id;
		this.appid = appid;
		this.versionno = versionno;
		this.versioninfo = versioninfo;
		this.publishstatus = publishstatus;
		this.downloadlink = downloadlink;
		this.versionsize = versionsize;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
		this.apklocpath = apklocpath;
		this.apkfilename = apkfilename;
		this.sname = sname;
		this.iname = iname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getVersionno() {
		return versionno;
	}

	public void setVersionno(String versionno) {
		this.versionno = versionno;
	}

	public String getVersioninfo() {
		return versioninfo;
	}

	public void setVersioninfo(String versioninfo) {
		this.versioninfo = versioninfo;
	}

	public Integer getPublishstatus() {
		return publishstatus;
	}

	public void setPublishstatus(Integer publishstatus) {
		this.publishstatus = publishstatus;
	}

	public String getDownloadlink() {
		return downloadlink;
	}

	public void setDownloadlink(String downloadlink) {
		this.downloadlink = downloadlink;
	}

	public Double getVersionsize() {
		return versionsize;
	}

	public void setVersionsize(Double versionsize) {
		this.versionsize = versionsize;
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

	public String getApklocpath() {
		return apklocpath;
	}

	public void setApklocpath(String apklocpath) {
		this.apklocpath = apklocpath;
	}

	public String getApkfilename() {
		return apkfilename;
	}

	public void setApkfilename(String apkfilename) {
		this.apkfilename = apkfilename;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	
}