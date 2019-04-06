package com.example.dto;

import java.util.Date;

import com.example.bean.CarService;
/**
 * 
  * <p>Title : CarServiceDto</p>
  * <p>Description : 车辆月缴产品DTO</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月25日 上午9:34:24
  * @version : 12.0.0
 */
public class CarServiceDto extends CarService {
	
	public CarServiceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarServiceDto(Integer carServiceId, Integer carServiceCarnumId, Integer carServicePmpId,
			Integer carServiceState, String carServiceMemo, Date carServiceCreateTime, Date carServiceUpdateTime) {
		super(carServiceId, carServiceCarnumId, carServicePmpId, carServiceState, carServiceMemo, carServiceCreateTime,
				carServiceUpdateTime);
		// TODO Auto-generated constructor stub
	}
	private String carNum;
	private String monthProduct;
	private String monthProductMonth;
	private String monthProductMoney;
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getMonthProduct() {
		return monthProduct;
	}
	public void setMonthProduct(String monthProduct) {
		this.monthProduct = monthProduct;
	}
	public String getMonthProductMonth() {
		return monthProductMonth;
	}
	public void setMonthProductMonth(String monthProductMonth) {
		this.monthProductMonth = monthProductMonth;
	}
	public String getMonthProductMoney() {
		return monthProductMoney;
	}
	public void setMonthProductMoney(String monthProductMoney) {
		this.monthProductMoney = monthProductMoney;
	}
	@Override
	public String toString() {
		return "CarServiceDto [carNum=" + carNum + ", monthProduct=" + monthProduct + ", monthProductMonth="
				+ monthProductMonth + ", monthProductMoney=" + monthProductMoney + "]";
	}
	
}
