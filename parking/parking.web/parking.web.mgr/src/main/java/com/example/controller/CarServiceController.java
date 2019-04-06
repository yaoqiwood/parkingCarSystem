/**
 * 
 */
package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.AdminAmountLog;
import com.example.bean.CarService;
import com.example.bean.Carnum;
import com.example.dto.CarServiceDto;
import com.example.service.CarServiceService;
import com.example.service.CarInService;

import oracle.net.aso.i;

/**
 * <p>
 * Title:CarServiceController
 * </p>
 * <p>
 * Description:车服务
 * </p>
 * <p>
 * DevelopTools:Eclipse_x64_v4.7.1
 * </p>
 * <p>
 * DevelopSystem : macOS Sierra 10.12.1
 * </p>
 * <p>
 * Company : org.xiongyi
 * </p>
 * 
 * @author:XiongYi
 * @date:2019年2月25日 上午6:07:24
 * @version:12.0.0
 */
@Controller
public class CarServiceController {
	@Autowired
	private CarServiceService carServiceService;

	@Autowired
	private CarInService carnumService;
	
	/**
	 * 检查车辆是否注册
	 * @param carNum 车辆车号
	 * @param request 请求
	 * @return json
	 */
	@RequestMapping("/checkCarNum.action")
	@ResponseBody
	public JSONObject checkCarNum(String carNum, HttpServletRequest request) {
		System.out.println(carNum);
		Carnum carnum = carnumService.checkCarnum(carNum);
		JSONObject data = new JSONObject();
		if (carnum != null) {
			HttpSession session = request.getSession();
			session.setAttribute("carnumId", carnum.getCarnumId());
			session.setAttribute("carnum", carnum.getCarNumber());
			data.put("type", 1);
		} else {
			data.put("type", 0);
			data.put("message", "请您先进行注册");
		}
		return data;
	}
	
	/**
	 * 购买产品
	 * @param addId 产品id
	 * @param addName 产品名
	 * @param addMoney 产品价格
	 * @param request 请求
	 * @return json
	 */
	@RequestMapping("/addMonthProductService.action")
	@ResponseBody
	public JSONObject buyMonthProduct(String addId, String addName, String addMoney, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer carServiceCarnumId = (Integer) session.getAttribute("carnumId");
		Integer carServicePmpId = Integer.valueOf(addId);
		Integer money = Integer.valueOf(addMoney);
		String carNum = (String) session.getAttribute("carnum");
		Integer res = carServiceService.selectCount(carServiceCarnumId);
		CarService carService = null;
		if(res==0) {
			carService = new CarService(null, carServiceCarnumId, carServicePmpId, 1, null, null, null);
			carnumService.modCarRole(carNum, "2");
		}else {
			carService = new CarService(null, carServiceCarnumId, carServicePmpId, 2, null, null, null);
		}
		
		AdminAmountLog adminAmountLog = new AdminAmountLog(null, 1, carNum, money, "购买" + addName + "产品", null, null,
				null);
		Integer flag = carServiceService.addCarService(carService, adminAmountLog);
		JSONObject data = new JSONObject();
		if (flag == 0) {
			data.put("type", 0);
			data.put("message", "购买失败");
		} else {
			data.put("type", 1);
			data.put("message", "购买成功");
		}
		return data;
	}
	
	/**
	 * 车服务分页显示
	 * @param carNum 车牌号
	 * @param rowPage 每页显示几条
	 * @param pageCount 当前页
	 * @param request 请求
	 * @return json
	 */
	@RequestMapping("/carServicePage.action")
	@ResponseBody
	public JSONObject carServicePage(String carNum, String rowPage, String pageCount, HttpServletRequest request) {
		Integer page = Integer.valueOf(pageCount);
		Integer limit = Integer.valueOf(rowPage);
		RowBounds rs = new RowBounds((page - 1) * limit, limit);
		ArrayList<CarServiceDto> serList = carServiceService.carServicePage(carNum, rs);
		HttpSession session = request.getSession();
		session.setAttribute("serviceList", serList);
		Integer count = carServiceService.count(carNum);
		JSONObject data = new JSONObject();
		data.put("list", serList);
		data.put("count", count);
		return data;
	}
	
	/**
	 * 退费
	 * @param ser_id 服务id
	 * @param request 请求
	 * @return json
	 */
	@RequestMapping("/refundMonthProduct.action")
	@ResponseBody
	public JSONObject refundMonthProduct(String ser_id, HttpServletRequest request) {
		CarServiceDto carServiceDto = carServiceService.selectCarServiceDto(ser_id);
		JSONObject data = new JSONObject();
		if(carServiceDto.getCarServiceState()==1) {
			data.put("type", 2);
			data.put("message", "无法退还正在使用的产品");
		}else if(carServiceDto.getCarServiceState()==2) {
			Integer money = Integer.valueOf(carServiceDto.getMonthProductMoney());
			AdminAmountLog adminAmountLog = new AdminAmountLog(null, 1, carServiceDto.getCarNum(), -money, "退费",
					null, null, null);
			Integer flag = carServiceService.refundCarService(ser_id, "3", adminAmountLog);
			if (flag == 1) {
				data.put("type", 1);
				data.put("money", money);
			} else {
				data.put("type", 3);
				data.put("message", "退费失败");
			}
		}else {
			data.put("type", 0);
			data.put("message", "该状态无法退费");
		}
		return data;
	}

}
