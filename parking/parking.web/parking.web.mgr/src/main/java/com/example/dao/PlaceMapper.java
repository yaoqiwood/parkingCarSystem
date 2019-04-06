package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.PlaceDto;

public interface PlaceMapper {
	
	/**
	 * 分页查询车位信息
	 * @param searchPlace
	 * @param searchFloor
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<PlaceDto> listPlaceByPage(@Param("searchFloor") String searchFloor, @Param("name")String name,@Param("start")Integer start,@Param("end")Integer end);

	/**
	 * 车位总数
	 * @param searchPlace
	 * @param searchFloor
	 * @param name
	 * @return
	 */
     Integer countPlace(@Param("searchFloor") String searchFloor, @Param("name")String name);

     /**
      * 删除
      * @param placeId
      * @return
      */
     Integer delPlace(@Param("placeId")String placeId);
     
     /**
      * 修改
      * @param dplace
      * @param dfloor
      * @param placePsId
      * @return
      */
     Integer updatePlace( @Param("dplace")String dplace,@Param("dfloor")String dfloor,
    		 @Param("placePsId")String placePsId);

     
     /**
      * 添加
      * @param addname
      * @param placepsId
      * @return
      */
     Integer addPlace(@Param("addname")String addname,@Param("addnum")String addnum,@Param("addfloor")String addfloor);
}
