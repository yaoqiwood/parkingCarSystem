package com.example.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuInf {
	private Integer menuId;
	private Integer menuParent;
	private String menuName;
	private String menuUrl;
	private Integer menuState;
	private String menuMemo;
	private Date menuCreateTime;
	private Date menuUpdateTime;
	private List<MenuInf> menuInfs = new ArrayList<MenuInf>();
	public MenuInf() {
		super();
	}
	public MenuInf(Integer menuId, Integer menuParent, String menuName, String menuUrl, Integer menuState,
			String menuMemo, Date menuCreateTime, Date menuUpdateTime, List<MenuInf> menuInfs) {
		super();
		this.menuId = menuId;
		this.menuParent = menuParent;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuState = menuState;
		this.menuMemo = menuMemo;
		this.menuCreateTime = menuCreateTime;
		this.menuUpdateTime = menuUpdateTime;
		this.menuInfs = menuInfs;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getMenuState() {
		return menuState;
	}
	public void setMenuState(Integer menuState) {
		this.menuState = menuState;
	}
	public String getMenuMemo() {
		return menuMemo;
	}
	public void setMenuMemo(String menuMemo) {
		this.menuMemo = menuMemo;
	}
	public Date getMenuCreateTime() {
		return menuCreateTime;
	}
	public void setMenuCreateTime(Date menuCreateTime) {
		this.menuCreateTime = menuCreateTime;
	}
	public Date getMenuUpdateTime() {
		return menuUpdateTime;
	}
	public void setMenuUpdateTime(Date menuUpdateTime) {
		this.menuUpdateTime = menuUpdateTime;
	}
	public List<MenuInf> getMenuInfs() {
		return menuInfs;
	}
	public void setMenuInfs(List<MenuInf> menuInfs) {
		this.menuInfs = menuInfs;
	}
	@Override
	public String toString() {
		return "MenuInf [menuId=" + menuId + ", menuParent=" + menuParent + ", menuName=" + menuName + ", menuUrl="
				+ menuUrl + ", menuState=" + menuState + ", menuMemo=" + menuMemo + ", menuCreateTime=" + menuCreateTime
				+ ", menuUpdateTime=" + menuUpdateTime + ", menuInfs=" + menuInfs + "]";
	}
	
	

}
