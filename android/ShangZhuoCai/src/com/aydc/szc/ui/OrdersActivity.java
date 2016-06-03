package com.aydc.szc.ui;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

import com.aydc.szc.app.App;
import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.OrderModel;
import com.aydc.szc.util.ApiCallBack;

public class OrdersActivity extends ActP<OrdersView> implements OnRefreshListener{
	public static boolean ORDER_JUMP=false;
	public static OrderBean ORDER_PAY_SECCESS=null;//是不是支付成功过后过来的
	@Override
	protected void preliminary() {
		super.preliminary();
		if(ORDER_JUMP){
			ORDER_JUMP=false;
			viewDelegate.jumpPage(ToPayActivity.class);//跳进支付页

		}else{
			load();
		}
	}
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.mSwipeRefreshLayout.setOnRefreshListener(this);
	}
	private void load() {
		if(!App.islogin) return;
		if(!viewDelegate.mSwipeRefreshLayout.isRefreshing()){
			viewDelegate.showLoading();
		}
		OrderModel.orderApi.getAllOrders(App.getInstance().userinfo.getId())
					.observeOn(AndroidSchedulers.mainThread())
					.subscribeOn(Schedulers.io())
					.doOnNext(new Action1<ResponseDataList<OrderBean>>() {
						@Override
						public void call(ResponseDataList<OrderBean> arg0) {
							viewDelegate.hideOperateFrame();
							viewDelegate.mSwipeRefreshLayout.setRefreshing(false);
						}
					})
					.subscribe(new ApiCallBack<ResponseDataList<OrderBean>>() {

						@Override
						protected void success(ResponseDataList<OrderBean> data) {
							viewDelegate.showdata(data.getData());
						}

						@Override
						protected void error(int code, String str) {
							
						}
					});
		
	}
	@Override
	protected void onResume() {
		super.onResume();//支付成功返回刷新下界面
		if(viewDelegate.orders!=null){
			
			viewDelegate.adapter.notifyDataSetChanged();
		}else{
			load();
		}
		if(ORDER_PAY_SECCESS!=null){
			OrderDetailActivity.order=ORDER_PAY_SECCESS;
			ORDER_PAY_SECCESS=null;
			Intent intent=new Intent(this, OrderDetailActivity.class);
			startActivity(intent);
		}
	}
	@Override
	public void onRefresh() {
		load();
	}

}
