package com.example.dto;

import java.util.Date;

import com.example.bean.CarRecord;

public class CarRecordDto extends CarRecord{
	
	private String carNum;
	
	public CarRecordDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarRecordDto(Integer carRecordId, Integer carRecordPCId, Date carRecordComeTime, Date carRecordOutTime,
			Integer carRecordState, String carRecordMemo, Date carRecordCreateTime, Date carRecordUpdateTime) {
		super(carRecordId, carRecordPCId, carRecordComeTime, carRecordOutTime, carRecordState, carRecordMemo,
				carRecordCreateTime, carRecordUpdateTime);
		// TODO Auto-generated constructor stub
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	@Override
	public String toString() {
		return "CarRecordDto [carNum=" + carNum + "]";
	}
	
}
