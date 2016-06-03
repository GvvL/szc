package com.aydc.szc.model;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import com.aydc.szc.entity.BalanceDetailBean;
import com.aydc.szc.entity.RechargeTypeBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.util.HttpManager;

public class RechargeModel {
	
	public interface RechargeApi{
		@GET("getAllRechargeType")
		Observable<ResponseDataList<RechargeTypeBean>> getAllRechargeType();
		@FormUrlEncoded
		@POST("submitRecharge")
		Observable<ResponseDataItem<RechargeTypeBean>> submitRecharge(@Field("uid") int uid,@Field("value") int value,@Field("channel") String channel);
		//获取余额明细
		@GET("getBalanceDetail")
		Observable<ResponseDataList<BalanceDetailBean>> getBalanceDetail(@Query("uid") int id);
		
	}
	public static RechargeApi rechargeApi=HttpManager.getRetrofit().create(RechargeApi.class);

}
