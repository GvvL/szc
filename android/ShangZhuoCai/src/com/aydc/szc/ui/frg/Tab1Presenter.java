package com.aydc.szc.ui.frg;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.Tab1Bean;
import com.aydc.szc.fram.FrgP;
import com.aydc.szc.model.Tab1Model;
import com.aydc.szc.ui.GoodsDetailActivity;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.util.Logger;

public class Tab1Presenter extends FrgP<Tab1View> implements OnRefreshListener,OnClickListener,OnItemClickListener{
	Tab1Bean tab1Bean;
	@Override
	protected void firstLoad() {
		Logger.e("++"+AppUtil.getStatusBarHeight()+";"+AppUtil.dp2px(50));
		if(tab1Bean==null){
			load();
		}else{
			viewDelegate.showData(tab1Bean);
		}
	}
	
	private void load() {
			Tab1Model.tab1Api.indexLoad()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new ApiCallBack<ResponseDataItem<Tab1Bean>>() {
				@Override
				protected void success(ResponseDataItem<Tab1Bean> data) {
					tab1Bean=data.getData();
					App.dishes=tab1Bean.getDishes();
					App.chefs=tab1Bean.getChefs();
					viewDelegate.showData(tab1Bean);
					if(viewDelegate.mSwipeRefreshLayout.isRefreshing())
						viewDelegate.mSwipeRefreshLayout.setRefreshing(false);
					if(viewDelegate.loading_framlayout.VISIBLE==View.VISIBLE) 
						viewDelegate.loading_framlayout.setVisibility(View.GONE);
					viewDelegate.hideOperateFrame();
				}

				@Override
				protected void error(int code, String str) {
					Logger.e(code+str);
					viewDelegate.showTS("网络异常");
					viewDelegate.showNoNet(Tab1Presenter.this);
				}
			});
	}
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.mSwipeRefreshLayout.setOnRefreshListener(this);
		viewDelegate.mListView.setOnItemClickListener(this);
	}

	@Override
	public void onRefresh() {
		load();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_retry:
			load();
			break;
		default:
			break;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		DishBean dishBean = tab1Bean.getDishes().get(position);
		if(dishBean!=null){
			GoodsDetailActivity.dishBean=dishBean;
			startActivity(new Intent(this.getContext(), GoodsDetailActivity.class));
		}
	}


}
