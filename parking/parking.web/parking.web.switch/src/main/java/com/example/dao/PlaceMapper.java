package com.example.dao;

import org.apache.ibatis.annotations.Param;

import com.example.bean.Place;

public interface PlaceMapper {
	
	Integer placeCount();

	Integer placeHasCount();
	
	Place placeInfo(@Param("carnum") String carnum);
}
