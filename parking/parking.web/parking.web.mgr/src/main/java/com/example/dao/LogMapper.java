package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.Log;
/**
 * 
  * <p>Title : LogMapper</p>
  * <p>Description : 日志映射类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月21日 下午6:24:10
  * @version : 12.0.0
 */

public interface LogMapper {
	/*日志分页*/
	List<Log> queryLogBySearch(@Param("timeSt") String timeSt,@Param("timeEn") String timeEn,@Param("name") String name, RowBounds rb);
	/*日志分页个数*/
	Integer countDocByUsId(@Param("timeSt") String timeSt,@Param("timeEn") String timeEn,@Param("name") String name);
	/*插入日志*/
	Integer insertLog(@Param("id") Integer id,@Param("adminId") Integer adminId,@Param("logDesc") String logDesc);
	
}
