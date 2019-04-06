package com.example.bean;

import java.util.Date;

public class Place {
	private Integer placeId;
	private Integer placePsId;
	private String placeNumber;
	private String placeUrl;
	private Integer placeState;
	private String placeMemo;
	private Date placeCreateTime;
	private Date placeUpdateTime;
	public Place() {
		// TODO Auto-generated constructor stub
	}
	public Place(Integer placeId, Integer placePsId, String placeNumber, String placeUrl, Integer placeState,
			String placeMemo, Date placeCreateTime, Date placeUpdateTime) {
		super();
		this.placeId = placeId;
		this.placePsId = placePsId;
		this.placeNumber = placeNumber;
		this.placeUrl = placeUrl;
		this.placeState = placeState;
		this.placeMemo = placeMemo;
		this.placeCreateTime = placeCreateTime;
		this.placeUpdateTime = placeUpdateTime;
	}
	public Integer getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}
	public Integer getPlacePsId() {
		return placePsId;
	}
	public void setPlacePsId(Integer placePsId) {
		this.placePsId = placePsId;
	}
	public String getPlaceNumber() {
		return placeNumber;
	}
	public void setPlaceNumber(String placeNumber) {
		this.placeNumber = placeNumber;
	}
	public String getPlaceUrl() {
		return placeUrl;
	}
	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}
	public Integer getPlaceState() {
		return placeState;
	}
	public void setPlaceState(Integer placeState) {
		this.placeState = placeState;
	}
	public String getPlaceMemo() {
		return placeMemo;
	}
	public void setPlaceMemo(String placeMemo) {
		this.placeMemo = placeMemo;
	}
	public Date getPlaceCreateTime() {
		return placeCreateTime;
	}
	public void setPlaceCreateTime(Date placeCreateTime) {
		this.placeCreateTime = placeCreateTime;
	}
	public Date getPlaceUpdateTime() {
		return placeUpdateTime;
	}
	public void setPlaceUpdateTime(Date placeUpdateTime) {
		this.placeUpdateTime = placeUpdateTime;
	}
	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", placePsId=" + placePsId + ", placeNumber=" + placeNumber + ", placeUrl="
				+ placeUrl + ", placeState=" + placeState + ", placeMemo=" + placeMemo + ", placeCreateTime="
				+ placeCreateTime + ", placeUpdateTime=" + placeUpdateTime + "]";
	}
	
}
