package com.aydc.szc.ui;

import android.os.Bundle;

import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ActP;

public class GoodsDetailActivity extends ActP<GoodsDetailView>{
	public static DishBean dishBean=new DishBean();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		transbar=false;
		super.onCreate(savedInstanceState);
	}
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.showData(dishBean);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus){
			viewDelegate.mesearHeight();
		}
	}

}
