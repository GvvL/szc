package com.aydc.szc.model;

import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;

import com.aydc.szc.entity.CouponBean;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.util.HttpManager;

public class CouponModel {
	
	
	public interface CouponApi{
		@Multipart
		@POST("getallcoupon")
		Observable<ResponseDataList<CouponBean>> getAllCoupon(@Part("uid") int id);
		@Multipart
		@POST("getOKcoupon")
		Observable<ResponseDataList<CouponBean>> getOKCoupon(@Part("uid") int id,@Part("price") float price);
	}
	public static CouponApi couponApi=HttpManager.getRetrofit().create(CouponApi.class);

}
