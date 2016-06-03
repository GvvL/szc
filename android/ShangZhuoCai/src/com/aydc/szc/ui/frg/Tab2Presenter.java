package com.aydc.szc.ui.frg;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.FrgP;
import com.aydc.szc.model.ChefModel;
import com.aydc.szc.util.ApiCallBack;

public class Tab2Presenter extends FrgP<Tab2View> implements OnRefreshListener,OnClickListener{
	
	@Override
	protected void firstLoad() {
		if(App.dishes.size()!=0){
			viewDelegate.loading_fram.setVisibility(View.GONE);
			viewDelegate.showDishes(App.dishes);
		}else{
			loadData();
		}
		
	}
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.mRefreshView.setOnRefreshListener(this);
	}
	@Override
	public void onRefresh() {
		loadData();
		
	}
	private void loadData() {
		ChefModel.chefApi.getAllFoods()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.subscribe(new ApiCallBack<ResponseDataList<DishBean>>() {

				@Override
				protected void success(ResponseDataList<DishBean> data) {
					App.dishes=data.getData();
					viewDelegate.showDishes(data.getData());
					viewDelegate.loading_fram.setVisibility(View.GONE);
					viewDelegate.hideOperateFrame();
					viewDelegate.mRefreshView.setRefreshing(false);
					
				}

				@Override
				protected void error(int code, String str) {
					viewDelegate.showNoNet(Tab2Presenter.this);
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


}
