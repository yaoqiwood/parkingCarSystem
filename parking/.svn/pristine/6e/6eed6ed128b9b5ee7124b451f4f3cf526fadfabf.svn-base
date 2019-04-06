package com.example.service;

import java.util.List;


import com.example.dto.CarnumDto;

public interface CarnumService {
	
	/**
	 * 分页查询车辆信息
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<CarnumDto> listCarnumByPage(String name ,Integer start,Integer end);

	/**
	 * 车辆总数
	 * @param name
	 * @return
	 */
     Integer countCarnum(String name);
     
     /**
      * 插入流水
      * @param carNum
      * @param money
      * @return
      */
     Integer addAmountLog(String carNum,String money);
     
     /**
      * 插入出入场记录表
      * @param carNumId
      * @param startTime
      * @return
      */
     Integer addcarRecord(String carNumId,String startTime);
     
     /**
      * 修改状态
      * @param number
      * @return
      */
     Integer updateCarState(String number);

}
