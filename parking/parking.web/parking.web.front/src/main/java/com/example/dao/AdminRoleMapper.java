package com.example.dao;

import java.util.List;

import com.example.bean.AdminRole;

/**
 * 管理员角色dao接口
 * @author 黄主文
 *
 */
public interface AdminRoleMapper {
	
	/**
	 * 获取下拉框的信息，集合返回
	 * @return
	 */
	List<AdminRole> listrole();

}
