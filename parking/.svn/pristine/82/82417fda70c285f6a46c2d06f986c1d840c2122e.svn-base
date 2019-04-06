/**
 * 
 */
package com.example.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.CarService;
import com.example.bean.Carnum;
import com.example.dto.CarServiceDto;

/**
 * <p>Title:CarServiceMapper</p>
 * <p>Description:车辆缴交业务</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月25日 上午2:32:28
 * @version:12.0.0
 */
public interface CarServiceMapper {
	/**
	 * 插入数据
	 * @param carService 车服务对象
	 * @return 0 1
	 */
	Integer addCarService(@Param("carService") CarService carService);
	
	/**
	 * 车服务分页显示
	 * @param carNum 车牌号
	 * @param rb 控制页数
	 * @return 服务集合
	 */
	ArrayList<CarServiceDto> carServicePage(@Param("carNum") String carNum,RowBounds rb);
	
	/**
	 * 车服务条数
	 * @param carNum 车牌号
	 * @return 车服务条数
	 */
	Integer count(@Param("carNum") String carNum);
	
	/**
	 * 修改服务状态
	 * @param serId 服务id
	 * @param state 修改状态
	 * @return 0 1
	 */
	Integer modCarService(@Param("serId") String serId,@Param("state") String state);
	
	/**
	 * 查看是否购买过
	 * @param carId 车序号
	 * @return 0  1 
	 */
	Integer selectCount(@Param("carId") Integer carId);
}
