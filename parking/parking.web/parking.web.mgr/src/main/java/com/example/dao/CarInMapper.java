package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.Carnum;
import com.example.dto.CarnumDto;

public interface CarInMapper {
	
	/**
	 * 分页查询车辆信息
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<CarnumDto> listCarnumByPage(@Param("name")String name ,@Param("start")Integer start,
			@Param("end")Integer end);

	/**
	 * 车辆总数
	 * @param name
	 * @return
	 */
     Integer countCarnum(@Param("name")String name);
     
     /**
      * 添加/车辆信息
      * @param name
      * @return
      */
     Integer addCarnum(@Param("name")String name);
     
    /**
     * 查询车位
     * @param ppId
     * @return
     */
     String carNum(@Param("ppId")Integer ppId);
     
     /**
      * 修改车位状态
      * @param carNum
      * @return
      */
     Integer updatePlaceState(@Param("carNum")String carNum);
     

     /**
      * 检查车辆是否注册
      * @param carNum 车牌号
      * @return 车辆对象
      */
     Carnum checkCarnum(@Param("carNum") String carNum);
     
     /**
      * 修改车辆用户状态
      * @param carNum 车牌号
      * @return 0 1
      */
     Integer modCarRole(@Param("carNum") String carNum,@Param("state") String state);
}
