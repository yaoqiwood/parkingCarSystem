/**
 * 
 */
package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.Configure;
import com.example.dao.ConfigureMapper;
import com.example.service.ConfigureService;
import com.example.utils.CheckInfoUtils;

/**
 * Title : ConfigureController Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 24, 2019 11:42:47 AM
 * @version : 12.0.0
 */

@Controller
public class ConfigureController {

	@Autowired
	private ConfigureService configureService;

	/**
	 * 刷新配置
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/ref-configure.action")
	@ResponseBody
	public JSONArray refConfigure(HttpServletRequest req, HttpServletResponse res) {
		String configureName = req.getParameter("configureName");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");
		JSONArray jsonArray = new JSONArray();

		String Start = BeginPage(CurrentPage, Limit);
		String End = EndPage(CurrentPage, Limit);

		List<Configure> configures = configureService.refConfigure(configureName, Start, End);
		jsonArray = (JSONArray) JSONArray.toJSON(configures);
		return jsonArray;
	}

	/**
	 * 统计配置表
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/cnt-configure.action")
	@ResponseBody
	public JSONObject cntConfigure(HttpServletRequest req, HttpServletResponse res) {
		String configureName = req.getParameter("configureName");
		JSONObject jsonObject = new JSONObject();
		String Count = configureService.cntConfigure(configureName);
		jsonObject.put("count", Count);
		return jsonObject;
	}

	/**
	 * 添加配置
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/add-configure.action")
	@ResponseBody
	public JSONObject addConfigure(HttpServletRequest req, HttpServletResponse res) {
		String configureName = req.getParameter("addConfigureName");
		String configureValue = req.getParameter("addConfigureValue");
		JSONObject jsonObject = new JSONObject();
		if (!(isEmpty(configureName) || isEmpty(configureValue))) {
			if (configureService.checkConfigName(configureName) == 0) {
				Integer out = configureService.addConfigure(configureName, configureValue);
				if (out > 0) {
					jsonObject = jsonMessage("1", "添加成功");
				} else {
					jsonObject = jsonMessage("0", "添加失败");
				}
			} else {
				jsonObject = jsonMessage("3", "添加名字不可重复");
			}
		} else {
			jsonObject = jsonMessage("3", "参数不可为空");
		}
		return jsonObject;
	}

	/**
	 * 修改配置
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/up-configure.action")
	@ResponseBody
	public JSONObject upConfigure(HttpServletRequest req, HttpServletResponse res) {
		String upConfigID = req.getParameter("upConfigID");
		String upConfigName = req.getParameter("upConfigName");
		String upConfigParamter = req.getParameter("upConfigParamter");
		JSONObject jsonObject = new JSONObject();

		if (isEmpAnIsNum(upConfigID) && (!isEmpty(upConfigName)) || (!isEmpty(upConfigParamter))) {
			Integer out = configureService.upConfigure(Integer.parseInt(upConfigID), upConfigName, upConfigParamter);
			if (out > 0) {
				jsonObject = jsonMessage("1", "修改成功");
			} else {
				jsonObject = jsonMessage("0", "修改失败");
			}
		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 更新状态
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("upState-configure.action")
	@ResponseBody
	public JSONObject upStateConfigure(HttpServletRequest req, HttpServletResponse res) {
		String upState = req.getParameter("upState");
		String Fid = req.getParameter("Fid");
		JSONObject jsonObject = new JSONObject();
		if (isEmpAnIsNum(upState) && isEmpAnIsNum(Fid)) {
			Integer out = configureService.upStateConfigure(Integer.parseInt(upState), Integer.parseInt(Fid));
			if (out > 0) {
				jsonObject = jsonMessage("1", upState.equals("0") ? "禁用成功" : "启用成功");
			} else {
				jsonObject = jsonMessage("0", upState.equals("0") ? "禁用失败" : "启用失败");
			}
		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 删除
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("del-configure.action")
	@ResponseBody
	public JSONObject delConfigure(HttpServletRequest req, HttpServletResponse res) {
		String Fid = req.getParameter("Fid");
		JSONObject jsonObject = new JSONObject();
		if (isEmpAnIsNum(Fid)) {
			Integer out = configureService.upStateConfigure(9, Integer.parseInt(Fid));
			if (out > 0) {
				jsonObject = jsonMessage("1", "删除成功");
			} else {
				jsonObject = jsonMessage("0", "删除失败");
			}
		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 计算分页开始
	 * 
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public String BeginPage(String CurrentPage, String Limit) {
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
	public String EndPage(String CurrentPage, String Limit) {
		Integer CPage = Integer.parseInt(CurrentPage);
		Integer Lim = Integer.parseInt(Limit);
		return String.valueOf(CPage * Lim);
	}

	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return
	 */
	public boolean isEmpty(String str) {
		return CheckInfoUtils.isEmpty(str);
	}

	/**
	 * 检查不为空且检查是否为为数字
	 * 
	 * @param str
	 * @return boolean
	 */
	public boolean isEmpAnIsNum(String str) {
		boolean ret = false;
		if (!CheckInfoUtils.isEmpty(str)) {
			if (CheckInfoUtils.IsInteger(str)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * 消息封装
	 * 
	 * @param id
	 * @param message
	 * @return
	 */
	public JSONObject jsonMessage(String id, String message) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("message", message);
		return jsonObject;
	}

}
