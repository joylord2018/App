package com.app.entity;

import java.io.Serializable;
import java.util.Date;

public class Promotion implements Serializable{
    private Integer id;

    private Integer appid;

    private String adpicpath;

    private Integer adpv;

    private Integer carouselposition;

    private Date starttime;

    private Date endtime;

    private Integer createdby;

    private Date creationdate;

    private Integer modifyby;

    private Date modifydate;

	public Promotion(Integer id, Integer appid, String adpicpath, Integer adpv,
			Integer carouselposition, Date starttime, Date endtime,
			Integer createdby, Date creationdate, Integer modifyby,
			Date modifydate) {
		super();
		this.id = id;
		this.appid = appid;
		this.adpicpath = adpicpath;
		this.adpv = adpv;
		this.carouselposition = carouselposition;
		this.starttime = starttime;
		this.endtime = endtime;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	public Promotion() {
		super();
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

	public String getAdpicpath() {
		return adpicpath;
	}

	public void setAdpicpath(String adpicpath) {
		this.adpicpath = adpicpath;
	}

	public Integer getAdpv() {
		return adpv;
	}

	public void setAdpv(Integer adpv) {
		this.adpv = adpv;
	}

	public Integer getCarouselposition() {
		return carouselposition;
	}

	public void setCarouselposition(Integer carouselposition) {
		this.carouselposition = carouselposition;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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

}