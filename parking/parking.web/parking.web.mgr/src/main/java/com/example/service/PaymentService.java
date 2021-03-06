package com.example.service;
/**
 * 
  * <p>Title : PaymentService</p>
  * <p>Description : 缴费信息接口</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月26日 下午7:54:56
  * @version : 12.0.0
 */

import java.util.Date;

import com.example.bean.CarRecord;

public interface PaymentService {
	/**
	 * 通过车牌查找车id
	 * @param carnum
	 * @return
	 */
	public Integer queryCarId(String carnum);
	/**
	 * 查询车辆出入记录
	 * @param name
	 * @return
	 */
	public CarRecord queryRecord(String name);
	/**
	 * 更新离开时间
	 * @param outDate
	 * @param id
	 * @return
	 */
	public Integer updateRecord(Date outDate, Integer id);
	
	/**
	 * 删除车辆记录
	 * @param id
	 * @return
	 */
	public Integer deleteRecord(Integer id);
	/**
	 * 插入车辆记录
	 * @param mid
	 * @param carnum
	 * @param total_amount_int
	 * @return
	 */
	public Integer addMechineLog(Integer mid, String carnum, Integer total_amount_int);
}
