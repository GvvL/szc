package com.aydc.szc.ui.frg;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.FrgP;
import com.aydc.szc.model.ChefModel;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.Logger;

public class Tab3Presenter extends FrgP<Tab3View> implements OnClickListener,OnRefreshListener{

	@Override
	protected void firstLoad() {
		if(App.chefs.size()!=0){
			viewDelegate.loading_frame.setVisibility(View.GONE);
			viewDelegate.showChefs(App.chefs);
		}else{
			loadData();
		}
	}
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.mSwipeRefreshLayout.setOnRefreshListener(this);
	}
	
	private void loadData() {
		ChefModel.chefApi.getAllFChefs()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.subscribe(new ApiCallBack<ResponseDataList<ChefBean>>() {

				@Override
				protected void success(ResponseDataList<ChefBean> data) {
					Logger.e("jiazai");
					App.chefs=data.getData();
					viewDelegate.showChefs(data.getData());
					viewDelegate.loading_frame.setVisibility(View.GONE);
					viewDelegate.hideOperateFrame();
					viewDelegate.mSwipeRefreshLayout.setRefreshing(false);
					
				}

				@Override
				protected void error(int code, String str) {
					viewDelegate.showNoNet(Tab3Presenter.this);
				}
			});
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_retry:
			loadData();
			break;

		default:
			break;
		}
	}
	@Override
	public void onRefresh() {
		loadData();
	}
	

}
