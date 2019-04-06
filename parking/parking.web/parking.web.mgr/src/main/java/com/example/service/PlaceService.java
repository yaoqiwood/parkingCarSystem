package com.example.service;

import java.util.List;


import com.example.dto.PlaceDto;

public interface PlaceService {
	
	/**
	 * 分页查询车位信息
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @param start
	 * @param end
	 * @return
	 */
	List<PlaceDto> listPlaceByPage(String searchFloor,String name,Integer start,
			Integer end);

	/**
	 * 车位总数
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @return
	 */
     Integer countPlace(String searchFloor,String name);

     /**
      * 删除用户
      * @param adminId
      * @return
      */
     Integer delPlace(String placeId);
     
     /**
      * 修改
      * @param dplace
      * @param dfloor
      * @param placePsId
      * @return
      */
     Integer updatePlace(String dplace,String dfloor,String placePsId);
     
     /**
      * 添加
      * @param addname
      * @param placepsId
      * @return
      */
     Integer addPlace(String addname,String addnum,String addfloor);
}
