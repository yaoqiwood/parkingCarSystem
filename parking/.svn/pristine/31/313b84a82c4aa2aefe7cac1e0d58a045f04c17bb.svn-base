package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.Admin;
import com.example.dto.AdminDto;

public interface AdminMapper {
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Admin adminLogin(@Param("name") String name,@Param("password") String password);
		
	
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
	List<AdminDto> listAdminByPage(@Param("startTime")String startTime ,@Param("endTime") String endTime,
			@Param("name")String name ,@Param("roleId")Integer roleId
			,@Param("state")Integer state,@Param("start")Integer start,
			@Param("end")Integer end);

	/**
	 * 用户总数
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param roleId
	 * @param state
	 * @return
	 */
     Integer countAdmin(@Param("startTime")String startTime ,@Param("endTime") String endTime,
 			@Param("name")String name ,@Param("roleId")Integer roleId
 			,@Param("state")Integer state);
     
     /**
      * 删除用户
      * @param adminId
      * @return
      */
     Integer delAdmin(@Param("adminId")String adminId);
     
     /**
      * 启用/禁用
      * @param adminId
      * @param state
      * @return
      */
     Integer updateAdminState(@Param("adminId")String adminId ,@Param("state") String state);
     
     /**
      * 修改用户
      * @param adminId
      * @param dpassword
      * @param dname
      * @param drole
      * @param dstate
      * @return
      */
     Integer updateAdmin(@Param("dname")String dname, @Param("drole")String drole,@Param("dstate")String dstate,@Param("adminId")String adminId);

     /**
      * 重置密码
      * @param adminId
      * @return
      */
     Integer resetteAdmin(@Param("adminId")String adminId);
     
     /**
      * 添加用户信息
      * @param addname
      * @param addpassword
      * @param addrole
      * @return
      */
     Integer addAdmin(@Param("addname")String addname,@Param("addpassword")String addpassword,@Param("addrole")String addrole);

     /**
      * 注销用户
      * @param adminId
      * @return
      */
     Integer cancelAdmin(@Param("adminId") String adminId);
     
     /**
      * 查询单个用户信息
      * @param adminId 用户id
      * @return
      */
     Admin singleAdminInfo(@Param("adminId") String adminId);
     
     /**
      * 修改密码
      * @param oldpwd
      * @param adminId
      * @param newpwd
      * @return
      */
     Integer updatepwd(@Param("oldpwd")String oldpwd, @Param("adminId")Integer adminId , @Param("newpwd")String newpwd);

     /**
      * 查询是否有这个管理名
      * @param adminName
      * @return
      */
     Integer selectAdminName(@Param("adminName") String adminName);
}
