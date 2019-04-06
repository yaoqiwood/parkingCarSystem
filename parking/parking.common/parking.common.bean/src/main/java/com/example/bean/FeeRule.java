package com.example.bean;

import java.util.Date;

public class FeeRule {
	private Integer feeRuleId;
	private String feeRuleTime;
	private Integer feeRuleMoney;
	private Integer feeRuleState;
	private String feeRuleMemo;
	private Date feeRuleCreateTime;
	private Date feeRuleUpdateTime;
	public FeeRule(Integer feeRuleId, String feeRuleTime, Integer feeRuleMoney, Integer feeRuleState,
			String feeRuleMemo, Date feeRuleCreateTime, Date feeRuleUpdateTime) {
		super();
		this.feeRuleId = feeRuleId;
		this.feeRuleTime = feeRuleTime;
		this.feeRuleMoney = feeRuleMoney;
		this.feeRuleState = feeRuleState;
		this.feeRuleMemo = feeRuleMemo;
		this.feeRuleCreateTime = feeRuleCreateTime;
		this.feeRuleUpdateTime = feeRuleUpdateTime;
	}
	public FeeRule() {
		super();
	}
	@Override
	public String toString() {
		return "FeeRule [feeRuleId=" + feeRuleId + ", feeRuleTime=" + feeRuleTime + ", feeRuleMoney=" + feeRuleMoney
				+ ", feeRuleState=" + feeRuleState + ", feeRuleMemo=" + feeRuleMemo + ", feeRuleCreateTime="
				+ feeRuleCreateTime + ", feeRuleUpdateTime=" + feeRuleUpdateTime + "]";
	}
	public Integer getFeeRuleId() {
		return feeRuleId;
	}
	public void setFeeRuleId(Integer feeRuleId) {
		this.feeRuleId = feeRuleId;
	}
	public String getFeeRuleTime() {
		return feeRuleTime;
	}
	public void setFeeRuleTime(String feeRuleTime) {
		this.feeRuleTime = feeRuleTime;
	}
	public Integer getFeeRuleMoney() {
		return feeRuleMoney;
	}
	public void setFeeRuleMoney(Integer feeRuleMoney) {
		this.feeRuleMoney = feeRuleMoney;
	}
	public Integer getFeeRuleState() {
		return feeRuleState;
	}
	public void setFeeRuleState(Integer feeRuleState) {
		this.feeRuleState = feeRuleState;
	}
	public String getFeeRuleMemo() {
		return feeRuleMemo;
	}
	public void setFeeRuleMemo(String feeRuleMemo) {
		this.feeRuleMemo = feeRuleMemo;
	}
	public Date getFeeRuleCreateTime() {
		return feeRuleCreateTime;
	}
	public void setFeeRuleCreateTime(Date feeRuleCreateTime) {
		this.feeRuleCreateTime = feeRuleCreateTime;
	}
	public Date getFeeRuleUpdateTime() {
		return feeRuleUpdateTime;
	}
	public void setFeeRuleUpdateTime(Date feeRuleUpdateTime) {
		this.feeRuleUpdateTime = feeRuleUpdateTime;
	}
	
	
}
