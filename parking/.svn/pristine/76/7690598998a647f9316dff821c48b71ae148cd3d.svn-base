package com.example.service;

import java.util.List;

import com.example.bean.Admin;
import com.example.dto.AdminDto;

public interface AdminService {
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Admin adminLogin(String name,String password);
	
	
	/**
	 * 分页查询用户信息
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @param start
	 * @param end
	 * @return
	 */
	List<AdminDto> listAdminByPage(String startTime ,String endTime,
			String name ,Integer roleId,Integer state,Integer start,Integer end);

	/**
	 * 用户总数
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @return
	 */
     Integer countAdmin(String startTime ,String endTime,
 			String name ,Integer roleId,Integer state);
	

     /**
      * 删除用户
      * @param adminId
      * @return
      */
     Integer delAdmin(String adminId);
     
     /**
      * 启用/禁用
      * @param adminId
      * @param state
      * @return
      */
     Integer updateAdminState(String adminId ,String state);
     
     /**
      * 修改用户
      * @param adminId
      * @param dpassword
      * @param dname
      * @param drole
      * @param dstate
      * @return
      */
     Integer updateAdmin(String dname,String drole,String dstate,String adminId);
     
     /**
      * 重置密码
      * @param adminId
      * @return
      */
     Integer resetteAdmin(String adminId);
     
     /**
      * 添加用户信息
      * @param addname
      * @param addpassword
      * @param addrole
      * @return
      */
     Integer addAdmin(String addname,String addpassword,String addrole);

     /**
      * 注销用户
      * @param adminId
      * @return
      */
     Integer cancelAdmin(String adminId);
     
     /**
      * 查询单个用户信息
      * @param adminId	用户id
      * @return
      */
     Admin singleAdminInfo(String adminId);
     
     /**
      * 修改密码
      * @param oldpwd
      * @param adminId
      * @param newpwd
      * @return
      */
     Integer updatepwd(String oldpwd,Integer adminId,String newpwd);

	/**
	 * 登录通过id
	 * @param name
	 * @param password
	 * @return
	 */
	Admin adminLogin(Integer id);
	
}
