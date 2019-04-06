package com.example.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Log;
import com.example.dao.LogMapper;
import com.example.service.LogService;
/**
 * 
  * <p>Title : LogServiceImpl</p>
  * <p>Description : 日志服务实现类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月21日 下午6:21:57
  * @version : 12.0.0
 */
@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogMapper mapper;
	/**
	 * 查询日志-根据查询条件
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Log> queryLogBySearch(String timeSt, String timeEn, String name, String start, String end) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(Integer.parseInt(start)-1,Integer.parseInt(end));
		if(timeSt !=null && !"".equals(timeSt)) {
			timeSt = timeSt +" 00:00:00";
		}
		if(timeEn !=null && !"".equals(timeEn)) {
			timeEn = timeEn +" 00:00:00";
		}
		List<Log> queryLogBySearch = mapper.queryLogBySearch(timeSt, timeEn, "%" + name + "%", rb);
		return queryLogBySearch;
	}
	/**
	 * 日志个数统计
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countLogBySearch(String timeSt, String timeEn, String name) {
		// TODO Auto-generated method stub
		if(timeSt !=null && !"".equals(timeSt)) {
			timeSt = timeSt +" 00:00:00";
		}
		if(timeEn !=null && !"".equals(timeEn)) {
			timeEn = timeEn +" 00:00:00";
		}
		Integer countDocByUsId = mapper.countDocByUsId(timeSt, timeEn, "%" + name + "%");
		return countDocByUsId;
	}
	/**
	 * 插入日志
	 */
	@Override
	public Integer insertLog(Integer adminId, String logDesc) {
		// TODO Auto-generated method stub
		Integer id = null;
		Integer insertLog = mapper.insertLog(id, adminId, logDesc);
		System.out.println("insertLog= "+insertLog);
		return insertLog;
	}

}
