/**
 * 
 */
package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Menu;
import com.example.dao.ManagerBackMapper;
import com.example.dto.MenuDto;
import com.example.service.ManagerBackMenuService;

/**
 * 用于后台管理及菜单栏初始化
 * Title : ManagerFrontMenuServiceImpl
 * Description :
 * DevelopTools : Eclipse_x64
 * DevelopSystem : Win10
 * Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 21, 2019 11:22:42 PM
 * @version : 12.0.0
 */
@Service
public class ManagerBackMenuServiceImpl implements ManagerBackMenuService {

	@Autowired
	private ManagerBackMapper managerBackMapper;

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.service.ManagerBackMenuService#refMenuManager(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Menu> refMenuManager(String menuName, String menuState, String begin, String end) {
		// TODO Auto-generated method stub
		List<Menu> menus = managerBackMapper.refMenuManager(menuName, menuState, begin, end);
		return menus;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ManagerBackMenuService#cntMenuManager(java.lang.String, java.lang.String)
	 */
	@Override
	public String cntMenuManager(String menuName, String menuState) {
		// TODO Auto-generated method stub
		String cnt = managerBackMapper.cntMenuManager(menuName, menuState);
		
		return cnt;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ManagerBackMenuService#addMenuManager(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer addMenuManager(String addMenuName, Integer addParentID, String addURL) {
		// TODO Auto-generated method stub
		
		Integer out = managerBackMapper.addMenuManager(addMenuName, addParentID, addURL);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ManagerBackMenuService#upMenuManager(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer upMenuManager(Integer upMenuId, String upMenuName, Integer upParentID, String upURL) {
		// TODO Auto-generated method stub
		
		Integer out = managerBackMapper.upMenuManager(upMenuId, upMenuName, upParentID, upURL);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ManagerBackMenuService#upStateMenuManager(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer upStateMenuManager(Integer upState, Integer Fid) {
		// TODO Auto-generated method stub
		
		Integer out = managerBackMapper.upStateMenuManager(upState, Fid);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ManagerBackMenuService#checkReMName(java.lang.String)
	 */
	@Override
	public Integer checkReMName(String pmName) {
		// TODO Auto-generated method stub
		Integer out = managerBackMapper.checkReMName(pmName);
		return out;
	}


	/* (non-Javadoc)
	 * @see com.example.service.ManagerBackMenuService#viewUpMenuManager(java.lang.String)
	 */
	@Override
	public Menu viewUpMenuManager(String fid) {
		// TODO Auto-generated method stub
		Menu menu = managerBackMapper.viewUpMenuManager(fid);
		return menu;
	}


	@Override
	public List<MenuDto> initLeftMenu(Integer roleId) {
		// TODO Auto-generated method stub
		List<MenuDto> menus = managerBackMapper.initLeftMenu(roleId,0);
		return menus;
	}

}
