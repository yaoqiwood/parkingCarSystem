package com.example.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.CarnumDto;

public interface CarnumMapper {
	
	/**
	 * 分页查询车辆信息
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<CarnumDto> listCarnumByPage(@Param("name")String name ,@Param("start")Integer start,@Param("end")Integer end);

	/**
	 * 车辆总数
	 * @param name
	 * @return
	 */
     Integer countCarnum(@Param("name")String name);
     
     /**
      * 插入流水
      * @param carNum
      * @param money
      * @return
      */
     Integer addAmountLog(@Param("carNum")String carNum,@Param("money")String money);
     
     /**
      * 插入出入场记录表
      * @param carNumId
      * @param startTime
      * @return
      */
     Integer addcarRecord(@Param("carNumId")String carNumId,@Param("startTime") String startTime);
    
     /**
      * 修改状态
      * @param number
      * @return
      */
     Integer updateCarState(@Param("number")String number);
}
