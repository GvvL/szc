package com.aydc.szc.model;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;
import rx.schedulers.Schedulers;

import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.entity.COrderBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.util.HttpManager;

public class AddressModel {
	
	public static void setAddressDefault(int uid,int aid){
		addressApi.setDefaultAddress(uid,aid).subscribeOn(Schedulers.io()).subscribe();
	}
	
	
	public interface AddressApi{
		@Multipart
		@POST("getalladdress")
		Observable<ResponseDataList<AddressBean>> getAllAddress(@Part("uid") int id);
		@Multipart
		@POST("getDefaultAddress")
		Observable<ResponseDataItem<COrderBean>> getDefaultAddress(@Part("uid") int id,@Part("price") float price);
		@Multipart
		@POST("setAddressDefault")
		Observable<ResponseDataItem<AddressBean>> setDefaultAddress(@Part("uid") int id,@Part("addrid") int addrid);
		@FormUrlEncoded
		@POST("addaddress")
		Observable<ResponseDataItem<AddressBean>> addAddress(@Field("uid") int id,@Field("linkman") String linkman
																,@Field("linktel") String linktel,@Field("address") String address
																,@Field("isdef") boolean isdef);
		@FormUrlEncoded
		@POST("editAddress")
		Observable<ResponseDataItem<AddressBean>> editAddress(@Field("uid") int id,@Field("addressid") int addressid,@Field("linkman") String linkman
				,@Field("linktel") String linktel,@Field("address") String address
				,@Field("isdef") boolean isdef);
	}
	public static AddressApi addressApi=HttpManager.getRetrofit().create(AddressApi.class);
}
