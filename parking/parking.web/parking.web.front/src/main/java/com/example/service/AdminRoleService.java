package com.example.service;

import java.util.List;

import com.example.bean.AdminRole;

/**
 * 管理员角色业务接口
 * @author Administrator
 *
 */
public interface AdminRoleService {
	
	/**
	 * 获取下拉框的信息，集合返回
	 * @return
	 */
	List<AdminRole> listrole();

}
