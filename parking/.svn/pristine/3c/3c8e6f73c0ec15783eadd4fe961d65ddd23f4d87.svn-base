/**
 * 
 */
package com.example.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.AdminAmountLog;
import com.example.bean.CarService;
import com.example.dto.CarServiceDto;

/**
 * <p>Title:CarServiceService</p>
 * <p>Description:</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月25日 上午6:18:21
 * @version:12.0.0
 */
public interface CarServiceService {
	/**
	 * 插入数据
	 * @param carService 车服务对象
	 * @param amountLogMapper 流水表对象
	 * @return 0 1
	 */
	Integer addCarService(CarService carService,AdminAmountLog adminAmountLog);
	
	/**
	 * 车服务分页显示
	 * @param carNum 车牌号
	 * @param rb 控制页数
	 * @return 服务集合
	 */
	ArrayList<CarServiceDto> carServicePage(String carNum,RowBounds rb);
	
	/**
	 * 车服务条数
	 * @param carNum 车牌号
	 * @return 车服务条数
	 */
	Integer count(String carNum);
	
	/**
	 * 退费
	 * @param serId 服务id
	 * @param state 修改状态
	 * @param adminAmountLog 流水日志
	 * @return 0 1
	 */
	Integer refundCarService(String serId,String state,AdminAmountLog adminAmountLog);
	
	/**
	 * 修改
	 * @param serId 服务id
	 * @param state 修改状态
	 * @return 0 1
	 */
	Integer modCarService(String serId,String state);
	
	/**
	 * 查看是否购买过
	 * @param carId 车序号
	 * @return 0  1 
	 */
	Integer selectCount(@Param("carId") Integer carId);
}
