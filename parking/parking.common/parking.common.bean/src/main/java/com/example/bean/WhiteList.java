package com.example.bean;

import java.util.Date;

public class WhiteList {
	
	private Integer whiteListId;
	private String whiteListCarNum;
	private Integer whiteListState;
	private String whiteListMemo;
	private Date whiteListCreateTime;
	private Date whiteListUpdateTime;
	public WhiteList() {
		super();
	}
	public WhiteList(Integer whiteListId, String whiteListCarNum, Integer whiteListState, String whiteListMemo,
			Date whiteListCreateTime, Date whiteListUpdateTime) {
		super();
		this.whiteListId = whiteListId;
		this.whiteListCarNum = whiteListCarNum;
		this.whiteListState = whiteListState;
		this.whiteListMemo = whiteListMemo;
		this.whiteListCreateTime = whiteListCreateTime;
		this.whiteListUpdateTime = whiteListUpdateTime;
	}
	public Integer getWhiteListId() {
		return whiteListId;
	}
	public void setWhiteListId(Integer whiteListId) {
		this.whiteListId = whiteListId;
	}
	public String getWhiteListCarNum() {
		return whiteListCarNum;
	}
	public void setWhiteListCarNum(String whiteListCarNum) {
		this.whiteListCarNum = whiteListCarNum;
	}
	public Integer getWhiteListState() {
		return whiteListState;
	}
	public void setWhiteListState(Integer whiteListState) {
		this.whiteListState = whiteListState;
	}
	public String getWhiteListMemo() {
		return whiteListMemo;
	}
	public void setWhiteListMemo(String whiteListMemo) {
		this.whiteListMemo = whiteListMemo;
	}
	public Date getWhiteListCreateTime() {
		return whiteListCreateTime;
	}
	public void setWhiteListCreateTime(Date whiteListCreateTime) {
		this.whiteListCreateTime = whiteListCreateTime;
	}
	public Date getWhiteListUpdateTime() {
		return whiteListUpdateTime;
	}
	public void setWhiteListUpdateTime(Date whiteListUpdateTime) {
		this.whiteListUpdateTime = whiteListUpdateTime;
	}
	@Override
	public String toString() {
		return "WhiteList [whiteListId=" + whiteListId + ", whiteListCarNum=" + whiteListCarNum + ", whiteListState="
				+ whiteListState + ", whiteListMemo=" + whiteListMemo + ", whiteListCreateTime=" + whiteListCreateTime
				+ ", whiteListUpdateTime=" + whiteListUpdateTime + "]";
	}
	
	
	
	
	

}
