package com.example.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.CarRecord;
import com.example.dao.LogMapper;
import com.example.dao.PaymentMapper;
import com.example.service.PaymentService;
/**
 * 
  * <p>Title : PaymentServiceImpl</p>
  * <p>Description : 缴费信息实现类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月26日 下午8:03:01
  * @version : 12.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentMapper PaymentMapper;
	
	/**
	 * 查询车辆出入信息
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CarRecord queryRecord(String name) {
		// TODO Auto-generated method stub
		CarRecord queryRecord = PaymentMapper.queryRecord(name);
		//System.out.println(queryRecord.toString());
		return queryRecord;
	}
	/**
	 * 更新离开时间
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updateRecord(Date outDate, Integer id) {
		// TODO Auto-generated method stub
		Integer insertRecord = PaymentMapper.updateRecord(outDate, id);
		return insertRecord;
	}
	/**
	 * 通过车牌查找车id
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer queryCarId(String carnum) {
		// TODO Auto-generated method stub
		Integer queryCarId = PaymentMapper.queryCarId(carnum);
		System.out.println("queryCarId= "+queryCarId);
		return queryCarId;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer deleteRecord(Integer id) {
		// TODO Auto-generated method stub
		Integer deleteRecord = PaymentMapper.deleteRecord(id);
		return deleteRecord;
	}
	@Override
	public Integer addMechineLog(Integer mid, String carnum, Integer money) {
		// TODO Auto-generated method stub
		Integer id = null;
		Integer addMechineLog = PaymentMapper.addMechineLog(id, mid, carnum, money);
		System.out.println("addMechineLog= "+addMechineLog);
		return addMechineLog;
	}
	

}
