package com.aydc.szc.model;

import java.util.HashMap;

import org.json.JSONObject;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.content.Intent;

import com.aydc.szc.app.App;
import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.ui.ConfirmOrderActivity;
import com.aydc.szc.ui.MainActivity;
import com.aydc.szc.ui.OrderDetailActivity;
import com.aydc.szc.ui.OrdersActivity;
import com.aydc.szc.ui.ToPayActivity;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.HttpManager;
import com.aydc.szc.util.JSONUtil;
import com.aydc.szc.util.Logger;

public class OrderModel {
	public static final int USER_NOT_FOUND=410;
	public static final int COUPON_UNUSE=411;
	public static final int NO_ADDRESS=412;
	public static final int DISH_NOT_FOUND=415;
	public static final int PRICE_EXEPTION=416;
	public static final int ORDER_SUBMIT_FAILD=420;
	
	@SuppressWarnings("unchecked")
	public static void submitorder(final ViewDelegate v,int uid,float price,int addrid,int couponid,String note){
		HashMap<Integer, Integer> carMap = (HashMap<Integer, Integer>) App.carts.clone();
		for(Integer key:carMap.keySet()){
			if(App.carts.get(key)<=0) App.carts.remove(key);
		}
		JSONObject mapint2jsonObject = JSONUtil.mapint2JSONObject(App.carts);
		v.showLoadingDialog("");
		orderApi.submitOrder(uid, price, addrid, couponid,note+"空空",mapint2jsonObject.toString())
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new ApiCallBack<ResponseDataItem<OrderBean>>() {

					@Override
					protected void success(ResponseDataItem<OrderBean> data) {
						v.hideLoadingDialog();
						App.carts.clear();
						ConfirmOrderActivity.address=null;
						ConfirmOrderActivity.couponSel=null;
						Logger.e(data.getMsg());
						ToPayActivity.orderbean=data.getData();
						jumptoOrderDetail(v);
					}

					private void jumptoOrderDetail(ViewDelegate v) {
						Intent intent=new Intent();
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						OrdersActivity.ORDER_JUMP=true;
						intent.setClass(v.getActivity(), MainActivity.class);
						v.getActivity().startActivity(intent);
					}

					@Override
					protected void error(int code, String str) {
						v.hideLoadingDialog();
						Logger.e(str+":"+code);
						v.showTS(str);
					}
				});
	}
	
	public interface OrderApi{
		@FormUrlEncoded
		@POST("submitorder")
		Observable<ResponseDataItem<OrderBean>> submitOrder(@Field("uid") int id
															,@Field("price") float price
															,@Field("addrid") int addrid
															,@Field("couponid") int couponid
															,@Field("note") String note
															,@Field("dishes") String dishes
															);
		@FormUrlEncoded
		@POST("getallorders")
		Observable<ResponseDataList<OrderBean>> getAllOrders(@Field("uid") int id);
	}
	public static OrderApi orderApi=HttpManager.getRetrofit().create(OrderApi.class);
}
