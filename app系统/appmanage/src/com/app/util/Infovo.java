package com.app.util;

import java.io.Serializable;

/**
 * 复合查询vo
 * @author nibin
 *
 */
public class Infovo implements Serializable{
private String infoname;//软件名
private Integer flatformId;//所属平台
private Integer categoryLevel1;
private Integer categoryLevel2;
private Integer categoryLevel3;
private Integer devid;
private Integer status;
public Infovo(String infoname, Integer flatformId, Integer categoryLevel1,
		Integer categoryLevel2, Integer categoryLevel3, Integer devid,
		Integer status) {
	super();
	this.infoname = infoname;
	this.flatformId = flatformId;
	this.categoryLevel1 = categoryLevel1;
	this.categoryLevel2 = categoryLevel2;
	this.categoryLevel3 = categoryLevel3;
	this.devid = devid;
	this.status = status;
}
public Infovo() {
	super();
}
public String getInfoname() {
	return infoname;
}
public void setInfoname(String infoname) {
	this.infoname = infoname;
}
public Integer getFlatformId() {
	return flatformId;
}
public void setFlatformId(Integer flatformId) {
	this.flatformId = flatformId;
}
public Integer getCategoryLevel1() {
	return categoryLevel1;
}
public void setCategoryLevel1(Integer categoryLevel1) {
	this.categoryLevel1 = categoryLevel1;
}
public Integer getCategoryLevel2() {
	return categoryLevel2;
}
public void setCategoryLevel2(Integer categoryLevel2) {
	this.categoryLevel2 = categoryLevel2;
}
public Integer getCategoryLevel3() {
	return categoryLevel3;
}
public void setCategoryLevel3(Integer categoryLevel3) {
	this.categoryLevel3 = categoryLevel3;
}
public Integer getDevid() {
	return devid;
}
public void setDevid(Integer devid) {
	this.devid = devid;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}

}
