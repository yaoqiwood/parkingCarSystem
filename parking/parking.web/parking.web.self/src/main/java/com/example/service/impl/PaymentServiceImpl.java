package com.example.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.CarRecord;
import com.example.bean.Carnum;
import com.example.bean.Place;
import com.example.dao.PaymentMapper;
import com.example.dao.PlaceMapper;
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
	private PaymentMapper paymentMapper;
	@Autowired
	private PlaceMapper placeMapper;
	
	/**
	 * 查询车辆出入信息
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public CarRecord queryRecord(String name) {
		// TODO Auto-generated method stub
		CarRecord queryRecord = paymentMapper.queryRecord(name);
		return queryRecord;
	}
	/**
	 * 更新离开时间
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updateRecord(Date outDate, Integer id) {
		// TODO Auto-generated method stub
		Integer insertRecord = paymentMapper.updateRecord(outDate, id);
		return insertRecord;
	}
	/**
	 * 通过车牌查找车id
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer queryCarId(String carnum) {
		// TODO Auto-generated method stub
		Integer queryCarId = paymentMapper.queryCarId(carnum);
		return queryCarId;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer deleteRecord(Integer id) {
		// TODO Auto-generated method stub
		Integer deleteRecord = paymentMapper.deleteRecord(id);
		return deleteRecord;
	}
	@Override
	public Integer addMechineLog(Integer mid, String carnum, Integer money) {
		// TODO Auto-generated method stub
		Integer id = null;
		Integer addMechineLog = paymentMapper.addMechineLog(id, mid, carnum, money);
		return addMechineLog;
	}
	@Override
	public Place searchCar(String name) {
		// TODO Auto-generated method stub
		Place searchCar = placeMapper.searchCar(name);
		return searchCar;
	}

	@Override
	public Integer updateCar(Integer id) {
		// TODO Auto-generated method stub
		Integer updateCar = placeMapper.updateCar(id);
		return updateCar;
	}

	@Override
	public CarRecord queryRecordById(Integer id) {
		// TODO Auto-generated method stub
		CarRecord queryRecordById = paymentMapper.queryRecordById(id);
		//System.out.println(queryRecordById.toString());
		return queryRecordById;
	}
	
	@Override
	public Carnum carnumInfoById(Integer id) {
		// TODO Auto-generated method stub
		Carnum carnumInfoById = placeMapper.carnumInfoById(id);
		return carnumInfoById;
	}
	@Override
	public Integer isWhiteList(String carnum) {
		// TODO Auto-generated method stub
		Integer whiteList = placeMapper.isWhiteList(carnum);
		return whiteList;
	}
}
