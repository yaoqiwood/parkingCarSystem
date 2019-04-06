package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.WhiteList;

public interface WhiteListMapper {
	
	/**
	 * 分页查询白名单信息
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<WhiteList> listwhiteListByPage(@Param("startTime")String startTime ,@Param("endTime") String endTime,
			@Param("name")String name,@Param("start")Integer start,
			@Param("end")Integer end);

	/**
	 * 白名单总数
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @return
	 */
     Integer whiteList(@Param("startTime")String startTime ,@Param("endTime") String endTime,
 			@Param("name")String name);
     
     /**
      * 删除
      * @param carnumId
      * @return
      */
     Integer delwhiteList(@Param("whiteListId")String whiteListId);
     
     /**
             * 添加用户信息
      * @param addname
      * @return
      */
     Integer addWhiteList(@Param("addname")String addname);
     
     /**
      * 查询是否有该白名单用户
      * @param carnum
      * @return
      */
     WhiteList whiteListInfo(@Param("carnum") String carnum);
}
