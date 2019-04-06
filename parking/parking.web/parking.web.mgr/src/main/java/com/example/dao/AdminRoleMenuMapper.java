package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.AdminRoleMenu;

/**
 * 角色界面关系的dao
 * <p>Title : AdminRoleMenuMapper</p>
 * <p>Description : </p>
 * <p>DevelopTools : Eclipse_x64_v4.9.0</p>
 * <p>DevelopSystem : window 10</p>
 * @author : Lian
 * @date : 2019年3月4日 上午9:47:30
 * @version : 1.0.0
 */
public interface AdminRoleMenuMapper {
	
	List<AdminRoleMenu> roleMenuInf(@Param("roleId") Integer roleId);
	
	AdminRoleMenu roleMenuSingle(@Param("roleId") Integer roleId,@Param("menuId") String menuId);
	
	Integer roleMenuInsert(@Param("roleId") Integer roleId,@Param("menuId") String menuId,@Param("state") String state);
	
	Integer roleMenuUpdate(@Param("roleId") Integer roleId,@Param("menuId") String menuId,@Param("state") String state);

	List<AdminRoleMenu> roleMenuInfById(@Param("roleId") Integer roleId);
}
