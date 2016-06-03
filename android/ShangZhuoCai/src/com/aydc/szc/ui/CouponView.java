package com.aydc.szc.ui;

import java.util.ArrayList;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.adaper.AddressAdapter;
import com.aydc.szc.adaper.AddressDecoration;
import com.aydc.szc.adaper.CouponAdapter;
import com.aydc.szc.entity.CouponBean;
import com.aydc.szc.fram.ViewDelegate;
/**
 * 地址选择和地址查看
 * @author Administrator
 *
 */
public class CouponView extends HasTitleViewDelegater{
	@Bind(R.id.coupon_refreshview) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.coupon_recycleView) RecyclerView mRecyclerView;
	
	private CouponAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_coupon;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		
	}
	public void showdata(ArrayList<CouponBean> cous){
		if(adapter==null){
			adapter=new CouponAdapter(getActivity(), cous);
			mRecyclerView.setAdapter(adapter);
			mRecyclerView.addItemDecoration(new AddressDecoration());
		}else{
			adapter.setdata(cous);
		}
		if(mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(false);
		
	}

}
