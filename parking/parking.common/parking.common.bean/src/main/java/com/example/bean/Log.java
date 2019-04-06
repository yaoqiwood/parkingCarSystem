package com.example.bean;

import java.util.Date;
/**
 * 
  * <p>Title : Log</p>
  * <p>Description : 日志bean</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月21日 下午7:25:47
  * @version : 12.0.0
 */
public class Log {
	private Integer logId;
	private String logDesc;
	private Integer logState;
	private String logMemo;
	private Date logCreateTime;
	public Log() {
		super();
	}
	public Log(Integer logId, String logDesc, Integer logState, String logMemo, Date logCreateTime) {
		super();
		this.logId = logId;
		this.logDesc = logDesc;
		this.logState = logState;
		this.logMemo = logMemo;
		this.logCreateTime = logCreateTime;
	}
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public String getLogDesc() {
		return logDesc;
	}
	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}
	public Integer getLogState() {
		return logState;
	}
	public void setLogState(Integer logState) {
		this.logState = logState;
	}
	public String getLogMemo() {
		return logMemo;
	}
	public void setLogMemo(String logMemo) {
		this.logMemo = logMemo;
	}
	public Date getLogCreateTime() {
		return logCreateTime;
	}
	public void setLogCreateTime(Date logCreateTime) {
		this.logCreateTime = logCreateTime;
	}
	@Override
	public String toString() {
		return "Log [logId=" + logId + ", logDesc=" + logDesc + ", logState=" + logState + ", logMemo=" + logMemo
				+ ", logCreateTime=" + logCreateTime + "]";
	}
	
}
