package com.example.bean;

import java.util.Date;

public class AmountLog {
	
	private Integer amountLogId;
	private Integer adminRoleId;
	private String amountLogCarnum;
	private Integer amountLogMoney;
	private String amountLogDesc;
	private Integer amountLogState;
	private String amountLogMemo;
	private Date amountLogDescCreateTime;
	public AmountLog() {
		super();
	}
	public AmountLog(Integer amountLogId, Integer adminRoleId, String amountLogCarnum, Integer amountLogMoney,
			String amountLogDesc, Integer amountLogState, String amountLogMemo, Date amountLogDescCreateTime) {
		super();
		this.amountLogId = amountLogId;
		this.adminRoleId = adminRoleId;
		this.amountLogCarnum = amountLogCarnum;
		this.amountLogMoney = amountLogMoney;
		this.amountLogDesc = amountLogDesc;
		this.amountLogState = amountLogState;
		this.amountLogMemo = amountLogMemo;
		this.amountLogDescCreateTime = amountLogDescCreateTime;
	}
	public Integer getAmountLogId() {
		return amountLogId;
	}
	public void setAmountLogId(Integer amountLogId) {
		this.amountLogId = amountLogId;
	}
	public Integer getAdminRoleId() {
		return adminRoleId;
	}
	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
	public String getAmountLogCarnum() {
		return amountLogCarnum;
	}
	public void setAmountLogCarnum(String amountLogCarnum) {
		this.amountLogCarnum = amountLogCarnum;
	}
	public Integer getAmountLogMoney() {
		return amountLogMoney;
	}
	public void setAmountLogMoney(Integer amountLogMoney) {
		this.amountLogMoney = amountLogMoney;
	}
	public String getAmountLogDesc() {
		return amountLogDesc;
	}
	public void setAmountLogDesc(String amountLogDesc) {
		this.amountLogDesc = amountLogDesc;
	}
	public Integer getAmountLogState() {
		return amountLogState;
	}
	public void setAmountLogState(Integer amountLogState) {
		this.amountLogState = amountLogState;
	}
	public String getAmountLogMemo() {
		return amountLogMemo;
	}
	public void setAmountLogMemo(String amountLogMemo) {
		this.amountLogMemo = amountLogMemo;
	}
	public Date getAmountLogDescCreateTime() {
		return amountLogDescCreateTime;
	}
	public void setAmountLogDescCreateTime(Date amountLogDescCreateTime) {
		this.amountLogDescCreateTime = amountLogDescCreateTime;
	}
	@Override
	public String toString() {
		return "AmountLog [amountLogId=" + amountLogId + ", adminRoleId=" + adminRoleId + ", amountLogCarnum="
				+ amountLogCarnum + ", amountLogMoney=" + amountLogMoney + ", amountLogDesc=" + amountLogDesc
				+ ", amountLogState=" + amountLogState + ", amountLogMemo=" + amountLogMemo
				+ ", amountLogDescCreateTime=" + amountLogDescCreateTime + "]";
	}
	
}
