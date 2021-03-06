/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.bean.AdminRole;

/**
 * Title : RoleManagerService Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 角色管理服务层
 * @author : CatWood
 * @date : Feb 22, 2019 7:19:18 PM
 * @version : 12.0.0
 */
public interface RoleManagerService {
	
	/**
	 * 刷新角色信息表
	 * @param roleName
	 * @param roleState
	 * @return
	 */
	List<AdminRole> refRoleManager(String roleName, Integer roleState, String begin, String end);
	
	/**
	 * 统计角色信息数据行
	 * @param roleName
	 * @param roleState
	 * @return
	 */
	String cntRoleManager(String roleName, Integer roleState);
	
	/**
	 * 插入角色
	 * @param roleName
	 * @return
	 */
	Integer addRoleManager(String roleName);
	
	/**
	 * 修改角色名
	 * @param upRoleId
	 * @param upRoleName
	 * @return
	 */
	Integer upRoleManager(Integer upRoleId,String upRoleName);
	
	/**
	 * 修改角色状态
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateRoleManager(Integer upState,Integer Fid);
	
	
	/**
	 * 查重
	 * @param roleName
	 * @return
	 */
	Integer checkRoleNameR(String roleName);
	
}
