package com.example.bean;

import java.util.Date;

public class CarRecord {
	private Integer carRecordId;
	private Integer carRecordPCId;
	private Date carRecordComeTime;
	private Date carRecordOutTime; 
	private Integer carRecordState;
	private String carRecordMemo;
	private Date carRecordCreateTime;
	private Date carRecordUpdateTime;
	public CarRecord(Integer carRecordId, Integer carRecordPCId, Date carRecordComeTime, Date carRecordOutTime,
			Integer carRecordState, String carRecordMemo, Date carRecordCreateTime, Date carRecordUpdateTime) {
		super();
		this.carRecordId = carRecordId;
		this.carRecordPCId = carRecordPCId;
		this.carRecordComeTime = carRecordComeTime;
		this.carRecordOutTime = carRecordOutTime;
		this.carRecordState = carRecordState;
		this.carRecordMemo = carRecordMemo;
		this.carRecordCreateTime = carRecordCreateTime;
		this.carRecordUpdateTime = carRecordUpdateTime;
	}
	public CarRecord() {
		super();
	}
	@Override
	public String toString() {
		return "CarRecord [carRecordId=" + carRecordId + ", carRecordPCId=" + carRecordPCId + ", carRecordComeTime="
				+ carRecordComeTime + ", carRecordOutTime=" + carRecordOutTime + ", carRecordState=" + carRecordState
				+ ", carRecordMemo=" + carRecordMemo + ", carRecordCreateTime=" + carRecordCreateTime
				+ ", carRecordUpdateTime=" + carRecordUpdateTime + "]";
	}
	public Integer getCarRecordId() {
		return carRecordId;
	}
	public void setCarRecordId(Integer carRecordId) {
		this.carRecordId = carRecordId;
	}
	public Integer getCarRecordPCId() {
		return carRecordPCId;
	}
	public void setCarRecordPCId(Integer carRecordPCId) {
		this.carRecordPCId = carRecordPCId;
	}
	public Date getCarRecordComeTime() {
		return carRecordComeTime;
	}
	public void setCarRecordComeTime(Date carRecordComeTime) {
		this.carRecordComeTime = carRecordComeTime;
	}
	public Date getCarRecordOutTime() {
		return carRecordOutTime;
	}
	public void setCarRecordOutTime(Date carRecordOutTime) {
		this.carRecordOutTime = carRecordOutTime;
	}
	public Integer getCarRecordState() {
		return carRecordState;
	}
	public void setCarRecordState(Integer carRecordState) {
		this.carRecordState = carRecordState;
	}
	public String getCarRecordMemo() {
		return carRecordMemo;
	}
	public void setCarRecordMemo(String carRecordMemo) {
		this.carRecordMemo = carRecordMemo;
	}
	public Date getCarRecordCreateTime() {
		return carRecordCreateTime;
	}
	public void setCarRecordCreateTime(Date carRecordCreateTime) {
		this.carRecordCreateTime = carRecordCreateTime;
	}
	public Date getCarRecordUpdateTime() {
		return carRecordUpdateTime;
	}
	public void setCarRecordUpdateTime(Date carRecordUpdateTime) {
		this.carRecordUpdateTime = carRecordUpdateTime;
	}
	
	
}
