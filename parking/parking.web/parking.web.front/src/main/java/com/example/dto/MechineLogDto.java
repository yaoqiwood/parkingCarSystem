package com.example.dto;

import com.example.bean.MechineLog;
/**
 * 
  * <p>Title : MechineLogDto</p>
  * <p>Description : 自助终端缴费Dto</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月25日 上午9:35:05
  * @version : 12.0.0
 */
public class MechineLogDto extends MechineLog{
	private String selfMechineNum;
	public MechineLogDto() {
		super();
	}
	public MechineLogDto(String selfMechineNum) {
		super();
		this.selfMechineNum = selfMechineNum;
	}
	public String getSelfMechineNum() {
		return selfMechineNum;
	}
	public void setSelfMechineNum(String selfMechineNum) {
		this.selfMechineNum = selfMechineNum;
	}
	@Override
	public String toString() {
		return "MechineLogDto [selfMechineNum=" + selfMechineNum + "]";
	}
	
}
