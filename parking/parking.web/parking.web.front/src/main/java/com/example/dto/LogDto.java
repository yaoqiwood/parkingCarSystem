package com.example.dto;

import com.example.bean.Log;

public class LogDto extends Log{
	private String adminId;
	private String adminName;
	public LogDto() {
		super();
	}
	public LogDto(String adminId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "LogDto [adminId=" + adminId + ", adminName=" + adminName + "]";
	}
	
}
