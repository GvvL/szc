package com.aydc.szc.ui;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.KeyEvent.DispatcherState;

import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.ChefModel;
import com.aydc.szc.model.ChefModel.DishGetCallBack;
import com.aydc.szc.util.Logger;

public class ChefDetailActivity extends ActP<ChefDetailView>{
	public static ChefBean chefb;
	private ArrayList<DishBean> dishes;
	
	
	
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.showLoading();
		if(chefb==null) return;
		viewDelegate.showChef(chefb);
		ChefModel.getdishbychefid(chefb.getId(),new DishGetCallBack() {
			
			@Override
			public void success(ArrayList<DishBean> dishes) {
				ChefDetailActivity.this.dishes=dishes;
				viewDelegate.hideOperateFrame();
				viewDelegate.showData(ChefDetailActivity.this.dishes);
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.transbar=false;
		super.onCreate(savedInstanceState);
	}
	private boolean mesearFlag=false;
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus&&!mesearFlag){
			mesearFlag=true;
			viewDelegate.mesearHeight();
		}
	}
	@Override
	public void onBackPressed() {
		dishes=null;
		chefb=null;
		super.onBackPressed();
	}


}
