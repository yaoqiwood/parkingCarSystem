package com.example.dto;

import com.example.bean.Admin;

public class AdminDto extends Admin {
	
	private String adminRoleName;

	public AdminDto(String adminRoleName) {
		super();
		this.adminRoleName = adminRoleName;
	}

	public AdminDto() {
		super();
	}

	public String getAdminRoleName() {
		return adminRoleName;
	}

	public void setAdminRoleName(String adminRoleName) {
		this.adminRoleName = adminRoleName;
	}

	@Override
	public String toString() {
		return super.toString() + "AdminDto [adminRoleName=" + adminRoleName + "]";
	}
	
	

}
