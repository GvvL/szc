package com.aydc.szc.ui;

import retrofit.http.POST;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.util.AppUtil;


public class SettingView extends HasTitleViewDelegater{
	@Bind(R.id.set_cacche_size)
	TextView set_cacche_size;
	@Bind(R.id.set_ban)
	TextView set_ban;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_setting;
	}
	@OnClick(R.id.ll_clean_cache)
	public void cacheClick(View v){
		AppUtil.cleanCache();
		set_cacche_size.setText("0.0M");
	}
	@OnClick(R.id.ll_ban)
	public void banClick(View v){
		v.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				showTS("无新版本");
				
			}
		}, 1000);
	}
	@OnClick(R.id.ll_suggest)
	public void suggestClick(View v){
		
	}
	@OnClick(R.id.ll_tui)
	public void tuiClick(View v){
		
	}
	@OnClick(R.id.ll_about)
	public void aboutClick(View v){
		
	}
	@OnClick(R.id.setting_logout)
	public void logout(View v){
		UserModel.getInstance().logout(getActivity());
		getActivity().finish();
	}
}
