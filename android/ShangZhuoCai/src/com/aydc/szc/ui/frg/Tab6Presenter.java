package com.aydc.szc.ui.frg;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.UserBean;
import com.aydc.szc.fram.FrgP;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.model.UserModel.UserCallBack;
import com.aydc.szc.ui.LoginActivity;

public class Tab6Presenter extends FrgP<Tab6View> implements OnClickListener,OnRefreshListener{
	

	@Override
	protected void firstLoad() {
		resetView();
		UserModel.getInstance().getUserOnServer(getActivity(), new UserCallBack() {
			@Override
			public void getUserSuccess(UserBean loginUser) {
				viewDelegate.showLoginView(loginUser);
			}
		});
		
	}
	@Override
	protected void bindEvenListener() {
		viewDelegate.setOnClickListener(this, R.id.tab6_login);
		viewDelegate.mSwipeRefreshLayout.setOnRefreshListener(this);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==Common.LOGIN_REQUEST_CODE && resultCode==Common.LOGIN_RESPONSE_CODE){
			UserBean user=UserModel.getInstance().getUserLocal();
			viewDelegate.showLoginView(user);
		}
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab6_login:
			startActivityForResult(new Intent(getActivity(), LoginActivity.class), Common.LOGIN_REQUEST_CODE);
			break;

		default:
			break;
		}
	}
	@Override
	public void onRefresh() {
		if(!App.islogin){
			viewDelegate.mSwipeRefreshLayout.setRefreshing(false);
			return;
		}
		UserModel.getInstance().getUserOnServer(getActivity(), new UserCallBack() {
			@Override
			public void getUserSuccess(UserBean loginUser) {
				viewDelegate.mSwipeRefreshLayout.setRefreshing(false);
				viewDelegate.showLoginView(loginUser);
			}
		});
		
	}
	public void resetView(){
		if(App.islogin){
			viewDelegate.showLoginView(App.getInstance().userinfo);
		} else{
			viewDelegate.showUnLoginView();
		}
	}
	@Override
	public void onResume() {
		super.onResume();
		resetView();
	}
}
