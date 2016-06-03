package com.aydc.szc.ui;


import java.util.ArrayList;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.adaper.AddressDecoration;
import com.aydc.szc.adaper.OrdersAdapter;
import com.aydc.szc.entity.OrderBean;

public class OrdersView extends HasTitleViewDelegater{
	@Bind(R.id.sr_refreshview) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.rc_recycleView) RecyclerView mRecyclerView;
	ArrayList<OrderBean> orders;
	OrdersAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_orders;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		adapter=new OrdersAdapter(getActivity());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.addItemDecoration(new AddressDecoration());
	}
	
	public void showdata(ArrayList<OrderBean> orders){
		if(adapter==null) return;
		this.orders=orders;
		adapter.setdata(this.orders);
	}

}
