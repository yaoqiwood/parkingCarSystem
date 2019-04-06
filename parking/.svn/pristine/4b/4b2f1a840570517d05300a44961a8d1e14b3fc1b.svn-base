package com.example.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.CarRecord;
import com.example.bean.Log;
/**
 * 
  * <p>Title : PaymentMapper</p>
  * <p>Description : 车辆出入信息映射类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月26日 下午8:08:07
  * @version : 12.0.0
 */
public interface PaymentMapper {
	/*查询车辆id*/
	Integer queryCarId(@Param("carnum") String carnum);
	/*查询车辆出入信息*/
	CarRecord queryRecord(@Param("name") String name);
	/*插入离开时间*/
	Integer updateRecord(@Param("outDate") Date outDate, @Param("id") Integer id);
	/**
	 * 删除车辆记录
	 * @param id
	 * @return
	 */
	Integer deleteRecord(@Param("id") Integer id);
	/**
	 * 新增自助日志
	 * @param id
	 * @param mid
	 * @param carnum
	 * @param money
	 * @return
	 */
	Integer addMechineLog(@Param("id") Integer id, @Param("mid") Integer mid,@Param("carnum") String carnum,@Param("money") Integer money);
	
	CarRecord queryRecordById(@Param("id") Integer id);
	
}
