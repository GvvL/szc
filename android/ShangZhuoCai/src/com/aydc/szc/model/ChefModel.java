package com.aydc.szc.model;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.aydc.szc.app.App;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.HttpManager;

public class ChefModel {
	//获取一个出是+所有菜品 先缓存 后网络
	public static void findChef(int chefid,final FindChefCallBack callback){
		ChefBean chef = null;
		for(ChefBean chefb:App.chefs){
			if(chefid==chefb.getId()){
				chef=chefb;
				break;
			} 
		}
		if(chef!=null){
			callback.findSuccess(chef);
			return;
		}
		chefApi.getChefById(chefid+"")
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.subscribe(new ApiCallBack<ResponseDataItem<ChefBean>>() {

				@Override
				protected void success(ResponseDataItem<ChefBean> data) {
					callback.findSuccess(data.getData());
				}

				@Override
				protected void error(int code, String str) {
					callback.findFaild();//该厨师已被下架
				}
			});
	}
	//网络获取所有菜品
	public static void findChefFoods(int chefid,final FindChefCallBack callback){
		chefApi.getChefFoods(chefid+"")
		.observeOn(AndroidSchedulers.mainThread())
		.subscribeOn(Schedulers.io())
		.subscribe(new ApiCallBack<ResponseDataItem<ChefBean>>() {

			@Override
			protected void success(ResponseDataItem<ChefBean> data) {
				callback.findSuccess(data.getData());
			}

			@Override
			protected void error(int code, String str) {
				callback.findFaild();//该厨师已被下架
			}
		});
	}
	
	public  static interface FindChefCallBack{
		void findSuccess(ChefBean chef);
		void findFaild();
	}
	public static void getdishbychefid(int id,DishGetCallBack dcb){
		ArrayList<DishBean> dishes=new ArrayList<>();
		for(DishBean db:App.dishes){
			if(db.getChef_id()==id){
				dishes.add(db);
			}
		}
		dcb.success(dishes);
	}
	public static interface DishGetCallBack{
		void success(ArrayList<DishBean> dishes);
	}
	
	
	
	public interface ChefApi{
		@GET("getChefById")
		Observable<ResponseDataItem<ChefBean>> getChefById(@Query("chefid") String id);
		@GET("getChefById")
		Observable<ResponseDataItem<ChefBean>> getChefFoods(@Query("chefid") String id);
		@GET("getAllDishes")
		Observable<ResponseDataList<DishBean>> getAllFoods();
		@GET("getAllChefs")
		Observable<ResponseDataList<ChefBean>> getAllFChefs();
	}
	public static ChefApi chefApi=HttpManager.getRetrofit().create(ChefApi.class);

}
