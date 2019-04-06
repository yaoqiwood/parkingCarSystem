/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.bean.Configure;

/**
 * Title : ConfigureService Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 24, 2019 11:45:20 AM
 * @version : 12.0.0
 */
public interface ConfigureService {

	/**
	 * 刷新配置表
	 * 
	 * @param configureName
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	List<Configure> refConfigure(String configureName, String Start, String End);

	/**
	 * 统计配置表
	 * 
	 * @param configureName
	 * @return
	 */
	String cntConfigure(String configureName);

	/**
	 * 增加配置
	 * 
	 * @param configureName
	 * @param configureValue
	 * @return
	 */
	Integer addConfigure(String configureName, String configureValue);

	/**
	 * 更新配置
	 * @param upConfigID
	 * @param upConfigName
	 * @param upConfigParamter
	 * @return
	 */
	Integer upConfigure(Integer upConfigID, String upConfigName, String upConfigParamter);

	/**
	 * 更新配置状态
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateConfigure(Integer upState, Integer Fid);
	
	/**
	 * 查重
	 * @param configureName
	 * @return
	 */
	Integer checkConfigName(String configureName);
}
