package com.aydc.szc.ui;

import org.json.JSONObject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import android.content.Intent;

import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.AddressModel;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.JSONUtil;
import com.aydc.szc.util.Logger;

public class AddressActivity extends ActP<AddressView>{
	
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.showLoading();
		if(!App.islogin) return;
		AddressModel.addressApi.getAllAddress(App.getInstance().userinfo.getId())
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.doOnNext(new Action1<ResponseDataList<AddressBean>>() {
				@Override
				public void call(ResponseDataList<AddressBean> arg0) {
					viewDelegate.hideOperateFrame();
					if(arg0.getData().size()==0){
						viewDelegate.showNoData();
					}
				}
			})
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new ApiCallBack<ResponseDataList<AddressBean>>() {

				@Override
				protected void success(ResponseDataList<AddressBean> data) {
					viewDelegate.showData(data.getData());
				}

				@Override
				protected void error(int code, String str) {
					Logger.e(code+str);
					viewDelegate.showNoData();
				}
			});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode!=Common.RESPONSE_HANDLER_ADDRESS) return;
		String stringExtra = data.getStringExtra("ab");
		JSONObject instaceJsonObject = JSONUtil.instaceJsonObject(stringExtra);
		AddressBean addressBean = JSONUtil.jsonObject2Bean(instaceJsonObject, AddressBean.class);
		if(requestCode==Common.REQUEST_ADDRESS_ADD){
			viewDelegate.resetaddress();
			viewDelegate.addarr.add(addressBean);
			viewDelegate.adapter.notifyDataSetChanged();
			
		}else if(requestCode==Common.REQUEST_ADDRESS_EDIT){
			
			viewDelegate.resetaddress();
			for(AddressBean ab:viewDelegate.addarr){
				if(ab.getId()==addressBean.getId()){
					ab.setAddress_detail(addressBean.getAddress_detail());
					ab.setAddress_linkman(addressBean.getAddress_linkman());
					ab.setAddress_linktel(addressBean.getAddress_linktel());
					ab.setIsdefault(1);
					addressBean=null;
				}
			}
			viewDelegate.adapter.notifyDataSetChanged();
		
		}
	}

}
