package com.aydc.szc.model;

import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.Tab1Bean;
import com.aydc.szc.util.HttpManager;

import retrofit.http.POST;
import rx.Observable;


public class Tab1Model {
	
	public static Tab1Api tab1Api=HttpManager.getRetrofit().create(Tab1Api.class);
	
	public void firstQuery(){
		
	}
	
	
	public interface Tab1Api{
		@POST("indexLoad")
		Observable<ResponseDataItem<Tab1Bean>> indexLoad();
	}

}
