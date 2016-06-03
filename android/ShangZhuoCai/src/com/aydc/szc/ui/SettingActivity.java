package com.aydc.szc.ui;

import java.io.File;

import com.aydc.szc.app.App;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.util.AppUtil;
import com.bumptech.glide.Glide;

public class SettingActivity extends ActP<SettingView>{
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.set_cacche_size.setText("0.0M");
		try {
			viewDelegate.set_ban.setText("v "+AppUtil.getVersionName());
			File photoCacheDir = Glide.getPhotoCacheDir(App.getInstance().getApplicationContext());
			viewDelegate.set_cacche_size.setText(AppUtil.formatFloat(AppUtil.getFolderSize(photoCacheDir))+"M");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
