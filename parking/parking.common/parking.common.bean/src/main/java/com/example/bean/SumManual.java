package com.example.bean;
/**
 * 收费人员统计bean
  * <p>Title : SumManual</p>
  * <p>Description : </p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月25日 上午9:29:20
  * @version : 12.0.0
 */
public class SumManual {
	private Integer adminId;
	private String adminName;
	private String sumMoney;
	public SumManual() {
		super();
	}
	public SumManual(Integer adminId, String adminName, String sumMoney) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.sumMoney = sumMoney;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(String sumMoney) {
		this.sumMoney = sumMoney;
	}
	@Override
	public String toString() {
		return "sumManual [adminId=" + adminId + ", adminName=" + adminName + ", sumMoney=" + sumMoney + "]";
	}
	
}
