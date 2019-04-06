package com.example.dto;

import com.example.bean.Place;

public class PlaceDto extends Place{
	
	private String subareaName;
	private String subareaFloor;
	public PlaceDto() {
		super();
	}
	public PlaceDto(String subareaName, String subareaFloor) {
		super();
		this.subareaName = subareaName;
		this.subareaFloor = subareaFloor;
	}
	public String getSubareaName() {
		return subareaName;
	}
	public void setSubareaName(String subareaName) {
		this.subareaName = subareaName;
	}
	public String getSubareaFloor() {
		return subareaFloor;
	}
	public void setSubareaFloor(String subareaFloor) {
		this.subareaFloor = subareaFloor;
	}
	@Override
	public String toString() {
		return super.toString()+ "PlaceDto [subareaName=" + subareaName + ", subareaFloor=" + subareaFloor + "]";
	}
	
	

}
