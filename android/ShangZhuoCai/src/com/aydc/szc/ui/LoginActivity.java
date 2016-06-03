package com.aydc.szc.ui;

import android.view.View;
import android.view.View.OnClickListener;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.UserBean;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.model.UserModel.LoginCallBack;

public class LoginActivity extends ActP<LoginView> implements OnClickListener{
	
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.setOnClickListener(this, R.id.btn_login,R.id.act_log_btn_dong,R.id.act_log_btn_forget,R.id.act_log_img_qq,R.id.act_log_img_weixin,R.id.act_log_img_weibo);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			makeLogin();
			break;

		default:
			break;
		}
		
	}
	public void makeLogin(){
		String username=viewDelegate.edt_username.getText().toString().trim();
		String password=viewDelegate.edt_password.getText().toString().trim();
		if(!fliterUser(username,password)){
			viewDelegate.showTS("账号或密码错误");
			return;
		}
		UserModel.getInstance().login(viewDelegate, username, password,new LoginCallBack() {
			@Override
			public void loginSuccess(UserBean user) {
				viewDelegate.showTS("欢迎登陆,"+user.getNick());
				setResult(Common.LOGIN_RESPONSE_CODE);
				finish();
			}
		});
	}
	private boolean fliterUser(String username, String password) {
		if(username.length()!=11||!username.startsWith("1")) return false;
		if(password.length()<6) return false;
		return true;
	}

}
