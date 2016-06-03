package com.aydc.szc.ui;

import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.fram.ActP;

public class OrderDetailActivity extends ActP<OrderDetailView>{
	public static OrderBean order=new OrderBean();
	@Override
	protected void preliminary() {
		super.preliminary();
	}
	
	@Override
	public void finish() {
		super.finish();
		order=null;
	}
	

}
