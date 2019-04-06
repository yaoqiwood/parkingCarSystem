/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.bean.Menu;
import com.example.dto.MenuDto;

/**
 * 用于后台管理及菜单栏初始化
 * Title : ManagerFrontMenuService
 * Description :
 * DevelopTools : Eclipse_x64
 * DevelopSystem : Win10
 * Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 21, 2019 11:21:16 PM
 * @version : 12.0.0
 */
public interface ManagerBackMenuService {

	/**
	 * 初始化菜单
	 * 
	 * @param menuParent
	 * @return
	 */
	List<MenuDto> initLeftMenu(Integer roleId);

	/**
	 * 刷新菜单数据
	 * 
	 * @param menuName
	 * @param menuState
	 * @param begin
	 * @param end
	 * @return
	 */
	List<Menu> refMenuManager(String menuName, String menuState, String begin, String end);

	/**
	 * 统计菜单数据
	 * 
	 * @param menuName
	 * @param menuState
	 * @return
	 */
	String cntMenuManager(String menuName, String menuState);
	
	/**
	 * 根据ID查菜单信息
	 * @param fid
	 * @return
	 */
	Menu viewUpMenuManager(String fid);
	
	/**
	 * 增加菜单
	 * 
	 * @param addMenuName
	 * @param addParentID
	 * @param addURL
	 * @return
	 */
	Integer addMenuManager(String addMenuName, Integer addParentID, String addURL);

	/**
	 * 修改菜单
	 * @param upMenuId
	 * @param upMenuName
	 * @param upParentID
	 * @param upURL
	 * @return
	 */
	Integer upMenuManager(Integer upMenuId, String upMenuName, Integer upParentID, String upURL);
	
	/**
	 * 更新菜单状态
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateMenuManager(Integer upState, Integer Fid);

	/**
	 * 检查重复的行（菜单）
	 * @param pmName
	 * @return
	 */
	Integer checkReMName(String pmName);	
	
}
