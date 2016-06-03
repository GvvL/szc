package com.aydc.szc.ui;

import org.json.JSONObject;

import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.util.JSONUtil;

public class AddressDetailActivity extends ActP<AddressDetailView>{
	
	@Override
	protected void preliminary() {
		super.preliminary();
		if(!getIntent().hasExtra("isadd")) finish();
		boolean booleanExtra = getIntent().getBooleanExtra("isadd", false);
		viewDelegate.isadd=booleanExtra;
		if(!booleanExtra){
			viewDelegate.nav_bar_title.setText("编辑地址");
			String stringExtra = getIntent().getStringExtra("addr");
			JSONObject instaceJsonObject = JSONUtil.instaceJsonObject(stringExtra);
			AddressBean addressbean=JSONUtil.jsonObject2Bean(instaceJsonObject, AddressBean.class);
			viewDelegate.showAddr(addressbean);
		}
	}

}
