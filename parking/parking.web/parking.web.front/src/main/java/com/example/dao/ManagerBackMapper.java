/**
 * 
 */
package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.Menu;
import com.example.dto.MenuDto;

/**
 * Title : ManagerBackMapper
 * Description :
 * DevelopTools : Eclipse_x64
 * DevelopSystem : Win10
 * Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 22, 2019 12:15:09 AM
 * @version : 12.0.0
 */
public interface ManagerBackMapper {

	/**
	 * 初始化菜单栏
	 * 
	 * @param menuParent
	 * @return
	 */
	List<MenuDto> initLeftMenu(@Param("roleId") Integer roleId,@Param("menuParent") Integer menuParent);

	/**
	 * 刷新菜单数据
	 * 
	 * @param menuName
	 * @param menuState
	 * @param begin
	 * @param end
	 * @return
	 */
	List<Menu> refMenuManager(@Param("menuName") String menuName, @Param("menuState") String menuState,
			@Param("begin") String begin, @Param("end") String end);

	/**
	 * 查菜单数据总行数
	 * 
	 * @param menuName
	 * @param menuState
	 * @return
	 */
	String cntMenuManager(@Param("menuName") String menuName, @Param("menuState") String menuState);

	/**
	 * 增加菜单数据
	 * 
	 * @param addMenuName
	 * @param addParentID
	 * @param addURL
	 * @return
	 */
	Integer addMenuManager(@Param("addMenuName") String addMenuName, @Param("addParentID") Integer addParentID,
			@Param("addURL") String addURL);

	/**
	 * 修改菜单数据
	 * 
	 * @param upMenuId
	 * @param upMenuName
	 * @param upParentID
	 * @param upURL
	 * @return
	 */
	Integer upMenuManager(@Param("upMenuId") Integer upMenuId, @Param("upMenuName") String upMenuName,
			@Param("upParentID") Integer upParentID, @Param("upURL") String upURL);

	
	/**
	 * 更新状态
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateMenuManager(@Param("upState") Integer upState,@Param("Fid") Integer Fid);
	
	
	/**
	 * 检查重复名的数量
	 * @param pmName
	 * @return
	 */
	Integer checkReMName(@Param("pmName") String pmName);

}
