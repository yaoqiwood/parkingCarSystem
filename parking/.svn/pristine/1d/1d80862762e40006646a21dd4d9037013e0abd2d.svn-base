package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Carnum;
import com.example.dao.CarInMapper;
import com.example.dto.CarnumDto;
import com.example.service.CarInService;

@Service
public class CarInServiceImpl implements CarInService{

	@Autowired
	private CarInMapper mapper;

	/**
	 * 刷新车辆出入场表格
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<CarnumDto> listCarnumByPage(String name, Integer start, Integer end) {
		// TODO Auto-generated method stub
		List<CarnumDto> listCarnumByPage = mapper.listCarnumByPage("%"+name.trim()+"%", start, end);
		return listCarnumByPage;
	}

	/**
	 * 查询车辆个数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countCarnum(String name) {
		// TODO Auto-generated method stub
		Integer countCarnum = mapper.countCarnum("%"+name.trim()+"%");
		return countCarnum;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer addCarnum(String name) {
		// TODO Auto-generated method stub
		Integer addCarnum = mapper.addCarnum(name);
		return addCarnum;
	}

	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String carNum(Integer ppId) {
		// TODO Auto-generated method stub
		String carNum = mapper.carNum(ppId);
		return carNum;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Carnum checkCarnum(String carNum) {
		// TODO Auto-generated method stub
		Carnum carnum = mapper.checkCarnum(carNum);
		return carnum;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updatePlaceState(String carNum) {
		// TODO Auto-generated method stub
		Integer updatePlaceState = mapper.updatePlaceState(carNum);
		return updatePlaceState;
	}
	
	/* (non-Javadoc)
	 * @see com.example.service.CarnumService#modCarRole(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer modCarRole(String carNum, String state) {
		// TODO Auto-generated method stub
		Integer flag = mapper.modCarRole(carNum, state);
		return flag;
	}
}
