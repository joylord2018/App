package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class Info implements Serializable{
	
    private Integer id;
    @NotEmpty(message="软件名不能为空")
    private String softwarename;
    @NotEmpty(message="apk不能为空")
    private String apkname;
    @NotEmpty(message="支持rom不能为空")
    private String supportrom;
    @NotEmpty(message="语言不能为空")
    private String interfacelanguage;
    private Double softwaresize;
    
    private Date updatedate;
    
    private Integer devid;

    private String appinfo;
    private Integer status;
    
    private Date onsaledate;

    private Date offsaledate;
    @Min(value=1,message="请选择平台")
    private Integer flatformid;
    @Min(value=1,message="请选择分类")
    private Integer categorylevel3;
    private Integer downloads;

    private Integer createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;
    @Min(value=1,message="请选择分类")
    private Integer categorylevel1;
    @Min(value=1,message="请选择分类")
    private Integer categorylevel2;
    
    private String logopicpath;

    private String logolocpath;

    private Integer versionid;
    //
    private String t1;
    private String t2;
    private String t3;
    private String fname;
    private String sname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSoftwarename() {
		return softwarename;
	}
	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}
	public String getApkname() {
		return apkname;
	}
	public void setApkname(String apkname) {
		this.apkname = apkname;
	}
	public String getSupportrom() {
		return supportrom;
	}
	public void setSupportrom(String supportrom) {
		this.supportrom = supportrom;
	}
	public String getInterfacelanguage() {
		return interfacelanguage;
	}
	public void setInterfacelanguage(String interfacelanguage) {
		this.interfacelanguage = interfacelanguage;
	}
	public Double getSoftwaresize() {
		return softwaresize;
	}
	public void setSoftwaresize(Double softwaresize) {
		this.softwaresize = softwaresize;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public Integer getDevid() {
		return devid;
	}
	public void setDevid(Integer devid) {
		this.devid = devid;
	}
	public String getAppinfo() {
		return appinfo;
	}
	public void setAppinfo(String appinfo) {
		this.appinfo = appinfo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOnsaledate() {
		return onsaledate;
	}
	public void setOnsaledate(Date onsaledate) {
		this.onsaledate = onsaledate;
	}
	public Date getOffsaledate() {
		return offsaledate;
	}
	public void setOffsaledate(Date offsaledate) {
		this.offsaledate = offsaledate;
	}
	public Integer getFlatformid() {
		return flatformid;
	}
	public void setFlatformid(Integer flatformid) {
		this.flatformid = flatformid;
	}
	public Integer getCategorylevel3() {
		return categorylevel3;
	}
	public void setCategorylevel3(Integer categorylevel3) {
		this.categorylevel3 = categorylevel3;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
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
	public Integer getCategorylevel1() {
		return categorylevel1;
	}
	public void setCategorylevel1(Integer categorylevel1) {
		this.categorylevel1 = categorylevel1;
	}
	public Integer getCategorylevel2() {
		return categorylevel2;
	}
	public void setCategorylevel2(Integer categorylevel2) {
		this.categorylevel2 = categorylevel2;
	}
	public String getLogopicpath() {
		return logopicpath;
	}
	public void setLogopicpath(String logopicpath) {
		this.logopicpath = logopicpath;
	}
	public String getLogolocpath() {
		return logolocpath;
	}
	public void setLogolocpath(String logolocpath) {
		this.logolocpath = logolocpath;
	}
	public Integer getVersionid() {
		return versionid;
	}
	public void setVersionid(Integer versionid) {
		this.versionid = versionid;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getT3() {
		return t3;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Info(Integer id, String softwarename, String apkname,
			String supportrom, String interfacelanguage, Double softwaresize,
			Date updatedate, Integer devid, String appinfo, Integer status,
			Date onsaledate, Date offsaledate, Integer flatformid,
			Integer categorylevel3, Integer downloads, Integer createdby,
			Date creationdate, Integer modifyby, Date modifydate,
			Integer categorylevel1, Integer categorylevel2, String logopicpath,
			String logolocpath, Integer versionid, String t1, String t2,
			String t3, String fname, String sname) {
		super();
		this.id = id;
		this.softwarename = softwarename;
		this.apkname = apkname;
		this.supportrom = supportrom;
		this.interfacelanguage = interfacelanguage;
		this.softwaresize = softwaresize;
		this.updatedate = updatedate;
		this.devid = devid;
		this.appinfo = appinfo;
		this.status = status;
		this.onsaledate = onsaledate;
		this.offsaledate = offsaledate;
		this.flatformid = flatformid;
		this.categorylevel3 = categorylevel3;
		this.downloads = downloads;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
		this.categorylevel1 = categorylevel1;
		this.categorylevel2 = categorylevel2;
		this.logopicpath = logopicpath;
		this.logolocpath = logolocpath;
		this.versionid = versionid;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.fname = fname;
		this.sname = sname;
	}
	public Info() {
		super();
	}
    
}