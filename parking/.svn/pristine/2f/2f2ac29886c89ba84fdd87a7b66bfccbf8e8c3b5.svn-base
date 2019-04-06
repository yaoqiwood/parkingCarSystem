package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.PlaceMapper;
import com.example.dto.PlaceDto;
import com.example.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceMapper mapper;

	/**
	 * 刷新车位表格
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<PlaceDto> listPlaceByPage(String searchPlace, String searchFloor, String name, Integer start,
			Integer end) {
		// TODO Auto-generated method stub
		List<PlaceDto> listPlaceByPage = mapper.listPlaceByPage(searchPlace, searchFloor, "%"+name.trim()+"%", start, end);
		return listPlaceByPage;
	}

	/**
	 * 车位总数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countPlace(String searchPlace, String searchFloor, String name) {
		// TODO Auto-generated method stub
		Integer countPlace = mapper.countPlace(searchPlace, searchFloor, "%"+name.trim()+"%");
		return countPlace;
	}

	/**
	 * 删除
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer delPlace(String placeId) {
		// TODO Auto-generated method stub
		Integer delPlace = mapper.delPlace(placeId);
		return delPlace;
	}

	/**
	 * 修改
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updatePlace(String dplace, String dfloor, String placePsId) {
		// TODO Auto-generated method stub
		Integer updatePlace = mapper.updatePlace(dplace, dfloor, placePsId);
		return updatePlace;
	}

	/**
	 * 添加
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer addPlace(String addname, String addplace, String addfloor) {
		// TODO Auto-generated method stub
		Integer placepsId = mapper.getPlacepsId(addplace, addfloor);
		Integer addPlace2 = mapper.addPlace(addname, placepsId);
		return addPlace2;
	}
	
	

}
