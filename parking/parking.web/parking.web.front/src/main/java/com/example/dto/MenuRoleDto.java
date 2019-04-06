package com.example.dto;

import com.example.bean.MenuInf;

public class MenuRoleDto extends MenuInf{
	
	private Integer adminRoleId;
	private Integer adminRoleState;
	
	public MenuRoleDto( Integer adminRoleId, Integer adminRoleState) {
		super();
		this.adminRoleId = adminRoleId;
		this.adminRoleState = adminRoleState;
	}
	public MenuRoleDto() {
		super();
	}
	public Integer getAdminRoleId() {
		return adminRoleId;
	}
	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
	public Integer getAdminRoleState() {
		return adminRoleState;
	}
	public void setAdminRoleState(Integer adminRoleState) {
		this.adminRoleState = adminRoleState;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "MenuRoleDto [adminRoleMenuId="+ ", adminRoleId=" + adminRoleId + ", adminRoleState="
				+ adminRoleState + "]";
	}
	
	
	
	

}
