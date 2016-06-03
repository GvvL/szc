package com.aydc.szc.ui.frg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.UserBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.ui.AddressActivity;
import com.aydc.szc.ui.BalanceActivity;
import com.aydc.szc.ui.CouponActivity;
import com.aydc.szc.ui.LoginActivity;
import com.aydc.szc.ui.OrdersActivity;
import com.aydc.szc.ui.SettingActivity;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.widget.MImageView;

public class Tab6View extends ViewDelegate{
	@Bind(R.id.tab6_nav_bar_title1) TextView title1;
	@Bind(R.id.tab6_nav_bar_title2) TextView title2;
	
	@Bind(R.id.tab6_header) MImageView img_header;
	@Bind(R.id.tab6_tel) TextView tv_tel;
	@Bind(R.id.tab6_login) TextView tv_login;
	@Bind(R.id.tab6_imageView_bg) ImageView img_bg;
	
	@Bind(R.id.tab6_refresh)
	SwipeRefreshLayout mSwipeRefreshLayout;
	
	@Bind({R.id.tab6_cate2,R.id.tab6_cate3,R.id.tab6_cate4,R.id.tab6_cate5,R.id.tab6_cate6})
	TextView[] cates;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab6;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		FontUtil.init(1, title1,title2);
//		addBlur();
		mSwipeRefreshLayout.setColorSchemeColors(Color.BLACK);
	}
//	private void addBlur() {
//		Bitmap decodeResource = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.test_bg);
//		Bitmap fastblur = BitmapUtil.fastblur(getActivity(), decodeResource, 200);
//		img_bg.setImageBitmap(fastblur);
//	}
	@OnClick({R.id.tab6_cate1,R.id.tab6_cate2,R.id.tab6_cate3,R.id.tab6_cate4,R.id.tab6_setting})
	public void cateClick(View v){
		if(!App.islogin){
			getActivity().startActivityForResult(new Intent(getActivity(), LoginActivity.class), Common.LOGIN_REQUEST_CODE);
			return;
		}
		switch (v.getId()) {
		case R.id.tab6_cate1:
			jumpPage(OrdersActivity.class);
			break;
		case R.id.tab6_cate2:
			jumpPage(AddressActivity.class);
			break;
		case R.id.tab6_cate3:
			jumpPage(BalanceActivity.class);
			break;
		case R.id.tab6_cate4:
			jumpPage(CouponActivity.class);
			break;
		case R.id.tab6_setting:
			jumpPage(SettingActivity.class);
			break;
		default:
			break;
		}
		
	}
	public void showLoginView(UserBean ub){
		tv_tel.setVisibility(View.VISIBLE);
		tv_login.setVisibility(View.GONE);
		tv_tel.setText(ub.getTel());
		
	}
	public void showUnLoginView(){
		tv_tel.setVisibility(View.GONE);
		tv_login.setVisibility(View.VISIBLE);
	}
	

	

}
