package com.aydc.szc.entity;

import java.util.ArrayList;

public class COrderBean extends Bean{
	private AddressBean address;
	private ArrayList<CouponBean> coupon;
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public ArrayList<CouponBean> getCoupon() {
		return coupon;
	}
	public void setCoupon(ArrayList<CouponBean> coupon) {
		this.coupon = coupon;
	}

}
