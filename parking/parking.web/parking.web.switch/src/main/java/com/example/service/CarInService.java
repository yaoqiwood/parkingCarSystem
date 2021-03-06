package com.example.service;

import java.util.List;

import com.example.bean.Carnum;
import com.example.bean.Place;
import com.example.bean.WhiteList;
import com.example.dto.CarnumDto;

public interface CarInService {
	
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
      * 添加/车辆信息
      * @param name
      * @return
      */
     Integer addCarnum(Carnum carnum);
     
     /**
      * 查询车位
      * @param ppId
      * @return
      */
      String carNum(Integer ppId);
      
      /**
       * 修改车位状态
       * @param carNum
       * @return
       */
      Integer updatePlaceState(String carNum ,String number);

     /**
      * 检查车辆是否注册
      * @param carNum 车牌号
      * @return 车辆对象
      */
     Carnum checkCarnum(String carNum);
     
     /**
      * 添加行车记录
      * @param carNumId
      * @param startTime
      * @return
      */
     Integer addcarRecord(String carNumId, String startTime);
     
     WhiteList whiteListInfo(String carnum);
     
     Place placeInfo(String carnum);
}
