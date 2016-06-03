package com.aydc.szc.ui;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.BindColor;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.ChefDetailAdapter;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.widget.MGridView;
import com.aydc.szc.widget.MScrollViewExtend;
import com.aydc.szc.widget.MScrollViewExtend.OnScrollListener;

public class ChefDetailView extends ViewDelegate implements OnScrollListener {
	@BindColor(R.color.red)
	int redColor;
	@BindColor(R.color.black)
	int blackColor;
	@BindColor(R.color.white)
	int whiteColor;
	@Bind(R.id.scrollView1)
	MScrollViewExtend scrollView1;
	@Bind(R.id.view_fliter)
	LinearLayout view_fliter;
	@Bind(R.id.framelayout)
	FrameLayout framelayout;
	@Bind(R.id.ll_content)
	LinearLayout ll_content;
	@Bind(R.id.nav_bar)
	RelativeLayout nav_bar;
	@Bind(R.id.nav_bar_bg)
	View nav_bar_bg;
	@Bind(R.id.chef_detail_bg)
	ImageView chef_detail_bg;
	@Bind(R.id.gridview)
	MGridView gridview;
	
	@Bind(R.id.bar_left)
	TextView bar_left;
	@Bind(R.id.bar_cart)
	TextView bar_cart;
	@Bind(R.id.bar_share)
	TextView bar_share;
	@Bind(R.id.bar_title)
	TextView bar_title;
	@Bind(R.id.bar_cartnum_view)
	TextView bar_cartnum_view;
	
	@Bind(R.id.act_chefdetail_sales)
	TextView chefdetail_sales;
	@Bind(R.id.act_chefdetail_gride)
	TextView chefdetail_gride;
	@Bind(R.id.act_chefdetail_headimg)
	ImageView chefdetail_headimg;

	private View stub_view;
	
	private int nav_bar_height;
	private ChefDetailAdapter adapter;

	@Override
	public int getRootLayoutId() {
		return R.layout.act_chefdetail;
	}

	@Override
	public void initWidget() {
		super.initWidget();
		scrollView1.setOnScrollListener(this);
		stub_view=new View(getActivity());
		stub_view.setBackgroundColor(Color.TRANSPARENT);
		
		adapter=new ChefDetailAdapter(this);
		gridview.setAdapter(adapter);
		
	
		FontUtil.init(0, bar_cart,bar_left,bar_share);
		refeshCart();
	}
	
	public void showData(ArrayList<DishBean> dishes) {
		adapter.setData(dishes);
	}
	public void showChef(ChefBean chefb) {
		bar_title.setText(chefb.getName());
		chefdetail_gride.setText(chefb.getGrade()+"");
		chefdetail_sales.setText(chefb.getSupporter()+"");
		
	}
	public void refeshCart(){
		if(CartModel.getCartNum()==0){
			bar_cartnum_view.setVisibility(View.GONE);
			return;
		} 
		bar_cartnum_view.setVisibility(View.VISIBLE);
		bar_cartnum_view.setText(CartModel.getCartNum()+"");
	}
	//购物车点击事件
	@OnClick(R.id.bar_cart)
	public void cartclick(View v){
		jumpPage(CartActivity.class);
	}
	//返回按钮
	@OnClick(R.id.bar_left)
	public void backclick(View v){
		getActivity().onBackPressed();
	}
	@Override
	public void onScroll(int scrollY) {

	}

	private boolean isaddfliterview = false;
	private int specfliterviewheight = 0;
	private LinearLayout.LayoutParams fliter_lp;// 存储筛选菜单原来的位置

	@Override
	public void onScrollReal(int rY) {
		changeNavbarItemColor(rY);

		if (specfliterviewheight > 0 && rY > specfliterviewheight) {
			changeNavbarBgColor(1f);
			if (isaddfliterview)
				return;
			LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
			layoutParams.topMargin =nav_bar_height;
			layoutParams.gravity = Gravity.TOP;
			ll_content.removeView(view_fliter);
			ll_content.addView(stub_view, 0, fliter_lp);
			framelayout.addView(view_fliter, layoutParams);
			isaddfliterview = true;
		} else {
			changeNavbarBgColor(rY/(float)specfliterviewheight);
			if (fliter_lp == null || !isaddfliterview)
				return;
			framelayout.removeView(view_fliter);
			ll_content.removeView(stub_view);
			ll_content.addView(view_fliter, 0, fliter_lp);
			isaddfliterview = false;
		}
	}
	
	private boolean isSetNavBarColor=false;
	private void changeNavbarItemColor(int rY) {
		if (specfliterviewheight > 0 && rY > specfliterviewheight-AppUtil.designedDP2px(30)) {
			if(isSetNavBarColor) return;
			bar_cart.setTextColor(redColor);
			bar_share.setTextColor(redColor);
			bar_left.setTextColor(redColor);
			bar_title.setTextColor(blackColor);
			isSetNavBarColor=true;
		}else{
			if(!isSetNavBarColor) return;
			bar_cart.setTextColor(whiteColor);
			bar_share.setTextColor(whiteColor);
			bar_left.setTextColor(whiteColor);
			bar_title.setTextColor(whiteColor);
			isSetNavBarColor=false;
		}
	}

	public void mesearHeight() {
		nav_bar_height=nav_bar.getMeasuredHeight();
		int[] loc = new int[2];
		view_fliter.getLocationInWindow(loc);
		specfliterviewheight = loc[1] - AppUtil.getStatusBarHeight()-nav_bar_height;
		fliter_lp = (android.widget.LinearLayout.LayoutParams) view_fliter
				.getLayoutParams();
		fliter_lp.height=view_fliter.getMeasuredHeight();
		
	}
	
	private void changeNavbarBgColor(float v){
		nav_bar_bg.setAlpha(v);
	}
	public View getCartView(){
		return bar_cart;
	}





}
