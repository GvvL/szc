package com.aydc.szc.entity;

public class RechargeTypeBean extends Bean{
	private int id;
	private int member_id;
	private String recharge_sn;
	private String create_time;
	private String end_time;
	private int status;
	private int value;
	private String pay_channel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getPay_channel() {
		return pay_channel;
	}
	public void setPay_channel(String pay_channel) {
		this.pay_channel = pay_channel;
	}
	public String getRecharge_sn() {
		return recharge_sn;
	}
	public void setRecharge_sn(String recharge_sn) {
		this.recharge_sn = recharge_sn;
	}

}
