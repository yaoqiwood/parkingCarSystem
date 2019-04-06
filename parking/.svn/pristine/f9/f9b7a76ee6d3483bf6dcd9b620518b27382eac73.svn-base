/**
 * 
 */
package com.example.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.AdminAmountLog;
import com.example.bean.CarService;
import com.example.dao.AmountLogMapper;
import com.example.dao.CarServiceMapper;
import com.example.dto.CarServiceDto;
import com.example.service.CarServiceService;

/**
 * <p>Title:CarServiceServiceImpl</p>
 * <p>Description:</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月25日 上午6:19:05
 * @version:12.0.0
 */
@Service
public class CarServiceServiceImpl implements CarServiceService{
	@Autowired
	private CarServiceMapper carServiceMapper;
	
	@Autowired
	private AmountLogMapper amountLogMapper;

	/* (non-Javadoc)
	 * @see com.example.service.CarServiceService#addCarService(com.example.bean.CarService)
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Integer addCarService(CarService carService,AdminAmountLog adminAmountLog) {
		// TODO Auto-generated method stub
		Integer addCarflag = carServiceMapper.addCarService(carService);
		Integer addAmountflag = amountLogMapper.addAmountLog(adminAmountLog);
		if(addCarflag>0&&addAmountflag>0) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.example.service.CarServiceService#carServicePage(java.lang.String, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public ArrayList<CarServiceDto> carServicePage(String carNum, RowBounds rb) {
		// TODO Auto-generated method stub
		ArrayList<CarServiceDto> serList = carServiceMapper.carServicePage(carNum, rb);
		return serList;
	}

	/* (non-Javadoc)
	 * @see com.example.service.CarServiceService#count(java.lang.String)
	 */
	@Override
	public Integer count(String carNum) {
		// TODO Auto-generated method stub
		Integer flag = carServiceMapper.count(carNum);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.CarServiceService#modCarService(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer refundCarService(String serId, String state,AdminAmountLog adminAmountLog) {
		// TODO Auto-generated method stub
		Integer flag = carServiceMapper.modCarService(serId, state);
		Integer addAmountflag = amountLogMapper.addAmountLog(adminAmountLog);
		if(flag>0&&addAmountflag>0) {
			return 1;
		}else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see com.example.service.CarServiceService#modCarService(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer modCarService(String serId, String state) {
		// TODO Auto-generated method stub
		Integer flag = carServiceMapper.modCarService(serId, state);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.CarServiceService#selectCount(java.lang.Integer)
	 */
	@Override
	public Integer selectCount(Integer carId) {
		// TODO Auto-generated method stub
		Integer flag = carServiceMapper.selectCount(carId);
		return flag;
	}


}
