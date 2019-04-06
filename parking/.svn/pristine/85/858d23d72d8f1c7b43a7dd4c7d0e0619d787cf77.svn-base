package com.example.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.FeeRule;
import com.example.service.FeeRuleService;
import com.example.utils.CToolUtils;
import com.example.utils.CheckInfoUtils;
import com.example.utils.TimeUtils;

/**
 * 计费规则控制层 Title : FeeRuleController Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 22, 2019 7:34:27 PM
 * @version : 12.0.0
 */

@Controller
public class FeeRuleController {

	@Autowired
	private FeeRuleService feeRuleService;

	/**
	 * 查看计费规则表格
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/ref-feeRuleView.action")
	@ResponseBody
	public JSONArray refFeeRuleView(String ruleMoney, String CurrentPage, String Limit, HttpServletRequest req,
			HttpServletResponse res) {

		List<FeeRule> feeRules = feeRuleService.refFeeRuleView(ruleMoney, CToolUtils.BeginPage(CurrentPage, Limit),
				CToolUtils.EndPage(CurrentPage, Limit));
		JSONArray jsonArray = (JSONArray) JSONArray.toJSON(feeRules);
		return jsonArray;
	}

	/**
	 * 查看计费规则行数量
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/cnt-feeRuleView.action")
	@ResponseBody
	public JSONObject cntFeeRuleView(String ruleMoney, HttpServletRequest req, HttpServletResponse res) {
		String time = null;
		Integer Count = feeRuleService.cntFeeRuleView(ruleMoney);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", Count);
		return jsonObject;
	}

	/**
	 * 查看该规则ID下的信息
	 * 
	 * @param feeRuleId
	 * @return
	 */
	@RequestMapping("/upCI-feeRuleView.action")
	@ResponseBody
	public JSONObject upCIFeeRuleView(String feeRuleId) {
		JSONObject jsonObject = new JSONObject();
		if (!CheckInfoUtils.isEmpty(feeRuleId)) {
			FeeRule feeRule = feeRuleService.viewSinFeeRule(feeRuleId);
			jsonObject = (JSONObject) JSONObject.toJSON(feeRule);
		}
		return jsonObject;
	}

	/**
	 * 增加费用规则
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/add-feeRuleView.action")
	@ResponseBody
	public JSONObject addFeeRuleView(String addTimeLap, String ruleHourMoney, HttpServletRequest req,
			HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if (CheckInfoUtils.IsInteger(addTimeLap)) {
			if (Integer.parseInt(addTimeLap) > 0) {
				if (feeRuleService.checkReTimes(addTimeLap) == 0) {
					String time = String.valueOf(Integer.parseInt(addTimeLap));
					Integer ret = feeRuleService.insertFeeRuleView(time, Integer.parseInt(ruleHourMoney));
					if (ret > 0) {
						jsonObject.put("id", "1"); // 插入成功
						jsonObject.put("message", "插入成功");
					} else {
						jsonObject.put("id", "0"); // 插入失败
						jsonObject.put("message", "插入失败"); // 插入失败
					}
				} else {
					jsonObject.put("id", "3"); // 插入失败
					jsonObject.put("message", "当前时间规则已存在，请检查后重新输入"); // 插入失败
				}
			} else {
				jsonObject.put("id", "3"); // 插入失败
				jsonObject.put("message", "请输入一个大于零的数"); // 插入失败
			}
		} else {
			jsonObject.put("id", "3");
			jsonObject.put("message", "请输入正确的数字");
		}
		return jsonObject;
	}

	/**
	 * 修改规则
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/up-feeRuleView.action")
	@ResponseBody
	public JSONObject upFeeRuleView(String upRuleID, String upTimeLap, String upRuleMoney, HttpServletRequest req,
			HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		// 检查时间是否符合规则
		if (CheckInfoUtils.IsInteger(upTimeLap)) {
			if (Integer.parseInt(upTimeLap) > 0) {
				if (feeRuleService.checkReTimes(upTimeLap) == 0) {
					Integer ret = feeRuleService.upFeeRuleView(Integer.parseInt(upRuleID), upTimeLap,
							Integer.parseInt(upRuleMoney));
					if (ret > 0) {
						jsonObject.put("id", "1");
						jsonObject.put("message", "修改成功");
					} else {
						jsonObject.put("id", "0");
						jsonObject.put("message", "修改失败");
					}
				} else {
					jsonObject.put("id", "3"); // 插入失败
					jsonObject.put("message", "时间重复，请检查后再输入"); // 插入失败
				}
			} else {
				jsonObject.put("id", "3"); // 插入失败
				jsonObject.put("message", "请输入一个大于零的数"); // 插入失败
			}
		} else {
			jsonObject.put("id", "3"); // 插入失败
			jsonObject.put("message", "请输入数字"); // 插入失败
		}

		return jsonObject;
	}

	/**
	 * 修改规则状态
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/upState-feeRuleView.action")
	@ResponseBody
	public JSONObject upStateFeeRuleView(String upState, String Fid, HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if (CToolUtils.isEmpAnIsNum(Fid) && CToolUtils.isEmpAnIsNum(upState)) {
			Integer ret = feeRuleService.upStateFeeRuleView(Integer.parseInt(upState), Integer.parseInt(Fid));
			if (ret > 0) {
				jsonObject.put("id", "1");
				jsonObject.put("message", Integer.parseInt(upState) == 1 ? "启用成功" : "禁用成功");
			} else {
				jsonObject.put("id", "0");
				jsonObject.put("message", Integer.parseInt(upState) == 1 ? "启用失败" : "禁用失败");
			}
		} else {
			jsonObject.put("id", "3");
			jsonObject.put("message", "参数错误");
		}

		return jsonObject;
	}

	/**
	 * 删除规则
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/del-feeRuleView.action")
	@ResponseBody
	public JSONObject delFeeRuleView(String Fid, HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if (CToolUtils.isEmpAnIsNum(Fid)) {
			Integer ret = feeRuleService.delFeeRuleView(Integer.parseInt(Fid));
			if (ret > 0) {
				jsonObject.put("id", "1");
				jsonObject.put("message", "删除成功");
			} else {
				jsonObject.put("id", "0");
				jsonObject.put("message", "删除失败");
			}
		} else {
			jsonObject.put("id", "3");
			jsonObject.put("message", "参数有误");
		}
		return jsonObject;
	}

}
