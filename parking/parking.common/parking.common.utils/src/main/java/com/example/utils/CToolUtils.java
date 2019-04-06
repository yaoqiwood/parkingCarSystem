/**
 * 
 */
package com.example.utils;


/**
 * Title : CToolUtils Description : DevelopTools : Eclipse_x64 DevelopSystem :
 * Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Mar 2, 2019 8:14:50 PM
 * @version : 12.0.0
 */
public class CToolUtils {
	/**
	 * 计算分页开始
	 * 
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public static String BeginPage(String CurrentPage, String Limit) {
		Integer CPage = Integer.parseInt(CurrentPage);
		Integer Lim = Integer.parseInt(Limit);
		return String.valueOf(CPage * Lim - (Lim - 1));
	}

	/**
	 * 计算分页结束
	 * 
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public static String EndPage(String CurrentPage, String Limit) {
		Integer CPage = Integer.parseInt(CurrentPage);
		Integer Lim = Integer.parseInt(Limit);
		return String.valueOf(CPage * Lim);
	}

	/**
	 * 检查不为空且检查是否为为数字
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpAnIsNum(String str) {
		boolean ret = false;
		if (!CheckInfoUtils.isEmpty(str)) {
			if (CheckInfoUtils.IsInteger(str)) {
				ret = true;
			}
		}
		return ret;
	}
	




}
