package com.aydc.szc.ui;


import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import com.aydc.szc.R;
import com.aydc.szc.util.FontUtil;


public class LoginView extends HasTitleViewDelegater{
	@Bind(R.id.nav_bar_right) TextView nav_bar_right;
	
	@Bind(R.id.edt_username) EditText edt_username;
	@Bind(R.id.edt_password) EditText edt_password;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_login;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		FontUtil.init(1, nav_bar_right);
	}


}
