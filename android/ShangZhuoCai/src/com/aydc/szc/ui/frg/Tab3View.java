package com.aydc.szc.ui.frg;

import java.util.ArrayList;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.adaper.Tab2RecDecoration;
import com.aydc.szc.adaper.Tab3ChefAdapter;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.FontUtil;

public class Tab3View extends ViewDelegate{
	@Bind(R.id.tab3_nav_bar_title1) TextView nav_bar_title1;
	@Bind(R.id.tab3_nav_bar_title2) TextView nav_bar_title2;
	@Bind(R.id.tab3_condition_1) TextView condition1;
	@Bind(R.id.tab3_condition_2) TextView condition2;
	
	@Bind(R.id.tab3_recycleView) RecyclerView mRecyclerView;
	@Bind(R.id.tab3_loading_framlayout) RelativeLayout loading_frame;
	@Bind(R.id.tab3_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
	Tab3ChefAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab3;
	}
	
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		adapter=new Tab3ChefAdapter(getActivity());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.addItemDecoration(new Tab2RecDecoration());
		FontUtil.init(1, nav_bar_title1,nav_bar_title2,condition1,condition2);
	}
	
	public void showChefs(ArrayList<ChefBean> chefs){
		adapter.setdata(chefs);
	}

}
