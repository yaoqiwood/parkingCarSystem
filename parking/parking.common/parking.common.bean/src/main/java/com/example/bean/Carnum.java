package com.example.bean;

import java.util.Date;

public class Carnum {

	private Integer carnumId;
	private Integer carRoleId;
	private String carNumber;
	private String photoUrl;
	private Integer carnumState;
	private String carnumMemo;
	private Date carnumCreateTime;
	private Date carnumUpdateTime;

	public Carnum() {
		super();
	}

	public Carnum(Integer carnumId, Integer carRoleId, String carNumber, String photoUrl, Integer carnumState,
			String carnumMemo, Date carnumCreateTime, Date carnumUpdateTime) {
		super();
		this.carnumId = carnumId;
		this.carRoleId = carRoleId;
		this.carNumber = carNumber;
		this.photoUrl = photoUrl;
		this.carnumState = carnumState;
		this.carnumMemo = carnumMemo;
		this.carnumCreateTime = carnumCreateTime;
		this.carnumUpdateTime = carnumUpdateTime;
	}
	
	

	public Integer getCarnumId() {
		return carnumId;
	}

	public void setCarnumId(Integer carnumId) {
		this.carnumId = carnumId;
	}

	public Integer getCarRoleId() {
		return carRoleId;
	}

	public void setCarRoleId(Integer carRoleId) {
		this.carRoleId = carRoleId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getCarnumState() {
		return carnumState;
	}

	public void setCarnumState(Integer carnumState) {
		this.carnumState = carnumState;
	}

	public String getCarnumMemo() {
		return carnumMemo;
	}

	public void setCarnumMemo(String carnumMemo) {
		this.carnumMemo = carnumMemo;
	}

	public Date getCarnumCreateTime() {
		return carnumCreateTime;
	}

	public void setCarnumCreateTime(Date carnumCreateTime) {
		this.carnumCreateTime = carnumCreateTime;
	}

	public Date getCarnumUpdateTime() {
		return carnumUpdateTime;
	}

	public void setCarnumUpdateTime(Date carnumUpdateTime) {
		this.carnumUpdateTime = carnumUpdateTime;
	}

	@Override
	public String toString() {
		return "Carnum [carnumId=" + carnumId + ", carRoleId=" + carRoleId + ", carNumber=" + carNumber + ", photoUrl="
				+ photoUrl + ", carnumState=" + carnumState + ", carnumMemo=" + carnumMemo + ", carnumCreateTime="
				+ carnumCreateTime + ", carnumUpdateTime=" + carnumUpdateTime + "]";
	}

}
