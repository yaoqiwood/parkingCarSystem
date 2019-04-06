package com.example.service;

import java.util.List;

import com.example.bean.AdminRoleMenu;

public interface AdminRoleMenuService {
	
	/**
	 * 用于查询对应id再关系表中是否有消息
	 * @param roleId	角色id
	 * @return
	 */
	List<AdminRoleMenu> roleMenuInf(Integer roleId);
	
	Integer roleMenuUpdate(Integer roleId,String updateInf);
	
	/**
	 * 用于主页面的侧边栏加载
	 * @return
	 */
	List<AdminRoleMenu>	roleMenuInfById(Integer roleId);

}
