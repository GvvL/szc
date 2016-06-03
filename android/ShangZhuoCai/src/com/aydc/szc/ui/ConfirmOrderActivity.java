package com.aydc.szc.ui;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import android.content.Intent;

import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.entity.COrderBean;
import com.aydc.szc.entity.CouponBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.AddressModel;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.Logger;

public class ConfirmOrderActivity extends ActP<ConfirmOrderView>{
	public static AddressBean address=null;
	public static ArrayList<CouponBean> coupons=new ArrayList<>();
	public static CouponBean couponSel;
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.showData(CartModel.getCartDishes(true));
		//获取默认收货地址
		viewDelegate.showLoadingDialog("");
		AddressModel.addressApi.getDefaultAddress(App.getInstance().userinfo.getId(),CartModel.getCartPrice())
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.doOnNext(new Action1<ResponseDataItem<COrderBean>>() {
				@Override
				public void call(ResponseDataItem<COrderBean> arg0) {
					viewDelegate.hideLoadingDialog();
				}
			})
			.subscribe(new ApiCallBack<ResponseDataItem<COrderBean>>() {
				@Override
				protected void success(ResponseDataItem<COrderBean> data) {
					address=data.getData().getAddress();
					viewDelegate.showDefaultAddress(data.getData().getAddress());
					coupons=data.getData().getCoupon();
					couponSel=ConfirmOrderActivity.this.getBiggestCoupon();
					viewDelegate.showDefaultCoupon(couponSel);
				}
				@Override
				protected void error(int code, String str) {
					viewDelegate.showDefaultAddress(null);
					Logger.e(str);
				}
			});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==Common.SEL_ADDRESS_REQUEST_CODE&&resultCode==Common.SEL_ADDRESS_RESPONSE_CODE&&address!=null){
			viewDelegate.showDefaultAddress(address);
		}
		if(requestCode==Common.SEL_COUPON_REQUEST_CODE&&resultCode==Common.SEL_COUPON_RESPONSE_CODE&&couponSel!=null){
			viewDelegate.showDefaultCoupon(couponSel);
		}
		
	}
	public CouponBean getBiggestCoupon(){
		if(this.coupons==null||this.coupons.isEmpty()){
			return null;
		}
		CouponBean cb=null;
		for(CouponBean coub:this.coupons){
			if(coub.getStatus()!=1){
				continue;
			}
			if(cb==null){
				cb=coub;
			}
			if(cb.getValue()<coub.getValue()){
				cb=coub;
			}
			
		}
		return cb;
	}
}
