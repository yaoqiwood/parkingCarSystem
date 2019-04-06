package com.example.bean;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
	
	private Integer adminId;
	private Integer adminRoleId;
	private String adminName;
	private String adminPassword;
	private Integer adminState;
	private String adminMemo;
	private Date adminCreateTime;
	private Date adminUpdateTime;
	public Admin() {
		super();
	}
	public Admin(Integer adminId, Integer adminRoleId, String adminName, String adminPassword, Integer adminState,
			String adminMemo, Date adminCreateTime, Date adminUpdateTime) {
		super();
		this.adminId = adminId;
		this.adminRoleId = adminRoleId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminState = adminState;
		this.adminMemo = adminMemo;
		this.adminCreateTime = adminCreateTime;
		this.adminUpdateTime = adminUpdateTime;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getAdminRoleId() {
		return adminRoleId;
	}
	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Integer getAdminState() {
		return adminState;
	}
	public void setAdminState(Integer adminState) {
		this.adminState = adminState;
	}
	public String getAdminMemo() {
		return adminMemo;
	}
	public void setAdminMemo(String adminMemo) {
		this.adminMemo = adminMemo;
	}
	public Date getAdminCreateTime() {
		return adminCreateTime;
	}
	public void setAdminCreateTime(Date adminCreateTime) {
		this.adminCreateTime = adminCreateTime;
	}
	public Date getAdminUpdateTime() {
		return adminUpdateTime;
	}
	public void setAdminUpdateTime(Date adminUpdateTime) {
		this.adminUpdateTime = adminUpdateTime;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminRoleId=" + adminRoleId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + ", adminState=" + adminState + ", adminMemo=" + adminMemo
				+ ", adminCreateTime=" + adminCreateTime + ", adminUpdateTime=" + adminUpdateTime + "]";
	}
	
	
}
