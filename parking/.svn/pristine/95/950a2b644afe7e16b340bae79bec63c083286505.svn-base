package com.example.dao;

import org.apache.ibatis.annotations.Param;

import com.example.bean.Carnum;
import com.example.bean.Place;

public interface PlaceMapper {
	
	Place searchCar(@Param("name") String name);

	Integer updateCar(@Param("id") Integer id);
	
	Carnum carnumInfoById(@Param("id") Integer id);
	
	Integer isWhiteList(@Param("carnum") String carnum);
}
