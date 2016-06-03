package com.aydc.szc.ui;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.COrderBean;
import com.aydc.szc.entity.CouponBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.AddressModel;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.model.CouponModel;
import com.aydc.szc.util.ApiCallBack;

public class CouponActivity extends ActP<CouponView> implements OnRefreshListener{
	public static boolean isSel=false;
	public static float orderprice=0.0f;
	@Override
	protected void preliminary() {
		super.preliminary();
		if(getIntent().hasExtra(Common.SEL_COUPON)){
			isSel=getIntent().getBooleanExtra(Common.SEL_COUPON, false);
			orderprice=getIntent().getFloatExtra(Common.SEL_COUPON_PRICE, 0.0f);
		}
		if(isSel){
			viewDelegate.showdata(ConfirmOrderActivity.coupons);
		}else{
			load();
		}
	}
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.mSwipeRefreshLayout.setOnRefreshListener(this);
	}
	@Override
	public void onRefresh() {
		load();
	}
	public void load(){
		if(isSel){
			AddressModel.addressApi.getDefaultAddress(App.getInstance().userinfo.getId(),CartModel.getCartPrice())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(new ApiCallBack<ResponseDataItem<COrderBean>>() {

					@Override
					protected void success(ResponseDataItem<COrderBean> data) {
						ConfirmOrderActivity.coupons=data.getData().getCoupon();
						viewDelegate.showdata(ConfirmOrderActivity.coupons);
					}

					@Override
					protected void error(int code, String str) {
						viewDelegate.showTS("加载异常");
					}
				});
		}else{
			CouponModel.couponApi.getAllCoupon(App.getInstance().userinfo.getId())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(new ApiCallBack<ResponseDataList<CouponBean>>() {
					@Override
					protected void success(ResponseDataList<CouponBean> data) {
						viewDelegate.showdata(data.getData());
					}
					@Override
					protected void error(int code, String str) {
						
					}
				});
		}
	}

}
