package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.MenuDto;
import com.example.dto.MenuRoleDto;



public interface MenuMapper {
	
	List<MenuRoleDto> getMenu(@Param("roleId")String roleId);
	
	Integer updatemenu(@Param("roleId")String roleId);
	
	Integer updatemenuroleId(@Param("roleId")String roleId);
	
	/**
	 * 根据父级id找对应的子菜单
	 * @param menuParent
	 * @return
	 */
	List<MenuDto> menuByParent(@Param("menuParent") Integer menuParent);

}
