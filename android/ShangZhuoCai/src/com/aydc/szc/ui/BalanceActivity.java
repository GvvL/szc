package com.aydc.szc.ui;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.aydc.szc.app.App;
import com.aydc.szc.entity.BalanceDetailBean;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.RechargeModel;
import com.aydc.szc.util.ApiCallBack;

public class BalanceActivity extends ActP<BalanceView>{
	private boolean ff=true;
	
	
	
	@Override
	protected void onResume() {
		super.onResume();
		loadData();
		viewDelegate.balance_yue.setText(App.getInstance().userinfo.getBalance());
	}
	
	public void loadData(){
		if(ff){
			viewDelegate.showLoading();
		}else{
			viewDelegate.showLoadingDialog("");
		}
		RechargeModel.rechargeApi.getBalanceDetail(App.getInstance().userinfo.getId())
						.observeOn(AndroidSchedulers.mainThread())
						.subscribeOn(Schedulers.io())
						.subscribe(new ApiCallBack<ResponseDataList<BalanceDetailBean>>() {

							@Override
							protected void success(
									ResponseDataList<BalanceDetailBean> data) {
								if(ff){
									ff=false;
									viewDelegate.hideOperateFrame();
								}else{
									viewDelegate.hideLoadingDialog();
								}
								viewDelegate.showData(data.getData());
								
							}

							@Override
							protected void error(int code, String str) {
								
							}
						});
	}

}
