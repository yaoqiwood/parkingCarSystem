/**
 * 
 */
package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.Configure;

/**
 * Title : ConfigureMapper Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 24, 2019 11:46:50 AM
 * @version : 12.0.0
 */
public interface ConfigureMapper {

	/**
	 * 刷新配置表
	 * 
	 * @param configureName
	 * @param Start
	 * @param End
	 * @return
	 */
	List<Configure> refConfigure(@Param("configureName") String configureName, @Param("begin") String Start,
			@Param("end") String End);

	/**
	 * 统计配置表
	 * 
	 * @param configureName
	 * @return
	 */
	String cntConfigure(@Param("configureName") String configureName);

	/**
	 * 插入配置表
	 * 
	 * @param configureName
	 * @param configureValue
	 * @return
	 */
	Integer addConfigure(@Param("configureName") String configureName, @Param("configureValue") String configureValue);

	/**
	 * 修改配置表
	 * 
	 * @param upConfigID
	 * @param upConfigName
	 * @param upConfigParamter
	 * @return
	 */
	Integer upConfigure(@Param("upConfigID") Integer upConfigID, @Param("upConfigName") String upConfigName,
			@Param("upConfigParamter") String upConfigParamter);

	/**
	 * 修改状态
	 * 
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateConfigure(@Param("upState") Integer upState, @Param("Fid") Integer Fid);
	
	
	/**
	 * 查重
	 * @param configureName
	 * @return
	 */
	Integer checkConfigName(@Param("configureName") String configureName);

}
