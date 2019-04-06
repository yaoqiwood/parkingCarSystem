package com.example.service;

import java.util.List;


import com.example.bean.WhiteList;

public interface WhiteListService {
	
	/**
	 * 分页查询白名单信息
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @param start
	 * @param end
	 * @return
	 */
	List<WhiteList> listwhiteListByPage(String startTime ,String endTime,
			String name,Integer start,Integer end);

	/**
	 * 白名单总数
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @return
	 */
     Integer countWhiteList(String startTime ,String endTime,
 			String name);


     /**
             * 删除
      * @param carnumId
      * @return
      */
     Integer delWhiteList(String whiteListId);
     
     /**
	      * 添加用户信息
	* @param addname
	* @return
	*/
	Integer addWhiteList(String addname);
}
