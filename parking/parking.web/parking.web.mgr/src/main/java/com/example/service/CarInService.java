package com.example.service;

import java.util.List;

import com.example.bean.Carnum;
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
     Integer addCarnum(String name);
     
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
      Integer updatePlaceState(String carNum);

     /**
      * 检查车辆是否注册
      * @param carNum 车牌号
      * @return 车辆对象
      */
     Carnum checkCarnum(String carNum);
     
     /**
      * 修改车辆用户状态
      * @param carNum 车牌号
      * @return 0 1
      */
     Integer modCarRole(String carNum,String state);
}
