/**
 * 
 */
package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.AdminRole;

/**
 * Title : RoleManagerMapper Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 22, 2019 7:23:40 PM
 * @version : 12.0.0
 */
public interface RoleManagerMapper {

	/**
	 * 刷新角色信息表
	 * 
	 * @param roleName
	 * @param roleState
	 * @return
	 */
	List<AdminRole> refRoleManager(@Param("roleName") String roleName, @Param("roleState") Integer roleState,
			@Param("begin") String begin, @Param("end") String end);

	
	/**
	 * 统计角色信息数据行
	 * @param roleName
	 * @param roleState
	 * @return
	 */
	String cntRoleManager(@Param("roleName") String roleName, @Param("roleState") Integer roleState);
	
	/**
	 * 插入角色名
	 * @param roleName
	 * @return
	 */
	Integer addRoleManager(@Param("roleName") String roleName);
	
	/**
	 * 修改角色
	 * @param upRoleId
	 * @param upRoleName
	 * @return
	 */
	Integer upRoleManager(@Param("upRoleId") Integer upRoleId,@Param("upRoleName") String upRoleName);
	
	/**
	 * 修改状态
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateRoleManager(@Param("upState") Integer upState, @Param("Fid") Integer Fid);

	/**
	 * 查重
	 * @param roleName
	 * @return
	 */
	Integer checkRoleNameR(@Param("roleName") String roleName);
}
